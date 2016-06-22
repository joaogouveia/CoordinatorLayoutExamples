package br.com.concrete.coordinatorlayoutexamples.ui.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.concrete.coordinatorlayoutexamples.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class Coordinator3Activity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinator3);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

    }

}
