package echoServerBase;

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
	@Override
	public void run() {

	}

}
