package netTCP;
import java.io.*;
import java.net.*;

public class MyServer {
	public static void main(String[] args) throws IOException{
		//1������������ ָ���˿�
			ServerSocket server = new ServerSocket(8888);
		//2,���ܿͻ������� ����ʽ
			Socket socket = server.accept();
			System.out.println("һ���ͻ��˽�������");//�����������������   http://localhost:8888 ��ʱ��������ʾ����
		//3����������
			String msg = "��ӭʹ�÷�����";
			/*
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(msg);//����bw.close(),��Ϊ��ص���������
			bw.newLine();//�˴��ǳ���Ҫ���ڶ�ȡ����ʱ�ǰ���������ȡ�ģ����Դ˴��������һ���еı�Ƿ���Ҳ�������ַ������\n
			bw.flush();//ˢ��*/
			//Ϊ�˷�ֹ©��bw.newLine(),ʹ��DataOutputStream
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}

}
