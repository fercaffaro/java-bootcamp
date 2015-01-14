package key_3;

/** "ConcreteBuilder" */
public class GynaecologyRoomBuilder extends RoomBuilder {

	@Override
	public void buildName() {
		room.setName("Gynaecology Room");
	}

	@Override
	public void buildSize() {
		room.setSize(2, 3, 3);
	}

	@Override
	public void buildWindows() {
		room.setWindows(1);
	}

	@Override
	public void buildDoors() {
		room.setDoors(1);
		room.closeDoor(0);
	}

	@Override
	public void buildForniture() {
		room.addForniture("Desk");
		room.addForniture("Chair");
		room.addForniture("Chair");
		room.addForniture("Gynaecology Chair");
	}

}
