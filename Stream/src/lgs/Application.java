package lgs;

import java.util.Scanner;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Application {

	public static void main(String[] args) {
		Predicate<Integer> isPositiv = x -> x > 0;
		System.out.println(isPositiv.test(100));
		
		BinaryOperator <Integer> multiply = (x, y) -> x*y;
		
		System.out.println(multiply.apply(5, 6));
		
		UnaryOperator<Integer> square = x -> x*x;
		System.out.println(square.apply(10));
		
		Function<Integer, String> convert = x -> String.valueOf(x)+"$";
		System.out.println(convert.apply(15));
		
		Consumer<Integer> printer = x -> System.out.printf("%d $ \n", x);
		printer.accept(200);
		
		Supplier<User> userFactory = () -> {
			Scanner in = new Scanner(System.in);
			System.out.println("Enter user");
			String name = in.next();
			in.close();
			return new User(name);
			
		};
		
		User user1 =userFactory.get();
		User user2 = userFactory.get();
		
		System.out.println("Name user1 = " + user1.getName() + " Name user2 = " + user2.getName());
		
	}

}
class User{
	private String name;

	@Override
	public String toString() {
		return "User [name=" + name + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public User(String name) {
		super();
		this.name = name;
	}
	
}
