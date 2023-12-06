/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package base;

import java.io.*;
import java.security.MessageDigest;

/**
 *
 * @author mfada
 */
public class PasswordManager {
    private static final String PASSWORDS_FILE_PATH = System.getProperty("user.home") + File.separator + ".stegaApp" + File.separator + "passwords.txt";

    public static String getPasswordHashEN() {
        String password = PassEncodeGUI.enteredPassword;

        // Use a secure hashing algorithm, such as SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert the byte array to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static String getPasswordHashDE() {
        String password = PassDecodeGUI.enteredPassword;

        // Use a secure hashing algorithm, such as SHA-256
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes());

            // Convert the byte array to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void savePasswordToFile(String hashedPassword, String imgName) {
        try {
            File file = new File(PASSWORDS_FILE_PATH);
            file.getParentFile().mkdirs(); // Create parent directories if they don't exist

            try (FileWriter writer = new FileWriter(file, true)) {
                writer.write(imgName + "##" +hashedPassword + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean checkPassword(String enteredPassword, String imgName) throws IOException {
        String password;
        try (BufferedReader reader = new BufferedReader(new FileReader(PASSWORDS_FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.contains(imgName)){
                    password = line.substring(line.lastIndexOf("##") + 2);               
                    if (password.equals(enteredPassword)) {
                        return true; // Password is correct
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Password not found or incorrect
    }
}
