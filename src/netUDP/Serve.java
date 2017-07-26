package netUDP;

import java.io.*;
import java.net.*;
/**
 * 构建自己的服务器端
 * 1,创建服务器端 + 端口
 * 2,准备接受容器
 * 3,封装成包DatagramPacket(byte[] buf,int length)
 * 4,接受数据
 * 5，分析数据-->将字节数组转为为double类型的数据
 * 6,释放资源
 */
public class Serve {
	public static void main(String[] args) throws IOException{
		//1,创建服务器端 + 端口
		DatagramSocket serve = new DatagramSocket(8888);
		//2,准备接受容器
		byte[] container = new byte[1024];
		//3,封装成包DatagramPacket(byte[] buf,int length)
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4,接受数据
		serve.receive(packet);
		//5，分析数据
		byte[] data = packet.getData();
		double res = convert(data);
		System.out.println(res);
		//5,释放资源
		serve.close();
	}
	/**
	 * 字节数组 + Date 输入流
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();//已经将字节数组与dis相关联了
		dis.close();
		return num;
	}
}
