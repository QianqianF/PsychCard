package parser;

import model.Concept;
import model.FlashCardManager;
import model.Unit;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class ConceptParser {

    public static void loadUnit(FlashCardManager manager, String fileName) {
        int unitNum = getUnitNumber(fileName);
        Unit unit = new Unit(unitNum);

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for (String line; (line = br.readLine()) != null; ) {
                String[] strings = line.split(":");
                Concept c = new Concept(strings[0], strings[1], unitNum);
                unit.addConcept(c);
            }
            manager.addUnit(unit);
        } catch (IOException e) {
            System.out.println("File not found!");
            e.printStackTrace();
        }
    }

    private static int getUnitNumber(String fileName) {
        return Integer.parseInt(fileName.substring(fileName.length()-6, fileName.length()-4));
    }
}
