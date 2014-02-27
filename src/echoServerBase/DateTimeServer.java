package echoServerBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class DateTimeServer extends AnswerBase {

	public DateTimeServer(int _portNumber) {
		super(_portNumber);
	}

	@Override
	public void handleMessage(InputStream instream, OutputStream outstream) throws IOException {
	}

}
