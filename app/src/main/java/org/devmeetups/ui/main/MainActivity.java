package org.devmeetups.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.devmeetups.R;
import org.devmeetups.ui.main.cataloge.FragmentCataloge;

public class MainActivity extends AppCompatActivity {

    public TextView tv;
    public MainViewModel viewModel;
    public FragmentCataloge fragmentCatalog;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        init();
    }

    private void init() {
        fragmentCatalog = new FragmentCataloge();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragmentCatalog);
        fragmentTransaction.commit();

        progressBar = (ProgressBar) findViewById(R.id.progressBarMain);




    }


}
