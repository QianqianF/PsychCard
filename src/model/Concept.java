package model;

public class Concept implements Comparable<Concept> {

    private String word;
    private String description;
    private int unitNumber;
    private int forgetRate;

    /**
     * construct a Concept object with the word and description
     * forgetRate is set to 0
     */
    public Concept(String concept, String description, int unit) {
        this.word = concept;
        this.description = description;
        this.unitNumber = unit;
        this.forgetRate = 0;
    }

    public String getWord() {
        return word;
    }

    public String getDescription() {
        return description;
    }

    public int getUnitNumber() {
        return unitNumber;
    }

    public int getForgetRate() {
        return forgetRate;
    }

    /**
     * sort by forgetRate in decreasing order
     */
    @Override
    public int compareTo(Concept o) {
        return o.forgetRate - this.forgetRate;
    }


    public void forget() {
        forgetRate+=2;
    }

    public void remember() {
        forgetRate--;
    }
}
