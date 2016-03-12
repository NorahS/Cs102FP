package n.headsup;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

public class EnglishActivity extends Languages{



    static final String categories[]={"Actit", "Shows", "Celebrities", "Movies", "Songs"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_english);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String list[] = {"Actit", "Random", "Shows", "Celebrities", "Movies", "Songs"};
        int[] ids= {R.drawable.eact, R.drawable.erandom, R.drawable.eshows, R.drawable.ecelebs, R.drawable.emovies, R.drawable.esongs};
        this.setBtns(new ButtonAdapter(this, list, ids));
        this.setGridview((GridView) findViewById(R.id.menu2));
        this.setChosen("English/");
        this.setAdapter();
        this.setListner();





    }


}
