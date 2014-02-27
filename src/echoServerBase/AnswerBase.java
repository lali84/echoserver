package echoServerBase;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public abstract class AnswerBase implements Runnable {

	private final int portNumber;
	InputStream inStream;
	OutputStream outStream;
	ServerSocket serverSocket;
	Socket clientSocket;
	public AnswerBase(int _portNumber)
	{
		inStream = null;
		outStream = null;
		serverSocket = null;
		clientSocket = null;
		portNumber = _portNumber;
	}
	
	abstract void handleMessage(InputStream instream, OutputStream outstream) throws IOException;
		
	@Override
	public void run() {
		try {
			serverSocket = new ServerSocket(portNumber);
			System.out.println("Started server on port " + portNumber);
			// repeatedly wait for connections, and process
			while (true) {
				// a "blocking" call which waits until a connection is requested
				clientSocket = serverSocket.accept();
				System.out.println("Accepted connection from client");
				// open up IO streams
				inStream = new BufferedInputStream(
						clientSocket.getInputStream());
				outStream = new BufferedOutputStream(
						clientSocket.getOutputStream());
				handleMessage(inStream, outStream);
				outStream.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			cleanUp();
		}
	}

	private void cleanUp() {
		try {
			// close IO streams, then socket
			if(null != outStream) outStream.close();
			if(null != inStream) inStream.close();
			if(null != clientSocket) clientSocket.close();
			if(null != serverSocket) serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
