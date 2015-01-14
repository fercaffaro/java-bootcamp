package key_3;

/** "ConcreteBuilder" */
public class DoctorsRoomBuilder extends RoomBuilder {

	@Override
	public void buildName() {
		room.setName("Doctor's Room");
	}

	@Override
	public void buildSize() {
		room.setSize(3, 2, 3);
	}

	@Override
	public void buildWindows() {
		room.setWindows(1);
	}

	@Override
	public void buildDoors() {
		room.setDoors(1);
		room.closeAllTheDoors();
	}

	@Override
	public void buildForniture() {
		room.addForniture("Desk");
		room.addForniture("Table");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("telephone");
	}
}
