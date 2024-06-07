package Test;

import AES.Util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class test {
    public static void main(String[] args) throws Exception {
        String encryptedText = Util.encryptString("Hello");
        System.out.println(encryptedText);
        System.out.println(Util.decryptString(encryptedText));
    }
}
