package net;

import java.net.MalformedURLException;
import java.net.URL;

public class URLDemo {
	public static void main(String[] args) throws MalformedURLException{
		//����·��������Э����:����:�˿�/��Դ#��㣨�൱�ڿ��鶨λ��ÿһ�½ڣ�?�������û��Լ�����Ĳ�����
		URL url = new URL("http://www.baidu.com:80/index.html#aa?uname = bjsxt");
		URL url2 = new URL("http://www.baidu.com:80/index.html#aa?uname = bjsxt");
		System.out.println("Э�飺" + url.getProtocol());//��ȡЭ��
		System.out.println("������" + url.getHost());//��ȡ����
		System.out.println("�˿ںţ�" + url.getPort());//��ȡ�˿ں�
		System.out.println("��Դ��" + url.getFile());//��ȡ��Դ
		System.out.println("��㣺" + url.getRef());//��ȡ���
		System.out.println("�û�������" + url2.getQuery());//��ȡ�û�����,��������㣬����ʾ�գ�����������㣬�򷵻���ȷ
	
	
	  //���·������
		/*
		//���๹�������ὫAĿ¼����
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"/b.txt");*/
		
		url = new URL("http://www.baidu.com:80/a/");
		url = new URL(url,"b.txt");
		System.out.println(url.toString());
	}

}
