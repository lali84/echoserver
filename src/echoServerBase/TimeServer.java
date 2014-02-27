package echoServerBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class TimeServer extends AnswerBase {

	public TimeServer(int _portNumber) {
		super(_portNumber);
	}

	@Override
	public void handleMessage(InputStream instream, OutputStream outstream) throws IOException {
			ByteBuffer b = ByteBuffer.allocate(4);
			b.putInt((int) (System.currentTimeMillis() / 1000L));
			outstream.write(b.array());		
	}

}
