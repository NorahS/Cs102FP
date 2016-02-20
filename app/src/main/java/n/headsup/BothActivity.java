package n.headsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class BothActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });
    }
    public void onClick(View v) {
        String chosen =null;
        switch(v.getId()){
            case R.id.actBtnBoth:
                chosen = "Act";
                break;
            case R.id.celebsBtnBoth:
                chosen = "Celebrities";
                break;
            case R.id.moviesBtnBoth:
                chosen = "Movies";
                break;
            case R.id.randomBtnBoth:
                chosen = "Random";
                break;
            case R.id.showsBtnBoth:
                chosen = "Shows";
                break;
            case R.id.songsBtnBoth:
                chosen ="Songs";
                break;
        }

       Intent sendIntent = new Intent(getApplicationContext(), RoundsActivity.class);
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, chosen);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);

    }

}
