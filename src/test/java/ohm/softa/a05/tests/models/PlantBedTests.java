package ohm.softa.a05.tests.models;

import ohm.softa.a05.collections.SimpleList;
import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.PlantBed;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlantBedTests {
    private PlantBed<Flower> flowerBed;
    private PlantBed<Shrub> shrubBed;

    @BeforeEach
    void setup() {
        flowerBed = new PlantBed<>();
        shrubBed = new PlantBed<>();

        flowerBed.add(new Flower( 0.4, "Rosa", "Golden Celebration", PlantColor.YELLOW));
        flowerBed.add(new Flower( 0.5, "Rosa", "Abracadabra", PlantColor.RED));
        flowerBed.add(new Flower( 0.3, "Rosa", "Golden Celebration", PlantColor.YELLOW));
        flowerBed.add(new Flower( 0.35, "Rosa", "Golden Celebration", PlantColor.YELLOW));
        flowerBed.add(new Flower( 0.35, "Rosa", "Abracadabra", PlantColor.RED));
        flowerBed.add(new Flower(0.35,"Rosa", "Rosa chinensis", PlantColor.ORANGE));
        flowerBed.add(new Flower(0.35,"Tulip", "Curly Sue", PlantColor.BLUE));

        shrubBed.add(new Shrub(1.5,"Buxus", "Buxus sempervirens"));
        shrubBed.add(new Shrub(1.1,"Buxus", "Buxus sempervirens"));
        shrubBed.add(new Shrub(1.2,"Buxus", "Buxus sempervirens"));
        shrubBed.add(new Shrub(1.4,"Buxus", "Buxus sempervirens"));
    }

    @Test
    void testCreateEmptyPlantBed() {
        PlantBed<Flower> plantBed = new PlantBed<>();
        assertEquals(0, plantBed.size());
    }

    @Test
    void testGetSize() {
        assertEquals(4, shrubBed.size());
        assertEquals(7, flowerBed.size());
    }

    @Test
    void testGetPlantsByColorYellow() throws InstantiationException, IllegalAccessException {
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.YELLOW);
        assertEquals(3, flowers.size());
        for(Flower f : flowers) {
            assertEquals(PlantColor.YELLOW, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorRed() throws InstantiationException, IllegalAccessException {
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.RED);
        assertEquals(2, flowers.size());
        for(Flower f : flowers) {
            assertEquals(PlantColor.RED, f.getColor());
        }
    }

    @Test
    void testGetPlantsByColorGreen() throws InstantiationException, IllegalAccessException {
        SimpleList<Flower> flowers = flowerBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(0, flowers.size());

        SimpleList<Shrub> shrubs = shrubBed.getPlantsByColor(PlantColor.GREEN);
        assertEquals(4, shrubs.size());
    }
}
