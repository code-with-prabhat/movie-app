package com.MovieNow;

import android.app.*;
import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.net.Uri;
import android.os.Bundle;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import java.util.*;

public class MainActivity extends AppCompatActivity {
	
	private Timer timer = new Timer();
	
	private String click = "";
	private double click2 = 0;
	private double click3 = 0;
	
	private LinearLayout linear3;
	private LinearLayout linear2;
	private LinearLayout login_layout;
	private TextView textview9;
	private ImageView imageview2;
	private TextView textview6;
	private EditText edittext5;
	private EditText edittext3;
	private LinearLayout linear4;
	private Button button2;
	private TextView textview8;
	private EditText edittext6;
	private ImageView imageview3;
	private ImageView imageview1;
	private TextView textview2;
	private EditText edittext1;
	private LinearLayout linear5;
	private Button button1;
	private TextView textview3;
	private TextView textview4;
	private EditText edittext2;
	private ImageView imageview4;
	
	private Intent in = new Intent();
    private AlertDialog.Builder exit;    
	private FirebaseAuth auth;
	private OnCompleteListener<AuthResult> auth_create_user_listener;
	private OnCompleteListener<AuthResult> authsign_in_listener;
	private OnCompleteListener<Void> auth_reset_password_listener;
	private OnCompleteListener<Void> auth_updateEmailListener;
	private OnCompleteListener<Void> auth_updatePasswordListener;
	private OnCompleteListener<Void> auth_emailVerificationSentListener;
	private OnCompleteListener<Void> auth_deleteUserListener;
	private OnCompleteListener<Void> auth_updateProfileListener;
	private OnCompleteListener<AuthResult> auth_phoneAuthListener;
	private OnCompleteListener<AuthResult> auth_googleSignInListener;
	
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initialize(savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		login_layout = findViewById(R.id.login_layout);
		textview9 = findViewById(R.id.textview9);
		imageview2 = findViewById(R.id.imageview2);
		textview6 = findViewById(R.id.textview6);
		edittext5 = findViewById(R.id.edittext5);
		edittext3 = findViewById(R.id.edittext3);
		linear4 = findViewById(R.id.linear4);
		button2 = findViewById(R.id.button2);
		textview8 = findViewById(R.id.textview8);
		edittext6 = findViewById(R.id.edittext6);
		imageview3 = findViewById(R.id.imageview3);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		edittext1 = findViewById(R.id.edittext1);
		linear5 = findViewById(R.id.linear5);
		button1 = findViewById(R.id.button1);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		edittext2 = findViewById(R.id.edittext2);
		imageview4 = findViewById(R.id.imageview4);
		auth = FirebaseAuth.getInstance();
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (edittext5.getText().toString().trim().equals("")) {
					createSnackBar("Please enter name");
				}
				else {
					if (edittext3.getText().toString().trim().equals("")) {
						createSnackBar("Please enter email");
					}
					else {
						if (edittext6.getText().toString().trim().equals("")) {
							createSnackBar("Please enter password");
						}
						else {
							auth.createUserWithEmailAndPassword(edittext3.getText().toString(), edittext6.getText().toString()).addOnCompleteListener(MainActivity.this, auth_create_user_listener);
							ProgresbarShow("Loading....");
						}
					}
				}
			}
		});
		
		textview8.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				login_layout.setVisibility(View.VISIBLE);
				linear2.setVisibility(View.GONE);
			}
		});
		
		imageview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				click2++;
				if (String.valueOf((long)(click2)).equals("2")) {
					click2 = 0;
					
					edittext6.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
					
					
					
					imageview3.setImageResource(R.drawable.ic_visibility_off_black);
				}
				else {
					
					edittext6.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
					imageview3.setImageResource(R.drawable.ic_visibility_black);
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (edittext1.getText().toString().trim().equals("")) {
					createSnackBar("Please enter email");
				}
				else {
					if (edittext2.getText().toString().trim().equals("")) {
						createSnackBar("Please enter password");
					}
					else {
						auth.signInWithEmailAndPassword(edittext1.getText().toString().trim(), edittext2.getText().toString().trim()).addOnCompleteListener(MainActivity.this, authsign_in_listener);
						ProgresbarShow("Please wait...");
					}
				}
			}
		});
		
		textview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				login_layout.setVisibility(View.GONE);
				linear2.setVisibility(View.VISIBLE);
			}
		});
		
		imageview4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				click3++;
				if (String.valueOf((long)(click3)).equals("2")) {
					click3 = 0;
					
					edittext2.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
					
					
					
					imageview4.setImageResource(R.drawable.ic_visibility_off_black);
				}
				else {
					
					edittext2.setTransformationMethod(android.text.method.HideReturnsTransformationMethod.getInstance());
					imageview4.setImageResource(R.drawable.ic_visibility_black);
				}
			}
		});
		
		auth_updateEmailListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				
			}
		};
		
		auth_updatePasswordListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				
			}
		};
		
		auth_emailVerificationSentListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				
			}
		};
		
		auth_deleteUserListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				
			}
		};
		
		auth_phoneAuthListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean success = task.isSuccessful();
				final String errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_updateProfileListener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				
			}
		};
		
		auth_googleSignInListener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> task) {
				final boolean success = task.isSuccessful();
				final String errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		auth_create_user_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				if (success) {
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									ProgresbarDimiss();
									ToastUtil.showMessage(getApplicationContext(), "Account Created");
									in.setClass(getApplicationContext(), MovieListActivity.class);
									startActivity(in);
									finish();
								}
							});
						}
					};
					timer.schedule(t, (int)(500));
				}
				else {
					ProgresbarDimiss();
					ToastUtil.showMessage(getApplicationContext(), errorMessage);
				}
			}
		};
		
		authsign_in_listener = new OnCompleteListener<AuthResult>() {
			@Override
			public void onComplete(Task<AuthResult> param1) {
				final boolean success = param1.isSuccessful();
				final String errorMessage = param1.getException() != null ? param1.getException().getMessage() : "";
				if (success) {
					ProgresbarDimiss();
					in.setClass(getApplicationContext(), MovieListActivity.class);
					in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
					startActivity(in);
					finish();
				}
				else {
					ToastUtil.showMessage(getApplicationContext(), errorMessage);
					ProgresbarDimiss();
				}
			}
		};
		
		auth_reset_password_listener = new OnCompleteListener<Void>() {
			@Override
			public void onComplete(Task<Void> param1) {
				final boolean success = param1.isSuccessful();
				if (success) {
					ToastUtil.showMessage(getApplicationContext(), "Forget mail sent");
					ProgresbarDimiss();
				}
				else {
					ToastUtil.showMessage(getApplicationContext(), "Error");
					ProgresbarDimiss();
				}
			}
		};
	}
	
	private void initializeLogic() {
		click3 = 0;
		click2 = 0;
		if ((FirebaseAuth.getInstance().getCurrentUser() != null)) {
			in.setClass(getApplicationContext(), MovieListActivity.class);
			in.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(in);
            finish();    
		}
		linear2.setVisibility(View.GONE);
		edittext2.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
		
		edittext6.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
			statusbarcolor("#9E9E9E");
		
		textview6.setBackgroundColor(0xFFFF9800);
	}
    
    	@Override
	public void onBackPressed() {
		exit.setTitle("Exit");
		exit.setMessage("Do you exit this app?");
		exit.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				finishAffinity();
			}
		});
		exit.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
			}
		});
		exit.create().show();
	}
    
    
	private ProgressDialog prog;
	
	public void createSnackBar(String message) {
		ViewGroup parentLayout = (ViewGroup) ((ViewGroup) this .findViewById(android.R.id.content)).getChildAt(0);
		   com.google.android.material.snackbar.Snackbar.make(parentLayout, message, com.google.android.material.snackbar.Snackbar.LENGTH_LONG) 
		        .setAction("OK", new View.OnClickListener() {
			            @Override 
			            public void onClick(View view) {
				
				            } 
			        }).show();
	}
	
	
	public void statusbarcolor( String color) {
		
		Window w = this.getWindow();
            
        w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); w.setStatusBarColor(Color.parseColor(color));
	}
	
	
	public void ProgresbarShow( String title) {
		prog = new ProgressDialog(MainActivity.this);
		prog.setMax(100);
		prog.setMessage(title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
}    
	