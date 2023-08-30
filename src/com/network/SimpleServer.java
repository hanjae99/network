package com.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(5050);
            // 소켓 하나 열기
            Socket conn = server.accept();

            // 서버의 input 스트림 열기 및 보조스트림까지 연결
            InputStream is = conn.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(is);

            // 클라이언트에서 보낸 값 받기
            String str = (String) ois.readObject();
            System.out.println("서버에서 클라로부터 받은 값: " + str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
