package TEXT;

import java.io.Serializable;
import java.util.Objects;


public class Word implements Serializable {
    private String word;


    public Word() { this.word=" "; }
    public Word(String word) {
        this.word = word;
    }

    public String getWord() {
        return this.word;
    }
    public void setWord (String word)
    {
        this.word = word;
    }

    public Word[] objectArray(int n) {
        Word[] Array = new Word[n];
        for (int i = 0; i < n; i++) {
            Array[i] = new Word();
        }
        return Array;
    }

    @Override
    public String toString() { return "Слово: " + getWord(); }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Word word1 = (Word) object;
        return  this.word.equals(word1.word);
    }

    @Override
    public int hashCode() {
        return Objects.hash(word);
    }
}
