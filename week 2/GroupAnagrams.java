import java.util.*;

public class GroupAnagrams {


    public static List<List<String>> groupAnagrams(String[] strs){


        HashMap<String,List<String>> map=new HashMap<>();


        for(String s:strs){


            char[] ch=s.toCharArray();


            Arrays.sort(ch);


            String key=new String(ch);



            if(!map.containsKey(key)){

                map.put(key,new ArrayList<>());

            }


            map.get(key).add(s);

        }


        return new ArrayList<>(map.values());

    }



    public static void main(String[] args){


        Scanner sc=new Scanner(System.in);



        System.out.print("Enter number of strings: ");

        int n=sc.nextInt();



        String[] strs=new String[n];



        System.out.println("Enter strings:");

        for(int i=0;i<n;i++){

            strs[i]=sc.next();

        }



        List<List<String>> result=groupAnagrams(strs);



        System.out.println("Grouped Anagrams:");

        System.out.println(result);



        sc.close();

    }
}