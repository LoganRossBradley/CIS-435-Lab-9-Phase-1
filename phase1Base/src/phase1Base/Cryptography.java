package phase1Base;

import java.math.BigInteger;
import static phase1Base.Common.*;

/**
 *
 * @author yun
 */
public class Cryptography {

    private RSA rsa;

    Cryptography() {

        System.out.println(indent2 + "Run Cryptography --------");
    
        //TODO

    }

   
    // Use the mapping provided in our ICE, and you can modify the header of this method
    static public BigInteger CBC() {
     
        //TODO
        return BigInteger.ZERO;
    }

    static public BigInteger hash(BigInteger msg, BigInteger hashBase) {
        BigInteger msgCopy = msg;
        BigInteger hashValue = msgCopy.mod(hashBase);
        return hashValue;
    }

    static public BigInteger shift(BigInteger msg, BigInteger ks) {
        //TODO
        return null;
    }

    //(n, e)
    public void getPublicKey(BigInteger[] pubKey) {
       
        //TODO

    }

    // (n, d)
    public void getPrivateKey(BigInteger[] privateKey) {
       //TODO
    }

}
