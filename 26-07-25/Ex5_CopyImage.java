package com.wipro.filestream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyImage {
    public static void main(String[] args) {
        String source = "C:\\Users\\rutik\\Downloads\\JavaLogo.png";
        String destination = "C:\\Users\\rutik\\Downloads\\copyLogo.png";

        try {
            FileInputStream input = new FileInputStream(source);
            FileOutputStream output = new FileOutputStream(destination);

            byte[] buffer = new byte[1024]; // 1KB buffer
            int bytesRead;

            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead); // <--- 3 arguments used here
            }

            input.close();
            output.close();
            System.out.println("Image copied using buffer.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
