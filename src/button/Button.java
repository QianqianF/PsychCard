package button;

import ui.FlashCardDisplayer;

import javax.swing.*;
import java.awt.event.MouseEvent;

public abstract class Button {

    protected JButton button;
    protected FlashCardDisplayer displayer;

    /**
     * Constructor
     *
     * @param displayer  the flash card displayer associated with this tool
     * @param parent  the parent component to which this tool will be added
     */
    public Button(FlashCardDisplayer displayer, JComponent parent) {
        this.displayer = displayer;
        createButton(parent);
        addToParent(parent);
        addListener();
    }

    /**
     * Creates button used to activate tool
     * @param parent  the parent component
     */
    protected abstract void createButton(JComponent parent);

    /**
     * Adds button to parent component
     * @param parent  the parent component
     */
    public void addToParent(JComponent parent) {
        parent.add(button);
    }

    /**
     * Adds a listener for this tool.
     */
    protected abstract void addListener();

    /**
     * Mouse clicked handler - called when mouse button is clicked in flash card area
     * @param e  the mouse event
     */
    public abstract void mouseClickedInFlashCardArea(MouseEvent e) ;

}

