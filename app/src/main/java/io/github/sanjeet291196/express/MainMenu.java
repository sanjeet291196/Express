package io.github.sanjeet291196.express;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.firebase.database.FirebaseDatabase;

/**
 * @author sanjit
 *         MainMenu to display main menu as soon as the app launches
 */
public class MainMenu extends AppCompatActivity {


    public static final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static final int NUM_PAGES = 4;

    private ViewPager pager;
    private PagerAdapter adapter;

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

        //   database.setPersistenceEnabled(true);

        pager = (ViewPager) findViewById(R.id.pager);
        adapter = new CategoryAdapter(getSupportFragmentManager());
        pager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(pager);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("About");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getTitle().equals("About")) {
            startActivity(new Intent(this, AboutActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }

    public void closeAd(View view) {
        RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);
        adViewContainer.setVisibility(View.GONE);
    }

    private class CategoryAdapter extends FragmentStatePagerAdapter {
        public CategoryAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position == 0)
                return new NumberFragment();
            else if (position == 1)
                return new FamilyMembersFragment();
            else if (position == 2)
                return new ColorsFragment();
            else if (position == 3)
                return new PhraseFragment();
            return null;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0)
                return "Numbers";
            else if (position == 1)
                return "Family Members";
            else if (position == 2)
                return "Colors";
            else if (position == 3)
                return "Phrases";
            return super.getPageTitle(position);
        }

        @Override
        public int getCount() {
            return NUM_PAGES;
        }
    }

}

