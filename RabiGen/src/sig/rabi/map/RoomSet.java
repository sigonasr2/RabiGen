package sig.rabi.map;

public class RoomSet {
	final public static int BLANK_TILE = 18;
	
	int[] ground; // Ground tiles/Roof tiles
	int[] wall; // Side Tiles
	int[] filler; // Tiles that go in between ground/side tiles.
	int[] corner; // Tiles that go on corners.
	int[] endpiece; // Tiles that go over the edge of corners.
	int[] smallslope1; // A small slope.
	int[] smallslope2; // Second part of a small slope.
	int[] smallslope3; // Third part of a small slope.
	int[] smallslope1_bottom; // A small slope (bottom section).
	int[] smallslope2_bottom; // Second part of a small slope (bottom section).
	int[] smallslope3_bottom; // Third part of a small slope (bottom section).
	int[] steepslope1; // A steep slope.
	int[] steepslope2; // Second part of a steep slope.
	int[] steepslope1_bottom; // A steep slope (bottom section).
	int[] steepslope2_bottom; // Second part of a steep slope (bottom section).
	
	public RoomSet(int[] ground_tile, int[] wall_tile, int[] filler_tile) {
		this.ground = ground_tile;
		this.wall = wall_tile;
		this.filler = filler_tile;
	}

	public RoomSet setGroundTile(int[] ground_tile) {
		this.ground = ground_tile;
		return this;
	}

	public RoomSet setWallTile(int[] wall_tile) {
		this.wall = wall_tile;
		return this;
	}

	public RoomSet setFillerTile(int[] filler_tile) {
		this.filler = filler_tile;
		return this;
	}

	public RoomSet setEndpieceTile(int[] endpiece_tile) {
		this.endpiece = endpiece_tile;
		return this;
	}
	
	public RoomSet setCornerTile(int[] corner_tile) {
		this.corner = corner_tile;
		return this;
	}
	
	public RoomSet setSlopeTiles(int[] smallslope1_tile,int[] smallslope2_tile,
			int[] smallslope1_bottom_tile,int[] smallslope2_bottom_tile) {
		this.smallslope1 = smallslope1_tile;
		this.smallslope2 = smallslope2_tile;
		this.smallslope1_bottom = smallslope1_bottom_tile;
		this.smallslope2_bottom = smallslope2_bottom_tile;
		return this;
	}
	
	public RoomSet setSlopeTiles(int[] smallslope1_tile,int[] smallslope2_tile,int[] smallslope3_tile,
			int[] smallslope1_bottom_tile,int[] smallslope2_bottom_tile,int[] smallslope3_bottom_tile) {
		this.smallslope3 = smallslope3_tile;
		this.smallslope3_bottom = smallslope3_bottom_tile;
		return setSlopeTiles(smallslope1_tile,smallslope2_tile,
				smallslope1_bottom_tile,smallslope2_bottom_tile);
	}
	
	public RoomSet setSteepSlopeTiles(int[] steepslope1_tile,int[] steepslope2_tile,
			int[] steepslope1_bottom_tile,int[] steepslope2_bottom_tile) {
		this.steepslope1 = steepslope1_tile;
		this.steepslope2 = steepslope2_tile;
		this.steepslope1_bottom = steepslope1_bottom_tile;
		this.steepslope2_bottom = steepslope2_bottom_tile;
		return this;
	}
}
