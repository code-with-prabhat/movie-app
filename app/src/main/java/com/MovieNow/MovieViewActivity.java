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


public class MovieViewActivity extends AppCompatActivity {
	
	private String url = "";
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview3;
	private ImageView imageview1;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear3;
	private TextView textview3;
	private TextView textview4;
	private TextView textview5;
	
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_view);
		initialize(savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		imageview3 = findViewById(R.id.imageview3);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		linear3 = findViewById(R.id.linear3);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		textview5 = findViewById(R.id.textview5);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				in.setClass(getApplicationContext(), VideoViewActivity.class);
				in.putExtra("url", url);
				startActivity(in);
			}
		});
	}
	
	private void initializeLogic() {
		textview2.setText(getIntent().getStringExtra("name"));
		roundedImageURL(imageview1, 50, getIntent().getStringExtra("image"));
		textview3.setText(getIntent().getStringExtra("category"));
		textview5.setText(getIntent().getStringExtra("year"));
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/ubuntu_light.ttf"), 1);
		url = getIntent().getStringExtra("url");
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFFFFFFFF));
	}
	
	public void roundedImageURL(final ImageView imageview, final double rounded, final String url) {
		
		Glide.with(getApplicationContext())
		.load(url)
		.transform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners((int)rounded))
		.into(imageview);
	}
	
	
}