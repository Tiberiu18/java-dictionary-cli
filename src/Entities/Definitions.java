package Entities;

import java.util.Arrays;

public final class Definitions {
    private Definitions(){}

    private String dict;

    private String dictType;

    private Integer year;

    private String[] text;

    public Definitions(String dict, String dictType, Integer year, String[] text)
    {
        this.dict = dict;
        this.dictType = dictType;
        this.year = year;
        this.text = Arrays.copyOf(text, text.length);
    }


    @Override
    public String toString() {
        return "Definitions{" +
                "dict='" + dict + '\'' +
                ", dictType='" + dictType + '\'' +
                ", year=" + year +
                ", text=" + Arrays.toString(text) +
                '}';
    }


    public String getDict() {
        return dict;
    }

    public void setDict(String dict) {
        this.dict = dict;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }
}
