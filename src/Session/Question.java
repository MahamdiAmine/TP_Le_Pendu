package Session;

import Cases.ZeroChance;
import Cases.Propositions;
import Cases.MultiChances;
import Interfaces.Malus;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import Enum.EtatCase;
import Cases.Case;

/**
 * @author Mahamdi
 */
public class Question {
    private static final int NUM_ZERO_CHANCES = 0;
    private static final int NUM_Proposition = 1;
    private static final int NUM_MULTICHANCES = 2;
    private String mot;
    private Indication indication;
    private EtatCase etat = EtatCase.ENCOURS;
    private boolean sanction;
    private List<Case> cases = new ArrayList<>();

    public Question(String mot, Indication indication) {
        this.mot = mot;
        this.indication = indication;
        genererCases(mot);
        setSanction();
    }

    private void setSanction() {
        // if the number of proposition  and zeochance case if grater than 5
        int count = 0;
        for (Case c : cases) {
            if (c instanceof Malus) count++;
        }
        sanction = count > 5;
    }

    private void genererCases(String mot) {
        // generate the cases
        int[] numOf = new int[]{0, 0, 0};
        int maxOf = 3;
        Random random = new Random();
        for (char c : mot.toCharArray()) {
            int typeCase = random.nextInt(numOf.length);
            while (typeCase < 2 && numOf[NUM_ZERO_CHANCES] + numOf[NUM_Proposition] >= maxOf) {
                typeCase = random.nextInt(numOf.length);
            }
            Case ca;

            switch (typeCase) {
                case NUM_ZERO_CHANCES:
                    ca = new ZeroChance(c);
                    numOf[NUM_ZERO_CHANCES]++;
                    break;
                case NUM_Proposition:
                    ca = new Propositions(c);
                    numOf[NUM_Proposition]++;
                    break;
                case NUM_MULTICHANCES:
                    ca = new MultiChances(c);
                    numOf[NUM_MULTICHANCES]++;
                    break;
                default:
                    throw new AssertionError("Assertion Error !! ");
            }
            cases.add(ca);
        }
    }

    public Indication getIndication() {
        return indication;
    }

    public EtatCase getEtat() {
        return etat;
    }

    public List<Case> getCases() {
        return cases;
    }

    public String getMot() {
        return mot;
    }

    public void setEtat(EtatCase etat) {
        this.etat = etat;
    }

    public boolean isSanction() {
        return sanction;
    }

}
