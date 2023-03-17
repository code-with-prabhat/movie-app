package com.MovieNow;

import android.app.*;
import android.content.*;
import android.content.Intent;
import android.graphics.*;
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.net.*;
import android.os.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import java.util.*;

public class VideoViewActivity extends AppCompatActivity {
	
	private Timer timer = new Timer();
	
	private double oo9 = 0;
	private double next1 = 0;
	private double backk = 0;
	private String playingstatus = "";
	private String progress = "";
	private String fullscreen = "";
	private String ssssss = "";
	private String k5 = "";
	private String valieee = "";
	private String touching = "";
	private String txt = "";
	private String txt1 = "";
	private String bk = "";
	
	private LinearLayout linearmain;
	private LinearLayout secandarymain;
	private LinearLayout linear3;
	private LinearLayout linear1;
	private LinearLayout upword;
	private LinearLayout back;
	private LinearLayout linear17;
	private LinearLayout forwordddd;
	private LinearLayout linear12;
	private TextView love;
	private TextView cuple;
	private LinearLayout playbausbox;
	private LinearLayout linear4;
	private LinearLayout linear11;
	private ImageView imageview2;
	private LinearLayout linear13;
	private ImageView imageview3;
	private LinearLayout linear7;
	private LinearLayout linear9;
	private LinearLayout linear10;
	private ImageView backword;
	private ProgressBar progressbar1;
	private ImageView playpuse;
	private ImageView forword;
	private TextView compdur;
	private TextView textview1;
	private TextView totaldur;
	private SeekBar seekbar1;
	private ImageView imageview1;
	
