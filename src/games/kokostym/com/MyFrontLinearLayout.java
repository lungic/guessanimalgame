package games.kokostym.com;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MyFrontLinearLayout extends RelativeLayout {

	public ImageView mView;
	public TextView mText;
	private static int mIdentities = 333;
	
	public static int getIdent(){
		mIdentities++;
		return mIdentities;
	}

	public MyFrontLinearLayout(Context mContext){ 
		super(mContext);
		mView = new ImageView(mContext);
		mView.setId(getIdent());
		
		mText = new TextView(mContext);
		mText.setId(getIdent());
		mText.setTextSize(36);
		
		RelativeLayout.LayoutParams params1 = new RelativeLayout.LayoutParams(
	            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        params1.addRule(RelativeLayout.ALIGN_PARENT_LEFT, TRUE);
	        params1.addRule(RelativeLayout.ALIGN_PARENT_TOP, TRUE);
	   this.addView(mView, params1);
	   
	   RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(
	            LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
	        params2.addRule(RelativeLayout.CENTER_VERTICAL, mView.getId());
	        params2.addRule(RelativeLayout.RIGHT_OF, mView.getId());
	        params2.setMargins(30, 0,0,0);

	   this.addView(mText,params2);
	}

	public ImageView getImageView() {
		return this.mView;
	}

	public TextView getTextView() {
		return this.mText;
	}
}