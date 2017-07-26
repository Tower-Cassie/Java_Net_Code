package netTCP;
/**
 * 创建客户端:发送数据 + 接收数据
 * 写出数据：输出流
 * 读取数据:输入流
 * 
 * 输入流与输出流在同一个线程内 应该独立处理，彼此独立
 */
import java.io.*;
import java.net.*;

public class chatClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket client = new Socket("localhost",9999);
		//控制台输入流
		System.out.println("请从控制台输入信息：");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info = br.readLine();
		//输出流
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(info);
		dos.flush();
		//输入流
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println("客户端接收的数据-->" + str);
	}

}
