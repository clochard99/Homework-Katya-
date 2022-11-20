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
        Socket client = ss.accept();
        System.out.println("A client has joined..");
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        PrintWriter out = new PrintWriter(client.getOutputStream() , true);
        Thread receiver = new Thread(new Runnable() {
            String message;
            @Override
            public void run() {
                try {
                    message = in.readLine();
                    while (message!=null) {
                        System.out.println("Client:" + "\u001B[35m" + message + "\u001B[0m");
                        message = in.readLine();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("A client has disconnected...");
                out.close();
                try {
                    client.close();
                    ss.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        receiver.start();
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5699);
    }
}
