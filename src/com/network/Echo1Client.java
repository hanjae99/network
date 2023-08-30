package com.network;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Echo1Client {
    public static void main(String[] args) throws IOException {
        Socket client = null;
        PrintWriter out = null;

        client = new Socket();
        System.out.println("서버와 연결 시도...");
        try {
            // timeout : 연결 대기 시간
            client.connect(new InetSocketAddress("localhost", 5050), 3000);
            System.out.println("서버와 연결 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("서버와 연결 실패");
        }
        try {
            out = new PrintWriter(client.getOutputStream(), true);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("서버와 스트림 연결 실패");
        }
        Scanner in = new Scanner(System.in);
        String msg;
        System.out.println("보낼 메세지가 있나요? ");
        while ((msg = in.nextLine()) != null){
            if (msg.contains("끝")){
                break;
            }
            // out 에게 msg 를 라인단위로 보냄
            out.println(msg);
            System.out.println("보낼 메세지가 더 있나요?");
        }
        System.out.println("클라이언트 종료.");
        out.close();
        in.close();
        client.close();
    }
}
