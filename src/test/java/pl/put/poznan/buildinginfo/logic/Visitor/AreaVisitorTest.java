package pl.put.poznan.buildinginfo.logic.Visitor;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.put.poznan.buildinginfo.logic.Composite.Building;
import pl.put.poznan.buildinginfo.logic.Composite.Level;
import pl.put.poznan.buildinginfo.logic.Composite.Room;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AreaVisitorTest {

    private Building building;
    private Level level1;
    private Room room1;
    private AreaVisitor areaVisitor;

    @BeforeEach
    void setUp() {
        room1 = new Room(); room1.setArea(10);
        Room r2 = new Room(); r2.setArea(20);
        Room r3 = new Room(); r3.setArea(30);
        Room r4 = new Room(); r4.setArea(40);

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

        areaVisitor = new AreaVisitor();
    }


    @Test
    void testTotalAreaBuildingCalculation() {
        building.accept(areaVisitor);

        assertEquals(100, areaVisitor.getResult(), "Area calculation failed for the building.");
    }

    @Test
    void testTotalAreaLevelCalculation() {
        level1.accept(areaVisitor);

        assertEquals(30, areaVisitor.getResult(), "Area calculation failed for the level.");
    }

    @Test
    void testTotalRoomLevelCalculation() {
        room1.accept(areaVisitor);

        assertEquals(10, areaVisitor.getResult(), "Area calculation failed for the level.");
    }
}