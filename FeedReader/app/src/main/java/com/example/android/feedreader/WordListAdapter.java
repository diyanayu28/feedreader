package com.example.android.feedreader;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.LinkedList;

/**
 * Created by user on 06-May-18.
 */

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LinkedList<Newsitem> mNewsList;
    private final LayoutInflater mInflater;


    class WordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView wordItemView;
        public final TextView descItemView;

        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            wordItemView = (TextView) itemView.findViewById(R.id.title);
            descItemView = itemView.findViewById(R.id.desc);

            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @SuppressLint("SetTextI18n")
        @Override
        public void onClick(View view) {

        }
    }

    public WordListAdapter(Context context, LinkedList<Newsitem> newsList) {
        mInflater = LayoutInflater.from(context);
        this.mNewsList = newsList;
    }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item, parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    //retrive data for that position
    public void onBindViewHolder(WordListAdapter.WordViewHolder holder, int position) {
        //String mCurrent = mWordList.get(position);
        Newsitem news = mNewsList.get(position);
        holder.wordItemView.setText(news.title);
        holder.descItemView.setText(news.desc);
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
