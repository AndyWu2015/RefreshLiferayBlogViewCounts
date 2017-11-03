import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

public class MainRefresh {

	public static void main(String[] args) throws Exception {
		/*int count = 10;
		System.out.println("total count:"+count);
		for(int i = 0 ; i< count;i++)
		{
			refresh();
			Thread.sleep(1000);
			System.out.println("current count:"+i);
		}*/
		
		int count = 200;
		
		System.out.println("total count:"+count);
		for(int i = 0 ; i< count;i++)
		{
			PingThread pingThread = new PingThread();
			pingThread.setName("ping_"+i);

			System.out.println("current count:"+i);
			pingThread.start();
		}
	}
	
	
	
	public static void refresh()
	{
		BufferedReader in = null;
		try {
			String urlNameString = "https://web.liferay.com/web/yanan.yuan/blog/-/blogs/liferay-ide-3-1-milestone-3-released";

			URL realUrl = new URL(urlNameString);

			URLConnection connection = realUrl.openConnection();
			connection.connect();

			in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

			String line = null;

			while ((line = in.readLine()) != null) {
				line = null;
			}
			
			System.out.println("I am "+Thread.currentThread().getName()+" done!");
		} catch (Exception e) {
			System.out.println("I am "+Thread.currentThread().getName()+" fail!");
		}
		finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
