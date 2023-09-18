package org.example.engine;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {

    String host = "localhost";
    int port = 9999;

    {
        try {
            //创建socket服务对象
            ServerSocket serverSocket;
            serverSocket = new ServerSocket(port);
            System.out.println("TCP服务器已启动，正在等待连接...");

            //等待客户端连接
            Socket clientSocket = serverSocket.accept();
            System.out.println("客户端已连接：" + clientSocket.getInetAddress());

            //获取输入流和输出流
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            BufferedWriter out = new BufferedWriter(new PrintWriter(clientSocket.getOutputStream(),true));

            //接收和处理客户端发送的信息
            String inputLine ;
            while ((inputLine = in.readLine()) != null) {
                System.out.println("接收到的数据：" + inputLine);
            }

            //关闭连接
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }





}
