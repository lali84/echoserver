package echoServerBase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

//just for fat testing purposes naturally the test should be at least in separate package 
//just for fast testing better solution can be implemented really fast 
public class Tester implements Runnable {

	private final int port1;
	private final int port2;
	private final int port3;
	private String testdata;
	public Tester(String[] args) {
		port1= Integer.parseInt(args[0]);
		port2= Integer.parseInt(args[1]);
		port3= Integer.parseInt(args[2]);
		testdata ="testData";
	}

	private void case1()
	{
		byte[] expecteOutput;
		try {
		Socket socket = new Socket("localhost" ,port1);
		InputStream inStream = new BufferedInputStream(
				socket.getInputStream());
		OutputStream outStream = new BufferedOutputStream(
				socket.getOutputStream());
		outStream.write(testdata.getBytes());
		outStream.flush();
		expecteOutput = new byte[testdata.length()];
		inStream.read(expecteOutput);
		System.out.print(new String(expecteOutput) + "\r\n");
		inStream.close();
		outStream.close();
        socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}
	@Override
	public void run() {
			case1();
	}

}
