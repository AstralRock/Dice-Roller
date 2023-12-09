package org.openjfx;
import java.util.ArrayList;
public class BLogic {
    

    
    Characters characters = new Characters();
    private String currentCharacter;

    public void setCharacter(String name) {
        System.out.println("Character set: " + name);
        currentCharacter = name;
    }
    

    public void actionPressed(int actionID) {
        System.out.println("Action pressed: " + actionID);
        Logic logic = new Logic(characters.getCharacter(currentCharacter));

        switch (actionID) {
            case 0:
                //for melee
                logic.attack(0);
                Console.output("You attacked with your melee weapon");
                break;
            case 1:
                //for stealth
                break;
            case 2:
                
                break;
            case 3:
                // TODO: Handle action ID 3
                break;
            case 4:
                // TODO: Handle action ID 4
                break;
            case 5:
                // TODO: Handle action ID 5
                break;
            case 6:
                // TODO: Handle action ID 6
                break;
            case 7:
                // TODO: Handle action ID 7
                break;
            case 8:
                // TODO: Handle action ID 8
                break;
            case 9:
                // TODO: Handle action ID 9
                break;
            case 10:
                // TODO: Handle action ID 10
                break;
            case 11:
                // TODO: Handle action ID 11
                break;
            case 12:
                // TODO: Handle action ID 12
                break;
            case 13:
                // TODO: Handle action ID 13
                break;
            case 14:
                // TODO: Handle action ID 14
                break;
            case 15:
                // TODO: Handle action ID 15
                break;
            case 16:
                // TODO: Handle action ID 16
                break;
            case 17:
                // TODO: Handle action ID 17
                break;
            case 18:
                // TODO: Handle action ID 18
                break;
            default:
                System.out.println("Invalid action ID: " + actionID);
                break;
        }
    }
}