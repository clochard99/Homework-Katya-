package com.socket;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket ss;
    final Scanner sc = new Scanner(System.in);
    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
        System.out.println("Waiting for a client...");
        Socket client1 = ss.accept();
        System.out.println("A client has joined..");
        BufferedReader in = new BufferedReader(new InputStreamReader(client1.getInputStream()));
        PrintWriter out = new PrintWriter(client1.getOutputStream(), true);
        Thread receiver = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                try {
                    message = in.readLine();
                    while (message!=null) {
                        System.out.println("Client 1:" + "\u001B[35m" + message + "\u001B[0m");
                        message = in.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A client has disconnected...");
                out.close();
                try {
                    client1.close();
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        receiver.start();
        Socket client2 = ss.accept();
        System.out.println("A new client has joined..");

        BufferedReader in1 = new BufferedReader(new InputStreamReader(client2.getInputStream()));
        PrintWriter out1 = new PrintWriter(client2.getOutputStream(), true);
        Thread receiver1 = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                try {
                    message = in1.readLine();
                    while (message!=null) {
                        System.out.println("Client 2:" + "\u001B[35m" + message + "\u001B[0m");
                        message = in1.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A client has disconnected...");
                out1.close();
                try {
                    client2.close();
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        receiver1.start();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5699);
    }
}
