package sig.rabi.map;

import sig.rabi.map.room.RoomBackground;
import sig.rabi.map.room.RoomColor;
import sig.rabi.map.room.RoomType;

public class RoomData {
	RoomBackground bg;
	RoomColor color;
	RoomType type;
	
	public RoomData() {
		this.bg = RoomBackground.CAVERN;
		this.color = RoomColor.RAINBOW;
		this.type = RoomType.EMPTY;
	}
	
	public RoomData(RoomBackground bg, RoomColor color, RoomType type) {
		this.bg = bg;
		this.color = color;
		this.type = type;
	}
	
	public void setBackground(RoomBackground bg) {
		this.bg = bg;
	}
	
	public void setColor(RoomColor color) {
		this.color = color;
	}
	
	public void setType(RoomType type) {
		this.type = type;
	}
	
	public RoomBackground getBackground() {
		return bg;
	}
	
	public RoomColor getColor() {
		return color;
	}
	
	public RoomType getType() {
		return type;
	}
}