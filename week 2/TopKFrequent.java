import java.util.*;

public class TopKFrequent {


    public static int[] topKFrequent(int[] nums,int k){


        HashMap<Integer,Integer> map=new HashMap<>();


        for(int n:nums){

            map.put(n,map.getOrDefault(n,0)+1);

        }



        PriorityQueue<Integer> pq =
                new PriorityQueue<>(
                (a,b)->map.get(a)-map.get(b)
                );



        for(int n:map.keySet()){


            pq.add(n);



            if(pq.size()>k){

                pq.poll();

            }

        }



        int[] result=new int[k];



        for(int i=k-1;i>=0;i--){

            result[i]=pq.poll();

        }



        return result;

    }



    public static void main(String[] args){


        Scanner sc=new Scanner(System.in);


        System.out.print("Enter array size:");

        int n=sc.nextInt();


        int[] nums=new int[n];


        System.out.println("Enter elements:");

        for(int i=0;i<n;i++){

            nums[i]=sc.nextInt();

        }



        System.out.print("Enter k:");

        int k=sc.nextInt();



        int[] result=topKFrequent(nums,k);



        System.out.println("Top K Frequent Elements:");

        for(int x:result){

            System.out.print(x+" ");

        }



        sc.close();

    }
}