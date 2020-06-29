package JNI;

public class SayHello {

	static {
		new NativeLibrary().load();
	}

	public native String sayHello();

//	public static void main(String[] args) {
//		new SayHello().sayHello();
//	}

}
