package exam;

public class Test0601 {

	public static void main(String[] args) {
		package kr.or.iei.run;
		import java.io.BufferedReader;
		import java.io.IOException;
		import java.io.InputStreamReader;
		import java.io.PrintWriter;
		import java.net.Socket;
		import java.util.Scanner;
		public class Client {
			public static void main(String[] args) {
				Scanner sc = new Scanner(System.in);
				BufferedReader br = null;
				PrintWriter pw = null;
				Socket socket = null;
				int port = 3000;
				try {
					socket = new Socket(port);
					if(socket != null) {
						System.out.println("[Client]");
						System.out.println("서버와 연결 성공!");
						br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
						pw = new PrintWriter(socket.getOutputStream());
					// 이하 코드는 중간 생략..

					}
				}
			}
		}
	}