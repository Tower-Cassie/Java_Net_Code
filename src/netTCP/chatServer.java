package netTCP;

import java.io.*;
import java.net.*;

public class chatServer {
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(9999);
		//ֻ����һ���ͻ��˽��н���
		Socket client = server.accept();
		//������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		while(true){
		String str = dis.readUTF();
		System.out.println("�������˽��յ�����-->" + str);
		//�����
			dos.writeUTF("������-->" + str);
			dos.flush();
		}
	}

}
