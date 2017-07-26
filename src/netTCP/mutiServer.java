package netTCP;
/**
 * 不足之处：在第二个客户端向服务器发送请求时，必须等待第一个客户端运行完以后
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class mutiServer {
	public static void main(String[] args) throws IOException{
		//1，创建服务器 指定端口
			ServerSocket server = new ServerSocket(8888);
		//2,接受客户端连接 阻塞式
			while(true){
				Socket socket = server.accept();
				System.out.println("一个客户端建立连接");//可以在浏览器中输入   http://localhost:8888 此时服务器显示连接
			//3，发送数据
				String msg = "欢迎使用服务器";
				//为了防止漏洞bw.newLine(),使用DataOutputStream
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
			}
		}
}
