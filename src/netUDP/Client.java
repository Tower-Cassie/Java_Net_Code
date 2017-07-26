package netUDP;

import java.io.*;
import java.net.*;
/**
 * 创建自己的客户端
 * 1，创建客户端+ 端口
 * 2，准备数据---->字节数组  字节数组输出流
 * 3，打包（发送的地点及端口）
 * 4，发送
 * 5,释放资源
 */

public class Client {
	public static void main(String[] args) throws IOException{
		//1，创建客户端+ 端口
		DatagramSocket client = new DatagramSocket(6666);
		//2，准备数据
		double num = 12.12;
		byte[] data = convert(num);
		//3，打包（发送的地点及端口）
		//DatagramSocket(byte[] buf,int lenth,InetSockettAddress address)
		DatagramPacket packet = new DatagramPacket(data,data.length,new InetSocketAddress("localhost",8888));
		//4，发送
		client.send(packet);
		//5,释放资源
		client.close();
	}
	/**
	 * 字节数组 数据源 + Data输出流
	 * @param num
	 * @return
	 * @throws IOException 
	 */
	public static byte[] convert(double num) throws IOException{
		byte[] data = null;
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		DataOutputStream dos = new DataOutputStream(bos);
		//DataOutputStream dos = new DataOutputStream(new ByteArrayOutputStream());
		dos.writeDouble(num);
		dos.flush();//刷新
		//获取数据
		data = bos.toByteArray();
		dos.close();
		return data;
	}

}
