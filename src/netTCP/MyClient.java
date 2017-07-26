package netTCP;

import java.io.*;
import java.net.*;

public class MyClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
		//1，创建客户端 必须指定服务器+  端口  此时就在连接  而UDP是在传输数据时才创建连接
		Socket client = new Socket("localhost",8888);
		//2，接受数据
		/*
		BufferedReader br = new BufferedReader(new InputStreamReader(client.getInputStream()));
		String str = br.readLine();
		System.out.println(str);*/
		//接受数据和发送数据的类型必须一致
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println(str);
	}

}
