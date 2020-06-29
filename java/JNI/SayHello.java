
public class SayHello {

	static {
		new NativeLibrary().load();
	}

	native String sayHello();

//	public static void main(String[] args) {
//		new SayHello().sayHello();
//	}

}
