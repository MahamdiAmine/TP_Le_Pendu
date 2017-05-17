package Cases;
import Enum.EtatCase;


/**
 * Created by Mahamdi on 4/21/17.
 */
public abstract class Case {
    char caractere;
    EtatCase etat;

   public  Case(char caractere) {
        this.caractere = caractere;
        etat= EtatCase.ENCOURS;
    }

    public abstract int getValeur();

    public abstract EtatCase getEtat();

    public abstract String getType();


    public char getCaractere() {
        return caractere;
    }

    public abstract boolean verifierProposition(char caractere);//pour la verification


}
