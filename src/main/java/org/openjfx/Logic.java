package org.openjfx;

public class Logic {
    
    private String name;
    private Character chara;
    private final int DEAFAULT_SUCCESS_NUMBER = 11;
    private final int DEAFAULT_STAT_NUMBER = 4; 

    public Logic(Character charac) {
        System.out.println("Logic initialized");
        chara = charac;
    }

    public void setCharacter(Character charac) {
        chara = charac;
        this.name = charac.getName();
        System.out.println("Character set: " + name);
    }


    public int rollDie(boolean coinFlip, String type) {
        if (coinFlip) {
            int coin = (int) (Math.random() * 2);
            System.out.println("coinflip result: " + coin);
            if(coin == 0) {
                Console.output("coin landed on heads for "+ type);
            } else {
                Console.output("coin landed on tails for "+ type);
            }
            return coin;
        } else {
            int die = (int) (Math.random() * 20 + 1);
            Console.output("Dice rolled a "+die+ " for "+ type);
            return die;
        }
    }

    
    public int attack(int statNum, String type)
    {
        int die = rollDie(false, type);
        //success number calculations
        int stat = chara.getStat(statNum);
        int modifer = 0;
        String[] statName = Character.stats;        
        System.out.println("Attack stat: "+stat);
        if(die!= 20) {
            if(stat > DEAFAULT_STAT_NUMBER)
            {
                modifer = (stat - DEAFAULT_STAT_NUMBER) * -2;
            }
            if(stat < DEAFAULT_STAT_NUMBER)
            {
                modifer = (DEAFAULT_STAT_NUMBER - stat) * 2;
            }

            if(die >= DEAFAULT_SUCCESS_NUMBER + modifer)
            {
                System.out.println(name +" "+ statName[statNum] +" Attack successful");
                System.out.println("Attack method return value"+ stat);
                chara.removeTurn();   
                return stat;
            }
            else
            {
                System.out.println(name+" "+ statName[statNum] +" Attack failed");
                System.out.println("Attack method return value"+ stat);
                chara.removeTurn();
                return 0;
            }
        } else {
            System.out.println("Critical hit!");
            System.out.println("Attack method return value"+ stat);
            chara.removeTurn();
            return stat*2;
        }
    }


    //Block and dodge and ward method
    public int counter(int damage, String type)
    {
        int die = rollDie(true, type);
        type = type.toLowerCase().trim();
        //determining type of attack
        int statNum=0;
        switch(type) {
            case "block":
                statNum = 5;
                break;
            case "dodge":
                statNum = 2;
                break;
            case "ward":
                statNum = 4;
                break;
            default:
                System.out.println("Invalid type");
                break;
        }

        if(die == 1)
        {

            System.out.println("Bro blocked: "+statNum+" damage dealt "+damage);
            chara.removeTurn();
            return damage - chara.getStat(statNum);
        }
        System.out.println("bro failed to block, damage dealt: "+damage);
        chara.removeTurn();
        return damage;
    }


    //stealth
    public boolean skillCheck(int statNum, String type)
    {
        if(attack(statNum, type) != 0)
        {
            return true;
        }
        return false;
    }

    public boolean hacking(int iceLVL)
    {
        int[] succNum = {14, 18, 22};
        int successNumber = succNum[iceLVL-1];
        int modifer = 0;
        int stat = chara.getStat(3);

            if(stat > DEAFAULT_STAT_NUMBER)
            {
                modifer = (stat - DEAFAULT_STAT_NUMBER) * -2;
            }
            if(stat < DEAFAULT_STAT_NUMBER)
            {
                modifer = (DEAFAULT_STAT_NUMBER - stat) * 2;
            }

        int die = rollDie(false, "Hacking");
        if(die >= successNumber + modifer)
        {
            System.out.println("Hacking successful");
            chara.removeTurn();
            return true;
        }
        System.out.println("Hacking failed");
        chara.removeTurn();
        return false;

    }
    //mind control and re animation
    public boolean control()
    {
        
        int stat = chara.getStat(4);
        int modifer = 0;
        if(stat > DEAFAULT_STAT_NUMBER)
        {
            modifer = (stat - DEAFAULT_STAT_NUMBER) * -2;
        }
        if(stat < DEAFAULT_STAT_NUMBER)
        {
            modifer = (DEAFAULT_STAT_NUMBER - stat) * 2;
        }
        int succNum = 2 * (DEAFAULT_SUCCESS_NUMBER + modifer);

        int die = rollDie(false, "control");
        if(die >= succNum )
        {
            System.out.println(" control successful");
            chara.removeTurn();
            return true;
        }
        System.out.println(" control failed");
        chara.removeTurn();
        return false;
    }

    public int Heal(boolean magic)
    {
        int stat;
        if(magic) {
            stat = chara.getStat(4);
        } else {
            stat = chara.getStat(5);
        }

        int modifer = 0;
        if(stat > DEAFAULT_STAT_NUMBER)
        {
            modifer = (stat - DEAFAULT_STAT_NUMBER) * -2;
        }
        if(stat < DEAFAULT_STAT_NUMBER)
        {
            modifer = (DEAFAULT_STAT_NUMBER - stat) * 2;
        }
        int succNum = DEAFAULT_SUCCESS_NUMBER + modifer;


        int die = rollDie(false, "Heal");
        if(die >= succNum )
        {
            System.out.println("Heal successful");
            chara.removeTurn();
            return stat;
        }
        System.out.println("Heal failed");
        chara.removeTurn();
        return 0;
    }
}
