package Session;

import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

import Enum.EtatCase;

/**
 * Created by Mahamdi on 4/29/17.
 */

public class Session {
    private Joueur joueur;
    private Score score;
    private List<Question> questions;
    private int indMotCourant = 0;

    public Session(Joueur joueur, Score score, List<Question> questions) {
        this.joueur = joueur;
        this.score = score;
        this.questions = questions;
        get10Words();//get 10 words randomly from the dictionary
    }

    public void calulerScore() {
        //calculate score of the session
        score.scoreTotal(questions);
        int i = 0;
        for (Question question : questions) {
            if (question.getEtat() == EtatCase.ENCOURS) break;
            i++;
        }
        indMotCourant = i;
    }

    public int getScore() {
        return score.getScore();
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public Question getMotCourant() {
        return questions.get(indMotCourant);
    }

    public int getIndMotCourant() {
        return indMotCourant;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    private void get10Words() {
        //get 10 words randomly from the dictionary
        Random r = new Random();
        while (this.questions.size() > 10) {
            questions.remove(r.nextInt(questions.size()));
        }
        Collections.shuffle(questions);
    }

    public void saveScore(int score) {
        //save the score of the player in text file
        String s = joueur.getPseudo() + joueur.getPassword();
        FileWriter outputStream = null;
        try {
            outputStream = new FileWriter("./src/Outputs/" + s, true);
            outputStream.write("   " + score);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void updateBestScore(int oldScore) {
//update the best score of the player of this session in case: oldscore is grater the best score
        if (getScore() > oldScore) {
            String s1 = "" + joueur.getPseudo() + " " + joueur.getPassword() + " " + oldScore;
            String s2 = "" + joueur.getPseudo() + " " + joueur.getPassword() + " " + getScore();
            modifyFile("./src/Inputs/users.txt", s1, s2);
        }
    }


    static void modifyFile(String filePath, String oldString, String newString) {
        //replace oldstring by the newstring
        File fileToBeModified = new File(filePath);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;
        try {
            reader = new BufferedReader(new FileReader(fileToBeModified));
            //******* Reading all the lines of input text file into oldContent

            String line = reader.readLine();
            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            //****** Replacing oldString with newString in the oldContent
            String newContent = oldContent.replaceAll(oldString, newString);

            //****** Rewriting the input text file with newContent

            writer = new FileWriter(fileToBeModified);
            writer.write(newContent);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                //Closing the resources
                reader.close();
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addUser() {
        // add the player of this session "user" to the list of users
        FileWriter outputStream = null;
        try {
            outputStream = new FileWriter("./src/Inputs/users.txt", true);
            PrintWriter out = new PrintWriter(outputStream);
            out.println("" + joueur.getPseudo() + " " + joueur.getPassword() + " 0");
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
