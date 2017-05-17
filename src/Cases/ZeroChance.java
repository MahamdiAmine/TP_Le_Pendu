package Cases;
import Enum.EtatCase;

/**
 * Created by Mahamdi on 4/21/17.
 */

public class ZeroChance extends Case {

    private static final int valeur = 3;

    public ZeroChance(char caractere) {
        super(caractere);
    }

    @Override
    public int getValeur()
    {
        return valeur;
    }

    @Override
    public  EtatCase getEtat(){
        return etat;
    }

    @Override
    public String getType() {
        return "ZEROCHANCE";
    }


    @Override
    public boolean verifierProposition(char p) {
        etat = charEqualsNoCaseMatch(caractere,p) ? EtatCase.TROUVEE : EtatCase.RATEE;
        return charEqualsNoCaseMatch(caractere,p);
        }
    public  boolean charEqualsNoCaseMatch(char c1,char c2){
        return Character.toLowerCase(c1)==Character.toLowerCase(c2);
    }
}
