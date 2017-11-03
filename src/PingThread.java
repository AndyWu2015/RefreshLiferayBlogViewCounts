
public class PingThread extends Thread {

	@Override
	public void run() {
		super.run();
		
		MainRefresh.refresh();
	}
}
