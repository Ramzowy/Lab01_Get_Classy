import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class ProductReader {

    public static void main(String[] args) {


        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        int size = 4;
        String[] array = new String[size];
        String delimiter = ",";

        ArrayList<Product> recs = new ArrayList<>();

        try {
            // uses a fixed known path:
            //  Path file = Paths.get("c:\\My Documents\\data.txt");

            // use the toolkit to get the current working directory of the IDE
            // Not sure if the toolkit is thread safe...
            File workingDirectory = new File(System.getProperty("user.dir"));

            // Typiacally, we want the user to pick the file so we use a file chooser
            // kind of ugly code to make the chooser work with NIO.
            // Because the chooser is part of Swing it should be thread safe.
            chooser.setCurrentDirectory(workingDirectory);
            // Using the chooser adds some complexity to the code.
            // we have to code the complete program within the conditional return of
            // the filechooser because the user can close it without picking a file

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();
                // Typical java pattern of inherited classes
                // we wrap a BufferedWriter around a lower level BufferedOutputStream
                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                System.out.println();
                System.out.println("\tID#\t Name\tDescription\tCost");
                System.out.println("\t======================================");
                // Finally we can read the file LOL!

                while (reader.ready()) {
                    rec = reader.readLine();
                    array = rec.split(delimiter);
                    String id = array[0];
                    String name = array[1];
                    String description = array[2];
                    double cost = Double.parseDouble(array[3]);

                    Product product = new Product( id,name,description,cost);
                    recs.add(product);
                    // echo to screen
                }
                reader.close();// must close the file to seal it and flush buffer

                for (Product product : recs) {
                    System.out.printf("\n\t %-60s ", product);
                }

                System.out.println("\n\nData file read!");


            } else  // User closed the chooser without selecting a file
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
