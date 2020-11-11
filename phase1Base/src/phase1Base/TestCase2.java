package phase1Base;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Set;
import static phase1Base.Common.*;
import static phase1Base.TestingMethods.*;

/**
 * @author #04 | Moom Firdous 
 * @author #10 | Meridith Kcoh 
 * @author #12 | James Mckean
 * @author #15 | Logan Ross
 */
public class TestCase2 {

    public static void main(String[] args) {
        
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

        String case2 = "CASE #2: Using public-key cryptography, suppose Sender wants to send a message to Receiver and"
                + "Receiver wants to be sure that the message was indeed sent by the Sender";

        System.out.println(caseSeperator("*", case2));

        String senderCase1 = "Sender Operations";
        System.out.println(caseSeperator("+", senderCase1));

        BigInteger cipher = senderCase2(amySender, bobReceiver);

        System.out.println("==> Sender sends out cipher = | " + cipher + "\n");
        String receiverCase2 = "Receiver Operations";
        System.out.println(caseSeperator("+", receiverCase2));

        BigInteger msg = receiverCase1(bobReceiver, cipher);

        System.out.println("==> Receiver receives and decrypt msg = | " + msg + "\n");

    }

}

   