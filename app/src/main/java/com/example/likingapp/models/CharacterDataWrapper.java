package com.example.likingapp.models;

import android.provider.ContactsContract;

public class CharacterDataWrapper {
    private String attributionHTML;
    private String attributionText;
    private int code;
    private String copyright;
    private Data data;
    private String etag;
    private String status;

    public CharacterDataWrapper(String attributionHTML, String attributionText, int code, String copyright, Data data, String etag, String status) {
        this.attributionHTML = attributionHTML;
        this.attributionText = attributionText;
        this.code = code;
        this.copyright = copyright;
        this.data = data;
        this.etag = etag;
        this.status = status;
    }

    public String getAttributionHTML() {
        return attributionHTML;
    }

    public void setAttributionHTML(String attributionHTML) {
        this.attributionHTML = attributionHTML;
    }

    public String getAttributionText() {
        return attributionText;
    }

    public void setAttributionText(String attributionText) {
        this.attributionText = attributionText;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getEtag() {
        return etag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
