package Cases;
import Interfaces.Prop;
import Interfaces.Malus;
import Enum.EtatCase;
import java.util.ArrayList;
import java.util.Random;


/**
 * Created by Mahamdi on 4/21/17.
 */
public class Propositions extends ZeroChance implements Malus,Prop {

    private static final int valeur = 1;
    private static final int coeff = 1;
    private static final int maxEchec = 4;
    private static final int nbrProp = 4;
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private int nbrEchecs = 0;
    private ArrayList<Character> propsitions = new ArrayList<>();
    public Propositions(char caractere) {
        super(caractere);
        setPosition(caractere);//pour generer les positions
    }

    private void setPosition(char caractere) {
        //pour generer les positions
        Random r = new Random();
        for (int i = 0; i < nbrProp - 1; i++) {
            int c = r.nextInt(alphabet.length());
            while (charEqualsNoCaseMatch(caractere, alphabet.charAt(c))&& !propsitions.contains(alphabet.charAt(c))) {
                c = r.nextInt(alphabet.length());
            }

            propsitions.add(alphabet.charAt(c));
        }
        int pos = r.nextInt(propsitions.size());
        propsitions.add(pos, Character.toUpperCase(caractere));
    }

    @Override
    public int getCoeff() {
        return coeff;
    }

    @Override
    public int getNbrEchec() {
        return nbrEchecs;
    }
    public  boolean charEqualsNoCaseMatch(char c1,char c2){
        return Character.toLowerCase(c1)==Character.toLowerCase(c2);
    }

    @Override
    public ArrayList<Character> getPropositions() {
        return propsitions;
    }

    @Override
    public boolean verifierProposition(char caractere) {
        boolean res = super.verifierProposition(caractere);
        if (etat==EtatCase.RATEE){
            nbrEchecs=1;
        }
        return res;
    }

    public String getType() {
        return "PROPOSITION";
    }
}
