package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Card extends Button {

    private boolean isWord = false;
    private JButton desCard;

    public Card(FlashCardDisplayer displayer, JComponent parent) { super(displayer, parent); }

    @Override
    protected void createButton(JComponent parent) {
        Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);

        button = new JButton("");
        button.setPreferredSize(new Dimension(FlashCardDisplayer.CARD_WIDTH, FlashCardDisplayer.CARD_HEIGHT));
        button.setFont(font);


        desCard = new JButton("<html>");
        desCard.setPreferredSize(new Dimension(FlashCardDisplayer.CARD_WIDTH, FlashCardDisplayer.CARD_HEIGHT));
        desCard.setFont(new Font("SANS_SERIEF", Font.PLAIN, 16));
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener((e) -> {
            if (!isWord) {
                button.setText(displayer.updateConcept().getWord());
                desCard.setText("");
            } else {
                desCard.setText(withLayout(80, displayer.getCurrConcept().getDescription()));
            }
            isWord = !isWord;
        });
    }

    @Override
    public void addToParent(JComponent parent) {
        parent.add(button);
        parent.add(desCard);
    }

    @Override
    public void mouseClickedInFlashCardArea(MouseEvent e) {

    }

    /**
     * text wrapping block
     * @param width width of the text block in percentage
     */
    private String withLayout(int width, String text) {
        String str1 = "<html><center>" +
                "<body style='font-size: 16em; width: ";
        String str2 = "%" + "'>" + "<h>";
        String str3 = "</h></center>";
        return str1 + width + str2 + text + str3;
    }
}
