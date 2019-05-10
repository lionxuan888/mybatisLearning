package com.tian.mybatis;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServerTest {

    public void startListen() throws Exception {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 3389);
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(inetSocketAddress);
        while (true) {
            Socket accept = serverSocket.accept();
            System.out.println("client connected: " + accept);
            InputStream input = accept.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(input, "utf-8"));
            String line = br.readLine();
            System.out.println("login as:" + line);

            new Aysn(accept).start();
        }


    }

    public class Aysn extends Thread {
        private final Socket socket;

        public Aysn(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                System.out.println("running...");
                InputStream input = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(input, "utf-8"), 1);
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println("fefef");
                    System.out.println(line);
                }
                System.out.println("ending");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) throws Exception {
        SocketServerTest socketServer = new SocketServerTest();
        socketServer.startListen();
    }

}
