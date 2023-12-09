package org.openjfx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class Controller {

    BLogic BL = new BLogic();

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
    private TextArea terminal;

    private static Controller instance;

    public Controller() {
        instance = this;
    }

    public static TextArea getTerminal() {
        return instance.terminal;
    }
    
    @FXML
    private TextField setCharacter, DmgInput, targetBuff, statBuffed;

    // text fields
    @FXML
    public void handleSetCharacterInput(ActionEvent event) {
        System.out.println("character set");
        BL.setCharacter(setCharacter.getText());
        
    }

    @FXML
    public void handleDmgInput(ActionEvent event) {
        System.out.println("damage set");
    }

    @FXML
    public void handleTargetBuffInput(ActionEvent event) {
        System.out.println("target buff set");
    }

    @FXML
    public void handleStatBuffedInput(ActionEvent event) {
        System.out.println("buff set");
    }

    //buttons

    @FXML
    public void handleMeleeButtonAction(ActionEvent event) {
        System.out.println("Melee");
        BL.actionPressed(0);
    }

    @FXML
    public void handleStealthButtonAction(ActionEvent event) {
        System.out.println("Stealth");
    }

    @FXML
    public void handleCoinflipButtonAction(ActionEvent event) {
        System.out.println("Coinflip");
    }

    @FXML
    public void handleBlockButtonAction(ActionEvent event) {
        System.out.println("Block");
    }

    @FXML
    public void handleSpellButtonAction(ActionEvent event) {
        System.out.println("Spell");
    }

    @FXML
    public void handleRangedButtonAction(ActionEvent event) {
        System.out.println("Ranged");
    }

    @FXML
    public void handleDodgeButtonAction(ActionEvent event) {
        System.out.println("Dodge");
    }

    @FXML
    public void handleHealButtonAction(ActionEvent event) {
        System.out.println("Heal");
    }

    @FXML
    public void handleTechButtonAction(ActionEvent event) {
        System.out.println("Tech");
    }

    @FXML
    public void handlePersuadeButtonAction(ActionEvent event) {
        System.out.println("Persuade");
    }

    @FXML
    public void handleControlButtonAction(ActionEvent event) {
        System.out.println("Control");
    }

    @FXML
    public void handleDiceRollButtonAction(ActionEvent event) {
        System.out.println("Dice Roll");
    }

    @FXML
    public void handleHackOneButtonAction(ActionEvent event) {
        System.out.println("Hack One");
    }

    @FXML
    public void handleHackTwoButtonAction(ActionEvent event) {
        System.out.println("Hack Two");
    }

    @FXML
    public void handleHackThreeButtonAction(ActionEvent event) {
        System.out.println("Hack Three");
    }

    @FXML
    public void handleApplyBuffButtonAction(ActionEvent event) {
        System.out.println("Buff");
    }

    @FXML
    public void handleSaveButtonAction(ActionEvent event) {
        System.out.println("Save");
    }

    @FXML
    public void handleClearButtonAction(ActionEvent event) {
        System.out.println("Clear");
    }
}
