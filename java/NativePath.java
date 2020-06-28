

import java.io.File;

public enum NativePath {
	LINUX("libnative.so"), //
	MACOSX("libnative.dylib"), //
	WINDOWS10("native.dll"), //
	UNKNOWN("");
	public final String lib;
	NativePath(String lib) {
		this.lib = lib;
	}
	public static String get() {
		String osName = System.getProperty("os.name").replaceAll("\\s", "").toUpperCase();
		for (NativePath os : values())
			if (os.name().equals(osName))
				return new File("native/" + os.lib).getAbsolutePath();
		return UNKNOWN.lib;
	}
}
