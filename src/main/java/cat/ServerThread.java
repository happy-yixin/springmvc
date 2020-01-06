package cat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThread {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = new ServerSocket(8080);
        System.out.println("开启服务器...");
        Socket socket = serverSocket.accept();
        System.out.println("连接客户端："+ socket.getInetAddress().getHostAddress());

        new Received(socket,"server").start();

        new Send(socket,"client").start();
    }
}
