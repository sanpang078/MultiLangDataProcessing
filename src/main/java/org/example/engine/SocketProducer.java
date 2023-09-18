package org.example.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketProducer {

    public static void main(String[] args) {
        String host = "localhost";
        int port = 9999;

        try {
            Socket socket = new Socket(host, port);
            System.out.println("已连接到服务器：" + host + ":" + port);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String message = "Hello, Server!";
            out.println(message);
            System.out.println("已发送数据：" + message);

            out.close();
            socket.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
