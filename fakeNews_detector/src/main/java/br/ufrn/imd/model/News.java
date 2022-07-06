package br.ufrn.imd.model;
import java.time.ZonedDateTime;


public class News {

    private int id;
    private String link;
    private String textOriginal;
    private String text_format;
    private ZonedDateTime timestamp;
    private TypeNews typeNews; // fake news or true news


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getText_original() {
        return textOriginal;
    }

    public void setText_original(String text_original) {
        this.textOriginal = text_original;
    }

    public String getText_format() {
        return text_format;
    }

    public void setText_format(String text_format) {
        this.text_format = text_format;
    }

    public ZonedDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(ZonedDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public TypeNews getTypeNews() {
        return typeNews;
    }

    public void setTypeNews(TypeNews typeNews) {
        this.typeNews = typeNews;
    }

}
