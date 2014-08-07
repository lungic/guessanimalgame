package games.kokostym.com;

import android.app.Activity;
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

public class GameActivity extends Activity {

	private ImageAdapter mAdapter;
	private ImageView mLargeImage;
	private LinearLayout mLinear;
	Handler handler = new Handler();

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(games.kokostym.com.R.layout.game);

		createOverlay();

		// /Game.setBoard(new Game());
		// Game g = new Game();
		// g.setGameMode(GameCategories.animals);
		// Game.setBoard(g);

		GridView gridview = (GridView) findViewById(games.kokostym.com.R.id.GridView01);
		mAdapter = new ImageAdapter(this);
		gridview.setAdapter(mAdapter);

		gridview.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {

				disableGui();
				Card c = Game.getGame().getCards()[position];
				Card correct = Game.getGame().getCorrect();

				if (c == correct) {
					displayImage(c);

					// playSound(c);
					playVoice(c);
					handler.postDelayed(new Runnable() {
						public void run() {
							TimerMethod();
						}
					}, 3000);

					return;
				}

				enableGui();
			}

		});

		Button b = (Button) findViewById(games.kokostym.com.R.id.Button01);
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				startNewGame();
			}
		});

		Button tv = (Button) findViewById(games.kokostym.com.R.id.TextView01);
		tv.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				playVoice(Game.getGame().getCorrect());
			}
		});

		// STarta
		handler.postDelayed(new Runnable() {
			public void run() {
				TimerMethod();
			}
		}, 2000);
	}

	private void createOverlay() {
		RelativeLayout lay = (RelativeLayout) findViewById(R.id.RelativeLayout01);

		mLinear = new LinearLayout(this);
		mLinear.setBackgroundColor(Color.BLACK);
		mLinear.setGravity(Gravity.CENTER);
		LayoutParams llp = new LayoutParams(LayoutParams.FILL_PARENT,
				LayoutParams.FILL_PARENT);

		lay.addView(mLinear, llp);

		mLargeImage = new ImageView(this);

		LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,
				LayoutParams.WRAP_CONTENT);
		mLinear.addView(mLargeImage, lp);

		mLinear.setVisibility(View.INVISIBLE);
	}

	private void startNewGame() {
		Game g = Game.getGame();
		g.NewGame(4);
		mAdapter.setCards(g.getCards());
		mAdapter.notifyDataSetChanged();

		mLinear.setVisibility(View.INVISIBLE);

		Button tv = (Button) findViewById(games.kokostym.com.R.id.TextView01);
		tv.setText(g.getCorrect().SwedishName);

		enableGui();

		playVoice(g.getCorrect());
	}

	private void disableGui() {
		GridView gv = (GridView) findViewById(games.kokostym.com.R.id.GridView01);
		gv.setEnabled(false);

		Button tv = (Button) findViewById(games.kokostym.com.R.id.Button01);
		tv.setEnabled(false);
	}

	private void enableGui() {
		GridView gv = (GridView) findViewById(games.kokostym.com.R.id.GridView01);
		gv.setEnabled(true);

		Button tv = (Button) findViewById(games.kokostym.com.R.id.Button01);
		tv.setEnabled(true);
	}

	private void playSound(Card c) {

		try {
			MediaPlayer mp = MediaPlayer.create(GameActivity.this, c.Sound);
			mp.start();
		} catch (Exception ex) {

		}

	}

	private void playVoice(Card c) {
		try {
			MediaPlayer mp = MediaPlayer.create(GameActivity.this, c.Voice);
			mp.start();
		} catch (Exception ex) {
		}
	}

	private void displayImage(Card c) {
		mLargeImage.setImageDrawable(getResources().getDrawable(c.Image));
		mLinear.setVisibility(View.VISIBLE);
		mLinear.bringToFront();
		mLinear.startLayoutAnimation();
	}

	private void TimerMethod() {
		// This method is called directly by the timer
		// and runs in the same thread as the timer.

		// We call the method that will work with the UI
		// through the runOnUiThread method.
		this.runOnUiThread(Timer_Tick);
	}

	private Runnable Timer_Tick = new Runnable() {
		public void run() {
			startNewGame();
		}
	};
}