package n.headsup;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

public class BothActivity extends Languages {

    private String chosen = "Random/";
    //set a getter
     static final String catogries[] = {"7","4", "Shows", "Celebrities", "Movies", "Songs","5"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_both);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String list[] = {"7", "Random","Shows", "Celebrities", "Movies", "Songs"};
        int[] ids= {R.drawable.eact, R.drawable.erandom, R.drawable.eshows, R.drawable.ecelebs, R.drawable.emovies, R.drawable.esongs};
        this.setBtns(new ButtonAdapter(this ,list,ids));
        setGridview((GridView) findViewById(R.id.menu3));
        this.setChosen("Random/");
        this.setAdapter();
        this.setListner();





    }




}
