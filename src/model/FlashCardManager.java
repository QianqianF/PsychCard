package model;

import java.util.ArrayList;

public class FlashCardManager {

    private static final int REVIEW_LIST_SIZE = 40;

    private ArrayList<Unit> units;
    private ArrayList<Concept> review;
    private Concept currConcept;
    private int currUnit;
    private int currConIndex;

    public FlashCardManager() {
        units = new ArrayList<>();
        review = new ArrayList<>();
    }

    public void addUnit(Unit u) {
        if (u != null && !units.contains(u)) {
            units.add(u);
        }
    }

    public Concept getCurr() {
        return currConcept;
    }

    public Concept getNext() { return null; }

    public void buildReview() {}


}
