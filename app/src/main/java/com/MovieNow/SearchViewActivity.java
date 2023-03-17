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
import com.google.firebase.FirebaseApp;
import java.util.*;

public class SearchViewActivity extends AppCompatActivity {
	
	private LinearLayout linear3;
	private GridView gridview1;
	private LinearLayout linear2;
	private ImageView imageview1;
	private EditText edittext1;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search_view);
		initialize(savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		gridview1 = findViewById(R.id.gridview1);
		linear2 = findViewById(R.id.linear2);
		imageview1 = findViewById(R.id.imageview1);
		edittext1 = findViewById(R.id.edittext1);
	}
	
	private void initializeLogic() {
		edittext1.setSingleLine(true);
		linear2.setElevation((float)20);
		ToastUtil.showKeyboard(getApplicationContext());
	}
	

}