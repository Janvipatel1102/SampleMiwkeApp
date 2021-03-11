package com.example.justjava;

import android.net.Uri;

public class word {
    String defaultWord,miwokWord;
    int imageId;



    public word(String defaultWord, String miwokWord) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
    }

    public word(String defaultWord, String miwokWord, int uri) {
        this.defaultWord = defaultWord;
        this.miwokWord = miwokWord;
        this.imageId = uri;
    }

    public int getUri() {
        return imageId;
    }

    public void setUri(int uri) {
        this.imageId = uri;
    }

    public String getDefaultWord() {
        return defaultWord;
    }

    public String getMiwokWord() {
        return miwokWord;
    }
}
