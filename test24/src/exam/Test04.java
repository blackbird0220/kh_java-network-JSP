package exam;

import java.net.ServerSocket;
import java.net.Socket;

public class Test04 {

	public static void main(String[] args) {
		ServerSocket server = new ServerSocket();
		Socket s = server.accept();

	}

}
