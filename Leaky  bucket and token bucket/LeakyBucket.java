import java.util.*;
class LeakyBucket{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the bucket-capacity:");
        
        int bucketCapacity = sc.nextInt();

        System.out.println("Enter the number of packets:");
        int n = sc.nextInt();

        System.out.println("Enter the outputrate:");
        int outputrate = sc.nextInt();

        int[] PacketSizes = new int[n];
        System.out.println("Enter the packet size:");
        for(int i=0;i<n;i++)
        {
            PacketSizes[i] = sc.nextInt();
        }

        int currentBucketSize = 0;

        System.out.println("PacketSize\t\tBucketSize\t\tSent\t\tRemaining\t\tStatus");
        for(int packetSize : PacketSizes){
            if(currentBucketSize + packetSize <= bucketCapacity){
                currentBucketSize += packetSize;
                System.out.println(packetSize +"\t\t"+currentBucketSize+"\t\t"+Math.min(currentBucketSize,outputrate)+"\t\t"+Math.max(0,currentBucketSize-outputrate)+"\t\t"+"Accepted");
            }
            else{
                System.out.println(packetSize +"\t\t"+currentBucketSize+"\t\t"+Math.min(currentBucketSize,outputrate)+"\t\t"+Math.max(0,currentBucketSize-outputrate)+"\t\t"+"Dropped");
            }
            currentBucketSize=Math.max(0,currentBucketSize - outputrate);
        }

    }
}