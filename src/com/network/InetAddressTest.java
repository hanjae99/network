package com.network;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class InetAddressTest {
    public static void main(String[] args) {
        InetAddress addr1 = null, addr2 = null;
        System.out.println("호스트 이름을 입력하세요: ");
        Scanner in = new Scanner(System.in);
        String url = in.nextLine();
//        System.out.println(url);

        try {
            addr1 = InetAddress.getByName(url);
            addr2 = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        System.out.println(url + "의 IP주소: ");
        System.out.println(addr1);
        System.out.println(addr1.getHostAddress());
        System.out.println("로컬 IP주소: ");
        System.out.println(addr2.getHostAddress());
    }
}
