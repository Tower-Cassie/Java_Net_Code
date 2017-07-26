package net;

import java.io.*;
import java.net.*;

public class wetURLdemo {
	public static void main(String[] args) throws IOException{
		URL url = new URL("http://www.baidu.com");//主页默认资源，即访问百度主页
		/*
		//获取资源网络流,此方法获取的网络资源有乱码，解码和编码的码制不一样
		InputStream io = url.openStream();//获取指定的资源
		byte[] flush = new byte[1024];//获取的字节数
		int len = 0;
		while((len = (io.read(flush))) != -1){
			System.out.println(new String(flush,0,len));
		}
		io.close();
		
		//统一编码和解码的格式
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		String msg = null;
		while((msg = br.readLine()) != null){
			System.out.println(msg);
		}
		br.close();*/
		//将获取的资源输出到NET包下指定的文件中
		//输入流
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		//输出流
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),"utf-8"));
		String msg = null;
		while((msg = br.readLine()) != null){
			bw.append(msg);
			bw.newLine();
		}
		bw.flush();
		bw.close();
		br.close();
	}
	
	
	

}
