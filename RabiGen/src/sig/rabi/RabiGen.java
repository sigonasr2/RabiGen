package sig.rabi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;

import sig.rabi.map.Map;
import sig.rabi.map.RoomData;
import sig.rabi.map.RoomSet;
import sig.utils.FileUtils;

public class RabiGen {
	
	static RoomSet Starter_Forest_Set;
	static RoomSet RabiRibi_Park_Set;
	static RoomSet Rabi_Beach_Set;
	static RoomSet Sky_High_Bridge_Set;
	static RoomSet Graveyard_Set;
	static RoomSet Underwater_Set;
	static RoomSet Sky_Town_Set;
	static RoomSet Snow_Land_Set;
	static RoomSet North_Snow_Land_Set;
	static RoomSet Aurora_Palace_Set;
	static RoomSet Volcano_Set;
	static RoomSet Golden_Riverbank_Set;
	static RoomSet Forest_Night_Set;
	static RoomSet Plurkwood_Set;
	static RoomSet RabiRibi_Ravine_Set;
	static RoomSet Spectral_Cavern_Set;
	static RoomSet System_Set;
	static RoomSet Library_Set;
	
	public static void main(String[] args) {
		InitializeRoomSets();
		
		GenerateRabiMap();
		
		ConvertRabiMap();
	}

