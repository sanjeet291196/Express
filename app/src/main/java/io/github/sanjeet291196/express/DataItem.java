package io.github.sanjeet291196.express;

/**
 * Created by sanjit on 14/8/16.
 * Project: Express
 */
public class DataItem {
    /**
     * ImageResourceId to store image resource id
     */
    private int ImageResourceId;
    /**
     * EnglishTranslation to store english equivalent of current data
     */
    private String EnglishTranslation;
    /**
     * HindiTranslation to store hindi equivalent of current data
     */
    private String HindiTranslation;
    /**
     * LocalTranslation to store local language equivalent of current data
     */
    private String LocalTranslation;
    /**
     * Plus10 to represent that number representing data has value more than 10
     */
    private boolean Plus10;
    /**
     * Phrase to represent that object stores phrase
     */
    private boolean Phrase;

    public DataItem() {
    }

    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation, boolean plus10, boolean phrase) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        Plus10 = plus10;
        Phrase = phrase;
    }

    /**
     * @param imageResourceId    asigned to ImageResourceId
     * @param englishTranslation asigned to EnglishTranslation
     * @param hindiTranslation   asigned to HindiTranslation
     * @param localTranslation   asigned to LocalTranslation
     * @param plus10             asigned to Plus10
     */
    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation, boolean plus10) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;

        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        this.Plus10 = plus10;
    }

    /**
     * @param imageResourceId       asigned to ImageResourceId
     * @param englishTranslation    asigned to EnglishTranslation
     * @param hindiTranslation      asigned to HindiTranslation
     * @param localTranslation      asigned to LocalTranslation
     */
    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        Plus10 = false;
    }

    /**
     * @param englishTranslation    asigned to EnglishTranslation
     * @param hindiTranslation      asigned to HindiTranslation
     * @param localTranslation      asigned to LocalTranslation
     */
    public DataItem(String englishTranslation, String hindiTranslation, String localTranslation) {
        ImageResourceId = 0;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        Plus10 = false;
        Phrase = true;
    }

    /**
     * @return resource id of image related to current object
     */
    public int getImageResourceId() {
        return ImageResourceId;
    }

    public void setImageResourceId(int imageResourceId) {
        ImageResourceId = imageResourceId;
    }

    /**
     * @return english equivalent of object data
     */
    public String getEnglishTranslation() {
        return EnglishTranslation;
    }

    public void setEnglishTranslation(String englishTranslation) {
        EnglishTranslation = englishTranslation;
    }

    /**
     * @return hindi equivalent of object data
     */
    public String getHindiTranslation() {
        return HindiTranslation;
    }

    public void setHindiTranslation(String hindiTranslation) {
        HindiTranslation = hindiTranslation;
    }

    /**
     * @return local language equivalent of object data
     */
    public String getLocalTranslation() {
        return LocalTranslation;
    }

    public void setLocalTranslation(String localTranslation) {
        LocalTranslation = localTranslation;
    }

    /**
     * @return whether number value is more than 10 or not
     */
    public boolean isPlus10() {
        return Plus10;
    }

    public void setPlus10(boolean plus10) {
        Plus10 = plus10;
    }

    /**
     * @return whether data stored is phrase or not
     */
    public boolean isPhrase() {
        return Phrase;
    }

    public void setPhrase(boolean phrase) {
        Phrase = phrase;
    }
}
