package io.github.sanjeet291196.express;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

/**
 * Created by sanjit on 14/8/16.
 * Project: Express
 */
public class DataAdapter extends ArrayAdapter<DataItem> {

    final TextToSpeech t1 = new TextToSpeech(getContext(), new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int status) {
        }
    });

    public DataAdapter(Context context, List<DataItem> objects) {
        super(context, 0, objects);
    }

    /**
     * @param position    represents current object position in the object list
     * @param convertView view that is to be used for placing in list view
     * @param parent      parent view group
     * @return view to be displayed in list view
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View dataView = convertView;

        // if provided view is not initialised
        if (dataView == null) {
            //  make a required view for it
            dataView = LayoutInflater.from(getContext()).inflate(R.layout.item_list, parent, false);
        }

        // get the current data item object
        final DataItem currentDataItem = getItem(position);

        // link to icon on left side of each list item
        ImageView icon = (ImageView) dataView.findViewById(R.id.ItemIcon);
        // link to icon on right side of each list item
        ImageView icon2 = (ImageView) dataView.findViewById(R.id.ItemIcon2);

        // if current data is a phrase
        if (currentDataItem.isPhrase()) {
            // hide the icon on left
            icon.setVisibility(View.GONE);
            //hide the icon on right
            icon2.setVisibility(View.GONE);
        } else {    // otherwise
            // set the icon on left to be visible, if it was hidden by some other call
            icon.setVisibility(View.VISIBLE);
            // if data is a number greater than 10 then
            if (currentDataItem.isPlus10()) {
                // set left side icon as image representing 10
                icon.setImageResource(R.drawable.number_ten);
                // set right side icon as image resource stored in currentDataItem
                icon2.setImageResource(currentDataItem.getImageResourceId());
                // set the icon on right to be visible
                icon2.setVisibility(View.VISIBLE);
            } else { // otherwise
                // set icon on left as image stored in currentDataItem
                icon.setImageResource(currentDataItem.getImageResourceId());
                // hide the icon on right
                icon2.setVisibility(View.GONE);
            }
        }

        // link to english translation text view
        TextView englishTranslation = (TextView) dataView.findViewById(R.id.ItemEnglishTranslation);
        // set the english translation text view to show english translation
        englishTranslation.setText(currentDataItem.getEnglishTranslation());

        // link to hindi translation text view
        TextView hindiTranslation = (TextView) dataView.findViewById(R.id.ItemHindiTranslation);
        // set the hindi translation text view to show hindi translation
        hindiTranslation.setText(currentDataItem.getHindiTranslation());

        // link to local language translation text view
        TextView localTranslation = (TextView) dataView.findViewById(R.id.ItemLocalTranslation);
        // set the local language translation text view to show local language translation
        localTranslation.setText(currentDataItem.getLocalTranslation());


        t1.setLanguage(Locale.US);

        dataView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toSpeak = currentDataItem.getHindiTranslation();
                t1.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

        //return the view
        return dataView;
    }
}
