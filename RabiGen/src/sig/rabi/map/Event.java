package sig.rabi.map;

public class Event {
	int id;
	int x;
	int y;
	
	public Event(int id, int x, int y) {
		this.id = id;
		this.x = x;
		this.y = y;
	}
	
	public int getID() {
		return id;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}

	public int getMapX() {
		return x*32;
	}

	public int getMapY() {
		return y*32;
	}
}
