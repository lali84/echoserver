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
	
	private void case3()
	{
		byte[] expecteOutput;
		try {
		Socket socket = new Socket("localhost" ,port3);
		InputStream inStream = new BufferedInputStream(
				socket.getInputStream());
		OutputStream outStream = new BufferedOutputStream(
				socket.getOutputStream());
		outStream.write(testdata.getBytes());
		outStream.flush();
		expecteOutput = new byte[testdata.length()];
		inStream.read(expecteOutput);
		System.out.print(expecteOutput[0]);
		System.out.print(expecteOutput[1]);
		System.out.print(expecteOutput[2]);
		System.out.print(expecteOutput[3]);
		System.out.print("\r\n");
		inStream.close();
		outStream.close();
        socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void case2()
	{
		byte[] expecteOutput;
		try {
		Socket socket = new Socket("localhost" ,port2);
		InputStream inStream = new BufferedInputStream(
				socket.getInputStream());
		OutputStream outStream = new BufferedOutputStream(
				socket.getOutputStream());
		outStream.write(testdata.getBytes());
		outStream.flush();
		expecteOutput = new byte[testdata.length()];
		inStream.read(expecteOutput);
		System.out.print(new String(expecteOutput)+ "\r\n");
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
			case2();
			case3();
	}

}
