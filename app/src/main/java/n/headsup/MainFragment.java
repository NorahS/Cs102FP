package n.headsup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * Created by Norah on 2/2/16 AD.
 */
public class MainFragment extends Fragment {


    //constructor
    public MainFragment(){}

    Button arabicBtn;
    Button englishBtn;
    Button bothBtn;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);


        arabicBtn = (Button) rootView.findViewById(R.id.arabicBtn);
        arabicBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ArabicActivity.class);
                startActivity(i);
            }
        });

        englishBtn = (Button) rootView.findViewById(R.id.englishBtn);
        englishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), EnglishActivity.class);
                startActivity(i);
            }
        });

        bothBtn = (Button) rootView.findViewById(R.id.bothBtn);
        bothBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), BothActivity.class);
                startActivity(i);
            }
        });




        return rootView;


    }

}
