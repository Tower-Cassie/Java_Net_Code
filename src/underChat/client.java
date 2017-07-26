package underChat;

import java.io.*;
import java.net.*;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		System.out.println("�������û�����:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name == "") return;
		Socket client = new Socket("localhost",9999);
		new Thread(new SendClient(client,name)).start();//һ��·��
		new Thread(new RecevieClient(client)).start();//һ��·��
		
	}

}

class SendClient implements Runnable{
	//�ܵ������
	private DataOutputStream dos;
	//����̨������
	private BufferedReader br;
	//�����߳�
	private boolean running = true;
	private String name;
	//������
	public SendClient(){
		//System.out.println("��ӿ���̨��ȡ��Ϣ��");
		br = new BufferedReader(new InputStreamReader(System.in));
	}
	public SendClient(Socket client,String name){
		this();
		try {
			dos = new DataOutputStream(client.getOutputStream());
			this.name = name;
	
			Send(this.name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			running = false;
			CloseUtil.closeAll(dos,br);
		}
	}
	//�ӿ���̨��ȡ��Ϣ
	private String GetmsgFromConsole(){
		String str = null;
		try {
			str = br.readLine();
		} catch (IOException e) {
			CloseUtil.closeAll(dos,br);
			running = false;
		}
		return str;
	}
	
	/**
	 * //������Ϣ
	 * 1,�ӿ���̨��������
	 * 2����������
	 */
	private void Send(String str){
		if(str == null || str == "") return;
		else{
			try {
				dos.writeUTF(str);
				dos.flush();//ǿ��ˢ��
			} catch (IOException e) {
				running = false;
				CloseUtil.closeAll(dos,br);
			}
		}
		
	}
	@Override
	public void run() {
		while(running)
			Send(GetmsgFromConsole());
		
	}
	
}


//ʵ�ֿͻ��˵Ľ�������
class RecevieClient implements Runnable{
	private DataInputStream dis;
	private boolean running = true;
	//������
	public RecevieClient(Socket client){
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			running = false;
			CloseUtil.closeAll(dis);
		}
	}
	//���շ������˷�����������
	private String Recevie(){
		String str = "";
		try {
			str = dis.readUTF();
			System.out.println(str);
		} catch (IOException e) {
			running = false;
			CloseUtil.closeAll(dis);
		}
		return str;
	}
	@Override
	public void run() {
		while(running){
			System.out.println( "�ͻ��˽��յ����ݣ�" + Recevie());
		}
		
	}
	
}
