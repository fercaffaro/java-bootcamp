package key_2;


public class Test {

	public static void main(String[] args) {
		//Test1
		House h1 = new House();
		Room r1 = new Room();
		h1.addRoom(r1);
		System.out.println("Test 1:\n"+h1.toString()+"\n---------------------------------");
		
		//test 2
		House h2 = new House("Belgrano",567);
		Room r2 = new Room(4,3,2.5,2,4,"Living");
		r2.closeAllTheWindows();
		r2.openWindow(2);
		r2.closeDoor(1);
		r2.addForniture("armchair");
		r2.addForniture("lamp");
		r2.addForniture("desk");
		h2.addRoom(r2);
		Room r3 = new Room(2,2,3,1,0,"Bath");
		r3.closeDoor(0);
		r3.addForniture("toilet");
		r3.addForniture("shower");
		r3.addForniture("washbowl");
		h2.addRoom(r3);
		Room r4 = new Room(3,4,3,3,3,"Kitchen");
		r4.closeAllTheDoors();
		r4.openDoor(2);
		r4.removeDoor(0);
		r4.addWindow(false);//add a closed window
		r4.addForniture("table");
		r4.addForniture("chair");
		r4.addForniture("knife");
		r4.addForniture("tv");
		r4.removeForniture("knife");
		h2.addRoom(r4);
		
		System.out.println("Test 2:\n"+h2.toString()+"\n---------------------------------");

	}

}
