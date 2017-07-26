package netUDP;

import java.io.*;
import java.net.*;
/**
 * �����Լ��ķ�������
 * 1,������������ + �˿�
 * 2,׼����������
 * 3,��װ�ɰ�DatagramPacket(byte[] buf,int length)
 * 4,��������
 * 5����������-->���ֽ�����תΪΪdouble���͵�����
 * 6,�ͷ���Դ
 */
public class Serve {
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
		double res = convert(data);
		System.out.println(res);
		//5,�ͷ���Դ
		serve.close();
	}
	/**
	 * �ֽ����� + Date ������
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public static double convert(byte[] data) throws IOException{
		DataInputStream dis = new DataInputStream(new ByteArrayInputStream(data));
		double num = dis.readDouble();//�Ѿ����ֽ�������dis�������
		dis.close();
		return num;
	}
}
