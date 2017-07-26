package net;
/**
 * ����InetAddress�����ַ�������InetAddress����
 * 1��getLocalHost();
 * 2��getByName("www.163.com");//���������õ�InetAddress����
 * 3��getByName("61.135.253.15");//����ip�õ�InetAddress����
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {
	public static void main(String[] args) throws UnknownHostException{
		//ʹ��getLocalHost()��������InetAddress����
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());//���� 150.141.247.244
		System.out.println(address.getHostName());//����������
		//���������õ�InetAddress����
		address = InetAddress.getByName("www.163.com");
		System.out.println(address.getHostAddress());//����163��������ip:61.135.253.15
		System.out.println(address.getHostName());//�����www.163.com
		//����ip�õ�InetAddress����
		address = InetAddress.getByName("61.135.253.15");
		System.out.println(address.getHostAddress());//����163��������ip:61.135.253.15
		System.out.println(address.getHostName());//���ip������������������IP��ַ����,�򷵻�LocalHost
	}

}
