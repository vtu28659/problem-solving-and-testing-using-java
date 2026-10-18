import java.util.Scanner;
public class PreorderTraversal {
    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node[] nodes = new Node[n + 1];
        for (int i = 1; i <= n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i <= n; i++) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            if (left != -1) {
                nodes[i].left = nodes[left];
            }
            if (right != -1) {
                nodes[i].right = nodes[right];
            }
        }
        preOrder(nodes[1]);
        System.out.println();
        sc.close();
    }
}
