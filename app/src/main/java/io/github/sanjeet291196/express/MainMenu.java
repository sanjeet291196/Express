package io.github.sanjeet291196.express;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

    }

    public void showNumberActivity(View view) {
        startActivity(new Intent(this, NumbersActivity.class));
    }

    public void showFamilyActivity(View view) {
        startActivity(new Intent(this, FamilyMemberActivity.class));
    }

    public void showColorsActivity(View view) {
        startActivity(new Intent(this, ColorsActivity.class));
    }

    public void showPhraseActivity(View view) {
        startActivity(new Intent(this, PhraseActivity.class));
    }
}
