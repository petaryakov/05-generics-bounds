package ohm.softa.a05.tests.models;

import ohm.softa.a05.model.Flower;
import ohm.softa.a05.model.Plant;
import ohm.softa.a05.model.PlantColor;
import ohm.softa.a05.model.Shrub;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class FlowerTests {

    @Test
    void testFlowerConstructor() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(2.0, "Green Flowers", "name1", PlantColor.GREEN));
    }

    @Test
    void testCreateFlowerWithEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(0.5, "Rosa", null,  PlantColor.RED));
    }

    @Test
    void testCreateFlowerWithEmptyFamily() {
        assertThrows(IllegalArgumentException.class, () -> new Flower( 0.5, null, "Abracadabra", PlantColor.RED));
    }

    @Test
    void testCreateFlowerWithNegativeHeight() {
        assertThrows(IllegalArgumentException.class, () -> new Flower(-0.5, "Rosa", "Abracadabra", PlantColor.RED));
    }

    @Test
    void testGetCorrectColor() {
        Flower f = new Flower( 0.5, "Rosa", "Abracadabra", PlantColor.RED);
        assertEquals(PlantColor.RED, f.getColor());

    }

    @Test
    void testGetCorrectHeight() {
        Flower f = new Flower( 0.5, "Rosa", "Abracadabra", PlantColor.RED);
        assertEquals(0.5, f.getHeight(), 0.0000001);
    }

    @Test
    void testGetCorrectName() {
        Flower f = new Flower( 0.5, "Rosa", "Abracadabra", PlantColor.RED);
        assertEquals("Abracadabra", f.getName());
    }

    @Test
    void testGetCorrectFamily() {
        Flower f = new Flower( 0.5, "Rosa", "Abracadabra", PlantColor.RED);
        assertEquals("Rosa", f.getFamily());
    }

    @Test
    void testSortFlowers() {
        List<Plant> flowers = new LinkedList<>();

        flowers.add(new Shrub(3.5, "Buxus", "Buxus semperiverns"));
        flowers.add(new Flower(1.1, "Rosa", "Abracadabra", PlantColor.RED));
        flowers.add(new Shrub(5.5, "Buxus", "Buxus semperiverns"));
        flowers.add(new Flower(0.5, "Rosa", "Abracadabra", PlantColor.RED));
        flowers.add(new Shrub(1.5, "Buxus", "Buxus semperiverns"));
        flowers.add(new Flower(0.75, "Rosa", "Abracadabra", PlantColor.RED));
        flowers.add(new Shrub(4.5, "Buxus", "Buxus semperiverns"));
        flowers.add(new Flower(2.5, "Rosa", "Abracadabra", PlantColor.RED));

        flowers.sort(Plant::compareTo);

        double lastHeight = 0.0;
        for(Plant f : flowers){
            assertTrue(f.getHeight() > lastHeight);
            lastHeight = f.getHeight();
        }
    }

}
