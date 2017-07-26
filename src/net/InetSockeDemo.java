package net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * 封装端口：在InetSocketAddress基础上 + 端口
 * @author xiaohong
 *
 */
public class InetSockeDemo {
	public static void main(String[] args) throws UnknownHostException{
		InetSocketAddress address = new InetSocketAddress("127.0.0.1",9229);//Ip地址，端口号
		//此方法与上面的方法是一致的，此方法是JDK实现的原理
		address = new InetSocketAddress(InetAddress.getByName("127.0.0.1"),9229);
		System.out.println(address.getHostName());
		System.out.println(address.getPort());
		
		InetAddress addr = address.getAddress();
		System.out.println(addr.getHostAddress());//返回：地址
		System.out.println(addr.getHostName());//输出计算机名
	}
}
