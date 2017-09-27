package com.example.quytran.lisviewcustomize;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private SwipeRefreshLayout swipeRefreshLayout;
    private ArrayList image_details;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image_details = getListData();
        final ListView listView = (ListView) findViewById(R.id.custom_list);
        listView.setAdapter(new CustomListAdapter(MainActivity.this, image_details));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object o = listView.getItemAtPosition(position);
                NewItem newsData = (NewItem) o;
                Toast.makeText(MainActivity.this, "Selected :" + " " + newsData, Toast.LENGTH_LONG).show();
            }
        });
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);
                  fetchData();

            }
        });
    }
    private ArrayList getListData(){
        ArrayList<NewItem> results = new ArrayList<NewItem>();
        NewItem newsData = new NewItem();
        newsData.setHeadline("Dance of Democracy");
        newsData.setReportName("Pankaj Gupta");
        newsData.setDate("May 26, 2013, 13:35");
        NewItem newsData1 = new NewItem();
        newsData1.setHeadline("Dance of Democracy");
        newsData1.setReportName("Pankaj Gupta");
        newsData1.setDate("May 26, 2013, 13:35");
        results.add(newsData1);
        NewItem newsData2 = new NewItem();
        newsData2.setHeadline("Dance of Democracy");
        newsData2.setReportName("Pankaj Gupta");
        newsData2.setDate("May 26, 2013, 13:35");
        results.add(newsData2);
        return results;
    }
    private void fetchData(){
        swipeRefreshLayout.setRefreshing(true);
        image_details.clear();
        image_details = getListData();
        try {
            wait(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        swipeRefreshLayout.setRefreshing(false);

    }


}
