package zookeeper;

public class BatTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bat batTest = new Bat(300, "soarrr", "snap roar pop", 300);
		
		System.out.println("\n" +"These are the three attack town tests");
		System.out.println("\n" +batTest.attackTown(300));
		System.out.println("\n" +batTest.attackTown(300));
		System.out.println("\n" +batTest.attackTown(300) + "\n");

		
		System.out.println("These are the eatHuman tests");
		System.out.println("\n" + batTest.eatHumans(300));
		System.out.println("\n" +batTest.eatHumans(300) + "\n");
		

		System.out.println("These are the fly tests");
		System.out.println("\n" + batTest.fly("soarr", 300));
		System.out.println("\n" +batTest.fly("soarrr", 300) + "\n");



		

	}

}
