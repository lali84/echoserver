package echoServerBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class EchoServer extends AnswerBase {

	public EchoServer(int _portNumber) {
		super(_portNumber);
	}

	@Override
	public void handleMessage(InputStream instream, OutputStream outstream) throws IOException {
		byte[] readBytes = new byte[100];
		int byteCount = instream.read(readBytes, 0, 100);
	    outstream.write(readBytes, 0, byteCount);
	}
}
