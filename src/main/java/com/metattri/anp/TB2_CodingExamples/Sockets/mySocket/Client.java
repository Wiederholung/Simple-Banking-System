package com.metattri.anp.TB2_CodingExamples.Sockets.mySocket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        // byte[] ipAddr = new byte[] {10, 28, (byte) 233, 15};
        // try (Socket socket = new Socket(InetAddress.getByAddress(ipAddr), Server.PORT)) {
        try (Socket socket = new Socket(InetAddress.getByName("localhost"), Server.PORT)) {
            System.out.println("Connected to server");

            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader key_in = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            PrintWriter output = new PrintWriter(out, true);

            String str;
            do {
                str = key_in.readLine();
                output.println(str);
                System.out.println("Send: " + str);
                System.out.println("Rec: " + input.readLine());
            } while (!str.equals("end"));
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}