package net;
/**
 * 利用InetAddress的三种方法创建InetAddress对象
 * 1）getLocalHost();
 * 2）getByName("www.163.com");//根据域名得到InetAddress对象
 * 3）getByName("61.135.253.15");//根据ip得到InetAddress对象
 */
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetDemo {
	public static void main(String[] args) throws UnknownHostException{
		//使用getLocalHost()方法创建InetAddress对象
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address.getHostAddress());//返回 150.141.247.244
		System.out.println(address.getHostName());//输出计算机名
		//根据域名得到InetAddress对象
		address = InetAddress.getByName("www.163.com");
		System.out.println(address.getHostAddress());//返回163服务器的ip:61.135.253.15
		System.out.println(address.getHostName());//输出：www.163.com
		//根据ip得到InetAddress对象
		address = InetAddress.getByName("61.135.253.15");
		System.out.println(address.getHostAddress());//返回163服务器的ip:61.135.253.15
		System.out.println(address.getHostName());//输出ip而不是域名。如果这个IP地址不在,则返回LocalHost
	}

}
