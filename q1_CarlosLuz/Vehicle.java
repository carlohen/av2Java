package q1_CarlosLuz;

public abstract class Vehicle {
	private String registrationnumber;
	
	public Vehicle(String registrationnumber) {
	this.registrationnumber = registrationnumber;
	}

	public String getRegistrationnumber() {
		return registrationnumber;
	}

	public void setRegistrationnumber(String registrationnumber) {
		this.registrationnumber = registrationnumber;
	}
}
