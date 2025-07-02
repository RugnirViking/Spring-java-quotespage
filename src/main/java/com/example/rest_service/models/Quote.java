package com.example.rest_service.models;

import java.util.Objects;

public class Quote {
    private Long _id;
    public void setId(Long i) { _id = i; }
    public Long getId() { return _id; }

    private Author _author;
    public void setAuthor(Author value) { _author = value; }
    public Author getAuthor() { return _author; }

    private String _quotetext;
    public void setQuoteText(String value) { _quotetext = value; }
    public String getQuoteText() { return _quotetext; }

    public Quote(){

    }

    public Quote(long id, Author author, String quotetext) {
        setId(id);
        setAuthor(author);
        setQuoteText(quotetext);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Quote)) return false;
        Quote comparedAuthor = (Quote) o;
        return Objects.equals(_id, comparedAuthor.getId())
                && Objects.equals(_author, comparedAuthor.getAuthor())
                && Objects.equals(_quotetext, comparedAuthor.getQuoteText());
    }

}
