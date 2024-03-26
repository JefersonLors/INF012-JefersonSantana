package Client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private Socket serverSocket;
    private final int serverPort = 3290;
    private final String serverIP = "192.168.1.25";
    public EchoClient() throws IOException {
        this.serverSocket = new Socket(serverIP, serverPort);
    }
    public String sendMessage( String message ) throws IOException {
        PrintWriter outMessage = new PrintWriter(this.serverSocket.getOutputStream(), true);
        Scanner inMessage = new Scanner( this.serverSocket.getInputStream());
        outMessage.println(message);
        return inMessage.nextLine();
    }

    public static void main( String[] args ) throws IOException {
        String message = new EchoClient().sendMessage("Helicóptero");
        System.out.println(message);
    }
}
