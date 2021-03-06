package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Forget extends Button {

    public Forget(FlashCardDisplayer displayer, JComponent parent) {
        super(displayer, parent);
    }

    @Override
    protected void createButton(JComponent parent) {
        button = new JButton("forgot");
        addToParent(parent);
    }

    @Override
    protected void addListener() {
        button.addActionListener((e) -> {
            displayer.getCurrConcept().forget();
        });
    }

    @Override
    public void mouseClickedInFlashCardArea(MouseEvent e) {

    }
}
