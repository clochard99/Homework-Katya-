package com.socket;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket s;
    public Client(String address, int port) throws IOException {
        System.out.println("Connecting...");
        s = new Socket(address,port);
        System.out.println("Congrats!");
    }

    public static void main(String[] args) throws IOException {
        Client client1 = new Client("localhost", 5699);
        //Client client2 = new Client("null", 5699);
    }
}
