package key_3;

import java.util.ArrayList;

//This is the product in the builder pattern
public class Room {
	private int floor; //floor where the room is placed
	private double width; // room's width in meters
	private double height; // room's height in meters
	private double length; // room's lenght in meters
	private int numWindows; // number of windows in the room
	private int numDoors; // number of doors in the room
	private boolean windows[]; // state of each window in the room (true=open
								// false=close)
	private boolean doors[]; // state of each door in the room(true=open
								// false=close)
	private String name;
	private ArrayList<String> forniture;

	public Room() {
		this.floor = 0;
		
		this.width = 3;
		this.height = 3;
		this.length = 3;

		this.numDoors = 1;
		this.doors = new boolean[this.numDoors];
		for (int i = 0; i < this.numDoors; i++) {
			this.doors[i] = true; // doors are open
		}

		this.numWindows = 1;
		this.windows = new boolean[this.numWindows];
		for (int i = 0; i < this.numWindows; i++) {
			this.windows[i] = true; // windows are open
		}

		this.name = "";
		this.forniture = new ArrayList<String>();

	}

	public Room(int floor, double width, double length, double height, int numDoors, int numWindows, String name) {
		this.floor = floor;
		this.width = width;
		this.height = height;
		this.length = length;

		this.numDoors = numDoors;
		this.doors = new boolean[this.numDoors];
		for (int i = 0; i < this.numDoors; i++) {
			this.doors[i] = true; // doors are open
		}

		this.numWindows = numWindows;
		this.windows = new boolean[this.numWindows];
		for (int i = 0; i < this.numWindows; i++) {
			this.windows[i] = true; // windows are open
		}

		this.name = name;

		this.forniture = new ArrayList<String>();
	}

