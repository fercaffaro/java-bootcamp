package key_3;

/** "ConcreteBuilder" */
public class PublicInformationRoomBuilder extends RoomBuilder {

	@Override
	public void buildName() {
		room.setName("Public Information");
	}

	@Override
	public void buildSize() {
		room.setSize(6, 10, 3);
	}

	@Override
	public void buildWindows() {
		room.setWindows(4);
		room.openAllTheWindows();
	}

	@Override
	public void buildDoors() {
		room.setDoors(3);
		room.closeAllTheDoors();
	}

	@Override
	public void buildForniture() {
		room.addForniture("Desk");
		room.addForniture("Telephone");
		room.addForniture("TV");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("chair");
		room.addForniture("chair");

	}
}
