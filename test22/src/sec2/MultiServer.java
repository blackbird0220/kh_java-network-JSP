package sec2;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiServer {
	public static void main(String[] args) {
		MultiServer multi = new MultiServer();
		multi.start();

	}

	public void start() {
		/*
		String addr;
		InetAddress = null;
		
		try {
			 local = InetAddress.getLocalHost();
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server = new ServerSocket(8000);
			
		while(true) {	
			System.out.println("[Server 실행]: Client 연결 대기 중");
			socket = server.accept();
			ReceiveThread receiveThread = new ReceiveThread(socket);
			receiveThread.start(); //
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(server!=null) {
				
				try {
					server.close();
					System.out.println("[서버 종료]");
				} catch (IOException e) {
					System.out.println("[서버 소켓 통신 오류]");
					e.printStackTrace();
				}
			}
		}
	}
}
