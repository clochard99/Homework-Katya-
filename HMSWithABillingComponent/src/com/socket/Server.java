package com.socket;


import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    private ServerSocket ss;
    public Server(int port) throws IOException {
        ss = new ServerSocket(port);
        System.out.println("Waiting for a client...");
        ss.accept();
        System.out.println("Success!");
    }

    public static void main(String[] args) throws IOException {
        Server server = new Server(5699);
    }
}
