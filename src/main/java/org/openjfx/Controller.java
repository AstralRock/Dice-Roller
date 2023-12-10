package org.openjfx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import javafx.event.ActionEvent;

public class Controller {

    private Characters characters;
    private String currentCharacter = "doNotDelete";
    private String buffTarget = "doNotDelete";
    private int buffStat = 0;
    private int damage = 0;
    private Logic logic;

    
    @FXML
    private Button
    meleeButton, stealthButton, coinflipButton, 
    blockButton, spellButton, rangedButton,
    dodgeButton, healButton, techButton,
    persuadeButton, controlButton, diceRollButton,
    hackOneButton, hackTwoButton, hackThreeButton,
    buffButton, 
    saveButton, clearButton; 

    @FXML
    private Label warnings;
    public static Label getWarnings() {
        return instance.warnings;
    }

    @FXML
    private TextArea terminal;

    public static TextArea getTerminal() {
        return instance.terminal;
    }

    private static Controller instance;

    public Controller() {
        instance = this;
        Characters charList = new Characters();
        Logic l = new Logic(charList.getCharacter("doNotDelete"));

        characters = charList;
        logic = l;

    }


    
    @FXML
    private TextField setCharacter, dmgInput, targetBuff, statBuffed;

    // text fields
    @FXML
    public void handleSetCharacterInput(ActionEvent event) {
        System.out.println("character set");
        try {
            logic.setCharacter(characters.getCharacter(setCharacter.getText()));
            currentCharacter = setCharacter.getText();
            Console.flag("Character set to " + currentCharacter);
        }
        catch (NullPointerException e) {
            Console.error("Invalid Character");
            currentCharacter = "doNotDelete";
        }
    }


    @FXML
    public void handleDmgInput(ActionEvent event) {
        try {
            damage = Integer.parseInt(dmgInput.getText());
            Console.flag("Damage set to " + damage);
            if(damage == 0) Console.warn("Damage input is 0");
        } catch (NumberFormatException e) {
            System.out.println("Not a number");
            Console.error("Invalid Damage Input");
        }
    }

    @FXML
    public void handleTargetBuffInput(ActionEvent event) {
        try {
            characters.getCharacter(targetBuff.getText());
            buffTarget = targetBuff.getText();
            Console.flag("Target set to " + buffTarget);
        }
        catch (NullPointerException e) {
            Console.error("Invalid Character");
        }
    }


    @FXML
    public void handleStatBuffedInput(ActionEvent event) {
        String stat = statBuffed.getText();
        stat = stat.substring(0, 1).toUpperCase() + stat.substring(1).toLowerCase();

        Boolean validStat = false;
        int i = 0;
        for(i = 0; i < Character.stats.length; i++) {
            if(Character.stats[i].equals(stat)) {
                validStat = true;
                break;
            }
        }
        if(validStat) {
            buffStat = i;
            Console.flag("Stat set to " + Character.stats[buffStat]);
        }
        else Console.error("Invalid Stat");
    }


    //buttons

    @FXML
    public void handleMeleeButtonAction(ActionEvent event) {
        System.out.println("Melee");
        Console.output(currentCharacter +" did "+ logic.attack(0, "Melee") + " damage");
    }

    @FXML
    public void handleStealthButtonAction(ActionEvent event) {
        boolean w = logic.skillCheck(2, "Stealth");
        if(w) {
            Console.output(currentCharacter + " failed stealth attack");
        } else {
            Console.output(currentCharacter + " succeeded stealth attack");
        }
    }

    @FXML
    public void handleCoinflipButtonAction(ActionEvent event) {
        logic.rollDie(true, "Coinflip");
    }

    @FXML
    public void handleBlockButtonAction(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY && blockButton.getText().equals("Block")) {
            blockButton.setText("Ward");
        } else if (event.getButton() == MouseButton.SECONDARY && blockButton.getText().equals("Ward")) {
            blockButton.setText("Block");
        }

        if(damage == 0 && event.getButton() == MouseButton.PRIMARY) {
            Console.warn("Damage input is 0");
        }

