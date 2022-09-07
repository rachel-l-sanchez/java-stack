package zookeeper;


public class ZooTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		Gorilla gorillaTest = new Gorilla(100, "splat");
		
		System.out.print("\n" + "this is the throwthings test" + "\n");
		System.out.println(gorillaTest.throwSomething(100, "splat"));
		System.out.println(gorillaTest.throwSomething(100, "splat"));
		System.out.print("\n"+ +gorillaTest.throwSomething(100, "splat"));

		System.out.print("\n" +" "+ "this is the eatBananas test");
		System.out.print("\n"+" " +gorillaTest.eatBananas(100));
		System.out.print("\n"+" "+ +gorillaTest.eatBananas(100));

		System.out.print("\n" +" "+"this is the climb test");
		System.out.print("\n" +" "+ gorillaTest.climb(100));


	}

}
