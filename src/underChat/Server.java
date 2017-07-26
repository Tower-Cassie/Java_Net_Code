package underChat;

import java.io.*;
import java.net.*;
import java.util.*;
import netTCP.*;


public class Server {
	private List<Chnaanel>  all = new ArrayList<Chnaanel>();

	public static void main(String[] args) throws IOException{
			new Server().start();
	}
		
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		while(true){
			Socket client = server.accept();
			Chnaanel ch1 = new Chnaanel(client);
			all.add(ch1);
			new Thread(ch1).start();//һ����·
			
		}
	}
 class Chnaanel implements Runnable{
			private DataInputStream dis;
			private DataOutputStream dos;
			private boolean running = true;
			private String name;
			//������
			public Chnaanel(Socket client){
				try {
					dis = new DataInputStream(client.getInputStream());
					 dos = new DataOutputStream(client.getOutputStream());
					 this.name = dis.readUTF();
					//System.out.println("�ͻ��˴��͹�������Ϣ��" + this.name);
					 this.send("��ӭ���������ң�");
					 sendOthers(this.name + "�����������ң�");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					CloseUtil.closeAll(dis,dos);
					running = false;
				}
				
			}
		    //������Ϣ
			public String receive() throws IOException{
				String str = null;
				try {
					str = dis.readUTF();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					CloseUtil.closeAll(dis);
					running = false;
					all.remove(this);
				}
				return str;
			}
			//������Ϣ
			public void send(String msg) throws IOException{
				if(msg == null || msg == "")
					return ;
				else{
					try {
						dos.writeUTF(msg);
						dos.flush();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						CloseUtil.closeAll(dos);
						running = false;
					}
				}
			}
			/*
			//���͸������ͻ���
			private void sendOthers(String msg) throws IOException{
				for(Chnaanel other:all)
					if(other == this) continue;
				//���͸������ͻ���
					else
						other.send(msg);
				
			}*/
			//ʵ��˽��
			private void sendOthers(String msg) throws IOException{
				if(msg.startsWith("@") && msg.indexOf(":") > -1){//˽��
					String name = msg.substring(1, msg.indexOf(":"));//����ҿ�
					String content = msg.substring(msg.indexOf(":") + 1);
					for(Chnaanel other:all)
						if(other.name.equals(name))
							other.send(this.name + "���Ķ���˵��" + content);
				}else{//Ⱥ��
					for(Chnaanel other:all)
						if(other == this) continue;
					//���͸������ͻ���
						else
							other.send(this.name + "��������˵��" + msg);
				}
				
			}
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(running){
					try {
						sendOthers(this.receive());
					} catch (IOException e) {
						// TODO Auto-generated catch block
						CloseUtil.closeAll(dis,dos);
						running = false;
					}
				}
				
			}
			
		}
}