        if(event.getButton() == MouseButton.PRIMARY && blockButton.getText().equals("Block")) {
            Console.output(currentCharacter +" blocked "+ logic.counter(damage, "Block") + " damage");
        } else if(event.getButton() == MouseButton.PRIMARY && blockButton.getText().equals("Ward")) {
            Console.output(currentCharacter +" blocked "+ logic.counter(damage, "Ward") + " damage");
        }

    }

    @FXML
    public void handleSpellButtonAction(ActionEvent event) {
        Console.output(currentCharacter +" did "+ logic.attack(4, "Spell") + " damage");
    }

    @FXML
    public void handleRangedButtonAction(ActionEvent event) {
        Console.output(currentCharacter +" did "+ logic.attack(2, "Ranged") + " damage");
    }

    @FXML
    public void handleDodgeButtonAction(ActionEvent event) {
        if(damage == 0) {
            Console.warn("Damage input is 0");
        }
        Console.output(currentCharacter +" dodged "+ logic.counter(damage, "Dodge") + " damage");
    }

    @FXML
    public void handleHealButtonAction(MouseEvent event) {
        if (event.getButton() == MouseButton.SECONDARY && healButton.getText().equals("Heal")) {
            healButton.setText("Magic Heal");
        } else if (event.getButton() == MouseButton.SECONDARY && healButton.getText().equals("Magic Heal")) {
            healButton.setText("Heal");
        }

        if (event.getButton() == MouseButton.PRIMARY && healButton.getText().equals("Heal")) {
            Console.output(currentCharacter +" healed "+ logic.Heal(false) + " HP");
        } else if (event.getButton() == MouseButton.PRIMARY && healButton.getText().equals("Magic Heal")) {
            Console.output(currentCharacter +" healed "+ logic.Heal(true) + " HP");
        }
    }

    @FXML
    public void handleTechButtonAction(ActionEvent event) {
        Console.output(currentCharacter+ " did " + logic.attack(3, "Tech") + " damage");
    }

    @FXML
    public void handlePersuadeButtonAction(ActionEvent event) {
        boolean w2 = logic.skillCheck(6, "Persuade");
        if(w2) {
            Console.output(currentCharacter + " failed persuade");
        } else {
            Console.output(currentCharacter + " succeeded persuade");
        }
    }

    @FXML
    public void handleControlButtonAction(ActionEvent event) {
        //for control
        boolean w3 = logic.control();
        if(w3) {
            Console.output(currentCharacter + " failed to use control");
        } else {
            Console.output(currentCharacter + " used control successfully");
        }
    }

    @FXML
    public void handleDiceRollButtonAction(ActionEvent event) {
        logic.rollDie(false, "Dice Roll");
    }

    @FXML
    public void handleHackOneButtonAction(ActionEvent event) {
        if(logic.hacking(1)) {
            Console.output(currentCharacter + " hacked successfully");
        } else {
            Console.output(currentCharacter + " failed to hack");
        }
    }

    @FXML
    public void handleHackTwoButtonAction(ActionEvent event) {
        if(logic.hacking(2)) {
            Console.output(currentCharacter + " hacked successfully");
        } else {
            Console.output(currentCharacter + " failed to hack");
        }
    }

    @FXML
    public void handleHackThreeButtonAction(ActionEvent event) {
        if(logic.hacking(3)) {
            Console.output(currentCharacter + " hacked successfully");
        } else {
            Console.output(currentCharacter + " failed to hack");
        }
    }

    @FXML
    public void handleApplyBuffButtonAction(ActionEvent event) {
        int attunment = characters.getCharacter(currentCharacter).getStat(4);
        characters.getCharacter(buffTarget).addBuff(attunment, buffStat, true);
        Console.output(currentCharacter + " buffed " + buffTarget + "'s " + Character.stats[buffStat] + " by " + attunment/2);
    }

    @FXML
    public void handleSaveButtonAction(ActionEvent event) {
        File file = new File("log.txt");
        String text = getTerminal().getText();

        try (PrintWriter writer = new PrintWriter(file)) {
            writer.write(text);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void handleClearButtonAction(ActionEvent event) {
        System.out.println("Clear");
        getTerminal().clear();
    }
}
