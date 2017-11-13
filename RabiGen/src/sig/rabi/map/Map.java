package sig.rabi.map;

import java.util.ArrayList;
import java.util.List;

import sig.rabi.map.room.RoomBackground;
import sig.rabi.map.room.RoomColor;
import sig.rabi.map.room.RoomType;

public class Map {
	final public static int MAP_WIDTH = 500;
	final public static int MAP_HEIGHT = 200;
	final public static int MAP_ROOM_WIDTH = 25;
	final public static int MAP_ROOM_HEIGHT = 18;
	
	public int[][] collision_layer = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer0 = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer1 = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer2 = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer3 = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer4 = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer5 = new int[MAP_WIDTH][MAP_HEIGHT];
	public int[][] layer6 = new int[MAP_WIDTH][MAP_HEIGHT];
	public RoomData[][] room_data = new RoomData[MAP_ROOM_WIDTH][MAP_ROOM_HEIGHT];
	public List<Item> item_data = new ArrayList<Item>();
	public List<Event> event_data = new ArrayList<Event>();
	
	public Map() {
		InitializeRoomData();
	}

	private void InitializeRoomData() {
		for (int i=0;i<MAP_ROOM_WIDTH;i++) {
			for (int j=0;j<MAP_ROOM_HEIGHT;j++) {
				room_data[i][j] = new RoomData();
			}
		}
		
		for (int i=3;i<21;i++) {
			layer1[i][5] = 3;
			collision_layer[i][5] = 1682;
		}
		for (int i=3;i<21;i++) {
			for (int j=0;j<6;j++) {
				layer1[i][6+j] = 33;
				collision_layer[i][6+j] = 1682;
			}
		}
		event_data.add(new Event(34,8,4));
		item_data.add(new Item(299,3,4));
		room_data[0][0].setBackground(RoomBackground.EVERNIGHT_PEAK);
		room_data[0][0].setColor(RoomColor.CHOCOLATE);
		room_data[0][0].setType(RoomType.SINGLE_ROOM);
	}
}
