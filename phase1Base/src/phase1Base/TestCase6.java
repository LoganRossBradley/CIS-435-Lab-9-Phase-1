/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1Base;

import java.math.BigInteger;
import java.util.Arrays;
import static phase1Base.Common.*;
import static phase1Base.TestingMethods.*;
import static phase1Base.Cryptography.*;

/**
 * @author #04 | Moom Firdous 
 * @author #10 | Meridith Kcoh 
 * @author #12 | James Mckean
 * @author #15 | Logan Ross
 */
public class TestCase6 {
    public static void main(String[] args) {

        String case01 = "CASE #0_1 | Initialize Sender (Fixed Data) ";
        System.out.println(caseSeperator("*", case01));

        boolean fixedData = false;
        User amySender = createSender("Amy", fixedData);
        getRSAKeys(amySender);
        System.out.println("==> Sender's Status | " + amySender.toString() + "\n");

        String case02 = "CASE #0_2 | Initialize Receiver (Fixed Data) ";

        System.out.println(caseSeperator("*", case02));

        User bobReceiver = createReceiver("Bob");

        System.out.println("==> Receiver's Status | " + bobReceiver.toString() + "\n");
/////////
        String case1 = "CASE #6: Suppose Sender wants to send a secret message to Receiver with a MAC";

        System.out.println(caseSeperator("*", case1));

        System.out.println( indent1 + "------------------Start | senderOperationsCase6 ----------------");

        //hash the message
        BigInteger hash = hash(amySender.getMsg(), amySender.getHashBase());
        System.out.println( indent2 + "Message: " + amySender.getMsg());
        System.out.println( indent2 + "Hash Base: " + amySender.getHashBase());
        System.out.println( indent2 + "Hashed message: "+ hash);
        System.out.println(indent1 + "------------------End | senderOperationsCase6 ----------------");

        System.out.println("\n" + indent1 + "------------------ Start | receiverOperationsCase6 ----------------");
        bobReceiver.setMsg(amySender.getMsg());
        //bob checks hash
        if(hash.equals(hash(hash, amySender.getHashBase())))
        {
            System.out.println(indent2 + "Hash is valid");
        }
        else
        {
            System.out.println(indent2 + "Hash is not valid");
        }
        System.out.println( indent2 + "Hashed message: "+ hash);
        System.out.println( indent2 + "Message: "+ bobReceiver.getMsg());
        System.out.println( indent2 + " " + bobReceiver.toString());
        System.out.println( indent1 + "------------------ End | receiverOperationsCase6 ----------------");

        System.out.println("==> Receiver receives msg = | " + bobReceiver.getMsg() + "\n");
    }

}


