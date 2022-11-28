package com.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    private Socket s;
    final Scanner sc = new Scanner(System.in);
    public Client1(String address, int port) throws IOException {
        System.out.println("Connecting...");
        s = new Socket(address,port);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Send a message:");
        Thread sender = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                while(true) {
                    message =sc.nextLine();
                    out.println(message);
                }
            }
        });
        sender.start();
    }
    public static void main(String[] args) throws IOException {
        Client1 client1 = new Client1("localhost", 5699);

    }
}
