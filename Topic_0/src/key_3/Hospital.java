package key_3;

import java.util.ArrayList;

public class Hospital {
	private String hospitalName;
	private String streetName;
	private int streetNumber;
	private ArrayList<Room> rooms; 

	public Hospital(){
		this.hospitalName = "Clinica Standard";
		this.streetName = "San Martin";
		this.streetNumber = 123;
		this.rooms = new ArrayList<Room>();
	}
	
	public Hospital(String hospitalName, String streetName,int streetNumber){
		this.hospitalName = hospitalName;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.rooms = new ArrayList<Room>();
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public int getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(int streetNumber) {
		this.streetNumber = streetNumber;
	}

	public ArrayList<Room> getRooms() {
		return rooms;
	}

	public void setRooms(ArrayList<Room> rooms) {
		this.rooms = rooms;
	}
	
	public void addRoom(Room r){
		rooms.add(r);
	}
	
	public void removeRoom(Room r){
		rooms.remove(r);
	}

	@Override
	public String toString() {
		String info = "The "+ hospitalName + " hospital is in: " + streetNumber + " " + streetName + " street.\nHave: "
	+ rooms.size() + " rooms.";
		for(int i=0; i<rooms.size();i++){
			info += "\n---------------------------------\nRoom nr: "+i
				+"\n---------------------------------\n"
				+rooms.get(i).toString();
		}
		return info;
	}
	
	
}
