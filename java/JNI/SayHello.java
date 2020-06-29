package JNI;

public class SayHello {

	static {
		new NativeLibrary().load();
	}

	public native String sayHello();

}
