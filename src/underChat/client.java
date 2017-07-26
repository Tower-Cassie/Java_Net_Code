package underChat;

import java.io.*;
import java.net.*;

public class client {
	public static void main(String[] args) throws UnknownHostException, IOException{
		System.out.println("请输入用户名称:");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String name = br.readLine();
		if(name == "") return;
		Socket client = new Socket("localhost",9999);
		new Thread(new SendClient(client,name)).start();//一条路径
		new Thread(new RecevieClient(client)).start();//一条路径
		
	}

}

class SendClient implements Runnable{
	//管道输出流
	private DataOutputStream dos;
	//控制台输入流
	private BufferedReader br;
	//控制线程
	private boolean running = true;
	private String name;
	//构造器
	public SendClient(){
		//System.out.println("请从控制台获取信息：");
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
	//从控制台获取信息
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
	 * //发送消息
	 * 1,从控制台接收数据
	 * 2，发送数据
	 */
	private void Send(String str){
		if(str == null || str == "") return;
		else{
			try {
				dos.writeUTF(str);
				dos.flush();//强制刷新
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


//实现客户端的接收数据
class RecevieClient implements Runnable{
	private DataInputStream dis;
	private boolean running = true;
	//构造器
	public RecevieClient(Socket client){
		try {
			dis = new DataInputStream(client.getInputStream());
		} catch (IOException e) {
			running = false;
			CloseUtil.closeAll(dis);
		}
	}
	//接收服务器端发送来的数据
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
			System.out.println( "客户端接收的数据：" + Recevie());
		}
		
	}
	
}
