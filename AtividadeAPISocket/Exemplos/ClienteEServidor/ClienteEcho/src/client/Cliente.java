package client;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		
		Socket cliente=new Socket("127.0.0.1",3032);
		Scanner ler=new Scanner(cliente.getInputStream());
		PrintWriter escrever=new PrintWriter(cliente.getOutputStream(),true);
		
		escrever.println("Ola meu nome e maria");
		String resposta=ler.nextLine();
		System.out.println(resposta);

	}

}
