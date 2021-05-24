package TEXT;

import java.io.Serializable;
import java.util.Objects;

public class Text extends Sentence implements Serializable {
    String title; //заголовок текста
    private int numberSentences; // кол-во предложений в тексте
    Sentence text[] = new Sentence[numberSentences];

    public Text() {
        this.title="";
    }

    public Text(String title, Sentence[] text) {
        this.title = title;
        this.numberSentences=text.length;
        this.text=new Sentence[numberSentences];
        for (int i = 0; i < text.length; i++) {
            this.text[i]= new Sentence();
            this.text[i] = text[i];
        }
    }
    public Text(Sentence title, Sentence[] text) {
        this.title = title.getSentenceString();
        this.numberSentences=text.length;
        this.text=new Sentence[numberSentences];
        for (int i = 0; i < text.length; i++) {
            this.text[i]= new Sentence();
            this.text[i] = text[i];
        }
    }
    public Text(String title, String text) {
        this.title = title;
        String sentences[] = text.split("\\.", 0); //разделяем текст на предложения, помещаем в массив String
        this.numberSentences=sentences.length;
        this.text=new Sentence[numberSentences];
        for (int i = 0; i < sentences.length; i++) {
            this.text[i]= new Sentence(sentences[i]);
        }
    }

    public Sentence[] getTextSentence() {
        return this.text;
    }
    public String getTextString() {
        String result = "";
        for (int i = 0; i < this.numberSentences; i++) {
            result += this.text[i].getSentenceString();
            result += " ";
        }
        return result;
    }
    public String getTitleString(){
        return this.title;
    }
    public Sentence getTitleSentence(){
        String[] words = title.split(". ");
        Sentence result= new Sentence(words.length, words);
        return result;
    }

    public void setText(Sentence[] text) {
        for (int i = 0; i < text.length; i++) {
            this.text[i] = text[i];
        }
    }
    public void setText(String text) {
        String sentences[] = text.split(". "); //разделяем текст на предложения, помещаем в массив String
        this.numberSentences=sentences.length;
        for (int i = 0; i < sentences.length; i++) {
            this.text[i].setSentence(sentences[i]);
        }
    }
    public void setTitle(String title){
        this.title=title;
    }
    public void setTitle(Sentence title){
        this.title=title.getSentenceString();
    }

    public void addText(String text) {
        String sentences[] = text.split("\\.", 0); //разделяем текст на предложения, помещаем в массив String

        Sentence text1[] =new Sentence[this.numberSentences+sentences.length];
        for (int i = 0; i < this.numberSentences; i++) {
            text1[i]=this.text[i];
        }
        for (int i = this.numberSentences, j=0; i < this.numberSentences+sentences.length; i++, j++) {
            if (j < sentences.length) {
                text1[i] = new Sentence(sentences[j]);
            }
        }
        this.numberSentences+=sentences.length;
        this.text =new Sentence[numberSentences];
        this.text=text1;
    }

    public Text[] objectArray(int n) {
        Text[] Array = new Text[n];
        for (int i = 0; i < n; i++) {
            Array[i] = new Text();
        }
        return Array;
    }

    @Override
    public String toString() {
        return getTitleString()+ "\n" + getTextString();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Text text1 = (Text) object;
        return this.text.equals(text1.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text);
    }
}
