package netTCP;
/**
 * �����ͻ���:�������� + ��������
 * д�����ݣ������
 * ��ȡ����:������
 * 
 * ���������������ͬһ���߳��� Ӧ�ö��������˴˶���
 */
import java.io.*;
import java.net.*;

public class chatClient {
	public static void main(String[] args) throws UnknownHostException, IOException{
		Socket client = new Socket("localhost",9999);
		//����̨������
		System.out.println("��ӿ���̨������Ϣ��");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String info = br.readLine();
		//�����
		DataOutputStream dos = new DataOutputStream(client.getOutputStream());
		dos.writeUTF(info);
		dos.flush();
		//������
		DataInputStream dis = new DataInputStream(client.getInputStream());
		String str = dis.readUTF();
		System.out.println("�ͻ��˽��յ�����-->" + str);
	}

}
