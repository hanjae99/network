package com.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo1Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        Socket conn = null;
        BufferedReader in = null;

        try {
            server = new ServerSocket(5050);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("연결 대기중...");

        // 서버가 가지고있는 소켓 가져다줌
        try {
            conn = server.accept();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("메세지를 기다리는 중..");
        in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String msg;
        while ((msg = in.readLine()) != null){
            // 클라에서 끝 이라고 입력 시 서버 종료
            if (msg.contains("끝")){
                break;
            }
            System.out.println("읽은 메세지: " + msg);
        }
        System.out.println("서버 종료!");
        in.close();
        conn.close();
        server.close();
    }
}
