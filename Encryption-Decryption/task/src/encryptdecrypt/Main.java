package encryptdecrypt;

import java.io.*;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner;
        String mode = "enc";
        int key = 0;
        String data = "";
        String algorithm = "shift";
        File inputFile = new File("");
        File outPutFile = new File("");

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-mode")) {
                mode = args[i + 1];
            } else if (args[i].equals("-data")) {
                data = args[i + 1];
            } else if (args[i].equals("-key")) {
                key = Integer.parseInt(args[i + 1]);
            } else if (args[i].equals("-in")) {
                inputFile = Paths.get(args[i + 1]).toFile();
            } else if (args[i].equals("-out")) {
                outPutFile = new File(args[i + 1]);
            } else if (args[i].equals("-alg")) {
                algorithm = args[i + 1];
            }
        }
        if (!inputFile.exists() && data.length() < 1) {
            checkMode(mode, key, outPutFile, data, algorithm);
        } else if (inputFile.exists() && data.length() > 0) {
            checkMode(mode, key, outPutFile, data, algorithm);
        } else {
            String s = readFile(inputFile);
            checkMode(mode, key, outPutFile, s, algorithm);
        }
    }

    private static void checkMode(String mode, int key, File outPutFile, String s, String alg) {
        if (mode.equals("enc")) {
            String encrypt = alg.equals("unicode") ? encrypt(s, key) : shiftEncrypt(s, key);
            if (!outPutFile.getPath().isEmpty()) {

                writeFile(outPutFile, encrypt);
            } else {
                System.out.println(encrypt);
            }
        } else {
            String decrypt = alg.equals("unicode") ? decrypt(s, key) : shiftDecrypt(s, 26 - key);
            if (!outPutFile.getPath().isEmpty()) {
                writeFile(outPutFile, decrypt);
            } else {
                System.out.println(decrypt);
            }
        }
    }


    private static String readFile(File file) {
        String message = "";
        try (Scanner scanner = new Scanner(file);) {
            while (scanner.hasNext()) {
                message += scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        } finally {
            return message;
        }
    }

    private static void writeFile(File file, String message) {
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.print(message);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    private static String encrypt(String text, int key) {
        char[] chars = getChars(text);
        String cipherText = "";
        for (int i = 0; i < chars.length; i++) {
            cipherText += (char) (chars[i] + key);
        }
        return cipherText;
    }

    private static String decrypt(String cipherText, int key) {
        char[] chars = getChars(cipherText);
        String decipherText = "";
        for (int i = 0; i < chars.length; i++) {
            decipherText += (char) (chars[i] - key);
        }
        return decipherText;
    }

    private static String shiftEncrypt(String text, int key) {
        char[] chars = getChars(text);
        String cipherText = "";
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 65 && chars[i] <= 90) {
                cipherText += (char) ((((chars[i] + key) - 'A') % 26) + 'A');
            } else if (chars[i] >= 97 && chars[i] <= 122) {
                cipherText += (char) ((((chars[i] + key) - 'a') % 26) + 'a');
            } else {
                cipherText += (char) chars[i];
            }
        }
        return cipherText;
    }

    private static String shiftDecrypt(String text, int key) {

        char[] chars = getChars(text);
        String decipherText = "";
        for (int i = 0; i < chars.length; i++) {
            if (Character.isUpperCase(chars[i])) {
                decipherText += (char) ((chars[i] + key - 'A') % 26 + 'A');
            } else {
                decipherText += (char) ((chars[i] + key - 'a') % 26 + 'a');
            }
        }
        System.out.println(decipherText);
        return decipherText;
    }

    private static char[] getChars(String text) {
        return text.toCharArray();
    }
}