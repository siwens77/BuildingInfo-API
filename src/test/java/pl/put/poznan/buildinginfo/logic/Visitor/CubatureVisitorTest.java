package pl.put.poznan.buildinginfo.logic.Visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.buildinginfo.logic.Composite.Building;
import pl.put.poznan.buildinginfo.logic.Composite.Level;
import pl.put.poznan.buildinginfo.logic.Composite.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class CubatureVisitorTest {

    private Building building;
    private Level level1;
    private Room room1;
    private CubatureVisitor cubatureVisitor;

    @BeforeEach
    void setUp() {
        room1 = new Room(); room1.setCubature(10);
        Room r2 = new Room(); r2.setCubature(20);
        Room r3 = new Room(); r3.setCubature(30);
        Room r4 = new Room(); r4.setCubature(40);

        ArrayList<Room> roomsLevel1 = new ArrayList<>();
        roomsLevel1.add(room1);
        roomsLevel1.add(r2);
        ArrayList<Room> roomsLevel2 = new ArrayList<>();
        roomsLevel2.add(r3);
        roomsLevel2.add(r4);

        level1 = new Level();
        level1.setChildrenRooms(roomsLevel1);
        Level level2 = new Level();
        level2.setChildrenRooms(roomsLevel2);

        ArrayList<Level> levels = new ArrayList<>();
        levels.add(level1);
        levels.add(level2);

        building = new Building();
        building.setChildrenLevels(levels);

        cubatureVisitor = new CubatureVisitor();
    }


    @Test
    void testTotalCubatureBuildingCalculation() {
        building.accept(cubatureVisitor);

        assertEquals(100, cubatureVisitor.getResult(), "Cubature calculation failed for the building.");
    }

    @Test
    void testTotalCubatureLevelCalculation() {
        level1.accept(cubatureVisitor);

        assertEquals(30, cubatureVisitor.getResult(), "Cubature calculation failed for the level.");
    }

    @Test
    void testTotalCubatureRoomCalculation() {
        room1.accept(cubatureVisitor);

        assertEquals(10, cubatureVisitor.getResult(), "Cubature calculation failed for the room.");
    }
}