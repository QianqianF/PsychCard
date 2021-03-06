package model;

import java.util.ArrayList;

public class FlashCardManager {

    private static final int REVIEW_LIST_SIZE = 40;

    private final String END = "No more item in the review list!";

    private ArrayList<Unit> units;
    private ArrayList<Concept> review;
    private Concept currConcept;
    private int currUnit;
    private int currConIndex;

    public FlashCardManager() {
        units = new ArrayList<>();
        review = new ArrayList<>();
        currUnit = 0;
        currConIndex = -1;
    }

    public void addUnit(Unit u) {
        if (u != null && !units.contains(u)) {
            units.add(u);
        }
    }


    public Concept getNextConcept() {
        putBack();
        if (++currConIndex < review.size()) {
            currConcept = review.get(currConIndex);
            currUnit = currConcept.getUnitNumber();
            return currConcept;
        } else {
            System.out.println(END);
            return new Concept(END,"", currUnit);
        }
    }

    public void buildReview(int i, int size) {

        clearReview();
        for (Unit u: units) {
            u.addConcept(u.getReview());
            u.clearReview();
        }


        switch (i) {
            case 0: /* Build list from all units */
                return; // stub
            case 1: /** TODO: build list of given size */
                int week = 0;
                while (review.size() + units.get(week).getSize() <= size) {
                    review.addAll(units.get(week).getReview());
                    week++;
                    if (week >= units.size()) return;
                }
                for (int j = 0; j < size - review.size(); j++) {
                    review.add(units.get(week).getReview().get(j));
                }
                break;

            default: // build a review list of everything
                for (Unit u: units) {
                    u.buildReview(u.getSize());
                    review.addAll(u.getReview());
                }

        }

    }

    public void putBack() {

        if (currConcept != null) {
            if (currConcept.getWord().equals(END)) return;
            else currConcept.remember();
        }
        if (currUnit < units.size()) {
            units.get(currUnit).getReview().remove(currConcept);
            units.get(currUnit).addConcept(currConcept);
        }
    }

    public void clearReview() {
        review.clear();
        currUnit = 0;
        currConIndex = -1;
    }

}
