package echoServerBase;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateTimeServer extends AnswerBase {

	public DateTimeServer(int _portNumber) {
		super(_portNumber);
	}

	@Override
	public void handleMessage(InputStream instream, OutputStream outstream) throws IOException {
		String date = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
			outstream.write(date.getBytes());
	}

}
