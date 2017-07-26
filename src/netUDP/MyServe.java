package netUDP;
import java.io.IOException;
/**
 * 构建自己的服务器端
 * 1,创建服务器端 + 端口
 * 2,准备接受容器
 * 3,封装成包DatagramPacket(byte[] buf,int length)
 * 4,接受数据
 * 5，分析数据
 * 6,释放资源
 */
import java.net.*;

public class MyServe {
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
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		//5,释放资源
		serve.close();
	}

}
