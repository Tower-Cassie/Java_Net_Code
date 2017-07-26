package netUDP;
import java.io.IOException;
/**
 * �����Լ��ķ�������
 * 1,������������ + �˿�
 * 2,׼����������
 * 3,��װ�ɰ�DatagramPacket(byte[] buf,int length)
 * 4,��������
 * 5����������
 * 6,�ͷ���Դ
 */
import java.net.*;

public class MyServe {
	public static void main(String[] args) throws IOException{
		//1,������������ + �˿�
		DatagramSocket serve = new DatagramSocket(8888);
		//2,׼����������
		byte[] container = new byte[1024];
		//3,��װ�ɰ�DatagramPacket(byte[] buf,int length)
		DatagramPacket packet = new DatagramPacket(container,container.length);
		//4,��������
		serve.receive(packet);
		//5����������
		byte[] data = packet.getData();
		int len = packet.getLength();
		System.out.println(new String(data,0,len));
		//5,�ͷ���Դ
		serve.close();
	}

}
