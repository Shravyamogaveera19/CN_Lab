import java.math.BigInteger;
import java.util.*;

class RSAalgorithm{
    BigInteger puk,prk,mod;

    void getKeys(int bitlength)
    {
        Random r = new Random();
        BigInteger p = BigInteger.probablePrime(bitlength,r);
        BigInteger q = BigInteger.probablePrime(bitlength,r);
        mod = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        puk = BigInteger.probablePrime(bitlength/2, r);
        while(!phi.gcd(puk).equals(BigInteger.ONE) || puk.compareTo(phi) >= 0){
            puk = BigInteger.probablePrime(bitlength/2,r);
        }
        prk = puk.modInverse(phi);
    }
    BigInteger encrypt(BigInteger m)
    {
        return m.modPow(puk,mod);
    }
    BigInteger decrypt(BigInteger c){
        return c.modPow(prk,mod);
    }
}
class RSA{
    public static void main(String args[]){
        RSAalgorithm rsa = new RSAalgorithm();
        rsa.getKeys(512);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Data to encrypt:");
        BigInteger m = new BigInteger(sc.next().getBytes());
        BigInteger c = rsa.encrypt(m);
        System.out.println("Encrypted msg is:"+ c.longValue());
        BigInteger d = rsa.decrypt(c);
        System.out.println("Decrypted message:"+ new String(d.toByteArray()));

    }
}