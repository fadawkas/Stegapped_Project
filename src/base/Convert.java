/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;


import java.nio.charset.Charset;
import java.math.BigInteger;
/**
 *
 * @author mfada
 */
public class Convert {
    
    void conToString(StringBuilder binary) {
        try {
            BigInteger val = new BigInteger("" + binary, 2);
            byte[] imageInByte = val.toByteArray();
            String hi = new String(imageInByte);
            System.out.println(hi);
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    // Module to Convert String to Binary
    void conToBinary(String s) {
        byte[] arr = s.getBytes(Charset.forName("UTF-8"));
        StringBuilder binary = new StringBuilder();
        for (byte b : arr) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        System.out.println("'" + s + "' to binary: " + binary);
        conToString(binary);
    }

    byte[] txtToByte(String s) {
        byte[] arr = s.getBytes(Charset.forName("UTF-8"));
        return arr;
    }

    void conToBinary(byte[] barr) {
        StringBuilder binary = new StringBuilder();
        for (byte b : barr) {
            int val = b;
            for (int i = 0; i < 8; i++) {
                binary.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        System.out.println(" to binary: " + binary);
        conToString(binary);
    }    
}
