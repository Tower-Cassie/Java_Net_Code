package netTCP;

import java.io.*;
import java.net.*;
import java.util.*;

public class mutiChatServer {
	private List<Chnaanel>  all = new ArrayList<Chnaanel>();

	public static void main(String[] args) throws IOException{
						new mutiChatServer().start();
	}
		
	public void start() throws IOException{
		ServerSocket server = new ServerSocket(9999);
		while(true){
			Socket client = server.accept();
			Chnaanel ch1 = new Chnaanel(client);
			all.add(ch1);
			new Thread(ch1).start();//一条道路
			
		}
	}
 class Chnaanel implements Runnable{
			private DataInputStream dis;
			private DataOutputStream dos;
			private boolean running = true;
			//构造器
			public Chnaanel(Socket client){
				try {
					dis = new DataInputStream(client.getInputStream());
					 dos = new DataOutputStream(client.getOutputStream());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					CloseUtil.closeAll(dis,dos);
					running = false;
				}
				
			}
		    //接收消息
			public String receive() throws IOException{
				String str = null;
				try {
					str = dis.readUTF();
					System.out.println("服务器端接收的消息-->" + str);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					CloseUtil.closeAll(dis);
					running = false;
					all.remove(this);
				}
				return str;
			}
			//发送消息
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
			//发送给其他客户端
			private void sendOthers() throws IOException{
				String msg = this.receive();
				for(Chnaanel other:all)
					if(other == this) continue;
				//发送给其他客户端
					else
						other.send(msg);
				
			}
			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(running){
					try {
						sendOthers();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						CloseUtil.closeAll(dis,dos);
						running = false;
					}
				}
				
			}
			
		}

}
