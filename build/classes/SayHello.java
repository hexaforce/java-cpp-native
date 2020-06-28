
public class SayHello {

	static {
		new NativeLibrary().setup();
	}

	public static void main(String[] args) {
		new SayHello().sayHello();
	}

	native String sayHello();

}
