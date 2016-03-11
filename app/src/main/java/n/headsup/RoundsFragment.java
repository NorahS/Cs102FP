package n.headsup;

import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Norah on 2/2/16 AD.
 */
public class RoundsFragment extends Sensors{


    private AssetManager mngr;

    //constructor
    public RoundsFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = super.onCreateView(inflater,container, savedInstanceState);
        Intent intent = getActivity().getIntent();


        if (intent != null && intent.hasExtra(Intent.EXTRA_TEXT)) {
            String category = intent.getStringExtra(Intent.EXTRA_TEXT);
            this.mngr = getContext().getAssets();
            HelperFunctions.play(this,category, mngr);
            HelperFunctions.next();

        }



        return rootView;

    }



}
