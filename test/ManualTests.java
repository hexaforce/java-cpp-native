
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ManualTests {

	@BeforeEach
	public void setup() {
		new NativeLibrary().setup();
	}

	@Test
	@DisplayName("SayHello")
	public void whenNativeHelloWorld_thenOutputIsAsExpected() {
		SayHello helloWorld = new SayHello();
		String helloFromNative = helloWorld.sayHello();
		assertTrue(!helloFromNative.isEmpty() && helloFromNative.equals("Hello from C++ !!"));
	}

	@Test
	@DisplayName("ExampleParameters1")
	public void whenSumNative_thenResultIsArithmeticallyCorrect() {
		ExampleParameters parametersNativeMethods = new ExampleParameters();
		assertTrue(parametersNativeMethods.sumIntegers(200, 400) == 600L);
	}

	@Test
	@DisplayName("ExampleParameters2")
	public void whenSayingNativeHelloToMe_thenResultIsAsExpected() {
		ExampleParameters parametersNativeMethods = new ExampleParameters();
		assertEquals(parametersNativeMethods.sayHelloToMe("Orange", true), "Ms. Orange");
	}

	@Test
	@DisplayName("ExampleObjects1")
	public void whenCreatingNativeObject_thenObjectIsNotNullAndHasCorrectData() {
		String name = "Iker Casillas";
		double balance = 2378.78;
		ExampleObjects objectsNativeMethods = new ExampleObjects();
		UserData userFromNative = objectsNativeMethods.createUser(name, balance);
		assertNotNull(userFromNative);
		assertEquals(userFromNative.name, name);
		assertTrue(userFromNative.balance == balance);
	}

	@Test
	@DisplayName("ExampleObjects2")
	public void whenNativeCallingObjectMethod_thenResultIsAsExpected() {
		String name = "Sergio Ramos";
		double balance = 666.77;
		ExampleObjects objectsNativeMethods = new ExampleObjects();
		UserData userData = new UserData();
		userData.name = name;
		userData.balance = balance;
		assertEquals(objectsNativeMethods.printUserData(userData), "[name]=" + name + ", [balance]=" + balance);
	}

}
