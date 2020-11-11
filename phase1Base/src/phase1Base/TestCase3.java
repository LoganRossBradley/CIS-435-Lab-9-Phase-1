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
public class TestCase3 {
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
        bobReceiver.setKs(amySender.getKs());
        bobReceiver.setHashBase(amySender.getHashBase());

        System.out.println("==> Receiver's Status | " + bobReceiver.toString() + "\n");

        String case1 = "CASE #3: Suppose Sender wants to send a secret message to Receiver and the receiver wants to be sure that "
            +"the message was indeed the original one";

        System.out.println(caseSeperator("*", case1));

        String senderCase1 = "Sender Operations";
        System.out.println(caseSeperator("+", senderCase1));

        //add shift cipher
        BigInteger msg = shift(amySender.getMsg(), amySender.getKs());
        System.out.println("Msg with shift cipher: " + msg);

        //hash shifted cipher
        BigInteger hash = hash(msg, amySender.getHashBase());
        System.out.println("Hashed message: " + hash);

        //bob checks hash
        if(hash.equals(hash(msg, amySender.getHashBase())))
        {
            System.out.println(indent1 + "Hash is valid");
        }
        else
        {
            System.out.println(indent1 + "Hash is not valid");
        }
        //remove shift cipher
        msg = shift(msg, BigInteger.valueOf(-1).multiply(amySender.getKs()));
        System.out.println(indent1 + "Msg after removing shift cipher: " + msg);

        System.out.println("==> Receiver receives and decrypt msg = | " + msg + "\n");

    }

}


