import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p1,p2,p3,p4;

    @BeforeEach
    void setUp() {
        p1 = new Product("001","Pipeweed","Long Bottom Leaf",600);
        p2 = new Product("002","Lembas","Elven Wayfare Bread",200);
        p3 = new Product("003","Wine","Woodland Elf Wine",400);
        p4 = new Product("004","Mushrooms","Farmer Took Finest",125);
    }

    @Test
    void productName() {
        assertEquals("Pipeweed Long Bottom Leaf",p1.productName());
    }

    @Test
    void toJSON() {

        String result = p1.toJSON();

        // Assert: Verify the JSON string is as expected
        String expectedJSON = "{\"ID\":\"001\",\"name\":\"Pipeweed\",\"description\":\"Long Bottom Leaf\",\"cost\":\"600.0\"}";
        assertEquals(expectedJSON, result);

    }

    @Test
    void toXML() {
        String result = p1.toXML();

        // Assert: Verify the XML string is as expected
        String expectedXML = "<product><ID>001</ID><name>Pipeweed</name><description>Long Bottom Leaf</description><cost>600.00</cost></product>";
        assertEquals(expectedXML, result);
    }

    @Test
    void toCSV() {

        String result = p1.toCSV();

        // Assert: Verify the XML string is as expected
        String expectedCSV = "001,Pipeweed,Long Bottom Leaf,600.00";
        assertEquals(expectedCSV, result);
    }

    @Test
    void testEquals() {

        p1.setID("001");
        p1.setName("Pipe");
        p1.setDescription("Tobbaco");
        p1.setCost(600);
        assertEquals(false,p1.equals(p2));
    }

    @Test
    void testHashCode() {

        int hash1 = p1.hashCode();
        int hash2 = p2.hashCode();

        // Assert: The hash codes should be equal since the objects are identical
        assertNotEquals(hash1,hash2);
    }

    @Test
    void testToString() {

        p1.setID("001");
        p1.setName("Car");
        p1.setDescription("Tesla");
        p1.setCost(35000);

        String expected = "Product{ID='001', name='Car', description='Tesla', cost=35000.0}";

        String result = p1.toString();
        assertEquals(expected,result);
    }

    @Test
    void setID() {
        String expected = "001";
        p1.setID("001");
        assertEquals(expected, p1.getID());
    }

    @Test
    void setName() {
        String expected = "Car";
        p1.setName("Car");
        assertEquals(expected, p1.getName());
    }

    @Test
    void setDescription() {
        String expected = "Tesla";
        p1.setDescription("Tesla");
        assertEquals(expected, p1.getDescription());
    }

    @Test
    void setCost() {
        double expected = 35000;
        p1.setCost(35000.00);
        assertEquals(expected, p1.getCost());
    }
}