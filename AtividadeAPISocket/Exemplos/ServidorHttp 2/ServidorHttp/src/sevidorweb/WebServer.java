package sevidorweb;

import java.net.*;


public class WebServer {
  public static void main(String[] args)throws Exception {
    int port = 80;
    System.out.println("Servidor Web nor ar rodando na porta 80...");
    ServerSocket serv= new ServerSocket(port);
    while (true) {
      Socket listem=serv.accept();
      HttpRequest request = new HttpRequest(listem);
      request.start();
    }
  }
}
