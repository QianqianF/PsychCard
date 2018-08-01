package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Card extends Button {

    public Card(FlashCardDisplayer displayer, JComponent parent) {
        super(displayer, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("Group");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener((e) -> {

        });
    }

    @Override
    public void mouseClickedInFlashCardArea(MouseEvent e) {

    }
}
