package q1_CarlosLuz;

public class Car extends Vehicle {
	private String transmission;
	public Car(String registrationnumber, String transmission) {
		super(registrationnumber);
		this.transmission = transmission;
	}

	

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}
}
