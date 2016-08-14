package io.github.sanjeet291196.express;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrase);

        ArrayList<DataItem> dataItems = new ArrayList<>();
        dataItems.add(new DataItem("Where are you Going?", "Tum kahaan ja rahe ho?(तुम कहाँ जा रहे हो?)", "Nuvvu ekkaḍiki veḷutunnāvu?"));
        dataItems.add(new DataItem("What is your name?", "Aapaka naam kya hai?(आपका नाम क्या है?)", "Nī pēru ēmiṭi?"));
        dataItems.add(new DataItem("My Name is ...", "Mera naam ... hai(मेरा नाम ... है।)", "Nā pēru..."));
        dataItems.add(new DataItem("How are you?", "Aap kese ho?(आप कैसे हो?)", "Mīru elā unnāru?"));
        dataItems.add(new DataItem("I'm good.", "Main achchha hoon.(मैं अच्छा हूँ।)", "Nēnu man̄ci reḍī."));
        dataItems.add(new DataItem("I'm fine.", "Mai theek hoon.(मै ठीक हूँ।)", "Nēnu bāgunnānu."));
        dataItems.add(new DataItem("Are you comming?", "Kya tum aa rahe ho?(क्या तुम आ रहे हो?)", "Mīru vastunnārā?"));
        dataItems.add(new DataItem("Yes, I'm comming.", "Haan, aa raha hoon.(हाँ, आ रहा हूं।)", "Avunu, nēnu vastunnānu."));
        dataItems.add(new DataItem("I'm comming.", "Main aa raha hoon.(मैं आ रहा हूँ।)", "Nēnu vastunnānu."));
        dataItems.add(new DataItem("Lets go.", "Chalie chalate hain.(चलिए चलते हैं।)", "Yokka veḷḷi telapaṇḍi."));
        dataItems.add(new DataItem("Come here.", "Yahaan aao.(यहाँ आओ।)", "Ikkaḍa vastāyi."));

        DataAdapter adapter = new DataAdapter(this, dataItems);
        ListView phraseItemListView = (ListView) findViewById(R.id.phrase_item_listview);
        phraseItemListView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
