package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.event.MouseEvent;

public class Skip extends Button{

    public Skip(FlashCardDisplayer displayer, JComponent parent) {
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
