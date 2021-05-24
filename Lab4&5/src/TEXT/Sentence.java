package TEXT;

import java.io.Serializable;
import java.util.Objects;

public class Sentence implements Serializable {
    private int numberWords; // кол-во слов в предложении
    String sentence[]=new String[numberWords]; //массив слов

    public Sentence() {
       //this.numberWords=1;
        //this.sentence[0] = new String();
    }
    public Sentence(int numberWords, Word sentence[]) {
        this.numberWords=numberWords;
        this.sentence=new String[this.numberWords];
        for (int i=0; i< numberWords; i++){
            //this.sentence[i]=new Word();
            this.sentence[i]=sentence[i].toString();
        }
    }
    public Sentence(int numberWords, String[] sentence) {
        this.numberWords=numberWords;
        this.sentence=new String[this.numberWords];
        for (int i=0; i< numberWords; i++){
            //this.sentence[i]=new Word();
            this.sentence[i]=sentence[i];
        }
    }
    public Sentence(String sentence) {
        String sentences[] = sentence.split(" ");
        this.numberWords = sentences.length;
        this.sentence=new String[this.numberWords];
        this.sentence=sentences;
    }

    public int getNumberWords() {
        return this.numberWords;
    }
    /*public Word[] getSentenceWord() {
        return this.sentence;
    }*/
    public String getSentenceString() {
        String result="";
        for (int i=0; i< this.numberWords; i++){
            //result += this.sentence[i].getWord();
            result += this.sentence[i];
            result += " ";
        }
        return result;
    }
    public void setSentence (int numberWords, Word sentence[]) {
        this.numberWords=numberWords;
        this.sentence=new String[this.numberWords];
        for (int i=0; i< numberWords; i++){
            //this.sentence[i]=new Word();
            this.sentence[i]=sentence[i].getWord();
        }
    }
    public void setSentence (String sentence) {
        String sentences[] = sentence.split(" ");
        this.numberWords=sentences.length;
        this.sentence=new String[this.numberWords];
        for (int i=0; i< sentence.length(); i++){
            //this.sentence[i]=new Word();
            this.sentence[i]=sentences[i];
        }
    }

    public Sentence[] objectArray(int n) {
        Sentence[] Array = new Sentence[n];
        for (int i = 0; i < n; i++) {
            Array[i] = new Sentence();
        }
        return Array;
    }

    /*public void Show (Sentence[] sentence, int numberSentence){
        for (int i=0; i<numberSentence; i++)
        System.out.print(sentence[i].getSentenceString() +".\n");
    }*/

    @Override
    public String toString() { return "Предложение: " + getSentenceString(); }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Sentence s1 = (Sentence) object;
        return  this.sentence.equals(s1.sentence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sentence);
    }
}
