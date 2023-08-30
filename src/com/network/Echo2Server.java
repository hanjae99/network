package com.network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Echo2Server extends Thread{
    protected static boolean cont = true;
    protected Socket conn = null;

    private Echo2Server(Socket accept) {
        conn = accept;
        start();
    }

    public void run(){
        BufferedReader in;
        System.out.println("쓰레드 생성됨");
        try {
            in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String msg;
            while ((msg = in.readLine()) != null){
                System.out.println("읽은  메세지: " + msg);
            }
            in.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket server = null;
        server = new ServerSocket(5050);
        System.out.println("서버 소켓 생성중...");
        
        while (cont){
            System.out.println("연결 대기중...");
            new Echo2Server(server.accept());
        }
        server.close();
    }
}
