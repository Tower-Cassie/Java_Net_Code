package underChat;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭流的方法
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