package server;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Servidor {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int porta=3032;
		
		ServerSocket srv=new ServerSocket(porta);
		System.out.println("Servidor no ar ...porta 3032");
		while(true) {
		 Socket novoCliente=srv.accept();
		 Scanner ler=new Scanner(novoCliente.getInputStream());
		 PrintWriter escrever=new PrintWriter(novoCliente.getOutputStream(),true);
		 
		 String mensagem=ler.nextLine();
		 System.out.println(novoCliente.getInetAddress()+": " +mensagem);
		 mensagem=mensagem.toUpperCase();
		 escrever.println(mensagem);
		}
	}

}
