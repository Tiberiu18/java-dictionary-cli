package Entities;
import com.google.gson.annotations.SerializedName;

import java.util.List;


public class Word {
    @SerializedName("word")
    private String wordName;

    @SerializedName("word_en")
    private String word_en;

    @SerializedName("type")
    private String type;

    @SerializedName("singular")
    private List<String> singular;

    @SerializedName("plural")
    private List<String> plural;

    @SerializedName("definitions")
    private List<Definitions> definitions;


    public Word(String wordName, String word_en, String type, List<String> singular, List<String> plural, List<Definitions> definitions) {
        this.wordName = wordName;
        this.word_en = word_en;
        this.type = type;
        this.singular = singular;
        this.plural = plural;
        this.definitions = definitions;
    }

    public Word(String wordName, String word_en)
    {
        this.wordName = wordName;
        this.word_en = word_en;
    }

    public Word(String wordName)
    {
        this.wordName = wordName;
    }

    @Override
    public String toString() {
        return "Word{" +
                "wordName='" + wordName + '\'' +
                '}';
    }

    public String getWordName() {
        return wordName;
    }

    public void setWordName(String wordName) {
        this.wordName = wordName;
    }

    public String getWord_en() {
        return word_en;
    }

    public void setWord_en(String word_en) {
        this.word_en = word_en;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<String> getSingular() {
        return singular;
    }

    public void setSingular(List<String> singular) {
        this.singular = singular;
    }

    public List<String> getPlural() {
        return plural;
    }

    public void setPlural(List<String> plural) {
        this.plural = plural;
    }

    public List<Definitions> getDefinitions() {
        return definitions;
    }

    public void setDefinitions(List<Definitions> definitions) {
        this.definitions = definitions;
    }
}
