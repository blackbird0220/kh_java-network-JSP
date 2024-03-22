package exam;

import java.net.InetAddress;

public class Test04client {

	public static void main(String[] args) {
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			//
			Socket s = new Socket();	//서버소켓의 ip주소와 포트번호가 지정되지 않아 통신이 불가능하다
		}								//	Socket s = new Socket(ip, "3000");

	}

}
