import java.util.*;
class RED{
    public static class RandomEarlyDetection{
        private double minThreshold;
        private double maxThreshold;
        private int QueueSize;
        private int currentQueue;
        private double maxDropProb;

        RandomEarlyDetection(double min,double max,int size,double prob){
            minThreshold = min;
            maxThreshold = max;
            maxDropProb = prob;
            currentQueue = 0;
            QueueSize = size;
        }

        public boolean enqueue(){
            if(currentQueue >= QueueSize){
                System.out.println("Packet Dropped");
                return false;
            }
            double dropProb = calcdropProb();

            if(dropProb > 0 && shouldDrop(dropProb)){
                System.out.println("Packet Dropped (RED)");
                return false;
            }
            currentQueue++;
            System.err.println("Packet Enqueued Succesfully. Queuesize:" +currentQueue);
            return true;

        }

        public double calcdropProb(){
            if(currentQueue < minThreshold)
                return 0.0;
            else if(currentQueue >= maxThreshold)
                return 1.0; 
            else 
                return maxDropProb * ((currentQueue - minThreshold) /(maxThreshold - minThreshold));
        }

        private boolean shouldDrop(double prob){
            Random random = new Random();
            return random.nextDouble() > prob;
        }

    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        double min,max,prob;
        int size;
        System.out.println("Enter minThreshold:");
        min = sc.nextDouble();
        System.out.println("Enter maxThreshold:");
        max = sc.nextDouble();
        System.out.println("Enter QueueSize:");
        size = sc.nextInt();
        System.out.println("Enter Drop Probability:");
        prob = sc.nextDouble();

        System.out.println("Enter number of packets:");
        int n = sc.nextInt();

        RandomEarlyDetection red = new RandomEarlyDetection(min,max,size,prob);
        for(int i=0;i<n;i++){
            red.enqueue();
        }
    }
}