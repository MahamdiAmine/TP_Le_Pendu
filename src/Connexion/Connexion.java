package Connexion;

import Session.Joueur;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by Mahamdi on 4/22/17.
 */

public class Connexion {

    private List<Joueur> joueurs = new ArrayList<Joueur>();

    public boolean playerExist(Joueur player) {
        return (joueurs.contains(player));
    }


    public int meilleurScore(Joueur player) {
        // return the best score of player
        int score = 0;
        Iterator<Joueur> iterator = joueurs.iterator();
        while (iterator.hasNext()) {
            Joueur u = iterator.next();
            if (u.equals(player)) score = u.getBestScore();
        }
        return score;
    }


    public void chargerJoueurs(String path) {
        //load players when the game is start
        BufferedReader in = null;
        String ligne = "";
        String username, pass;
        int bestScore;
        try {
            in = new BufferedReader(new FileReader(path));
            while ((ligne = in.readLine()) != null)

            {
                StringTokenizer tok = new StringTokenizer(ligne, " ");
                username = "";
                pass = "";
                bestScore = 0;
                    for (int i = 0; i < 3; i++) {
                        if (i == 0) username = tok.nextToken();
                        if (i == 1) pass = tok.nextToken();
                        if (i == 2) bestScore = Integer.parseInt(tok.nextToken());
                    }
                    Joueur player = new Joueur(username, pass);
                    player.setBestScore(bestScore);
                    joueurs.add(player);
                }

        } catch (Exception e) {
            //e.printStackTrace();
        }
    }


}


