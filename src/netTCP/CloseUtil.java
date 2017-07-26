package netTCP;

import java.io.Closeable;
import java.io.IOException;

/**
 * �ر����ķ���
 * @author xiaohong
 *
 */
public class CloseUtil {
	public static void closeAll(Closeable... io){
		for(Closeable temp:io)
			if(temp != null)
				try {
					temp.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}

}