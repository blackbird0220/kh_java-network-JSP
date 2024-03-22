package exam;

import java.net.ServerSocket;
import java.net.Socket;

public class Test04server {

	public static void main(String[] args) {
		ServerSocket server = new ServerSocket(); //오류1. 서버클래스에 포트번호가 지정되지 않아 서버소켓이 생성되지 않아 통신 불가			
		//Serverocket server = new ServerSocket(3000);으로 수정
		Socket s = server.accept();

	}

}
