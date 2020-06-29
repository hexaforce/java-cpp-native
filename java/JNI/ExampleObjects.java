package JNI;

public class ExampleObjects {

	static {
		new NativeLibrary().load();
	}

	public native UserData createUser(String name, double balance);

	public native String printUserData(UserData user);

}
