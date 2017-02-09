package com.example.android.miwok;

/**
 * Created by csaenz on 2/9/2017.
 */

//Word class to provide Miwok word and its translation into a single object
public class Word {

    private String mMiwokTranslation;

    private String mDefaultTranslation;

    /**
     *
     * Takes two strings
     * @param miwokWord     Miwok word to learn
     * @param defaultWord   default word that translate the Miwork word
     */
    public Word(String miwokWord, String defaultWord){
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
    }

    /**
     *
     * @return Miwok word created
     */
    public String getMiwok(){
        return mMiwokTranslation;
    }

    /**
     * @return default word created for translation
     */
    public String getDefault(){
        return mDefaultTranslation;
    }
}
