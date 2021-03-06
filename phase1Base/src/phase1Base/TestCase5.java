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
public class TestCase5 {
    public static void main(String[] args) {

        String case01 = "CASE #0_1 | Initialize Sender (Fixed Data) ";
        System.out.println(caseSeperator("*", case01));

        boolean fixedData = true;
        User amySender = createSender("Amy", fixedData);
        getRSAKeys(amySender);
        System.out.println("==> Sender's Status | " + amySender.toString() + "\n");

        String case02 = "CASE #0_2 | Initialize Receiver (Fixed Data) ";

        System.out.println(caseSeperator("*", case02));

        User bobReceiver = createReceiver("Bob");
        getRSAKeys(bobReceiver);

        System.out.println("==> Receiver's Status | " + bobReceiver.toString() + "\n");

        String case1 = "CASE #5: Suppose Sender wants to send a secret message to Receiver with a digital signature";

        System.out.println(caseSeperator("*", case1));

        String senderCase1 = "Sender Operations";
        System.out.println(caseSeperator("+", senderCase1));

        //hash the message
        BigInteger hash = hash(amySender.getMsg(), amySender.getHashBase());

        //encrypt the hashed message
        BigInteger cipher = senderCase1(amySender, bobReceiver);
        System.out.println("==> Sender sends out cipher = | " + cipher + "\n");
        String receiverCase1 = "Receiver Operations";
        System.out.println(caseSeperator("+", receiverCase1));

        //bob checks hash
        if(hash.equals(hash(cipher, amySender.getHashBase())))
        {
            System.out.println(indent1 + "Hash is valid");
        }
        else
        {
            System.out.println(indent1 + "Hash is not valid");
        }
        BigInteger msg = receiverCase1(bobReceiver, cipher);

        System.out.println("==> Receiver receives and decrypt msg = | " + msg + "\n");
    }

}


