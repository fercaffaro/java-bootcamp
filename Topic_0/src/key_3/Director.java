package key_3;

/** "Director" */
class Director {
	private RoomBuilder roomBuilder;

	public Director() {
	}

	public void setRoomBuilder(RoomBuilder roomBuilder) {
		this.roomBuilder = roomBuilder;
	}

	public Room getRoom() {
		return roomBuilder.getRoom();
	}

	public void buildRoom() {
		roomBuilder.createNewRoom();
		roomBuilder.buildName();
		roomBuilder.buildSize();
		roomBuilder.buildWindows();
		roomBuilder.buildDoors();
		roomBuilder.buildForniture();
	}
}
