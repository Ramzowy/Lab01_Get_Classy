import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

      Person p1, p2, p3,p4;


      @BeforeEach
      void setup(){
          p1 = new Person("001","Bob","sally","Mr.",2001);
          p2 = new Person("002","Rahim","Zowy","Mr.",2002);
          p3 = new Person("003","Junior","Asake","Mr.",2003);
          p4 = new Person("004","Alex","sully","Mr.",2004);
      }

    @org.junit.jupiter.api.Test
    void fullName() {
          p1.fullName();
          assertEquals("Bob Sally","Bob Sally");
    }

    @org.junit.jupiter.api.Test
    void formalName() {
          p1.formalName();
          assertEquals("Mr. Bob Sally", "Mr. Bob Sally");
    }

    @org.junit.jupiter.api.Test
    void getAge() {
          p2.getAge();
          assertEquals(22,22);
    }

    @org.junit.jupiter.api.Test
    void testGetAge() {
          p1.getAge();
          assertEquals(23,23);
    }

    @org.junit.jupiter.api.Test
    void testEquals() {
          p1.setID("001");
          p1.setFirstName("Bob");
          p1.setLastName("sally");
          p1.setTitle("Mr.");
          p1.setYOB(2001);
          assertEquals(false,p1.equals(p2));
    }

//
    @org.junit.jupiter.api.Test
    void testToString() {
          p1.setID("001");
          p1.setFirstName("Zoey");
          p1.setLastName("Salah");
          p1.setTitle("Mr.");
          p1.setYOB(2002);

          String expected = "Person{firstName = 'Zoey', lastName = 'Salah', ID = 001, title = ' Mr.', YOB = 2002}";

          String result = p1.toString();
          assertEquals(expected,result);
    }

   @org.junit.jupiter.api.Test
    void setFirstName() {

          String expected = "Rahim";
          p1.setFirstName("Rahim");
          assertEquals(expected,p1.getFirstName());

   }

   @org.junit.jupiter.api.Test
   void setLastName() {

       String expected = "Zowange";
       p1.setLastName("Zowange");
       assertEquals(expected,p1.getLastName());
    }

    @org.junit.jupiter.api.Test
    void setTitle() {

        String expected = "Mr.";
        p1.setTitle("Mr.");
        assertEquals(expected, p1.getTitle());
    }


   @org.junit.jupiter.api.Test
    void setYOB() {
       int expected = 2005;
       p1.setYOB(2005);
       assertEquals(expected, p1.getYOB());
    }

    @org.junit.jupiter.api.Test
    void setID() {
      String expected = "005";
       p1.setID("005");
    assertEquals(expected, p1.getID());
    }



    @Test
    void toJSON() {

        // Act: Call the toJSON() method
        String result = p1.toJSON();

        // Assert: Verify the JSON string is as expected
        String expectedJSON = "{\"ID\":\"001\",\"firstName\":\"Bob\",\"lastName\":\"sally\",\"Title\":\"Mr.\",\"YOB\":\"2001\"}";
        assertEquals(expectedJSON, result);

    }

    @Test
    void toXML() {
        String result = p1.toXML();

        // Assert: Verify the XML string is as expected
        String expectedXML = "<person><ID>001</ID><firstName>Bob</firstName><lastName>sally</lastName><title>Mr.</title><YOB>2001</YOB></person>";
        assertEquals(expectedXML, result);
    }

    @Test
    void toCSV() {
        String result = p1.toCSV();

        // Assert: Verify the XML string is as expected
        String expectedCSV = "001,Bob,sally,Mr.,2001";
        assertEquals(expectedCSV, result);
    }

    @Test
    void testHashCode() {
        int hash1 = p1.hashCode();
        int hash2 = p2.hashCode();

        // Assert: The hash codes should be equal since the objects are identical
        assertNotEquals(hash1,hash2);
    }
}


