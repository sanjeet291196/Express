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
    private boolean plus10;

    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation, boolean plus10) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        this.plus10 = plus10;
    }

    public DataItem(int imageResourceId, String englishTranslation, String hindiTranslation, String localTranslation) {
        ImageResourceId = imageResourceId;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        plus10 = false;
    }

    public DataItem(String englishTranslation, String hindiTranslation, String localTranslation) {
        ImageResourceId = R.mipmap.ic_launcher;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
        plus10 = false;
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
        return plus10;
    }
}
