package n.headsup;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.GridView;

public class ArabicActivity extends Languages {




    static final String categories[] ={"5", "4", "6", "2", "3","7","1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arabic);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String list[] ={"5","Random", "4", "6", "2", "3","7","1"};
        int ids[] ={R.drawable.ptrial, R.drawable.rtrial, R.drawable.pltrial,R.drawable.ctrial,R.drawable.tvtrial, R.drawable.strial,R.drawable.actrial,R.drawable.mtrial};
        this.setBtns(new ButtonAdapter(this ,list,ids));
        this.setGridview((GridView) findViewById(R.id.menu3));
        this.setChosen("Arabic/");
        this.setAdapter();
        this.setListner();


    }


}
