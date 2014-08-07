package games.kokostym.com;

import android.R;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private Card[] mCards;

    public ImageAdapter(Context c) {
        mContext = c;
    }
    
    public void setCards(Card[] cards){
    	this.mCards = cards;
    }

    public int getCount() {
    	if(this.mCards == null){
    		return 0;
    	}
    	
        return mCards.length;
    }

    public Object getItem(int position) {
        return this.mCards[position];
    }

    public long getItemId(int position) {
        return this.mCards[position].Image;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(150,150 ));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mCards[position].Image);
        return imageView;
    }
}

