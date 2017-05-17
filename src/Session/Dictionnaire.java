package Session;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import Enum.TypeIndication;

/**
 * @author Mahamdi
 */
public class Dictionnaire {
    private String path;

    public Dictionnaire(String path) {
        this.path = path;
        chargerDictionnaire();
    }

    private List<Question> questions = new ArrayList<Question>();


    public boolean dictionnaireValid() {
        //check if the dictionary is valid 'if all words contains at least 6 characters '
        BufferedReader in = null;
        int minLenght = 99;
        String ligne;
        try {
            in = new BufferedReader(new FileReader(path));
            while ((ligne = in.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(ligne, ";");
                String mot = null;
                for (int i = 0; i < 3; i++) {
                    mot = tok.nextToken();
                    if (i == 2) {
                        if (mot.length() < minLenght) {
                            minLenght = mot.length();
                        }
                    }
                }
            }

        } catch (Exception e) {
        }
        if (minLenght < 6) return false;
        else return true;
    }

    public void chargerDictionnaire() {
        BufferedReader in = null;
        String ligne, mot, info, type;
        try {
            in = new BufferedReader(new FileReader(path));
            while ((ligne = in.readLine()) != null) {

                StringTokenizer tok = new StringTokenizer(ligne, ";");
                mot = "";
                info = "";
                type = "";
                for (int i = 0; i < 3; i++) {
                    if (i == 0) type = tok.nextToken();
                    if (i == 1) info = tok.nextToken();
                    if (i == 2) mot = tok.nextToken();
                }
                if (type.equals("ANTONYME")) {
                    questions.add(new Question(mot, new Indication(TypeIndication.ANTONYME, info)));
                }
                if (type.equals("DEFINITION")) {
                    questions.add(new Question(mot, new Indication(TypeIndication.DEFINITION, info)));
                }
                if (type.equals("SYNONYME")) {
                    questions.add(new Question(mot, new Indication(TypeIndication.SYNONYME, info)));
                }
            }
            if (in != null) in.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Question> getQuestions() {
        //return the questions
        return questions;
    }

    public static int maxLengthMot(String path) {
        //return the max length of words
        BufferedReader in = null;
        String ligne;
        int length = 0;
        try {
            in = new BufferedReader(new FileReader(path));
            while ((ligne = in.readLine()) != null) {
                StringTokenizer tok = new StringTokenizer(ligne, ";");

                for (int i = 0; i < 3; i++) {
                    String str = tok.nextToken();
                    if (i == 2 & length < str.length()) length = str.length();
                }
            }
        } catch (Exception e) {

        }
        return length;
    }


}