
public class ExampleObjects {

	static {
		new NativeLibrary().load();
	}

	public native UserData createUser(String name, double balance);

	public native String printUserData(UserData user);

//	public static void main(String[] args) {
//		ExampleObjects instance = new ExampleObjects();
//		UserData newUser = instance.createUser("John Doe", 450.67);
//		instance.printUserData(newUser);
//	}

}
