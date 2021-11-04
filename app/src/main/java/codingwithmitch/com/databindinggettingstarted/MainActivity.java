package codingwithmitch.com.databindinggettingstarted;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import codingwithmitch.com.databindinggettingstarted.adapters.RecyclerAdapter;
import codingwithmitch.com.databindinggettingstarted.models.NicePlace;
import codingwithmitch.com.databindinggettingstarted.viewmodels.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;
    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        try{

        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(@Nullable List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();
            }
        });
        }
        catch (Exception e){
            Log.d(TAG, "onCreate: "+ e.toString());
        }

        initRecyclerView();
    }

    private void initRecyclerView() {
        try{
            mAdapter = new RecyclerAdapter(this, (ArrayList<NicePlace>) mMainActivityViewModel.getNicePlaces().getValue());
            RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
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
