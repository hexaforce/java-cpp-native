package cpp.util;

import java.io.File;

public class LibraryPath {

	public static String get() {
		String osName = System.getProperty("os.name").toLowerCase();
		if (osName.startsWith("linux")) {
			return new File("native/linux_x86_64/libnative.so").getAbsolutePath();
		} else if (osName.startsWith("mac")) {
			return new File("native/macos/libnative.dylib").getAbsolutePath();
		} else if (osName.startsWith("windows")) {
			return new File("native/win32/native.dll").getAbsolutePath();
		} else {
			return "";
		}
	}

}
