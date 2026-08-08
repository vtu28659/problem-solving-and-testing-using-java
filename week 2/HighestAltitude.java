import java.util.*;

public class HighestAltitude {


    public static int largestAltitude(int[] gain) {


        int altitude = 0;

        int maxAltitude = 0;



        for(int i=0;i<gain.length;i++){


            altitude += gain[i];


            maxAltitude = Math.max(maxAltitude, altitude);

        }


        return maxAltitude;

    }



    public static void main(String[] args){


        Scanner sc=new Scanner(System.in);


        System.out.print("Enter number of gains: ");

        int n=sc.nextInt();



        int[] gain=new int[n];



        System.out.println("Enter gains:");

        for(int i=0;i<n;i++){

            gain[i]=sc.nextInt();

        }



        int result=largestAltitude(gain);



        System.out.println("Highest Altitude: "+result);



        sc.close();

    }
}