	private TimerTask eyg;
	private TimerTask pp9;
	private TimerTask sttim;
	private TimerTask kgx;
	private SharedPreferences dd;
	private SharedPreferences dt;
	private TimerTask f7;
	private Intent yyt = new Intent();
	private Intent cv = new Intent();
	private TimerTask gj;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.video_view);
		initialize(savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle savedInstanceState) {
		linearmain = findViewById(R.id.linearmain);
		secandarymain = findViewById(R.id.secandarymain);
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		upword = findViewById(R.id.upword);
		back = findViewById(R.id.back);
		linear17 = findViewById(R.id.linear17);
		forwordddd = findViewById(R.id.forwordddd);
		linear12 = findViewById(R.id.linear12);
		love = findViewById(R.id.love);
		cuple = findViewById(R.id.cuple);
		playbausbox = findViewById(R.id.playbausbox);
		linear4 = findViewById(R.id.linear4);
		linear11 = findViewById(R.id.linear11);
		imageview2 = findViewById(R.id.imageview2);
		linear13 = findViewById(R.id.linear13);
		imageview3 = findViewById(R.id.imageview3);
		linear7 = findViewById(R.id.linear7);
		linear9 = findViewById(R.id.linear9);
		linear10 = findViewById(R.id.linear10);
		backword = findViewById(R.id.backword);
		progressbar1 = findViewById(R.id.progressbar1);
		playpuse = findViewById(R.id.playpuse);
		forword = findViewById(R.id.forword);
		compdur = findViewById(R.id.compdur);
		textview1 = findViewById(R.id.textview1);
		totaldur = findViewById(R.id.totaldur);
		seekbar1 = findViewById(R.id.seekbar1);
		imageview1 = findViewById(R.id.imageview1);
		dd = getSharedPreferences("dd", Activity.MODE_PRIVATE);
		dt = getSharedPreferences("dt", Activity.MODE_PRIVATE);
		
		linear3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				linear3.setVisibility(View.GONE);
				touching = "";
			}
		});
		
		linear1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				linear3.setVisibility(View.VISIBLE);
				touching = "on";
			}
		});
		
		back.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (bk.equals("")) {
					bk = "ok";
					f7 = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									linear3.setVisibility(View.VISIBLE);
									bk = "";
								}
							});
						}
					};
					timer.schedule(f7, (int)(300));
				}
				else {
					f7.cancel();
					bk = "";
					if (Double.parseDouble(love.getText().toString()) > 5000) {
						vidview.seekTo((int)(vidview.getCurrentPosition() - 5000));
						txt = "《-0.5";
						ToastUtil.showMessage(getApplicationContext(), txt);
					}
				}
			}
		});
		
		forwordddd.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (bk.equals("")) {
					bk = "ok";
					f7 = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									linear3.setVisibility(View.VISIBLE);
									bk = "";
								}
							});
						}
					};
					timer.schedule(f7, (int)(300));
				}
				else {
					f7.cancel();
					bk = "";
					if (Double.parseDouble(cuple.getText().toString()) > (Double.parseDouble(love.getText().toString()) + 10000)) {
						vidview.seekTo((int)(vidview.getCurrentPosition() + 10000));
						txt = "+ 0.10》";
						ToastUtil.showMessage(getApplicationContext(), txt);
					}
				}
			}
		});
		
		backword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (Double.parseDouble(love.getText().toString()) > 5000) {
					vidview.seekTo((int)(vidview.getCurrentPosition() - 5000));
					txt = "《-0.5";
					ToastUtil.showMessage(getApplicationContext(), txt);
				}
			}
		});
		
		playpuse.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (vidview.isPlaying())
				{
					vidview.pause();
					playingstatus = "";
					playpuse.setImageResource(R.drawable.playarrow);
				}
				else { 
					
					vidview.start();
					playingstatus = "PLAY";
					playpuse.setImageResource(R.drawable.pause);
				}
			}
		});
		
		forword.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (Double.parseDouble(cuple.getText().toString()) > (Double.parseDouble(love.getText().toString()) + 10000)) {
					vidview.seekTo((int)(vidview.getCurrentPosition() + 10000));
					txt = "+ 0.10》";
					ToastUtil.showMessage(getApplicationContext(), txt);
				}
			}
		});
		
		seekbar1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
			@Override
			public void onProgressChanged(SeekBar param1, int param2, boolean param3) {
				final int progressValue = param2;
				compdur.setText(String.valueOf((long)((progressValue / 1000) / 60)).concat(":".concat(String.valueOf((long)((progressValue / 1000) % 60)))));
				valieee = String.valueOf((long)(progressValue));
			}
			
			@Override
			public void onStartTrackingTouch(SeekBar param1) {
				progress = "stop";
			}
			
			@Override
			public void onStopTrackingTouch(SeekBar param2) {
				vidview.seekTo((int)(seekbar1.getProgress()));
				progress = "";
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (fullscreen.equals("")) {
					linear12.setTranslationY((float)(0));
					playbausbox.setTranslationY((float)(0));
					linear4.setTranslationY((float)(0));
					linear11.setTranslationY((float)(0));
					imageview1.setImageResource(R.drawable.blb);
					setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
					fullscreen = "ON";
				}
				else {
					linear12.setTranslationY((float)(-500));
					playbausbox.setTranslationY((float)(-380));
					linear4.setTranslationY((float)(-380));
					linear11.setTranslationY((float)(-380));
					imageview1.setImageResource(R.drawable.switchfs);
					setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
					fullscreen = "";
				}
			}
		});
	}
	
	private void initializeLogic() {
		setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		imageview2.setVisibility(View.GONE);
		imageview3.setVisibility(View.GONE);
		seekbar1.getProgressDrawable().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		seekbar1.getThumb().setColorFilter(Color.parseColor("#FFFFFF"), PorterDuff.Mode.SRC_IN);
		_Videoplayer(getIntent().getStringExtra("url"));
		playpuse.setVisibility(View.GONE);
		_cupl();
		_loading();
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
	}
	
	public void _Videoplayer(final String videourl) {
		//Need this block for internet connection
		vidview = new VideoView(this);
		vidview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
		
		//change linear1 with your linear view
		linear1.addView(vidview);
		
		mediaControls = new MediaController(this); mediaControls.setAnchorView(vidview); 
		String vidAddress = videourl;
		
		Uri vidUri = Uri.parse(vidAddress);
		vidview.setVideoURI(vidUri);
		//Start video player 
		vidview.start();
		playingstatus = "PLAY";
		playpuse.setImageResource(R.drawable.pause);
	}
	
	
	public void _cupl() {
		gj = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						cuple.setText(String.valueOf(vidview.getDuration()));
						totaldur.setText(String.valueOf((long)((Double.parseDouble(cuple.getText().toString()) / 1000) / 60)).concat(":".concat(String.valueOf((long)((Double.parseDouble(cuple.getText().toString()) / 1000) % 60)))));
						seekbar1.setMax((int)Double.parseDouble(cuple.getText().toString()));
						love.setText(String.valueOf(vidview.getCurrentPosition())); 
						compdur.setText(String.valueOf((long)((Double.parseDouble(love.getText().toString()) / 1000) / 60)).concat(":".concat(String.valueOf((long)((Double.parseDouble(love.getText().toString()) / 1000) % 60)))));
						if (progress.equals("")) {
							seekbar1.setProgress((int)Double.parseDouble(love.getText().toString()));
						}
						if (totaldur.getText().toString().equals(compdur.getText().toString())) {
							
						}
						else {
							dd.edit().putString(getIntent().getStringExtra("posi"), compdur.getText().toString().concat(" / ".concat(totaldur.getText().toString()))).commit();
						}
						if (ToastUtil.getDisplayHeightPixels(getApplicationContext()) > ToastUtil.getDisplayWidthPixels(getApplicationContext())) {
							//normal size
							imageview1.setImageResource(R.drawable.switchfs);
							fullscreen = "";
						}
						else {
							//fullscreen size
							imageview1.setImageResource(R.drawable.blb);
							fullscreen = "ON";
						}
					}
				});
			}
		};
		timer.scheduleAtFixedRate(gj, (int)(0), (int)(5));
	}
	
	
	public void _loading() {
		gj = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (compdur.getText().toString().equals(totaldur.getText().toString())) {
							
						}
						else {
							if (playingstatus.equals("")) {
								oo9 = 0;
								progressbar1.setVisibility(View.GONE);
								playpuse.setVisibility(View.VISIBLE);
							}
							else {
								ssssss = love.getText().toString();
								eyg = new TimerTask() {
									@Override
									public void run() {
										runOnUiThread(new Runnable() {
											@Override
											public void run() {
												if (love.getText().toString().equals(ssssss)) {
													oo9++;
													playpuse.setVisibility(View.GONE);
													progressbar1.setVisibility(View.VISIBLE);
												}
												else {
													oo9 = 0;
													progressbar1.setVisibility(View.GONE);
													playpuse.setVisibility(View.VISIBLE);
													sttim = new TimerTask() {
														@Override
														public void run() {
															runOnUiThread(new Runnable() {
																@Override
																public void run() {
																	if (k5.equals("")) {
																		linear3.setVisibility(View.GONE);
																		k5 = "ok";
																	}
																}
															});
														}
													};
													timer.schedule(sttim, (int)(100));
												}
											}
										});
									}
								};
								timer.schedule(eyg, (int)(5));
							}
						}
					}
				});
			}
		};
		timer.scheduleAtFixedRate(gj, (int)(0), (int)(55));
	}
	
	
	
	VideoView vidview;
	MediaController mediaControls;
	
	
	
	
}