package com.example.android.feedreader;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private final LinkedList<String> mWordList = new LinkedList<>();
    private int mCount = 0;
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;
    private final LinkedList<Newsitem> mNewsList = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        for (int i = 0; i < 20; i++) {
            mWordList.addLast("Word " + mCount++);
            Log.d("WordList", mWordList.getLast());
        }

        Newsitem news1 = new Newsitem();
        news1.title = "John's Diary";
        news1.desc = "Tought, Experience and Opinion";
        mNewsList.add(news1);

        Newsitem news2 = new Newsitem();
        news2.title = "Masgun";
        news2.desc = "Story Maker and Designer";
        mNewsList.add(news2);

        Newsitem news3 = new Newsitem();
        news3.title = "Puruhita";
        news3.desc = "Wadah dokumentasi dan ekspresi";
        mNewsList.add(news3);

        Newsitem news4 = new Newsitem();
        news4.title = "Matt Cutts";
        news4.desc = "Gadget, Google and SEO";
        mNewsList.add(news4);


        // Get a handle to the RecyclerView.
        mRecyclerView = (RecyclerView) findViewById(R.id.feedreader);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new WordListAdapter(this, mNewsList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
}

