package org.openjfx;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;


public class controller {
    @FXML
    private Button MeleeButton;

    @FXML
    private Button StealthButton;

    @FXML
    private Button CoinFlipButton;

    @FXML
    private Button SpellButton;

    @FXML
    private Button RangedButton;

    @FXML
    private Button DodgeButton;

    @FXML
    private Button HealButton;

    @FXML
    private Button TechButton;

    @FXML
    private Button PersuadeButton;

    @FXML
    private Button ControlButton;

    @FXML
    private Button DiceRollButton;

    @FXML
    private Button HackOneButton;

    @FXML
    private Button HackTwoButton;

    @FXML
    private Button HackThreeButton;

    @FXML
    private Button ReloadButton;

    @FXML
    private Button SaveButton;

    @FXML
    private Button clearButton;

    @FXML
    private TextField CharacterInput;

    @FXML
    private TextField targetBuff;

    @FXML
    private TextField statBuff;

    @FXML
    private TextArea terminal;

    @FXML
    private void handleMeleeButtonAction(ActionEvent event) {
        System.out.println("Melee Button Pressed");
    }
    @FXML
    private void handleStealthButtonAction(ActionEvent event) {
        System.out.println("Stealth Button Pressed");
    }

    @FXML
    private void handleCoinFlipButtonAction(ActionEvent event) {
        System.out.println("Coin Flip Button Pressed");
    }

    @FXML
    private void handleSpellButtonAction(ActionEvent event) {
        System.out.println("Spell Button Pressed");
    }

    @FXML
    private void handleRangedButtonAction(ActionEvent event) {
        System.out.println("Ranged Button Pressed");
    }

    @FXML
    private void handleDodgeButtonAction(ActionEvent event) {
        System.out.println("Dodge Button Pressed");
    }

    @FXML
    private void handleHealButtonAction(ActionEvent event) {
        System.out.println("Heal Button Pressed");
    }

    @FXML
    private void handleTechButtonAction(ActionEvent event) {
        System.out.println("Tech Button Pressed");
    }

    @FXML
    private void handlePersuadeButtonAction(ActionEvent event) {
        System.out.println("Persuade Button Pressed");
    }

    @FXML
    private void handleControlButtonAction(ActionEvent event) {
        System.out.println("Control Button Pressed");
    }

    @FXML
    private void handleDiceRollButtonAction(ActionEvent event) {
        System.out.println("Dice Roll Button Pressed");
    }

    @FXML
    private void handleHackOneButtonAction(ActionEvent event) {
        System.out.println("Hack One Button Pressed");
    }

    @FXML
    private void handleHackTwoButtonAction(ActionEvent event) {
        System.out.println("Hack Two Button Pressed");
    }

    @FXML
    private void handleHackThreeButtonAction(ActionEvent event) {
        System.out.println("Hack Three Button Pressed");
    }
}
