package JNI;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class NativeLibrary {

	final String NATIVE_DIRECTORY = "native";
	final OS os;

	public NativeLibrary() {
		this.os = OS.get();
	}

	public void load() {
		File libFile = new File(NATIVE_DIRECTORY + "/" + os.lib);
		if (!libFile.exists()) {
			try (InputStream inputStream = getClass().getResourceAsStream("/" + os.lib)) {
				Files.createDirectories(Paths.get(NATIVE_DIRECTORY));
				Files.copy(inputStream, libFile.toPath(), StandardCopyOption.REPLACE_EXISTING);// Export binary.
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.load(libFile.getAbsolutePath());
	}

	enum OS {
		LINUX("libnative.so"), //
		MACOSX("libnative.dylib"), //
		WINDOWS10("native.dll"), //
		UNKNOWN("");

		public final String lib;

		OS(String lib) {
			this.lib = lib;
		}

		public static OS get() {
			String osName = System.getProperty("os.name").replaceAll("\\s", "").toUpperCase();
			for (OS os : values())
				if (os.name().equals(osName))
					return os;
			return UNKNOWN;
		}

	}

}
