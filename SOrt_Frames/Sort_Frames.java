//Java Programs for Sorting packets
import java.util.*;
class Sort_Frames{

    
    static class Frame{
        int fnum;
        String content;

        Frame(int num,String c){
            this.fnum = num;
            this.content = c;
        }
    }

    public static void sorting(int n,Frame[] F){

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n-i-1;j++){
                if(F[j].fnum > F[j+1].fnum){
                    int a = F[j].fnum; int b= F[j+1].fnum;
                    String s= F[j].content; 
                    String t=F[j+1].content;
                    F[j].fnum = b;
                    F[j+1].fnum = a;
                    F[j].content = s;
                    F[j+1].content = t;
                }
            }
        }
    }

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of frames");
        int n = sc.nextInt();
        Frame[] F= new Frame[n];
        for(int i=0;i<n;i++)
        {
            System.out.println("Enter the frame number:");
            int a = sc.nextInt();
            System.out.println("Enter the frame content:");
            String b = sc.next();
            F[i] = new Frame(a,b);
        }

        //To Shuffle Packets
        List<Frame> frameList = new ArrayList<>(Arrays.asList(F));
        Collections.shuffle(frameList);
        F = frameList.toArray(new Frame[0]);

        System.out.println("Before Sorting:\n");
        for(int i=0;i<n;i++)
        {
            System.out.print(F[i].fnum +" ");
        }
        
        sorting(n,F);

        System.out.println("After Sorting:\n");
        for(int i=0;i<n;i++)
        {
            System.out.print(F[i].fnum +" ");
        }
    }
}