package exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

//전 하나도 모르겠어요 \\^ㅡ^//
public class Client {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		int port = 3000;
		
		try {
			socket = new Socket("127.0.0.1",6000);
			if(socket != null) {
				System.out.println("[Client]");
				System.out.println("서버와 연결 성공!");
				br = new BufferedReader(new InputStream)
			}
			
			
			
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
