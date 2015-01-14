package key_3;


public class Test {

	public static void main(String[] args) {
		//Test1
		Hospital h1 = new Hospital();
		
		Director dir = new Director();
		
		//Add a Surgery Room to the Hospital N°:1
        RoomBuilder surgery = new SurgeryRoomBuilder();
        dir.setRoomBuilder(surgery);
        dir.buildRoom();
        Room room = dir.getRoom();		
		h1.addRoom(room);
		
		System.out.println("Test 1:\n"+h1.toString()+"\n---------------------------------");
		
		//test 2  Hospital N°2
		Hospital h2 = new Hospital("Allende","Belgrano",567);
		
		//Add a Gynaecology Room to the Hospital
		RoomBuilder gyn = new GynaecologyRoomBuilder();
        dir.setRoomBuilder(gyn);
        dir.buildRoom();
        room = dir.getRoom();		
        room.setFloor(1); //Gynaecology is in the first floor
		h2.addRoom(room);
		
		//Add a Public Information Room to the Hospital in floor 0
		RoomBuilder pub = new PublicInformationRoomBuilder();
        dir.setRoomBuilder(pub);
        dir.buildRoom();
        room = dir.getRoom();
        room.openAllTheDoors();
        room.openAllTheWindows();
		h2.addRoom(room);
		
		//Add a Doctor's Room to the Hospital in floor 0
		RoomBuilder doc = new DoctorsRoomBuilder();
        dir.setRoomBuilder(doc);
        dir.buildRoom();
        room = dir.getRoom();		
		h2.addRoom(room);
		
		//add a second Doctor's Room with an opened door in floor 1
		dir.buildRoom();
        room = dir.getRoom();	
        room.openDoor(0);
        room.setFloor(1);
		h2.addRoom(room);
		
		System.out.println("Test 2:\n"+h2.toString()+"\n---------------------------------");

	}

}
