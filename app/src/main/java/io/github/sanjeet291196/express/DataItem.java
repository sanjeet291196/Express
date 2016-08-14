package io.github.sanjeet291196.express;

/**
 * Created by sanjit on 14/8/16.
 * Project: Express
 */
public class DataItem {
    private int ImageResourceId;
    private String EnglishTranslation;
    private String HindiTranslation;
    private String LocalTranslation;
    private boolean Plus10;
    private boolean Phrase;

    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation, boolean plus10) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        this.Plus10 = plus10;
    }

    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        Plus10 = false;
    }

    public DataItem(String englishTranslation, String hindiTranslation, String localTranslation) {
        ImageResourceId = 0;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        Plus10 = false;
        Phrase = true;
    }

    public int getImageResourceId() {
        return ImageResourceId;
    }

    public String getEnglishTranslation() {
        return EnglishTranslation;
    }

    public String getHindiTranslation() {
        return HindiTranslation;
    }

    public String getLocalTranslation() {
        return LocalTranslation;
    }

    public boolean isPlus10() {
        return Plus10;
    }

    public boolean isPhrase() {
        return Phrase;
    }
}
