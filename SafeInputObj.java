import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;
    public SafeInputObj(){

        this.pipe = new Scanner(System.in);

    }

    public SafeInputObj(Scanner pipe){

        pipe = new Scanner(System.in);

    }

    public String getNonZeroLenString( String prompt)
    {
        String retString = "";  // Set this to zero length. Loop runs until it isn’t
        do
        {
            System.out.print("\n" +prompt + ": "); // show prompt add space
            retString = this.pipe.nextLine();
        }while(retString.length() == 0);

        return retString;

    }

    public int getInt(String prompt)
    {
        int retInt;
        while (true)
        {
            System.out.print("\n" + prompt + ":");
            if (this.pipe.hasNextInt())
            {
                retInt = this.pipe.nextInt();
                this.pipe.nextLine();
                break;
            }
            else
            {
                System.out.println("Please enter a valid input!!");
                this.pipe.nextLine();
            }
        }
        return retInt;
    }

    public double getDouble(String prompt)
    {
        double retDouble;
        while (true)
        {
            System.out.print("\n" + prompt + ": ");
            if (this.pipe.hasNextDouble())
            {
                retDouble = this.pipe.nextDouble();
                this.pipe.nextLine();
                break;
            } else
            {
                System.out.println("Please enter a valid input!!");
                this.pipe.nextLine();
            }
        }
        return retDouble;
    }


    public int getRangedInt(String prompt, int min, int max )
    {
        int y;
        y = max;
        int x;
        x = min;
        int retInt;

        while (true)
        {
            System.out.print("\n" + prompt + ":");
            if (this.pipe.hasNextInt())
            {
                retInt = this.pipe.nextInt();
                if (retInt >= x && retInt <= y)
                {
                    this.pipe.nextLine();
                    break;
                } else
                {
                    System.out.println("Please make sure your integer is within range!!");
                    this.pipe.nextLine();
                }
            }
            else
            {
                System.out.println("Please enter a valid input!");
                this.pipe.nextLine();
            }
        }
        return retInt;

    }



    public  double getRangedDouble( String prompt, double min, double max )
    {
        double y;
        y = max;
        double x;
        x = min;
        double retDouble;

        while (true)
        {
            System.out.print("\n" + prompt + ": ");
            if (this.pipe.hasNextDouble())
            {
                retDouble = this.pipe.nextDouble();
                if (retDouble >= x && retDouble <= y)
                {this.pipe.nextLine();
                    break;
                } else
                {
                    System.out.println("Please make sure your double is within range!!");
                    this.pipe.nextLine();
                }
            }
            else
            {
                System.out.println("Please enter a valid input!");
                this.pipe.nextLine();
            }
        }

        return retDouble;
    }

    public boolean getYNConfirm(String prompt)
    {
        String str ="";
        boolean done = false;
        while (true)
        {
            System.out.print(prompt+" ");
            str = this.pipe.nextLine();
            if (str.equalsIgnoreCase("Y") || str.equalsIgnoreCase("Yes"))
            {
                done = true;
                break;
            }
            else if (str.equalsIgnoreCase("N") || str.equalsIgnoreCase("No"))
            {
                break;
            }
            else
            {
                System.out.println("Please enter a valid input!!");
            }
        }
        return done;
    }


    public String getRegExString(String regexPattern, String prompt) {
        String input;
        while (true)
        {
            System.out.print(prompt);
            input = this.pipe.nextLine();
            if (input.matches(regexPattern))
            {
                return input;
            }
            else {
                System.out.println("Invalid input. Please follow the specified pattern.");
            }
        }
    }

    public static void main(String[] args) {

    }
}
