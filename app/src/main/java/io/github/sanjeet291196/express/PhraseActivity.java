package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * @author sanjit
 *         PhraseActivity to display common phrases translations in different languages
 */
public class PhraseActivity extends AppCompatActivity {

    private static final String REFERENCE_ID = "Phrases";
    DataAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        AdView adView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice("B57E80B764791677F26544661D06015F")
                .build();
        adView.loadAd(adRequest);

        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        // adapter for linking dataItems to phraseItemListView
        adapter = new DataAdapter(this, dataItems);
        // phraseItemListView to display colors in related list
        ListView phraseItemListView = (ListView) findViewById(R.id.phrase_item_listview);
        // set the adapter for the phraseItemListView
        phraseItemListView.setAdapter(adapter);
        // notify the adapter to refresh the list
        adapter.notifyDataSetChanged();

        DatabaseReference reference = MainMenu.database.getReference(REFERENCE_ID);

        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                DataItem newDataItem = dataSnapshot.getValue(DataItem.class);

                if (newDataItem != null) {
                    dataItems.add(newDataItem);
                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    /*    DataItem[] dataItem = new DataItem[]{
                (new DataItem("Where are you Going?", "Tum kahaan ja rahe ho?(तुम कहाँ जा रहे हो?)", "Nuvvu ekkaḍiki veḷutunnāvu?")),
                (new DataItem("What is your name?", "Aapka naam kya hai?(आपका नाम क्या है?)", "Nī pēru ēmiṭi?")),
                (new DataItem("My Name is ...", "Mera naam ... hai(मेरा नाम ... है।)", "Nā pēru...")),
                (new DataItem("How are you?", "Aap kese ho?(आप कैसे हो?)", "Mīru elā unnāru?")),
                (new DataItem("I'm good.", "Main achchha hoon.(मैं अच्छा हूँ।)", "Nēnu man̄ci reḍī.")),
                (new DataItem("I'm fine.", "Mai theek hoon.(मै ठीक हूँ।)", "Nēnu bāgunnānu.")),
                (new DataItem("Are you comming?", "Kya tum aa rahe ho?(क्या तुम आ रहे हो?)", "Mīru vastunnārā?")),
                (new DataItem("Yes, I'm comming.", "Haan, aa raha hoon.(हाँ, आ रहा हूं।)", "Avunu, nēnu vastunnānu,.")),
                (new DataItem("I'm comming.", "Main aa raha hoon.(मैं आ रहा हूँ।)", "Nēnu vastunnānu.")),
                (new DataItem("Lets go.", "Chalie chalate hain.(चलिए चलते हैं।)", "Yokka veḷḷi telapaṇḍi.")),
                (new DataItem("Come here.", "Yahaan aao.(यहाँ आओ।)", "Ikkaḍa vastāyi."))
        };

        for (DataItem d : dataItem) {
            String id = d.getEnglishTranslation();
            reference.child(id.replaceAll("[.]", "")).setValue(d);
        }
*/
    }

    @Override
    protected void onDestroy() {
        adapter.shutdownt();
        super.onDestroy();
    }
}
