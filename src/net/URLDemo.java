package net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	public static void main(String[] args) throws MalformedURLException{
		//绝对路径构建：协议名:域名:端口/资源#瞄点（相当于看书定位到每一章节）?参数（用户自己传入的参数）
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname = bjsxt");
		URL url2 = new URL("http://www.baidu.com:80/index.html#aa?uname = bjsxt");
		System.out.println("协议：" + url.getProtocol());//获取协议
		System.out.println("域名：" + url.getHost());//获取域名
		System.out.println("端口号：" + url.getPort());//获取端口号
		System.out.println("资源：" + url.getFile());//获取资源
		System.out.println("瞄点：" + url.getRef());//获取瞄点
		System.out.println("用户参数：" + url2.getQuery());//获取用户参数,若存在瞄点，则显示空，若不存在瞄点，则返回正确
	
	
	  //相对路径构建
		/*
		//此类构建方法会将A目录隐藏
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"/b.txt");*/
		
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");
		System.out.println(url.toString());
	}

}
