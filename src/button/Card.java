package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Card extends Button {

    private boolean isWord = false;
    private JTextArea desCard;

    public Card(FlashCardDisplayer displayer, JComponent parent) { super(displayer, parent); }

    @Override
    protected void createButton(JComponent parent) {
        Font font = new Font(Font.SANS_SERIF, Font.PLAIN, 16);

        button = new JButton("");
        button.setSize(new Dimension(FlashCardDisplayer.BUTTON_WIDTH, FlashCardDisplayer.BUTTON_HEIGHT));
        button.setFont(font);


        desCard = new JTextArea("");
        desCard.setSize(new Dimension(FlashCardDisplayer.BUTTON_WIDTH, FlashCardDisplayer.BUTTON_HEIGHT*2/3));
        desCard.setEditable(false);
        desCard.setLineWrap(true);
        desCard.setWrapStyleWord(true);
        desCard.setFont(font);
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener((e) -> {
            if (!isWord) {
                button.setText(displayer.updateConcept().getWord());
                desCard.setText("");
            } else {
                desCard.setText(displayer.getCurrConcept().getDescription());
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

    public void setVisible() {
        button.setVisible(true);
    }

    public void hide() {
        button.setVisible(false);
    }
}
