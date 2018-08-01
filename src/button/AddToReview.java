package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class AddToReview extends Button {

    public AddToReview(FlashCardDisplayer displayer, JComponent parent) {
        super(displayer, parent);
    }

    @Override
    protected void createButton(JComponent parent) {

    }

    @Override
    protected void addListener() {

    }

    @Override
    public void mouseClickedInFlashCardArea(MouseEvent e) {

    }
}
