package com.example.android.computersciencenews;


import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NewsAdapter extends ArrayAdapter<News> {

    // Constructs a new NewsAdapter passing the context of the app and the list of news
    public NewsAdapter(Activity context, ArrayList<News> news) {
        super(context, 0, news);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if there is an existing list item view (called convertView) that we can reuse,
        // otherwise, if convertView is null, then inflate a new list item layout.
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        // Find the news at the given position in the list
        News currentNews = getItem(position);

        // Find the TextView with view ID title and set the title of the news
        TextView titleView = (TextView) listItemView.findViewById(R.id.title);
        titleView.setText(currentNews.getTitle());

        // Find the TextView with view ID date
        TextView publicationDateView = (TextView) listItemView.findViewById(R.id.date);
        // Extract the publication date by splitting it from the time of publishing
        // (I decided not to display the time of publishing)
        String dateString = currentNews.getPublicationDate().split("T")[0];
        // Set the publication date
        publicationDateView.setText(dateString);

        // Find the TextView with view ID section
        TextView sectionView = (TextView) listItemView.findViewById(R.id.section);

        // Get the section's name
        String sectionName = currentNews.getSectionName();
        // Get the color corresponding to the section
        int sectionColor = getSectionColor(sectionName);

        // Set the section's name
        sectionView.setText(sectionName);
        // Set its color
        sectionView.setTextColor(sectionColor);

        // Find the ImageView with view ID section_image
        ImageView sectionImage = (ImageView) listItemView.findViewById(R.id.section_image);
        // Get the image corresponding to the section and set it to the image view
        sectionImage.setImageResource(getSectionImage(sectionName));

        // Find the TextView with view ID author
        TextView authorView = (TextView) listItemView.findViewById(R.id.author);

        // Check if the current news has an author
        if (currentNews.getAuthor() != null) {
            // If yes, set the author name of the article
            authorView.setText(currentNews.getAuthor());
        }
        else {
            // If not, hide the TextView
            authorView.setText("");
        }

        // Return the ListView created
        return listItemView;
    }

    // A method which returns the color ID corresponding to the news' section using a switch statement
    private int getSectionColor(String section) {
        int sectionColorResourceID;
        switch (section) {
            case "Cyber Aware":
                sectionColorResourceID = R.color.cyber_aware_section;
                break;
            case "Politics":
                sectionColorResourceID = R.color.politics_section;
                break;
            case "Technology":
                sectionColorResourceID = R.color.technology_section;
                break;
            case "US news":
                sectionColorResourceID = R.color.us_news_section;
                break;
            case "Opinion":
                sectionColorResourceID = R.color.opinion_section;
                break;
            default:
                sectionColorResourceID = R.color.black;
                break;
        }
        return ContextCompat.getColor(getContext(), sectionColorResourceID);
    }

    // A method which returns the image ID corresponding to the news' section using a switch statement
    private int getSectionImage(String section) {
        int sectionImageResourceID = 0;
        switch (section) {
            case "Cyber Aware":
                sectionImageResourceID = R.drawable.cyber_aware;
                break;
            case "Politics":
                sectionImageResourceID = R.drawable.politics;
                break;
            case "Technology":
                sectionImageResourceID = R.drawable.technology;
                break;
            case "US news":
                sectionImageResourceID = R.drawable.us_news;
                break;
            case "Opinion":
                sectionImageResourceID = R.drawable.opinion;
                break;
        }
        return sectionImageResourceID;
    }
}
