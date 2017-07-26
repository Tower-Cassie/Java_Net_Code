package netTCP;
import java.io.*;
import java.net.*;

public class MyServer {
	public static void main(String[] args) throws IOException{
		//1，创建服务器 指定端口
			ServerSocket server = new ServerSocket(8888);
		//2,接受客户端连接 阻塞式
			Socket socket = server.accept();
			System.out.println("一个客户端建立连接");//可以在浏览器中输入   http://localhost:8888 此时服务器显示连接
		//3，发送数据
			String msg = "欢迎使用服务器";
			/*
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(msg);//不能bw.close(),因为会关掉服务器端
			bw.newLine();//此处非常重要，在读取数据时是按照行来读取的，所以此处必须添加一个行的标记符，也可以在字符串后加\n
			bw.flush();//刷新*/
			//为了防止漏洞bw.newLine(),使用DataOutputStream
			DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		}

}
