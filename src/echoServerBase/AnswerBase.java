package echoServerBase;

public abstract class AnswerBase implements Runnable {

	private final int portNumber;
	public AnswerBase(int _portNumber)
	{
		portNumber = _portNumber;
	}
		
	@Override
	public void run() {

	}

}
