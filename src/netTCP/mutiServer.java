package netTCP;
/**
 * ����֮�����ڵڶ����ͻ������������������ʱ������ȴ���һ���ͻ����������Ժ�
 */
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class mutiServer {
	public static void main(String[] args) throws IOException{
		//1������������ ָ���˿�
			ServerSocket server = new ServerSocket(8888);
		//2,���ܿͻ������� ����ʽ
			while(true){
				Socket socket = server.accept();
				System.out.println("һ���ͻ��˽�������");//�����������������   http://localhost:8888 ��ʱ��������ʾ����
			//3����������
				String msg = "��ӭʹ�÷�����";
				//Ϊ�˷�ֹ©��bw.newLine(),ʹ��DataOutputStream
				DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
				dos.writeUTF(msg);
				dos.flush();
			}
		}
}
