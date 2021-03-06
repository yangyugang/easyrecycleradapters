package com.carlosdelachica.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.carlosdelachica.easyrecycleradapters.sample.R;
import com.carlosdelachica.sample.fragments.CustomViewHolderFactoryFragment;
import com.carlosdelachica.sample.fragments.FullCustomizationEasyRecyclerViewFragment;
import com.carlosdelachica.sample.fragments.MultiViewEasyAdapterFragment;
import com.carlosdelachica.sample.fragments.SimpleViewEasyAdapterFragment;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends ActionBarActivity{

    @InjectView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);
        initToolbar();
        if (savedInstanceState == null) {
            navigateToFragment(new SimpleViewEasyAdapterFragment());
        }
    }

    private void navigateToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment)
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                .commit();
    }

    private void initToolbar() {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setTitle(item.getTitle());
        switch (item.getItemId()) {
            case R.id.simpleViewTypeFragment:
                navigateToFragment(new SimpleViewEasyAdapterFragment());
                return true;
            case R.id.multiViewTypeFragment:
                navigateToFragment(new MultiViewEasyAdapterFragment());
                return true;
            case R.id.fullCustomizationFragment:
                navigateToFragment(new FullCustomizationEasyRecyclerViewFragment());
                return true;
            case R.id.customFactoryFragment:
                navigateToFragment(new CustomViewHolderFactoryFragment());
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
