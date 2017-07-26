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
			new Thread(ch1).start();//一条道路
			
		}
	}
 class Chnaanel implements Runnable{
			private DataInputStream dis;
			private DataOutputStream dos;
			private boolean running = true;
			private String name;
			//构造器
			public Chnaanel(Socket client){
				try {
					dis = new DataInputStream(client.getInputStream());
					 dos = new DataOutputStream(client.getOutputStream());
					 this.name = dis.readUTF();
					//System.out.println("客户端传送过来的信息：" + this.name);
					 this.send("欢迎进入聊天室！");
					 sendOthers(this.name + "进入了聊天室！");
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
			/*
			//发送给其他客户端
			private void sendOthers(String msg) throws IOException{
				for(Chnaanel other:all)
					if(other == this) continue;
				//发送给其他客户端
					else
						other.send(msg);
				
			}*/
			//实现私聊
			private void sendOthers(String msg) throws IOException{
				if(msg.startsWith("@") && msg.indexOf(":") > -1){//私聊
					String name = msg.substring(1, msg.indexOf(":"));//左闭右开
					String content = msg.substring(msg.indexOf(":") + 1);
					for(Chnaanel other:all)
						if(other.name.equals(name))
							other.send(this.name + "悄悄对你说：" + content);
				}else{//群发
					for(Chnaanel other:all)
						if(other == this) continue;
					//发送给其他客户端
						else
							other.send(this.name + "对所有人说：" + msg);
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
