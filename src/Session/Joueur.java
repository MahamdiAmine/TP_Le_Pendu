package Session;

import Exception.AuthentificationException;

/**
 * @author Mahamdi
 */
public class Joueur {

    private String pseudo;
    private int  bestScore;
    private String password;

    public Joueur(String pseudo, String password) throws AuthentificationException {
        if (!pseudoValide(pseudo)) throw new AuthentificationException();
        else {
            this.pseudo = pseudo;
            this.bestScore = 0;
            this.password = password;
        }

    }


    public String getPseudo() {
        return pseudo;
    }

    public void setBestScore(int bestScore) {
        this.bestScore = bestScore;
    }

    public String getPassword() {
        return password;
    }

    public int getBestScore() {
        return bestScore;
    }


    public boolean pseudoValide(String nom) {

        return (!(nom.charAt(0) >= 48 && nom.charAt(0) <= 57));

    }

    @Override

    public boolean equals(Object obj) {
        // two player's equals if they have the same name and the same password
        return ((pseudo.equals((((Joueur) obj).getPseudo()))) && (password.equals((((Joueur) obj).getPassword()))));
    }

}

