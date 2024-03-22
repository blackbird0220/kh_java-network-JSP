package exam;


import java.io.FileOutputStream;
import java.io.IOException;

public class Test01IOService {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileOutputStream fos = null; //byte 단위 전송이므로 저장되는 데이터는 바이트 단위이므로 문자가 손상되어 나타난다. 정상적으로 인코딩되지 않음
		try {   						//Filewriter fos = null; 로 바꿔야 함
			fos = new FileOutputStream("test.txt");
			String str = "안녕하세요!"; //한글은 2바이트라서 바이트 전송이 불가능하다
			for(int i=0 ; i<str.length(); i++) {
				fos.write(str.charAt(i));
			//바이트 단위로... 문자단위로
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}finally { 
			try {
				fos.close();
			} catch(IOException e) //예외 발생여부와 관계없이 사용한 값은 반환되어야 하므로 close를 이용해서 반환구절을 넣어야 함.
			}
		}
	}
}
