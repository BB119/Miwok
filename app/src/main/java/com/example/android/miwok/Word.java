package com.example.android.miwok;

/**
 * Represents a vocabulary word that the user wants to learn
 */
public class Word {
    /** Miwok translation of the word*/
    private String mMiwokTranslation;
    /** Default translation of the word */
    private String mDefaultTranslationWord;
    /** Image resource ID */
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    /** Audio resource ID */
    private int mAudioResourceId;

    /** No image view constant */
    private static final int NO_IMAGE_PROVIDED = -1;

    /** Creating a Word instance */
    public Word(String miwokWord, String defaultTranslation, int audioId) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslationWord = defaultTranslation;
        mAudioResourceId = audioId;
    }

    /** Creating a Word instance with an image*/
    public Word(String miwokWord, String defaultTranslation, int imageId, int audioId) {
        mMiwokTranslation = miwokWord;
        mDefaultTranslationWord = defaultTranslation;
        mImageResourceId = imageId;
        mAudioResourceId = audioId;
    }

    /**
     * @return the default translation of the word
     */
    public String getmDefaultTranslationWord() {
        return mDefaultTranslationWord;
    }

    /**
     *
     * @return the Miwok translation of the word
     */
    public String getmMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     *
     * @return the image resource ID of the word
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     *
     * @return the audio resource ID of the word
     */
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }

    /**
     *
     * @return a boolean indicating whether the word has an ImageView or not
     */
    public boolean hasImage() {
        return mImageResourceId != -1;
    }
}
