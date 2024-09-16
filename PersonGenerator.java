import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class PersonGenerator {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Person> recs = new ArrayList<>();

        boolean doneInput = false;

        String ID = " ";
        String fName = "";
        String lName = "";
        String title = "";
        int yob = 0;

        do {
            ID = SafeInput.getNonZeroLenString(in,"Enter your ID(0001) ");
            fName = SafeInput.getNonZeroLenString(in,"Enter your first name");
            lName = SafeInput.getNonZeroLenString(in,"Enter your last name");
            title = SafeInput.getNonZeroLenString(in,"Enter your title");
            yob = SafeInput.getRangedInt(in,"Enter your year of birth", 1000, 9999);


             Person rec = new Person(ID,fName,lName,title,yob);

             recs.add(rec);

             doneInput = SafeInput.getYNConfirm(in, "Are you done ?");

        } while (!doneInput);





//        fileName = SafeInput.getNonZeroLenString(in,"Enter the name of the file (without extension)");


        // uses a fixed known path:
        //  Path file = Paths.get("c:\\My Documents\\data.txt");

        // use the toolkit to get the current working directory of the IDE
        // will create the file within the Netbeans project src folder
        // (may need to adjust for other IDE)
        // Not sure if the toolkit is thread safe...
        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + File.separator + "PersonData.txt");

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person r : recs)
            {

                writer.write(r.toCSV());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }
}