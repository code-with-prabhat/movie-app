package com.MovieNow;

import android.content.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.app.*;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import java.text.*;
import java.util.*;
import com.bumptech.glide.Glide;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.DatabaseError;


public class MovieListActivity extends AppCompatActivity {
	
	private ArrayList<HashMap<String, Object>> movie = new ArrayList<>();
    private FirebaseDatabase firebase = FirebaseDatabase.getInstance();
    private DatabaseReference  movie2 = firebase.getReference("movie");
    private ChildEventListener child;     
	private String url;
    private String year;
    private String category;
    private String name;
    private String image;
	private GridView gridview1;
    private Intent intent = new Intent(); 
    private AlertDialog.Builder exit;    
	private FloatingActionButton fab;
    private LinearLayout plinear;
    private LinearLayout newlinear;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.movie_list);
		initialize();
		initializeLogic();
        FirebaseApp.initializeApp(this);
	}
	
	private void initialize() {
		gridview1 = findViewById(R.id.gridview1);
        fab = findViewById(R.id.fab); 
        newlinear = findViewById(R.id.newlinear);
        plinear = findViewById(R.id.plinear);           
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> param1, View param2, int param3, long param4) {
				final int position = param3;
				intent.setClass(getApplicationContext(), MovieViewActivity.class);
                intent.putExtra("name", name);    
                intent.putExtra("url",url );    
                intent.putExtra("image",image);
                intent.putExtra("category",category);
                intent.putExtra("year",year);            
                startActivity(intent);
			}
		});
        
        
        
       child = new ChildEventListener(){
        @Override
        public void onChildAdded(DataSnapshot param1, String param2){
            GenericTypeIndicator<HashMap<String, Object>> io = new GenericTypeIndicator<HashMap<String, Object>>(){};      
                String key = param1.getKey();
                HashMap<String, Object>  value = param1.getValue(io);   
               movie.add((int)0, value); 
               gridview1.setAdapter(new Gridview1Adapter(movie));
               newlinear.setVisibility(View.VISIBLE);    
               plinear.setVisibility(View.GONE);     
                    
         }
         	
             @Override
			public void onChildChanged(DataSnapshot param1, String param2) {
				GenericTypeIndicator<HashMap<String, Object>> io = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String key = param1.getKey();
				final HashMap<String, Object> value = param1.getValue(io);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot param1, String param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot param1) {
				GenericTypeIndicator<HashMap<String, Object>> io = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String key = param1.getKey();
				final HashMap<String, Object> value = param1.getValue(io);
				
			}
			
			@Override
			public void onCancelled(DatabaseError param1) {
				final int errorCode = param1.getCode();
				final String errorMessage = param1.getMessage();
				
			}
         
         
         
       };
       
        movie2.addChildEventListener(child);
            
            
	}
	
	private void initializeLogic() {
        newlinear.setVisibility(View.GONE);    
		
	}
    
    
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> arr) {
			data = arr;
		}
		
		@Override
		public int getCount() {
			return data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int index) {
			return data.get(index);
		}
		
		@Override
		public long getItemId(int index) {
			return index;
		}
		
		@Override
		public View getView(final int position, View v, ViewGroup  container) {
			LayoutInflater inflater = getLayoutInflater();
			View view = v;
			if (view == null) {
				view = inflater.inflate(R.layout.movie, null);
			}
			 ImageView imageview1 = view.findViewById(R.id.imageview1);
			 TextView textview1 = view.findViewById(R.id.textview1);
             LinearLayout linear1 = view.findViewById(R.id.linear1);   
			
             if (data.get((int)position).containsKey("movie_image_url")) {
				roundedImageURL(imageview1, 10, data.get((int)position).get("movie_image_url").toString());
			}
			else {
				imageview1.setImageResource(R.drawable.default_image);
			}
			textview1.setText(data.get((int)position).get("movie_name").toString());
			url = data.get((int)position).get("movie_url").toString();
			category = data.get((int)position).get("category").toString();
			year = data.get((int)position).get("year").toString();
            image =  data.get((int)position).get("movie_image_url").toString();  
            name = data.get((int)position).get("movie_name").toString(); 
			
			return view;
		}
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
	
    
    public void roundedImageURL(ImageView imageview, double rounded, String url) {
		
		Glide.with(getApplicationContext())
		.load(url)
		.transform(new com.bumptech.glide.load.resource.bitmap.RoundedCorners((int)rounded))
		.into(imageview);
	}
}
