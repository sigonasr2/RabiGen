package sig.rabi.map.room;

public enum RoomType {
	EMPTY(0),
	SINGLE_ROOM(1), //No scroll
	HORIZONTAL_ROOM(2), //Scrolls horizontally
	VERTICAL_ROOM(3), //Scrolls vertically
	FREEROAM_ROOM(4), //Free moving camera.
	TRANSITION_ROOM(5), //Draws an arrow on the minimap.
	NOVERT_ROOM(-1), //Prevents entering from above/below.
	NOHORZ_ROOM(-2), //Prevents entering from left/right side.
	NOENTER_ROOM(-3), //Prevents entering from any side.
	;
	
	int id;
	
	RoomType(int id) {
		this.id=id;
	}
	
	public int getID() {
		return id;
	}
}
