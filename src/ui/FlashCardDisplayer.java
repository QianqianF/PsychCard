package ui;

import button.Button;
import button.Card;
import button.Forget;
import button.NewReview;
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
    public static int CARD_WIDTH = 700;
    public static int CARD_HEIGHT = HEIGHT/2;
    public static int BUTTON_WIDTH = WIDTH - CARD_WIDTH;
    private static String[] files = {"Week01.txt", "Week02.txt"};

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

    public void generateNewReview() {
        manager.buildReview(-1,0);
    }

    private void load() {
        for (String file: files) {
            ConceptParser.loadUnit(manager, "res/" + file);
        }
        // build review with given size
        manager.buildReview(-1,0);
    }

    private void createCard() {
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new GridLayout(0, 1));
        rightPanel.setSize(new Dimension(CARD_WIDTH, HEIGHT));
        add(rightPanel, BorderLayout.EAST);
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new GridLayout(0,1));
        leftPanel.setSize(new Dimension(BUTTON_WIDTH, HEIGHT));
        add(leftPanel, BorderLayout.WEST);

        Card wordCard = new Card(this, rightPanel);
        buttons.add(wordCard);
        Forget forget = new Forget(this, leftPanel);
        buttons.add(forget);
        NewReview newReview = new NewReview(this, leftPanel);
        buttons.add(newReview);

    }

    public static void main(String[] args) {
        new FlashCardDisplayer();
    }

}
