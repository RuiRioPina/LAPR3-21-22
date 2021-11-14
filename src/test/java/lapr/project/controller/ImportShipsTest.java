package lapr.project.controller;

import lapr.project.model.Ship;
import lapr.project.model.ShipStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ImportShipsTest {
    ShipStore shipStore;

    @BeforeEach
    void setUp() {
        shipStore = new ShipStore();
    }

    @Test
    void importShips() {
        String fileName = "csvFiles/sships.csv";
        List<Ship> shipsList = ImportShips.importShips(fileName);
        for (Ship ships : shipsList) {
            shipStore.addShipToAVL(ships);
        }
        Ship expected = shipStore.findShipDetails("IMO9395044");
        assertEquals(expected, shipStore.getStore().smallestElement());
    }
    @Test
    void importShips45() {
        String fileName = "csvFiles/bships.csv";
        List<Ship> shipsList = ImportShips.importShips(fileName);
        for (Ship ships : shipsList) {
            shipStore.addShipToAVL(ships);
        }
        assertEquals(shipStore.getStore().smallestElement(), shipStore.getStore().smallestElement());
    }


    @Test
    void importShips2() {
        String fileName = "csvFiles/noElements.csv";
        ImportShips.importShips(fileName);
        String code = "339911000";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{ Ship ship = shipStore.findShipDetails(code);;} );


    }
    @Test
    void importShips3() {
        String fileName = "csvFiles/shipID.csv";
        List<Ship> shipsList = ImportShips.importShips(fileName);
        String code = "IMO9395044";
        for (Ship ships : shipsList) {
            ships.getShipId().setSearchCode(code);
            shipStore.addShipToAVL(ships);
        }
        Throwable exception = assertThrows(IllegalArgumentException.class,
                ()->{ Ship ship = shipStore.findShipDetails(code);;} );



    }
}