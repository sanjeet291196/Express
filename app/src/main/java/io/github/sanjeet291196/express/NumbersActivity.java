package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem(R.drawable.number_one, "One", "Ek(एक)", "Oka"));
        dataItems.add(new DataItem(R.drawable.number_two, "Two", "Do(दो)", "reṇḍu"));
        dataItems.add(new DataItem(R.drawable.number_three, "Three", "Teen(तीन)", "mūḍu"));
        dataItems.add(new DataItem(R.drawable.number_four, "Four", "Chaar(चार)", "nālugu"));
        dataItems.add(new DataItem(R.drawable.number_five, "Five", "Paanch(पांच)", "aidu"));
        dataItems.add(new DataItem(R.drawable.number_six, "Six", "Cheh(छह)", "āru"));
        dataItems.add(new DataItem(R.drawable.number_seven, "Seven", "Saat(सात)", "ēḍu"));
        dataItems.add(new DataItem(R.drawable.number_eight, "Eight", "Aath(आठ)", "enimidi"));
        dataItems.add(new DataItem(R.drawable.number_nine, "Nine", "Nau(नौ)", "tom'midi"));
        dataItems.add(new DataItem(R.drawable.number_ten, "Ten", "Das(दस)", "padi"));

        dataItems.add(new DataItem(R.drawable.number_one, "Eleven", "Gyaarah(ग्यारह)", "Padakoṇḍu", true));
        dataItems.add(new DataItem(R.drawable.number_two, "Twelve", "Baarah(बारह)", "panneṇḍu", true));
        dataItems.add(new DataItem(R.drawable.number_three, "Thirteen", "Terah(तेरह)", "padamūḍu", true));
        dataItems.add(new DataItem(R.drawable.number_four, "Fourteen", "Chaudah(चौदह)", "padnālugu", true));
        dataItems.add(new DataItem(R.drawable.number_five, "Fifteen", "Pandrah(पंद्रह)", "padihēnu", true));
        dataItems.add(new DataItem(R.drawable.number_six, "Sixteen", "Solah(सोलह)", "padahāru", true));
        dataItems.add(new DataItem(R.drawable.number_seven, "Seventeen", "Satrah(सत्रह)", "padihēḍu", true));
        dataItems.add(new DataItem(R.drawable.number_eight, "Eighteen", "Athaarah(अठारह)", "paddenimidi", true));
        dataItems.add(new DataItem(R.drawable.number_nine, "Nineteen", "Unnees(उन्नीस)", "nainṭīn", true));
        dataItems.add(new DataItem(R.drawable.number_ten, "Twenty", "Bees(बीस)", "iravai", true));

        DataAdapter adapter = new DataAdapter(this, dataItems);
        ListView numberItemListView = (ListView) findViewById(R.id.NumberItemListView);
        numberItemListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
