package q1_CarlosLuz;

public class Main {
	public static void main (String []args) {
		Company c = new Company("tarefinha");
		Employee e = new Employee("outratarefinha");
		Truck t = new Truck("caminhoes", 128);
		Car cr = new Car("carin", "carrao");
		System.out.println(c.getName());
	}
}
