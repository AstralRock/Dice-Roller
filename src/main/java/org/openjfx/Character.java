package org.openjfx;

class Character {
    private String name;
    private int strength, perception, dexterity, technical, attunement, constitution, charisma;
    private int buffTurnsLeft = 0;
    public static final String[] stats = {"Strength", "Perception", "Dexterity", "Technical", "Attunement","Constitution", "Charisma"};


    public Character(String[] chararcStrings) {
        this.name = chararcStrings[0];
        this.strength = Integer.parseInt(chararcStrings[1]);
        this.perception = Integer.parseInt(chararcStrings[2]);
        this.dexterity = Integer.parseInt(chararcStrings[3]);
        this.technical = Integer.parseInt(chararcStrings[4]);
        this.attunement = Integer.parseInt(chararcStrings[5]);
        this.constitution = Integer.parseInt(chararcStrings[6]);
        this.charisma = Integer.parseInt(chararcStrings[7]);
    }
    
    public int getStat(int statNum) {
        switch (statNum) {
            case 0:
                return strength;
            case 1:
                return perception;
            case 2:
                return dexterity;
            case 3:
                return technical;
            case 4:
                return attunement;
            case 5:
                return constitution;
            case 6:
                return charisma;
            default:
                return 0;
        }
    }

    public void addBuff(int attunementLevel, int buffType, boolean isBuff) {
            switch (buffType) {
                case 0:
                    strength += attunementLevel/2;
                    break;
                case 1:
                    perception += attunementLevel/2;
                    break;
                case 2:
                    dexterity += attunementLevel/2;
                    break;
                case 3:
                    technical += attunementLevel/2;
                    break;
                case 4:
                    attunement += attunementLevel/2;
                    break;
                case 5:
                    constitution += attunementLevel/2;
                    break;
                case 6:
                    charisma += attunementLevel/2;
                    break;
                default:
                    break;
            }
        buffTurnsLeft = attunementLevel/2;
    }

    public String getName() {
        return name;
    }

    public void removeTurn()
    {
        if(buffTurnsLeft > 1)
        {
            buffTurnsLeft--;
            Console.output("Buff turns left: " + buffTurnsLeft);
        }
        else if(buffTurnsLeft == 1)
        {
            buffTurnsLeft--;
            Console.output(name+"'s Buff has worn off");
            strength -= 2;
            perception -= 2;
            dexterity -= 2;
            technical -= 2;
            attunement -= 2;
            constitution -= 2;
            charisma -= 2;
        }
    }

}

