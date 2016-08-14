package io.github.sanjeet291196.express;

/**
 * Created by sanjit on 14/8/16.
 * Project: Express
 */
public class DataItem {
    private int image;
    private String EnglishTranslation;
    private String HindiTranslation;
    private String LocalTranslation;

    public DataItem(int image, String englishTranslation, String hindiTranslation, String localTranslation) {
        this.image = image;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
    }

    public DataItem(String englishTranslation, String hindiTranslation, String localTranslation) {
        image = R.mipmap.ic_launcher;
        EnglishTranslation = englishTranslation;
        HindiTranslation = hindiTranslation;
        LocalTranslation = localTranslation;
    }

    public int getImage() {
        return image;
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

}
