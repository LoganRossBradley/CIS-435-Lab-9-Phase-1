package phase1Base;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Set;
import static phase1Base.Common.*;

/**
 *
 * @author yun
 */
public class TestCase1 {

    public static void main(String[] args) {

        //SENDER Steps:        
        // Hash Message
        // Encrypt that hash value using n and d
        // Combine message and encypted hash value in array
        // Generate session key
        // Encrypt the session key with RECEIVER's public key
        // Encrypt combined message with session key (shift cipher [and/or CBC?])
        // Combine the previous message with the encrypted session key
        // Send to RECEIVER
        
        //RECEIVER Steps:
        // Split the session key and message
        // Decrypt the session key with RECEIVER's private key
        // Decrypt the message with the session key (undo shift cipher [and/or CBC?])
        // Split the message and signature
        // Hash the message
        // Decrypt the signature with SENDER's public key
        // Compare the hashes
        
        // Hash = hash function
        // Symmetric encryption = shift function
        
        String case01 = "CASE #0_1 | Initialize Sender (Random Data) ";
        System.out.println(caseSeperator("*", case01));

        // true for using fixed msg, ks, and hash value, other wise random data
        boolean fixedData = false;
        User amySender = createSender("Amy", fixedData);
        getRSAKeys(amySender);
        System.out.println("==> Sender's Status | " + amySender.toString() + "\n");

        String case02 = "CASE #0_2 | Initialize Receiver (Random Data) ";

        System.out.println(caseSeperator("*", case02));

        User bobReceiver = createReceiver("Bob");
        getRSAKeys(bobReceiver);

        System.out.println("==> Receiver's Status | " + bobReceiver.toString() + "\n");

        String case1 = "CASE #1: Suppose Sender wants to send a secret message to Receiver using public key cryptography";

        System.out.println(caseSeperator("*", case1));

        String senderCase1 = "Sender Operations";
        System.out.println(caseSeperator("+", senderCase1));

        BigInteger cipher = senderCase1(amySender, bobReceiver);
        System.out.println("==> Sender sends out cipher = | " + cipher + "\n");
        String receiverCase1 = "Receiver Operations";
        System.out.println(caseSeperator("+", receiverCase1));

        BigInteger msg = receiverCase1(bobReceiver, cipher);

        System.out.println("==> Receiver receives and decrypt msg = | " + msg + "\n");

    }

    public static void getRSAKeys(User user) {

        step++;
        System.out.println("\n--- Step #" + step + ": START - getRSAKeys()\t" + padding);

        int subStep = 1;

        System.out.println("--- Step #" + step + "-" + subStep + ": Run RSA " + "------------");

        Cryptography crypto = new Cryptography();

        subStep++;
        System.out.println("\n--- Step #" + step + "-" + subStep + ": Gets RSA keys" + "------------");

        // James: Create BigInt arrays to hold key values, fill it with the one that crypto generates
        // and pass it to the user
        BigInteger[] key1 = new BigInteger[2];
        crypto.getPublicKey(key1);
        user.setPubKey(key1);
        BigInteger[] key2 = new BigInteger[2];
        crypto.getPrivateKey(key2);
        user.setPrivateKey(key2);
        
        System.out.println(indent2 + "pubKey: " + Arrays.toString(user.getPubKey()));
        System.out.println(indent2 + "privateKey: " + Arrays.toString(user.getPrivateKey()));

        System.out.println("--- Step #" + step + ": END of getRSAKeys() \t" + padding + "\n");

    }

    public static User createSender(String name, boolean fixedData) {

        step++;
        System.out.println("\n--- Step #" + step + ": START - Sender generates\t" + padding);
        Role sendRole = Role.SENDER;
        User send = new User(name, sendRole, fixedData);
        send.toString();
        send.printDetails();
        System.out.println("--- Step #" + step + ": END of this Step \t\t" + padding + "\n");
        return send;
    }

    public static User createReceiver(String name) {

        step = 1;
        System.out.println("\n--- Step #" + step + ": START - Receiver generates\t" + padding);
        Role recvRole = Role.RECEIVER;
        User recv = new User(name, recvRole);
        System.out.println("--- Step #" + step + ": END of this Step \t\t" + padding + "\n");
        return recv;
    }

    public static void useCryptography(User user) {

        int subStep = 1;

        System.out.println("\n--- Step #" + step + "-" + subStep + ": Run RSA " + "------------");

        //TODO
        
    }

    //Suppose Bob wants to send a secret message to Alice using public key cryptography. 
    //Pa+(M)
    public static BigInteger receiverCase1(User receiver, BigInteger cipher) {

        //Retrieve public key information
        BigInteger n = null, e = null;
        BigInteger[] pubKey = receiver.getPubKey();
        if(pubKey[0] != null){
            n = pubKey[0];
        }
        if(pubKey[1] != null){
            e = pubKey[1];
        }
        
        //Encrypt with RSA
        //c=m^e mod n
        BigInteger encryptedCipher = cipher.pow(e.intValue());
        encryptedCipher = encryptedCipher.mod(n);
        
        return encryptedCipher;

    }

    public static BigInteger senderCase1(User sender, User receiver) {

        int subStep = 0;

        System.out.println(indent1 + "Sub-Step #" + subStep + ": Initial case");
        System.out.println(indent2 + sender.toString());
        receiver.setMsg(senderOperationsCase1(sender, receiver));
        
        
        return receiver.getMsg();

    }

    private static BigInteger senderOperationsCase1(User sender, User receiver) {

        System.out.println("\n" + indent2 + "------------------Start | senderOperationsCase1 ----------------");

        BigInteger eMsg = sender.getMsg();
        BigInteger[] rPub = new BigInteger[2];
        rPub = receiver.getPubKey();
        eMsg = eMsg.pow(rPub[1].intValue());
        eMsg = eMsg.mod(rPub[0]);
        System.out.println("===> Encrypted Message: " + eMsg);
        System.out.println(indent2 + "------------------ End | senderOperationsCase1 ----------------\n");
        return eMsg;

    }

    private static BigInteger receiverOperationsCase1(User receiver, BigInteger cipher) {

        System.out.println("\n" + indent2 + "------------------ Start | receiverOperationsCase1 ----------------");

        BigInteger[] rPriv = new BigInteger[2];
        rPriv = receiver.getPrivateKey();
        BigInteger plain;
        plain = receiver.getMsg().pow(rPriv[1].intValue());
        plain = plain.mod(rPriv[0]);
        
        System.out.println(indent2 + "------------------ End | receiverOperationsCase1 ----------------\n");
        return plain;
    }

}
