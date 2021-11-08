package lapr.project.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class SummaryOfShipMovementTest {
    ShipStore store = new ShipStore();
    Ship ship;
    Route route = new Route();
    ShipCharacteristics shipCharacteristics;
    Identification idShip;
    ShipDynamic dynamic;
    SummaryOfShipMovement summaryOfShipMovement;
    @BeforeEach
    public void setUp()  {
        idShip = new Identification("210950000", "VARAMO", "IMO9395044", "C4SQ2");
        shipCharacteristics = new ShipCharacteristics(70, 166.0, 25.0, 9.5);

        dynamic = (new ShipDynamic("31/12/2020 16:12", new Location(42.73879, -66.97726), new Movement(13.4, 3.4, 357.0), "NA", "A"));
        ShipDynamic dynamic1 = (new ShipDynamic("31/12/2020 17:03", new Location(42.92236, -66.97243), new Movement(12.5, 2.4, 358.0), "NA", "A"));
        ShipDynamic dynamic2 = (new ShipDynamic("31/12/2020 17:13", new Location(42.95969, -66.97106), new Movement(12.9, 8.1, 358.0), "NA", "A"));
        ShipDynamic dynamic3 = (new ShipDynamic("31/12/2020 16:32", new Location(42.81133, -66.97587), new Movement(13.4, 10.0, 356.0), "NA", "A"));
        ShipDynamic dynamic4 = (new ShipDynamic("31/12/2020 16:52", new Location(42.8839, -66.97577), new Movement(12.7, 2.5, 359.0), "NA", "A"));
        ShipDynamic dynamic5 = (new ShipDynamic("31/12/2020 17:33", new Location(43.02665, -66.97076), new Movement(12.5, 3.6, 354.0), "NA", "A"));

        route.add(dynamic1);
        route.add(dynamic);
        route.add(dynamic2);
        route.add(dynamic3);
        route.add(dynamic4);
        route.add(dynamic5);
        ship = new Ship(idShip, shipCharacteristics, route);
        store.addShipToBST(ship);
        store.organizeShipMessage();
       summaryOfShipMovement= new SummaryOfShipMovement(ship);
    }
    @Test
    public void testToString(){
        String expected = summaryOfShipMovement.toString();
        assertEquals(expected,summaryOfShipMovement.toString());
    }
}
