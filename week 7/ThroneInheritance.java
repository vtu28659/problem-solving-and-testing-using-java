import java.util.*;

public class ThroneInheritance {
    private String king;
    private Map<String, List<String>> familyTree;
    private Set<String> dead;

    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.dead = new HashSet<>();
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        familyTree.computeIfAbsent(parentName, k -> new ArrayList<>()).add(childName);
    }
    
    public void death(String name) {
        dead.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        dfs(king, order);
        return order;
    }

    private void dfs(String current, List<String> order) {
        if (!dead.contains(current)) {
            order.add(current);
        }

        List<String> children = familyTree.get(current);
        if (children != null) {
            for (String child : children) {
                dfs(child, order);
            }
        }
    }

    // Added main method to run from command prompt
    public static void main(String[] args) {
        ThroneInheritance t = new ThroneInheritance("king");
        t.birth("king", "andy");
        t.birth("king", "bob");
        t.birth("king", "catherine");
        t.birth("andy", "matthew");
        t.birth("bob", "alex");
        t.birth("bob", "asha");

        System.out.println("Order 1: " + t.getInheritanceOrder());

        t.death("bob");
        System.out.println("Order 2 (after Bob's death): " + t.getInheritanceOrder());
    }
}