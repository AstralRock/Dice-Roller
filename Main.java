import java.util.Scanner;



class Main
{
    public static void main(String[] args)
    {
        //clear terminal regex
        System.out.print("\n\n\n\n");
        System.out.println("Welcome to the game!");
        System.out.println("What is your name?");
        Logic l = new Logic("Xander Checker");

        for (int i = 0; i < 40; i++) {
            
            System.out.println( l.magicHeal());

            System.out.println("AGAIN!! \n");
        }


    }
}

