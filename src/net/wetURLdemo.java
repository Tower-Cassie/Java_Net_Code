package net;

import java.io.*;
import java.net.*;

public class wetURLdemo {
	public static void main(String[] args) throws IOException{
		URL url = new URL("http://www.baidu.com");//��ҳĬ����Դ�������ʰٶ���ҳ
		/*
		//��ȡ��Դ������,�˷�����ȡ��������Դ�����룬����ͱ�������Ʋ�һ��
		InputStream io = url.openStream();//��ȡָ������Դ
		byte[] flush = new byte[1024];//��ȡ���ֽ���
		int len = 0;
		while((len = (io.read(flush))) != -1){
			System.out.println(new String(flush,0,len));
		}
		io.close();
		
		//ͳһ����ͽ���ĸ�ʽ
		
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		String msg = null;
		while((msg = br.readLine()) != null){
			System.out.println(msg);
		}
		br.close();*/
		//����ȡ����Դ�����NET����ָ�����ļ���
		//������
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"utf-8"));
		//�����
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
