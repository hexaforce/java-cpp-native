package cpp;

import cpp.util.LibraryPath;

public class SayHello {

	static {
		System.load(LibraryPath.get());
	}

	public static void main(String[] args) {
		new SayHello().sayHello();
	}

	native String sayHello();

}
