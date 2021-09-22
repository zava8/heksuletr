package com.zava8.calculator.activities;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.zava8.calculator.R;
import com.zava8.calculator.managers.HistoryManager;
import com.zava8.calculator.model.HistoryResult;
import com.zava8.calculator.model.ThemeSetting;
import com.zava8.calculator.utils.SharedPreferencesUtil;

import java.util.ArrayList;
public class HistoryActivity extends AppCompatActivity {
    private ListView historyListView; private ArrayAdapter arrayAdapter;
    ArrayList<String> historyResults = getResults();
    @Override protected void onCreate(Bundle savedInstanceState) {
        SharedPreferencesUtil prefUtil = new SharedPreferencesUtil(this);
        setTheme(ThemeSetting.getThemeStyleByThemeSetting(prefUtil.loadThemeSetting()));
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true); getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        historyListView = findViewById(R.id.lvHistory);
        arrayAdapter = new ArrayAdapter<String>(this, R.layout.history_adapter, historyResults);
        historyListView.setAdapter(arrayAdapter);
        historyListView.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            deleteItem(position); arrayAdapter.notifyDataSetChanged();
        });
    }
    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) { this.finish(); }
        return super.onOptionsItemSelected(item);
    }
    private ArrayList<String> getResults() {
        ArrayList<HistoryResult> list = HistoryManager.getSharedInstance().fetchAllHistoryResults();
        ArrayList<String> results = new ArrayList<String>();
        for (HistoryResult result: list) { results.add(result.getResult()); }
        return results;
    }
    private void deleteItem(int position) {
        ArrayList<HistoryResult> results = HistoryManager.getSharedInstance().fetchAllHistoryResults();
        HistoryResult result = results.get(position);
        historyResults.remove(position);
        HistoryManager.getSharedInstance().deleteResult(result);
    }
}
