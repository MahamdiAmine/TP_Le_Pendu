package Enum;
/**
 * Created by Mahamdi on 4/22/17.
 */
public enum TypeIndication {
    DEFINITION(3),
    SYNONYME(2),
    ANTONYME(1);

    private final int coeff;

    TypeIndication(int coeff) {
        this.coeff = coeff;
    }

    public final int getCoeff() {
        return this.coeff;
    }
}