	public Room(int floor, double width, double length, double height, int numDoors, int numWindows, String name, ArrayList<String> forniture) {
		this(floor, width,  length, height, numDoors, numWindows, name);
		this.forniture = forniture;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getLength() {
		return length;
	}

	public void setLength(double length) {
		this.length = length;
	}

	// get the size of the room as a String
	public String getSize() {
		return "Size of the Room: " + this.width + "x" + this.length + "x" + this.height;
	}

	// set the size of the room
	public boolean setSize(double width, double length, double height) {
		try {
			this.width = width;
			this.height = height;
			this.length = length;
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// close all the windows in the room
	public void closeAllTheWindows() {
		for (int i = 0; i < this.numWindows; i++) {
			this.windows[i] = false; // window is closed
		}
	}

	// close all the doors in the room
	public void closeAllTheDoors() {
		for (int i = 0; i < this.numDoors; i++) {
			this.doors[i] = false; // door is closed
		}
	}

	// open all the windows in the room
	public void openAllTheWindows() {
		for (int i = 0; i < this.numWindows; i++) {
			this.windows[i] = true; // window is opened
		}
	}

	// open all the doors in the room
	public void openAllTheDoors() {
		for (int i = 0; i < this.numDoors; i++) {
			this.doors[i] = true; // door is opened
		}
	}

	// open the window passed as parameter
	public void openWindow(int window) {
		this.windows[window] = true;
	}

	// open the door passed as parameter
	public void openDoor(int door) {
		this.doors[door] = true;
	}

	// close the window passed as parameter
	public void closeWindow(int window) {
		this.windows[window] = false;
	}

	// close the door passed as parameter
	public void closeDoor(int door) {
		this.doors[door] = false;
	}

	// open or close the window passed as parameter
	public void openCloseWindow(int window, boolean state) {
		this.windows[window] = state;
	}

	// open or close the window passed as parameter
	public void openCloseDoor(int door, boolean state) {
		this.doors[door] = state;
	}

	public int getNumDoors() {
		return numDoors;
	}

	public int getNumWindows() {
		return numWindows;
	}

	public boolean[] getDoors() {
		return doors;
	}

	public boolean[] getWindows() {
		return windows;
	}

	public void setNumDoors(int numDoors) {
		this.numDoors = numDoors;
		this.doors = new boolean[this.numDoors];
		for (int i = 0; i < this.numDoors; i++) {
			this.doors[i] = true; // doors are open
		}
	}

	public void setNumWindows(int numWindows) {
		this.numWindows = numWindows;
		this.windows = new boolean[this.numWindows];
		for (int i = 0; i < this.numWindows; i++) {
			this.windows[i] = true; // windows are open
		}
	}

	public void setDoors(boolean[] doors) {
		this.doors = doors;
		this.numDoors = doors.length;
	}

	public void setWindows(boolean[] windows) {
		this.windows = windows;
		this.numWindows = windows.length;
	}

	// Add a door with its state at the end
	public void addDoor(boolean state) {
		this.numDoors++;
		boolean oldDoors[] = this.doors;
		this.doors = new boolean[this.numDoors];
		for (int i = 0; i < this.numDoors - 1; i++) {
			this.doors[i] = oldDoors[i]; // doors are copied
		}
		this.doors[this.numDoors - 1] = state;
	}

	// remove a door
	public boolean removeDoor(int door) {
		try {
			if (door >= 0 && door < this.numDoors) {
				this.numDoors--;
				boolean oldDoors[] = this.doors;
				this.doors = new boolean[this.numDoors];
				int id = 0;
				for (int i = 0; i < oldDoors.length; i++) {
					if (i != door) {
						this.doors[id] = oldDoors[i]; // only the door passed as
														// parameter is not
														// copied
						id++;
					}
				}
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}
	
	// Add a window with its state at the end
		public void addWindow(boolean state) {
			this.numWindows++;
			boolean oldWindows[] = this.windows;
			this.windows = new boolean[this.numWindows];
			for (int i = 0; i < this.numWindows - 1; i++) {
				this.windows[i] = oldWindows[i]; // windows are copied
			}
			this.windows[this.numWindows - 1] = state;
		}

		// remove a window
		public boolean removeWindow(int window) {
			try {
				if (window > 0 && window <= this.numWindows) {
					this.numWindows--;
					boolean oldWindows[] = this.windows;
					this.windows = new boolean[this.numWindows];
					for (int i = 0; i < oldWindows.length; i++) {
						if (i != window) {
							this.windows[i] = oldWindows[i]; // only the window passed as
															// parameter is not
															// copied
						}
					}
					return true;
				}
				return false;
			} catch (Exception e) {
				return false;
			}
		}


	public ArrayList<String> getForniture() {
		return forniture;
	}

	public void setForniture(ArrayList<String> forniture) {
		this.forniture = forniture;
	}
	
	public void addForniture(String forniture){
		this.forniture.add(forniture);
	}
	
	public void removeForniture(String forniture){
		this.forniture.remove(forniture);
	}

	@Override
	public String toString() {
		return "Room's Name: "+this.name
				+"\nSituated in the floor number: " + this.floor 
				+"\nSize of the Room: " + this.width + "m. x " + this.length + "m. x " + this.height+"m."
				+"\nNumber of Doors: "+ this.numDoors
				+"\nNumbers of opened Doors: "+ getOpenedDoors()
				+"\nNumbers of closed Doors: "+ getClosedDoors()
				+"\nNumber of Windows: "+ this.numWindows
				+"\nNumbers of opened Windows: "+ getOpenedWindows()
				+"\nNumbers of closed Windows: "+ getClosedWindows()
				+"\nRoom's Forniture: "+ getForniture().toString();
	}

	// Return the number of opened windows
	private int getOpenedWindows() {
		int cont = 0;
		for (int i = 0; i < this.numWindows; i++) {
			if (this.windows[i] == true) {
				cont++;
			}
		}
		return cont;
	}

	// Return the number of closed windows
	private int getClosedWindows() {
		int cont = 0;
		for (int i = 0; i < this.numWindows; i++) {
			if (this.windows[i] == false) {
				cont++;
			}
		}
		return cont;
	}

	// Return the number of opened doors
	private int getOpenedDoors() {
		int cont = 0;
		for (int i = 0; i < this.numDoors; i++) {
			if (this.doors[i] == true) {
				cont++;
			}
		}
		return cont;
	}

	// Return the number of closed doors
	private int getClosedDoors() {
		int cont = 0;
		for (int i = 0; i < this.numDoors; i++) {
			if (this.doors[i] == false) {
				cont++;
			}
		}
		return cont;
	}

	public void setWindows(int numWindows) {
		this.numWindows = numWindows;
		this.windows = new boolean[numWindows];
		for (int i = 0; i < numWindows; i++) {
			this.windows[i] = true; // windows are open
		}
		
	}

	public void setDoors(int numDoors) {
		this.numDoors = numDoors;
		this.doors = new boolean[numDoors];
		for (int i = 0; i < numDoors; i++) {
			this.doors[i] = true; // doors are open
		}
		
	}

}
