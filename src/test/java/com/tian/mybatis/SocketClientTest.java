package com.tian.mybatis;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

public class SocketClientTest extends DriverTest{


    private void start() throws Exception {
        Socket socket = new Socket();
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 3389);
        socket.connect(inetSocketAddress);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "utf-8"));
        printWriter.println("jinxiaoxuan");
        printWriter.flush();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
              outputStream = socket.getOutputStream();
              printWriter = new PrintWriter(new OutputStreamWriter(outputStream, "utf-8"));
            System.out.println(line);
            printWriter.println(line);
            printWriter.flush();
         }
        System.out.println("close client ");
        socket.close();
    }

    public static void main(String[] args) throws Exception {

        SocketClientTest socketClientTest = new SocketClientTest();
        socketClientTest.start();
        Thread.sleep(Integer.MAX_VALUE);

    }

}
