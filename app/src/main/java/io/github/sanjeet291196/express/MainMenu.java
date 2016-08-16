package io.github.sanjeet291196.express;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

/**
 * @author sanjit
 *         MainMenu to display main menu as soon as the app launches
 */
public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        MobileAds.initialize(getApplicationContext(), getResources().getString(R.string.ad_app_id));

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);

    }


    /**
     * Starts NumberActivity
     *
     * @param view which calls this function by onClickk event
     */
    public void showNumberActivity(View view) {
        startActivity(new Intent(this, NumbersActivity.class));
    }

    /**
     * Starts FamilyMemberActivity
     * @param view which calls this function by onClickk event
     */
    public void showFamilyActivity(View view) {
        startActivity(new Intent(this, FamilyMemberActivity.class));
    }

    /**
     * Starts ColorsActivity
     * @param view which calls this function by onClickk event
     */
    public void showColorsActivity(View view) {
        startActivity(new Intent(this, ColorsActivity.class));
    }

    /**
     * Starts PhraseActivity
     * @param view which calls this function by onClickk event
     */
    public void showPhraseActivity(View view) {
        startActivity(new Intent(this, PhraseActivity.class));
    }
}
