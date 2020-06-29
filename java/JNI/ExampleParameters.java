package JNI;

public class ExampleParameters {

	static {
		new NativeLibrary().load();
	}

	// Declare another method sumIntegers that receives two integers and return a long with the sum
	public native long sumIntegers(int first, int second);

	// Declare another method sayHelloToMe that receives the name and gender and returns the proper salutation
	public native String sayHelloToMe(String name, boolean isFemale);

}
