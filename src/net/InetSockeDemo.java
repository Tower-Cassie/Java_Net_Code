package net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * ��װ�˿ڣ���InetSocketAddress������ + �˿�
 * @author xiaohong
 *
 */
public class InetSockeDemo {
	public static void main(String[] args) throws UnknownHostException{
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",9229);//Ip��ַ���˿ں�
		//�˷���������ķ�����һ�µģ��˷�����JDKʵ�ֵ�ԭ��
		address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9229);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());//���أ���ַ
		System.out.println(addr.getHostName());//����������
	}
}
