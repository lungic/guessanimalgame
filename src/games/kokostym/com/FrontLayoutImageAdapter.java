package games.kokostym.com;

import android.R;
import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FrontLayoutImageAdapter extends BaseAdapter {

	private Context mContext;
	private FrontPageCategory[] mCards;

	public FrontLayoutImageAdapter(Context c) {
		mContext = c;
	}

	public void setCategories(FrontPageCategory[] cats) {
		this.mCards = cats;
	}

	public int getCount() {
		if (this.mCards == null) {
			return 0;
		}

		return mCards.length;
	}

	public Object getItem(int position) {
		return this.mCards[position];
	}

	public long getItemId(int position) {
		return this.mCards[position].getImage();
	}

	// create a new ImageView for each item referenced by the Adapter
	public View getView(int position, View convertView, ViewGroup parent) {
		MyFrontLinearLayout l;

		if (convertView == null) { // if it's not recycled, initialize some
									// attributes
			l = new MyFrontLinearLayout(mContext);
			l.setLayoutParams(new GridView.LayoutParams(-1, 100));
			l.setPadding(4, 4, 4, 4);

		} else {
			l = (MyFrontLinearLayout) convertView;
		}

		l.setBackgroundColor(mCards[position].getColor());
		l.getImageView().setImageResource(mCards[position].getImage());
		l.getTextView().setText(mCards[position].getText());
		return l;
	}
}
