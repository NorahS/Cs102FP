package n.headsup;

/**
 * Created by Norah on 3/3/16 AD.
 */
import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/** An image view which always remains square with respect to its width. */
final class SquaredImageView extends ImageView {
    public SquaredImageView(Context context) {
        super(context);
    }

    public SquaredImageView(Context context, AttributeSet attributes) {
        super(context, attributes);
    }

    @Override protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        setMeasuredDimension(getMeasuredWidth(), getMeasuredWidth());
    }
}
