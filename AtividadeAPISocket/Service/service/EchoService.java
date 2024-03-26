package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoService {
    private Socket clientSocket;
    public EchoService(Socket clientSocket){
        this.clientSocket = clientSocket;
    }
    public void echo( ) throws IOException {
        PrintWriter outPackage = new PrintWriter(this.clientSocket.getOutputStream(), true);
        Scanner inPackage = new Scanner( this.clientSocket.getInputStream());
        String response = inPackage.nextLine();
        outPackage.println(response.toUpperCase());
    }

}
