package netTCP;

import java.io.*;
import java.net.*;

public class chatServer {
	public static void main(String[] args) throws IOException{
		ServerSocket server = new ServerSocket(9999);
		//只允许一个客户端进行交互
		Socket client = server.accept();
		//输入流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		while(true){
		String str = dis.readUTF();
		System.out.println("服务器端接收的数据-->" + str);
		//输出流
			dos.writeUTF("服务器-->" + str);
			dos.flush();
		}
	}

}
