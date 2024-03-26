package server;

import service.EchoService;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {
    private Socket clientSocket;
    private ServerSocket serviceSocket;
    private final int port = 3290;
    public EchoServer() throws IOException {
        this.serviceSocket =  new ServerSocket(port);
    }
    public void getRequest() throws IOException {
        while( true ){
            this.clientSocket = this.serviceSocket.accept();
            new EchoService(this.clientSocket).echo();
        }
    }

    public static void main (String[] args) throws IOException {
        System.out.println("Servidor on: ");
        new EchoServer().getRequest();
    }

}