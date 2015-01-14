package key_3;

/** "Abstract Builder" */
public abstract class RoomBuilder {

	protected Room room;

	public Room getRoom() {
		return room;
	}

	public void createNewRoom() {
		room = new Room();
	}

	public abstract void buildName();

	public abstract void buildSize();

	public abstract void buildWindows();

	public abstract void buildDoors();

	public abstract void buildForniture();

}