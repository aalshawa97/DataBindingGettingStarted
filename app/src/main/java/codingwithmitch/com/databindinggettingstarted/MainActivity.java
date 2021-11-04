package codingwithmitch.com.databindinggettingstarted;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import codingwithmitch.com.databindinggettingstarted.adapters.RecyclerAdapter;
import codingwithmitch.com.databindinggettingstarted.models.NicePlace;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initRecyclerView();
    }

    private void initRecyclerView() {
        mAdapter = new RecyclerAdapter(this, new ArrayList<NicePlace>());
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        try{
            mRecyclerView.setLayoutManager(linearLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }
        catch (Exception e)
        {

        }

    }

    private void showProgressBar() { mProgressBar.setVisibility(View.VISIBLE);}
    private void hideProgressBar() { mProgressBar.setVisibility(View.GONE);}
}
