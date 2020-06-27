package cpp;

import cpp.util.NativePath;

public class SayHello {

	static {
		System.load(NativePath.get());
	}

	public static void main(String[] args) {
		new SayHello().sayHello();
	}

	native String sayHello();

}
