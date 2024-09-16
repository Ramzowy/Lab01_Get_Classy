import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

/**
 *
 * @author wulft
 * 
 * Use the thread safe NIO IO library to read a file
 */
public class PersonReader
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        String rec = "";
        int size = 5;
        String[] array = new String[size];
        String delimiter = ",";

        ArrayList<Person> recs = new ArrayList<>();
        
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
                 System.out.println("\tID#\t FirstName\tLastName\tTitle\tYOB");
                 System.out.println("\t======================================");
               // Finally we can read the file LOL!

               while (reader.ready()) {
                   rec = reader.readLine();
                   array = rec.split(delimiter);
                    String id = array[0];
                    String firstName = array[1];
                    String lastName = array[2];
                    String title = array[3];
                    int yob = Integer.parseInt(array[4]);

                  Person person = new Person( id,firstName,lastName,title,yob);
                       recs.add(person);
                   // echo to screen
               }
               reader.close();// must close the file to seal it and flush buffer

               for (Person person : recs) {
                   System.out.printf("\n\t %-60s ", person);
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
