package n.headsup;

/**
 * Created by Norah on 3/5/16 AD.
 */

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

public class Languages extends AppCompatActivity {

    private ButtonAdapter btns;
    private GridView gridview;
    private String chosen="";


    public void setBtns(ButtonAdapter btns) {
        this.btns = btns;
    }

    public void setGridview(GridView gridview) {
        this.gridview = gridview;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }

    public ButtonAdapter getBtns() {
        return btns;
    }

    public String getChosen() {
        return chosen;
    }

    public GridView getGridview() {
        return gridview;
    }

    public void setAdapter(){
        this.gridview.setAdapter(this.btns);
    }


    public void setListner(){
        this.gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
               String path = chosen + btns.getItem(position);
                Intent intent = new Intent(getApplication(), RoundsActivity.class)
                        .putExtra(Intent.EXTRA_TEXT,path);
                startActivity(intent);
            }
        });

    }
}



