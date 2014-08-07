package games.kokostym.com;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.opengl.Visibility;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Front extends Activity {

	private FrontLayoutImageAdapter mAdapter;
	Handler handler = new Handler();

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(games.kokostym.com.R.layout.front);
		// createOverlay();

		Game thegame = new Game();
		Game.setBoard(thegame);

		GridView gridview = (GridView) findViewById(games.kokostym.com.R.id.FrontGridView01);
		mAdapter = new FrontLayoutImageAdapter(this);
		mAdapter.setCategories(FrontPageCategory.getFrontPageCategories());
		gridview.setAdapter(mAdapter);

		gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				try {
					disableGui();
					FrontPageCategory cat = FrontPageCategory
							.getFrontPageCategories()[position];
					startGameForCategory(cat);
				} finally {
					enableGui();
				}
			}
		});
	}

	private void disableGui() {
		GridView g = (GridView) findViewById(R.id.FrontGridView01);
		g.setEnabled(false);
	}

	private void enableGui() {
		GridView g = (GridView) findViewById(R.id.FrontGridView01);
		g.setEnabled(true);
	}

	public void startGameForCategory(FrontPageCategory cat) {
		Game.getGame().setGameMode(cat.getGameCategory());

		Intent intent = new Intent(this, GameActivity.class);
		/*
		 * EditText editText = (EditText) findViewById(R.id.edit_message);
		 * String message = editText.getText().toString();
		 * intent.putExtra(EXTRA_MESSAGE, message);
		 */
		startActivity(intent);

	}
}