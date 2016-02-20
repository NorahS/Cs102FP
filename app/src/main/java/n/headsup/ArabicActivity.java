package n.headsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class ArabicActivity extends AppCompatActivity {


    Button randomBtn;
    Button moviesBtn;
    Button showsBtn;
    Button songsBtn;
    Button celebsBtn;
    Button phrasesBtn;
    Button playsBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final Intent sendIntent = new Intent(getApplicationContext(), RoundsActivity.class);
        sendIntent.setAction(Intent.ACTION_SEND);

        randomBtn = (Button) findViewById(R.id.randomBtn);
        randomBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                sendIntent.putExtra(Intent.EXTRA_TEXT, randomBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

            }
        });



        moviesBtn = (Button) findViewById(R.id.moviesBtn);
        moviesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra(Intent.EXTRA_TEXT, moviesBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



        showsBtn = (Button) findViewById(R.id.showsBtn);
        showsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra(Intent.EXTRA_TEXT, showsBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



        songsBtn = (Button) findViewById(R.id.songsBtn);
        songsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra(Intent.EXTRA_TEXT, songsBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



        celebsBtn = (Button) findViewById(R.id.celebsBtn);
        celebsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra(Intent.EXTRA_TEXT, celebsBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



        phrasesBtn = (Button) findViewById(R.id.phrasesBtn);
        phrasesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra(Intent.EXTRA_TEXT, phrasesBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });



        playsBtn = (Button) findViewById(R.id.playsBtn);
        playsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendIntent.putExtra(Intent.EXTRA_TEXT, playsBtn.getText());
                sendIntent.setType("text/plain");
                startActivity(sendIntent);
            }
        });

    }

}
