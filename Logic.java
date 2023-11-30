public class Logic {
    
    private String name;
    private final int DEAFAULT_SUCCESS_NUMBER = 11;
    private final int DEAFAULT_STAT_NUMBER = 4; 

    Character c = new Character();
    public Logic(String name) {
        this.name = name;
    }


    public int rollDie(boolean coinFlip) {
        if (coinFlip) {
            int coin = (int) (Math.random() * 2);
            System.out.println("coinflip result: " + coin);
            return coin;
        } else {
            int die = (int) (Math.random() * 20 + 1);
            System.out.println("Dice roll: "+ die);
            return die;
        }
    }

    
    public int attack(int statNum)
    {
        int die = rollDie(false);
        //success number calculations
        int stat = c.getStat(name, statNum);
        int modifer = 0;
        String[] statName = {"Strength", "Perception", "Dexterity", "Technical", "Attunement","Constitution"};

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
                return statNum;
            }
            else
            {
                System.out.println(name+" "+ statName[statNum] +"Attack failed");
                return 0;
            }
        } else {
            System.out.println("Critical hit!");
            return statNum*2;
        }
            
    }


    //Block and dodge and ward method
    public int counter(int damage, String type)
    {
        int die = rollDie(true);
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
            return damage - c.getStat(name, statNum);
        }
        System.out.println("bro failed to block, damage dealt: "+damage);
        return damage;
    }

    public boolean skillCheck(int statNum)
    {
        if(attack(statNum) != 0)
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
        int stat = c.getStat(name, 3);

            if(stat > DEAFAULT_STAT_NUMBER)
            {
                modifer = (stat - DEAFAULT_STAT_NUMBER) * -2;
            }
            if(stat < DEAFAULT_STAT_NUMBER)
            {
                modifer = (DEAFAULT_STAT_NUMBER - stat) * 2;
            }

        int die = rollDie(false);
        if(die >= successNumber + modifer)
        {
            System.out.println("Hacking successful");
            return true;
        }
        System.out.println("Hacking failed");
        return false;

    }

    public boolean mindControl()
    {
        int stat = c.getStat(name, 4);
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

        int die = rollDie(false);
        if(die >= succNum )
        {
            System.out.println("Mind control successful");
            return true;
        }
        System.out.println("Mind control failed");
        return false;
    }

    public int magicHeal()
    {
        int stat = c.getStat(name, 4);
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


        int die = rollDie(false);
        if(die >= succNum )
        {
            System.out.println("Heal successful");
            return stat;
        }
        System.out.println("Heal failed");
        return 0;
    }
}
