package TNS003;

	public class HierarchicalInhDemo {

		public static void main(String[] args) {
			Person p1 = new Person();
			System.out.println("----------------- Person Details ---------------------");
			System.out.println(p1);

			Person p;
			p = new Person("Dhruv", "Mumbai");
			if (p instanceof Person)
				System.out.println("Person Details "+p);}}
			
		