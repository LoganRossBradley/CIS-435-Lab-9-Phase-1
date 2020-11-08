/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phase1Base;

import java.math.BigInteger;
import java.util.Arrays;
import static phase1Base.Common.*;
import phase1Base.Common.Role;

/**
 *
 * @author yun
 */
public class User {

    private String name;
    private Role role;

    private BigInteger msg, ks, hashBase;
    BigInteger[] pubKey = new BigInteger[2]; // (n, e)
    BigInteger[] privateKey = new BigInteger[2]; // (n, d)

    User(String name, Role role, boolean fixedData) {

        this.name = name;
        this.role = role;

        
        if (fixedData) {
            msg = BigInteger.valueOf(17);
            ks = BigInteger.valueOf(5);
            hashBase = BigInteger.valueOf(13);
        } else {
            // James: If not using fixed data, generate random values
            Integer randMsg = (int) (java.lang.Math.random()*17+1);
            Integer randKs = (int) (java.lang.Math.random()*5+1);
            Integer randHashbase = (int) (Math.random()*13+1);
            msg.valueOf(randMsg);
            ks.valueOf(randKs);
            hashBase.valueOf(randHashbase);
        }

    }

    User(String name, Role role) {
        this.name = name;
        this.role = role;

        // James: If not using fixed data, generate random values
            Integer randMsg = (int) (java.lang.Math.random()*17+1);
            Integer randKs = (int) (java.lang.Math.random()*5+1);
            Integer randHashbase = (int) (Math.random()*13+1);
            msg.valueOf(randMsg);
            ks.valueOf(randKs);
            hashBase.valueOf(randHashbase);
        
    }

    User(BigInteger msg, BigInteger ks, BigInteger hashBase) {

        this.msg = msg;
        this.ks = ks;
        this.hashBase = hashBase;

    }

    public void printDetails() {

        System.out.println(indent1 + "Original Msg from Sender (msg): " + getMsg());
        System.out.println(indent1 + "Random Session Key (Ks): "
                + getKs());
        System.out.println(indent1 + "Choose hash function with (hashBase): "
                + getHashBase());

    }

    @Override
    public String toString() {

        if (role.equals(Role.RECEIVER)) {

            return "Receiver {" + "name=" + name + ", msg=" + msg + ", ks=" + ks + ", hashBase=" + hashBase
                    + ", pubKey=" + Arrays.toString(pubKey) + ", privateKey=" + Arrays.toString(privateKey) + '}';
        }

        return "Sender {" + "name=" + name + ", msg=" + msg + ", ks=" + ks + ", hashBase=" + hashBase
                + ", pubKey=" + Arrays.toString(pubKey) + ", privateKey=" + Arrays.toString(privateKey) + '}';
    }

    
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger[] getPubKey() {
        return pubKey;
    }

    public void setPubKey(BigInteger[] pubKey) {
        this.pubKey = pubKey;
    }

    public BigInteger[] getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(BigInteger[] privateKey) {
        this.privateKey = privateKey;
    }

    public BigInteger getMsg() {
        return msg;
    }

    public void setMsg(BigInteger msg) {
        this.msg = msg;
    }

    public BigInteger getKs() {
        return ks;
    }

    public void setKs(BigInteger ks) {
        this.ks = ks;
    }

    public BigInteger getHashBase() {
        return hashBase;
    }

    public void setHashBase(BigInteger hashBase) {
        this.hashBase = hashBase;
    }

}
