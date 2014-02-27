package echoServerBase;

public class Main {

	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.print("Bad Signature");
		}
        final Thread echoServer = new Thread(new EchoServer(Integer.parseInt(args[0])));
        echoServer.start();
        final Thread datetimeServer = new Thread(new DateTimeServer(
				Integer.parseInt(args[1])));
		datetimeServer.start();
		final Thread timeServer = new Thread(new TimeServer(Integer.parseInt(args[2])));
		timeServer.start();

		Thread tester = new Thread(new Tester(args));
		tester.start();
	}
}
