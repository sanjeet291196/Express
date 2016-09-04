package io.github.sanjeet291196.express;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhraseFragment extends Fragment {

    private static final String REFERENCE_ID = "Phrases";
    private DataAdapter adapter;

    public PhraseFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.word_list, container, false);


        // array list to store data items
        final ArrayList<DataItem> dataItems = new ArrayList<>();

        // adapter for linking dataItems to phraseItemListView
        adapter = new DataAdapter(getActivity(), dataItems);
        // phraseItemListView to display colors in related list
        ListView phraseItemListView = (ListView) rootView.findViewById(R.id.item_listview);
        phraseItemListView.setBackgroundColor(getResources().getColor(R.color.colorPhrase));
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

        return rootView;
    }

    @Override
    public void onDestroyView() {
        adapter.shutdownt();
        super.onDestroyView();
    }
}
