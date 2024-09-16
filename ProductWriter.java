import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductWriter {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        ArrayList<Product> recs = new ArrayList<>();

        boolean doneInput = false;

        String ID = " ";
        String name = "";
        String description = "";
        double cost = 0;

        do {

            ID = SafeInput.getNonZeroLenString(in, "Enter your ID (001) ");
            name = SafeInput.getNonZeroLenString(in, "Enter your the product name");
            description = SafeInput.getNonZeroLenString(in, "Enter the description of the product");
            cost = SafeInput.getDouble(in, "Enter the cost of the product");


            Product rec = new Product(ID, name, description, cost);

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
        Path file = Paths.get(workingDirectory.getPath() + File.separator + "ProductData.txt");

        try {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for (Product r : recs) {

                writer.write(r.toCSV());  // stupid syntax for write rec
                // 0 is where to start (1st char) the write
                // rec. length() is how many chars to write (all)
                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    }

