package com.example.android.miwok;

/**
 * Created by csaenz on 2/9/2017.
 */

//Word class to provide Miwok word and its translation into a single object
public class Word {

    private static final int NO_IMAGE = -1;

    private String mMiwokTranslation;

    private String mDefaultTranslation;

    private int mSoundRecourceID;

    private int mImageResourceID = NO_IMAGE;

    /**
     * Takes two strings
     *
     * @param miwokWord   Miwok word to learn
     * @param defaultWord default word that translate the Miwork word
     */
    public Word(String miwokWord, String defaultWord, int sound) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mSoundRecourceID = sound;
    }

    /**
     * Second constructor that takes three arguments for images
     *
     * @param miwokWord   Miwok word to learn
     * @param defaultWord default word that translate the Miwork word
     * @param drawable    Picture of MiWok word for visual reference
     */
    public Word(String miwokWord, String defaultWord, int drawable, int sound) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslation = defaultWord;
        mImageResourceID = drawable;
        mSoundRecourceID = sound;
    }

    /**
     * @return Miwok word created
     */
    public String getMiwok() {
        return mMiwokTranslation;
    }

    /**
     * @return default word created for translation
     */
    public String getDefault() {
        return mDefaultTranslation;
    }

    /**
     * @return Returns drawable location
     */
    public int getImage() {
        return mImageResourceID;
    }

    /**
     *
     * @return true if image has been referenced drawable
     */
    public boolean hasImage() {
        return mImageResourceID != NO_IMAGE;
    }

    /**
     *
     * @return sound reference
     */
    public int getSound(){ return mSoundRecourceID;}
}

