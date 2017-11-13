package sig.rabi.map.room;

public enum RoomBackground {
	DEFAULT(0),
	CLOUDS(1),
	FOG(2),
	DARKNESS(3),
	EVERNIGHT_PEAK(6),
	LABORATORY(7),
	PYRAMID(8),
	CITY(9),
	DARK_BLUE(10),
	TOWN(11),
	CAVERN(13),
	;
	
	int id;
	
	RoomBackground(int id) {
		this.id=id;
	}
	
	public int getID() {
		return id;
	}
}
