package key_3;

/** "ConcreteBuilder" */
public class SurgeryRoomBuilder extends RoomBuilder {

	@Override
	public void buildName() {
		room.setName("Surgery Room");
	}

	@Override
	public void buildSize() {
		room.setSize(5, 5, 3);
	}

	@Override
	public void buildWindows() {
		room.setWindows(0);
	}

	@Override
	public void buildDoors() {
		room.setDoors(2);
		room.closeAllTheDoors();
	}

	@Override
	public void buildForniture() {
		room.addForniture("surgical lamp");
		room.addForniture("surgical aspirator");
		room.addForniture("instrumental table");
		room.addForniture("surgery table");
		room.addForniture("monitor");
		room.addForniture("anesthesia tube");

	}
}
