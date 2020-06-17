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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.content_main, container, false);


        Button pressMe = (Button) rootView.findViewById(R.id.button);
        pressMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detail  = new Intent(getActivity(), RoundsActivity.class).putExtra(Intent.EXTRA_TEXT,"Activity 2");
                startActivity(detail);
            }
        });




        return rootView;


    }

}
