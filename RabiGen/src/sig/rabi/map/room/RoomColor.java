package sig.rabi.map.room;

public enum RoomColor {
	DARK_GREEN(7),
	GREEN(1),
	GOLD(3),
	PERIWINKLE(2),
	BROWN(6),
	LIGHT_GREEN(24),
	RED_BROWN(34),
	MAROON(21),
	PURPLE(15),
	BLUE(9),
	YELLOW(10),
	RAINBOW(5),
	TEAL(26),
	PASTEL_GREEN(55),
	GREENER(11),
	CHOCOLATE(13),
	PURPLER(14),
	AQUA(23),
	DARK_BLUE(31),
	BRIGHT_PURPLE(16),
	UNDERWATER_GREEN(25),
	VIOLET(18),
	CHEESE(20),
	FADED_RED(19),
	PEACH(12),
	BURNT_ORANGE(29),
	RED(28),
	ORANGE(32),
	STEEL_BLUE(30),
	GRAY(50),
	GREY(50),
	LIGHT_BLUE(17),
	LIGHT_RED(22),
	;
	
	int id;
	
	RoomColor(int id) {
		this.id=id;
	}
	
	public int getID() {
		return id;
	}
}