	private static void GenerateRabiMap() {
		JSONObject area0map = new JSONObject();
		
		Map Area0_Map = new Map();
		
		JSONObject bglayer = new JSONObject();
		bglayer.put("color", "#00ff00");
		bglayer.put("draworder", "topdown");
		bglayer.put("name", "roombg");
		bglayer.put("opacity", 1);
		bglayer.put("type", "objectgroup");
		bglayer.put("visible", false);
		bglayer.put("x", 0);
		bglayer.put("y", 0);
		JSONObject colorlayer = new JSONObject();
		colorlayer.put("color", "#ffff00");
		colorlayer.put("draworder", "topdown");
		colorlayer.put("name", "roomcolor");
		colorlayer.put("opacity", 1);
		colorlayer.put("type", "objectgroup");
		colorlayer.put("visible", false);
		colorlayer.put("x", 0);
		colorlayer.put("y", 0);
		JSONObject typelayer = new JSONObject();
		typelayer.put("color", "#00ffff");
		typelayer.put("draworder", "topdown");
		typelayer.put("name", "roomtype");
		typelayer.put("opacity", 1);
		typelayer.put("type", "objectgroup");
		typelayer.put("visible", false);
		typelayer.put("x", 0);
		typelayer.put("y", 0);
		int unique_id = 4000;
		for (int j=0;j<Map.MAP_ROOM_HEIGHT;j++) {
			for (int i=0;i<Map.MAP_ROOM_WIDTH;i++) {
				RoomData data = Area0_Map.room_data[i][j];
				JSONObject roomtype_obj = new JSONObject();
				JSONObject roomcolor_obj = new JSONObject();
				JSONObject roombg_obj = new JSONObject();
				
				roomtype_obj.put("id", unique_id++);
				roomcolor_obj.put("id", unique_id++);
				roombg_obj.put("id", unique_id++);
				
				ApplyPropertyToAll("height", 352, roomtype_obj, roomcolor_obj, roombg_obj);
				ApplyPropertyToAll("width", 640, roomtype_obj, roomcolor_obj, roombg_obj);
				ApplyPropertyToAll("visible", true, roomtype_obj, roomcolor_obj, roombg_obj);
				
				roomtype_obj.put("name", data.getType().getID());
				roomcolor_obj.put("name", data.getColor().getID());
				roombg_obj.put("name", data.getBackground().getID());
				
				ApplyPropertyToAll("type", "("+i+","+j+")", roomtype_obj, roomcolor_obj, roombg_obj);
				ApplyPropertyToAll("x", i*640, roomtype_obj, roomcolor_obj, roombg_obj);
				ApplyPropertyToAll("y", j*352+(((j+3)/4)*32), roomtype_obj, roomcolor_obj, roombg_obj);
				
				bglayer.append("objects", roombg_obj);
				colorlayer.append("objects", roomcolor_obj);
				typelayer.append("objects", roomtype_obj);
			}
		}
		JSONObject itemslayer = new JSONObject();
		itemslayer.put("color", "#ff6000");
		itemslayer.put("draworder", "topdown");
		itemslayer.put("name", "items");
		itemslayer.put("opacity", 1);
		itemslayer.put("type", "objectgroup");
		itemslayer.put("visible", false);
		itemslayer.put("x", 0);
		itemslayer.put("y", 0);
		itemslayer.append("objects", null);
		for (int i=0;i<Area0_Map.item_data.size();i++) {
			JSONObject event_obj = new JSONObject();
			event_obj.put("id", unique_id++);
			event_obj.put("name", Area0_Map.item_data.get(i).getID());
			event_obj.put("x", Area0_Map.item_data.get(i).getMapX());
			event_obj.put("y", Area0_Map.item_data.get(i).getMapY());
			event_obj.put("width", 32);
			event_obj.put("height", 32);
			event_obj.put("rotation", 0);
			event_obj.put("type", "");
			event_obj.put("visible", true);
			itemslayer.append("objects", event_obj);
		}
		JSONObject eventlayer = new JSONObject();
		eventlayer.put("color", "#8080ff");
		eventlayer.put("draworder", "topdown");
		eventlayer.put("name", "event");
		eventlayer.put("opacity", 1);
		eventlayer.put("type", "objectgroup");
		eventlayer.put("visible", false);
		eventlayer.put("x", 0);
		eventlayer.put("y", 0);
		eventlayer.append("objects", null);
		for (int i=0;i<Area0_Map.event_data.size();i++) {
			JSONObject event_obj = new JSONObject();
			event_obj.put("id", unique_id++);
			event_obj.put("name", Area0_Map.event_data.get(i).getID());
			event_obj.put("x", Area0_Map.event_data.get(i).getMapX());
			event_obj.put("y", Area0_Map.event_data.get(i).getMapY());
			event_obj.put("width", 32);
			event_obj.put("height", 32);
			event_obj.put("rotation", 0);
			event_obj.put("type", "");
			event_obj.put("visible", true);
			eventlayer.append("objects", event_obj);
		}
		JSONObject collision_tile_layer = new JSONObject();
		setLayerData(collision_tile_layer,"collision",Area0_Map.collision_layer);
		JSONObject tile0_layer = new JSONObject();
		setLayerData(tile0_layer,"tiles0",Area0_Map.layer0);
		JSONObject tile1_layer = new JSONObject();
		setLayerData(tile1_layer,"tiles1",Area0_Map.layer1);
		JSONObject tile2_layer = new JSONObject();
		setLayerData(tile2_layer,"tiles2",Area0_Map.layer2);
		JSONObject tile3_layer = new JSONObject();
		setLayerData(tile3_layer,"tiles3",Area0_Map.layer3);
		JSONObject tile4_layer = new JSONObject();
		setLayerData(tile4_layer,"tiles4",Area0_Map.layer4);
		JSONObject tile5_layer = new JSONObject();
		setLayerData(tile5_layer,"tiles5",Area0_Map.layer5);
		JSONObject tile6_layer = new JSONObject();
		setLayerData(tile6_layer,"tiles6",Area0_Map.layer6);
		
		area0map.put("height", 200);
		area0map.append("layers", collision_tile_layer);
		area0map.append("layers", tile0_layer);
		area0map.append("layers", tile3_layer);
		area0map.append("layers", tile4_layer);
		area0map.append("layers", tile1_layer);
		area0map.append("layers", tile5_layer);
		area0map.append("layers", tile6_layer);
		area0map.append("layers", tile2_layer);
		area0map.append("layers", eventlayer);
		area0map.append("layers", itemslayer);
		area0map.append("layers", typelayer);
		area0map.append("layers", colorlayer);
		area0map.append("layers", bglayer);
		
		area0map.put("nextobjectid", unique_id);
		area0map.put("orientation", "orthogonal");
		JSONObject properties = new JSONObject();
		properties.put("area", 0);
		properties.put("version", 150);
		area0map.put("properties", properties);
		JSONObject propertytypes = new JSONObject();
		propertytypes.put("area", "int");
		propertytypes.put("version", "int");
		area0map.put("propertytypes", propertytypes);
		area0map.put("renderorder", "right-down");
		area0map.put("tiledversion", "1.0.2");
		area0map.put("tileheight", 32);
		area0map.put("tilewidth", 32);
		area0map.put("type", "map");
		area0map.put("version", 1);
		area0map.put("width", 500);

		JSONArray tilesets = new JSONArray();
		JSONObject tile1 = new JSONObject();
		JSONObject tile2 = new JSONObject();
		tile1.put("firstgid", 1);
		tile1.put("source", "TILE_A.tsx");
		tile2.put("firstgid", 1681);
		tile2.put("source", "collision.tsx");
		tilesets.put(tile1);
		tilesets.put(tile2);
		
		area0map.put("tilesets", tilesets);
		
		File area0file = new File("./jsonConverter/s2_editable_maps/area0.json");
		FileWriter writer;
		try {
			writer = new FileWriter(area0file);
			area0map.write(writer);
			writer.close();
			System.out.println("Successfully wrote map data to file "+area0file.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void ApplyPropertyToAll(String string, Object value, JSONObject roomtype_obj, JSONObject roomcolor_obj,
			JSONObject roombg_obj) {
		roomtype_obj.put(string, value);
		roomcolor_obj.put(string, value);
		roombg_obj.put(string, value);
	}

	private static void setLayerData(JSONObject obj, String layername, int[][] data) {
		for (int j=0;j<Map.MAP_HEIGHT;j++) {
			for (int i=0;i<Map.MAP_WIDTH;i++) {
				obj.append("data", data[i][j]);
			}
		}
		obj.put("height", Map.MAP_HEIGHT);
		obj.put("width", Map.MAP_WIDTH);
		obj.put("name", layername);
		obj.put("opacity", 1);
		obj.put("type", "tilelayer");
		obj.put("visible", true);
		obj.put("x", 0);
		obj.put("y", 0);
	}

	private static void InitializeRoomSets() {
		Starter_Forest_Set = new RoomSet(new int[]{733,734},new int[]{1030},new int[]{1031})
				.setEndpieceTile(new int[]{768})
				.setSlopeTiles(new int[]{36}, new int[]{37}, new int[]{66}, new int[]{67})
				.setSteepSlopeTiles(new int[]{39}, new int[]{70}, new int[]{69}, new int[]{100});
	}

	private static void ConvertRabiMap() {
		File file = new File("./jsonConverter");
		Process process;
		try {
			ProcessBuilder myProcess = new ProcessBuilder(
					file.getCanonicalPath()+"/editable_to_final.bat");
			myProcess.directory(file);
			process = myProcess.start();
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line;

			System.out.printf("Output of running %s is:", myProcess.command());

			while ((line = br.readLine()) != null) {
			  System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
