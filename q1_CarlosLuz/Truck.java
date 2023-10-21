package q1_CarlosLuz;

public class Truck extends Vehicle {
	private int mass;
	public Truck(String registrationnumber, int mass) {
		super(registrationnumber);
		this.mass = mass;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}
}
