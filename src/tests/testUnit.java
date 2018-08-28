package tests;

import model.Concept;
import model.Unit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class testUnit {

    private Concept c1;
    private Concept c2;
    private Unit u1;

    @BeforeEach
    public void setUp() {
        c1 = new Concept("Psyc101", "A Psyc class by UBC",0);
        c2 = new Concept("Psyc102", "Another Psyc class by UBC",0);
        u1 = new Unit(1);
    }

    @Test
    public void testConstructor() {
        Unit u0 = new Unit(0);
        u0.addConcept(c1);
        u0.addConcept(c2);
        assertTrue(u0.contains(c1));
        assertTrue(u0.contains(c2));
        assertEquals(0, u0.getReview().size());
    }

    @Test
    public void testPQ() {
        c2.forget();
        u1.addConcept(c1);
        u1.addConcept(c2);
        u1.buildReview(2);
        assertTrue(u1.reviewContains(c1));
        assertTrue(u1.reviewContains(c2));
        u1.clearReview();

        u1.addConcept(c1);
        u1.addConcept(c2);
        u1.buildReview(1);
        assertTrue(u1.reviewContains(c2));
        assertFalse(u1.reviewContains(c1));
        u1.clear();

        u1.addConcept(c1);
        u1.buildReview(2);
        assertTrue(u1.reviewContains(c1));
        assertFalse(u1.reviewContains(c2));
    }

}
