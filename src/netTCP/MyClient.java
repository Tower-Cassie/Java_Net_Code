package netTCP;

import java.io.*;
import java.net.*;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
		//1�������ͻ��� ����ָ��������+  �˿�  ��ʱ��������  ��UDP���ڴ�������ʱ�Ŵ�������
		Socket client = new Socket("localhost",8888);
		//2����������
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str = br.readLine();
		System.out.println(str);*/
		//�������ݺͷ������ݵ����ͱ���һ��
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println(str);
	}

}
