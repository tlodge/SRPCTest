import java.io.IOException;
import java.net.InetAddress;

import java.util.Random;


public class HomeworkTest {

	public static Random random = new Random(System.currentTimeMillis());
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String localAddr = "127.0.0.1";
		
		//Check the server socket details;
		try {
			InetAddress local = InetAddress.getLocalHost();
			localAddr = local.getHostAddress();			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// TODO Auto-generated method stub
		JavaSRPC srpcclient = new JavaSRPC();
		try{
			srpcclient.connect(InetAddress.getByName("192.168.1.1"), 987);
		}catch(Exception e){
			System.err.println("error connecting " + e.getMessage());
		}
		System.out.println("successfully connected!");
		
		try{
			//String query = "SQL:subscribe SysLast " + localAddr + " " + srpcclient.getLocalPort() + " " + "SysMonitorHandlerResponse";
			//String query = "SQL:select * from Sys";
			String query = "SQL:save (select * from Sys [last]) as Sissy";
			System.err.println("calling " +query);
			String s = srpcclient.call(query);
			System.err.println("finished rpc call ");
			System.out.println("reponse from subscribe command is " + s);
		}catch(Exception e){
			System.err.println("error calling " + e.getMessage());
		}
		
	}

}
