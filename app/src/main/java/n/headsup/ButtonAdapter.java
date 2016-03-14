package n.headsup;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Norah on 1/17/16 AD.
 */
public class ButtonAdapter extends BaseAdapter {
    private Context mContext;
    private int btns[];
    private String mThumbIds[];

    public ButtonAdapter(Context c, String[] categories, int btns[]) {
        this.mContext = c;
        this.btns = btns;
        this.mThumbIds = categories;

    }
    public int getCount() {

        return mThumbIds.length;
    }
    public String getItem(int position) {
        return  mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView=null;

        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView=inflater.inflate(R.layout.image_view, parent, false);

        imageView =(ImageView) rowView.findViewById(R.id.imageView1);



        // Trigger the download of the URL asynchronously into the image view.
        Picasso.with(mContext)
                .load(btns[position])
                .placeholder(R.drawable.eact)
                .fit().centerCrop()
                .tag(mContext)

                .into(imageView);

        return rowView;
    }


}

