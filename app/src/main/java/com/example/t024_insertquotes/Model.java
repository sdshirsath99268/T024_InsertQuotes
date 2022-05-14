package com.example.t024_insertquotes;

public class Model {
    String id, quote_cat , quote_cat_no , quote_no , quote;

    public Model() {
    }

    public Model(String id, String quote_cat, String quote_cat_no, String quote_no, String quote) {
        this.id = id;
        this.quote_cat = quote_cat;
        this.quote_cat_no = quote_cat_no;
        this.quote_no = quote_no;
        this.quote = quote;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuote_cat() {
        return quote_cat;
    }

    public void setQuote_cat(String quote_cat) {
        this.quote_cat = quote_cat;
    }

    public String getQuote_cat_no() {
        return quote_cat_no;
    }

    public void setQuote_cat_no(String quote_cat_no) {
        this.quote_cat_no = quote_cat_no;
    }

    public String getQuote_no() {
        return quote_no;
    }

    public void setQuote_no(String quote_no) {
        this.quote_no = quote_no;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }
}