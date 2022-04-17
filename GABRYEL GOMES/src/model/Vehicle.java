package model;

public class Vehicle {
	
	private int id, age, vehicleTypeId;
	private String plate, mark;
		
	public void setAge(int age) {
		this.age = age;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setVehicleTypeId(int vehicleTypeId) {
		this.vehicleTypeId = vehicleTypeId;
	}
	
	public int getVehicleTypeId() {
		return vehicleTypeId;
	}
	
	public void setPlate(String plate) {
		this.plate = plate;
	}
	
	public String getPlate() {
		return plate;
	}
	
	public void setMark(String mark) {
		this.mark = mark;
	}
	
	public String getMark() {
		return mark;
	}
	
}