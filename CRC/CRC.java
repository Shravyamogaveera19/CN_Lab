import java.util.*;

class CRC{


    public static String divide(char[] dividend ,char[] divisor){
        
        int m = dividend.length;
        int n = divisor.length;
        for(int i=0;i<n;i++)
        {
            if(dividend[i] == '1'){
                if(n-i < m){
                    break;                        
                }

                for(int j=0;j<m;j++){
                    dividend[i+j] = divisor[j] == '0'? dividend[i+j] :dividend[i+j] == '1'? '0':'1';
                }
            }
        }
        return new String(dividend).substring(n-m+1);
    }

    public static String encode(String data,String key){
        return data + divide((data + "0".repeat(key.length() - 1)).toCharArray(), key.toCharArray());
    }

    public static boolean decode(String encodedData,String key){
        return divide(encodedData.toCharArray(),key.toCharArray()).contains("1");
    }

    public static void main(String args[]){
      
      Scanner sc = new Scanner(System.in);

      System.out.println("Enter the key:");
      String key = sc.next();

      System.out.println("Enter the Binary data:");
      System.out.println(encode(sc.next(),key));

      System.out.println("Enter the encoded data:");
      System.out.println( decode(sc.next(),key)? "Error is present": "Error free data");
    }

}