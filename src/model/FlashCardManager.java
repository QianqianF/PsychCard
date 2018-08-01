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
            System.out.println("No more item in the review list!");
            return null;
        }
    }

    public void buildReview(int i, int size) {
        switch (i) {
            case 0: /* Build list from all units */
                return; // stub
            default: // build list from week 0 and above
                int week = 0;
                while (review.size() + units.get(week).getReview().size() <= size) {
                    review.addAll(units.get(week).getReview());
                    week++;
                    if (week >= units.size()) return;
                }
                for (int j = 0; j < size - review.size(); j++) {
                    review.add(units.get(week).getReview().get(j));
                }
        }

    }

    public void putBack() {
        if (currUnit < units.size()) {
            units.get(currUnit).addConcept(currConcept);
        }
    }

    public void clearReview() {
        review.clear();
    }

}
