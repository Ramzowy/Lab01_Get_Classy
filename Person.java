import java.util.Calendar;
import java.util.Objects;

public class Person {

    private  String ID;
  private  String firstName;
   private String lastName;
   private String title;
  private  int YOB;

    public Person( String ID,String firstName, String lastName, String title, int YOB) {

        this.ID = ID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.YOB = YOB;
    }

    public String fullName(){
        return firstName + " " + lastName;
    }

    public String formalName(){
        return title + " " + fullName();
    }

    public String getAge() {
        // Get the current date
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);

        // Calculate age
        int age = currentYear - this.YOB;

        // Return the age as a string
        return String.valueOf(age);
    }

    public String getAge(int YOB){
        Calendar today = Calendar.getInstance();
        int currentYear = today.get(Calendar.YEAR);

        int age = currentYear - YOB;

        // Return the age as a string
        return String.valueOf(age);
    }

    public String toJSON(){

        String DQ = "\"";

        return "{"+ DQ + "ID" + DQ + ":" + DQ + this.ID + DQ + "," + DQ + "firstName" + DQ + ":" + DQ + this.firstName + DQ + "," + DQ + "lastName" + DQ + ":" + DQ + this.lastName + DQ + "," + DQ + "Title" + DQ + ":" + DQ + this.title + DQ + "," + DQ + "YOB" + DQ + ":" + DQ + this.YOB + DQ + "}";
    }

   public String toXML(){
        return String.format("<person><ID>%S</ID><firstName>%s</firstName><lastName>%s</lastName><title>%s</title><YOB>%d</YOB></person>", ID, firstName,lastName,title,YOB);
   }
    public String toCSV(){
        return String.format("%s,%s,%s,%s,%d", ID, firstName, lastName, title, YOB);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return ID == person.ID && YOB == person.YOB && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(title, person.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, ID, title, YOB);
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName = '" + firstName + '\'' +
                ", lastName = '" + lastName + '\'' +
                ", ID = " + ID +
                ", title = ' " + title + '\'' +
                ", YOB = " + YOB +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getID() {
        return ID;
    }

    public int getYOB() {
        return YOB;
    }

    public void setYOB(int YOB) {
        this.YOB = YOB;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public static void main(String[] args) {

        Person sally = new Person("0001","Sally","tURNER","Mr.",2001);

        System.out.println(sally.toString());

    }


}
