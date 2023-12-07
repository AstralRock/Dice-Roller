package org.openjfx;

class Character {
    private String name;
    private int strength, perception, dexterity, technical, attunement, constitution;
    private int buffTurnsLeft = 0;


    public Character(String[] chararcStrings) {
        this.name = chararcStrings[0];
        this.strength = Integer.parseInt(chararcStrings[1]);
        this.perception = Integer.parseInt(chararcStrings[2]);
        this.dexterity = Integer.parseInt(chararcStrings[3]);
        this.technical = Integer.parseInt(chararcStrings[4]);
        this.attunement = Integer.parseInt(chararcStrings[5]);
        this.constitution = Integer.parseInt(chararcStrings[6]);
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
            default:
                return 0;
        }
    }

    public void addBuff(int attunementLevel, int buffType, boolean isBuff) {
        if (isBuff) {
            switch (buffType) {
                case 0:
                    strength += attunementLevel/2;
                    break;
                case 1:
                    perception += attunementLevel;
                    break;
                case 2:
                    dexterity += attunementLevel;
                    break;
                case 3:
                    technical += attunementLevel;
                    break;
                case 4:
                    attunement += attunementLevel;
                    break;
                case 5:
                    constitution += attunementLevel;
                    break;
                default:
                    break;
            }

        buffTurnsLeft = attunementLevel/2;
        }
        else {
            switch (buffType) {
                case 0:
                    strength -= attunementLevel/2;
                    break;
                case 1:
                    perception -= attunementLevel/2;
                    break;
                case 2:
                    dexterity -= attunementLevel/2;
                    break;
                case 3:
                    technical -= attunementLevel/2;
                    break;
                case 4:
                    attunement -= attunementLevel/2;
                    break;
                case 5:
                    constitution -= attunementLevel/2;
                    break;
                default:
                    break;
            }
        }
    }

    public String getName() {
        return name;
    }

    public void removeTurn()
    {
        buffTurnsLeft--;
        if(buffTurnsLeft == 0)
        {
            buffTurnsLeft = 0;
        }
        if(buffTurnsLeft < 0)
        {
            buffTurnsLeft = 0;
        }
    }

}

