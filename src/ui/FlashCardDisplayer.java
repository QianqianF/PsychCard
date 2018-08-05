package ui;

import button.Button;
import button.Card;
import model.Concept;
import model.FlashCardManager;
import parser.ConceptParser;

import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class FlashCardDisplayer extends JFrame {

    private static int WIDTH = 800;
    private static int HEIGHT = 700;
    public static int BUTTON_WIDTH = 700;
    public static int BUTTON_HEIGHT = HEIGHT/2;
    private static String[] files = {"Week01.txt"};

    private FlashCardManager manager;
    private List<Button> buttons;

    private Concept currConcept;


    public FlashCardDisplayer() {
        super("UBC PSYC 101 Flash Cards");

        manager = new FlashCardManager();
        load();
        buttons = new LinkedList<>();

        setLayout(new BorderLayout());
        setMinimumSize(new Dimension(WIDTH, HEIGHT));
        createCard();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public Concept getCurrConcept() {
        return currConcept;
    }

    public Concept updateConcept() {
        currConcept = manager.getNextConcept();
        return currConcept;
    }

    private void load() {
        for (String file: files) {
            ConceptParser.loadUnit(manager, "res/" + file);
        }
        // build review with given size
        manager.buildReview(3,2);
    }

    private void createCard() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 1));
        rightPanel.setSize(new Dimension(BUTTON_WIDTH, HEIGHT));
        add(rightPanel, BorderLayout.EAST);

        Card wordCard = new Card(this, rightPanel);
        buttons.add(wordCard);
    }

    public static void main(String[] args) {
        new FlashCardDisplayer();
    }

}
