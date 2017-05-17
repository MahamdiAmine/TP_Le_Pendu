package Cases;
import Interfaces.Malus;
import Enum.EtatCase;
/**
 * Created by Mahamdi on 4/21/17.
 */
public class MultiChances extends Case implements Malus {

    private static final int valeur = 2;
    private static final int coeff = 2;
    private static final int maxEchec = 4;
    private int nbrEchecs;

    public MultiChances(char caractere) {
        super(caractere);
    }

    @Override
    public EtatCase getEtat() {
        return etat;
    }

    @Override
    public String getType() {
        return "MULTICHANCES";
    }


    @Override
    public boolean verifierProposition(char p) {
        if (!charEqualsNoCaseMatch(caractere,p)){
            nbrEchecs++;
            if (nbrEchecs>=maxEchec){
                etat = EtatCase.RATEE;
            }
        }else{
            etat = EtatCase.TROUVEE;
        }
        return charEqualsNoCaseMatch(caractere,p);
    }

    public  boolean charEqualsNoCaseMatch(char c1,char c2){
        return Character.toLowerCase(c1)==Character.toLowerCase(c2);
    }

    @Override
    public int getValeur() {
        return valeur;
    }

    @Override
    public int getNbrEchec() {
        return nbrEchecs;
    }

       @Override
    public int getCoeff() {
        return coeff;
    }

}
