package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class NewReview extends Button {

    public NewReview(FlashCardDisplayer displayer, JComponent parent) {
        super(displayer, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("New");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener(e -> {
            displayer.generateNewReview();
        });
    }

    @Override
    public void mouseClickedInFlashCardArea(MouseEvent e) {

    }
}
