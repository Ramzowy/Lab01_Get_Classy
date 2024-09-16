public class ObjInputTest {
    public static void main(String[] args) {
        SafeInputObj input = new SafeInputObj();

        String name = "";
        int age = 0;
        int yob = 0;
        double cents = 0;
        double height = 0;
        boolean valid = false;
        String SSN = "";


          name = input.getNonZeroLenString("What's your name?");
          System.out.println(name);

          age = input.getInt("What's your age?");
          System.out.println(age);

          cents = input.getDouble("How many cents you got?");
          System.out.println(cents);

          yob = input.getRangedInt("What's your year of birth",1950,2010);
          System.out.println(yob);

          height = input.getRangedDouble("What's your height in feet?",4.8,6.7);
          System.out.println(height);

          valid = input.getYNConfirm("Are you above 21?[Y/N]");
          System.out.println(valid);

          SSN = input.getRegExString("^\\d{3}-\\d{2}-\\d{4}$", "What's your social number?");
          System.out.println(SSN);







    }
}
