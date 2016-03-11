package n.headsup;

/**
 * Created by Norah on 3/10/16 AD.
 */
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class Setup extends Fragment {

    protected View rootView = null;
    private  static TextView text;
    protected Map langugae = new HashMap();
    private String colors[]= {"#95c890","#eed55e","#f6c0a8","#ef7277","#D88b7d"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        rootView = inflater.inflate(R.layout.activity_rounds, container, false);
        rootView.setBackgroundColor(Color.parseColor(colors[(int) (Math.random() * colors.length)]));
        text = (TextView) rootView.findViewById(R.id.fullscreen_content);

        langugae.put("English", EnglishActivity.catogries);
        langugae.put("Random", BothActivity.catogries);
        langugae.put("Arabic", ArabicActivity.catgories);

        return rootView;
    }

    protected static void setText(String s){
        text.setText(s);
    }
}