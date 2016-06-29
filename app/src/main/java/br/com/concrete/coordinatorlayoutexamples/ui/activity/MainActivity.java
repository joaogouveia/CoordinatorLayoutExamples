package br.com.concrete.coordinatorlayoutexamples.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.concrete.coordinatorlayoutexamples.R;
import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by João Gouveia on 22/06/2016.
 */

public class MainActivity extends AppCompatActivity {
    @Bind(R.id.text_snackbar)
    TextView textSnackbar;
    @Bind(R.id.text_scroll)
    TextView textScroll;
    @Bind(R.id.text_collapse)
    TextView textCollapse;
    @Bind(R.id.text_behavior)
    TextView textBehavior;
    @Bind(R.id.text_dismiss)
    TextView textDismiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.text_snackbar)
    protected void clickSnack() {
        startActivity(new Intent(this, Coordinator1Activity.class));
    }

    @OnClick(R.id.text_scroll)
    protected void clickScroll() {
        startActivity(new Intent(this, Coordinator2Activity.class));
    }

    @OnClick(R.id.text_collapse)
    protected void clickCollapse() {
        startActivity(new Intent(this, Coordinator3Activity.class));
    }

    @OnClick(R.id.text_behavior)
    protected void click4() {
        startActivity(new Intent(this, Coordinator4Activity.class));
    }

    @OnClick(R.id.text_dismiss)
    protected void click5() {
        startActivity(new Intent(this, Coordinator5Activity.class));
    }
}
