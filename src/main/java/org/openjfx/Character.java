package org.openjfx;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;

public class Character {
    private ArrayList<String[]> characters = new ArrayList<String[]>();
    private ArrayList<String> charNames = new ArrayList<String>();
    public Character() {
        File f = new File("characters.txt");
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().toUpperCase().trim();
                if (line.length() > 0) { // Check if line has a length greater than 0
                    String identifier = line.substring(0, 1);
                    if (!identifier.equals("[") && !identifier.equals("\n") && !identifier.equals(" ")) {
                        String[] chararcStrings = { line, "Strength", "Perception", "Dexterity", "Technical", "Attunement","Constitution" };

                        charNames.add(line);

                        //cycles through the next few lines to and incrementally overwrite the default values of the array
                        //looks for the last ] of the character entry, takes the rest and trims it, this should catch any stupid extra spaces in case the user is dumb
                        for (int i = 1; i < chararcStrings.length; i++) {
                            String nextLine = sc.nextLine();
                            int numIndex = nextLine.indexOf("]");
                            chararcStrings[i] = nextLine.substring(numIndex + 1).trim();
                        }
                        characters.add(chararcStrings);
                    }
                }
            }
            sc.close();

            // Print out the entire ArrayList
            System.out.println("Characters loaded");
            // for (String[] character : characters) {
            //     for (String attribute : character) {
            //         System.out.print(" "+attribute);
            //     }
            //     System.out.println();
            // }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


        public String[] getCharacter(String name) {
            name = name.toUpperCase().trim();
            for (int i = 0; i < charNames.size(); i++)
            {
                if (charNames.get(i).equals(name))
                {
                    //System.out.println("Character found "+charNames.get(i));
                    return characters.get(i);
                }
            }
            System.out.println("Character not found");
            String[] nochar = {"-1"};
            return nochar;
        }

        public int getStat(String name, int statNum) {
            String[] character = getCharacter(name);
            return Integer.parseInt(character[statNum+1]);
        }

        public int numCharactersLoaded() {
            return characters.size();
        }
    }
