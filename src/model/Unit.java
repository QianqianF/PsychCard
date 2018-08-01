package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.PriorityQueue;

public class Unit {

    private int week;

    private PriorityQueue<Concept> concepts;
    private ArrayList<Concept> review;


    public Unit(int week) {
        this.week = week;
        concepts = new PriorityQueue<>();
        review = new ArrayList<>();
    }

    public ArrayList<Concept> getReview() { return review; }

    public void addConcept(Concept c) {
        if (c != null && !concepts.contains(c)) {
            concepts.add(c);
        }
    }

    public void addConcept(Collection<Concept> l) {
        for (Concept c: l) {
            addConcept(c);
        }
    }

    public boolean contains(Concept c) {
        return concepts.contains(c);
    }


    /**
     * build review from concept list
     * @param size the size of the review list
     */
    public void buildReview(int size) {
        for (int i = 0; i < size; i++) {
            Concept c = concepts.poll();
            if (c != null) {
                review.add(c);
            }
        }
    }

    public boolean reviewContains(Concept c) {
        return review.contains(c);
    }

    public void clearReview() { review.clear(); }

    /**
     * for testing purpose, clear concepts and review
     */
    public void clear() {
        concepts.clear();
        review.clear();
    }

}
