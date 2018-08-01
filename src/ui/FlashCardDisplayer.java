package ui;

import button.Button;
import model.Concept;
import model.FlashCardManager;
import parser.ConceptParser;

import javax.swing.*;
import java.util.List;

public class FlashCardDisplayer extends JFrame {

    private static int WIDTH = 500;
    private static int HEIGHT = 500;
    private static int BUTTON_WIDTH = 100;
    private static String[] files = {"Week01.txt"};

    private FlashCardManager manager;
    private List<Button> buttons;

    private Concept currConcept;


    public FlashCardDisplayer() {
        super("UBC PSYC 101 Flash Cards");

        manager = new FlashCardManager();
        load();
        
    }

    private void load() {
        for (String file: files) {
            ConceptParser.loadUnit(manager, "res/" + file);
        }
    }

    public static void main(String[] args) {
        new FlashCardDisplayer();
    }
}
