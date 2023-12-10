package org.openjfx;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


import java.util.ArrayList;

public class Characters {
    private ArrayList<String[]> characters = new ArrayList<String[]>();
    private ArrayList<Character> characterObjects = new ArrayList<Character>();
    public Characters() {
        File f = new File("characters.txt");
        try {
            Scanner sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine().toUpperCase().trim();
                if (line.length() > 0) { // Check if line has a length greater than 0
                    String identifier = line.substring(0, 1);
                    if (!identifier.equals("[") && !identifier.equals("\n") && !identifier.equals(" ")) {
                        String[] chararcStrings = Character.stats;

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
            for(int i = 0; i < characters.size(); i++)
            {
                Character c = new Character(characters.get(i));
                characterObjects.add(c);
            }

            System.out.println("Characters loaded");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public Character getCharacter(String name) {
            name = name.toUpperCase().trim();
            for (int i = 0; i < characters.size(); i++)
            {
                Character currentCharacter = characterObjects.get(i);
                String curCharName = currentCharacter.getName().toUpperCase().trim();
                if (curCharName.equals(name))
                {
                    return currentCharacter;
                }
            }
            System.out.println("Character not found");
            return null;
    }

        public int numCharactersLoaded() {
            return characters.size();
        }

    }

