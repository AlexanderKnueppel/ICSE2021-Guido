package guido.network;

public class DefaultPrinter implements Printer {

	@Override
	public void printMsg(String name) {
		System.out.println(name);
	}

}
