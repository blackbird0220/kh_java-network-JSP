package sec1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

//스레드 상속받기
public class ServerBack extends Thread {
	Vector<ReceiveInfo> clientList = new Vector<>();//클라이언트 스레드 목록
	List<String> nickNameList = new ArrayList<String>();//클라이언트 대화명(닉네임) 목록
	ServerSocket serverSocket;
	Socket socket;
	private ChatServerGUI serverChatGui;

	public void setGUI(ChatServerGUI serverChatGui) {
		this.serverChatGui = serverChatGui;
	}
	
	
	public void startServer(int port) {
		
		try {
			Collections.synchronizedList(clientList);	//이거 뭐라고?
			serverSocket = new ServerSocket(port);
			System.out.println("현재 IP주소:["+InetAddress.getLocalHost()+"],"+"Port 번호 :["+port+"]");
		} catch (IOException e) {		//InetAddress
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			nickNameList.add("Admin");
			while(true) {				
				System.out.println("접속대기중");
				socket = serverSocket.accept();
				System.out.println("["+socket.getInetAddress()+"]에서 접속하셨습니다");
				ReceiveInfo receive = new ReceiveInfo(socket);
				clientList.add(receive);
				receive.start();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	
	public void transmitAll(String message) {
		for(int i=0; i<clientList.size(); i++) {
			try {
				ReceiveInfo ri = clientList.elementAt(i);
				ri.transmitAll(message);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
			
	public void removeClient(ReceiveInfo client, String nickName) {
		clientList.removeElement(client);
		nickNameList.remove(nickName);
		System.out.println("목록에서"+nickName+"를 제거하였습니다.");
		serverChatGui.userList.setText(null);
		serverChatGui.appendUserList(nickNameList);
		
	}
	
	class ReceiveInfo extends Thread {
		private DataInputStream in;
		private DataOutputStream out;
		String nickName;
		String message;
		
		public ReceiveInfo(Socket socket) {
			try {
				out = new DataOutputStream(socket.getOutputStream());
				in = new DataInputStream(socket.getInputStream());
				nickName = in.readUTF();//Line->UTF 바꾸는 이유는 한글값을 받기 위해서
				nickNameList.add(nickName);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void run() {
			try {
				serverChatGui.userList.setText(null);
				serverChatGui.appendUserList(nickNameList);
				transmitAll(nickName+"님이 입장하셨습니다.\n");
				for(int i=0; i<nickNameList.size(); i++) {
					transmitAll("+++닉네임의시작+++"+nickNameList.get(i));
				
				}
			
				serverChatGui.appendMessage(nickName + "님이 입장하셨습니다.\n");

				while(true) {
					message = in.readUTF();
					serverChatGui.appendMessage(message);
					transmitAll(message);
				}
			} catch (Exception e) {
				System.out.println(nickName+"님이 퇴장하셨습니다.");
				removeClient(this, nickName);
				transmitAll(nickName+"님이 퇴장하셨습니다.");
				
				for(int i=0; i<nickNameList.size();i++) {
					transmitAll("+++닉네임의시작+++"+nickNameList.get(i));
				}
				serverChatGui.appendMessage(nickName+"님이 퇴장하셨습니다.");
			}
		}
			
		public void transmitAll(String message) {
			try {
				out.writeUTF(message);
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}
	}
}
