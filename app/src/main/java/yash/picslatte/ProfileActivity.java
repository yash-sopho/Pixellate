package yash.picslatte;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

public class ProfileActivity extends AppCompatActivity{
    private Context mContext = ProfileActivity.this;
    private static final int ACTIVITY_NO = 4;
    public ImageButton fb;
    public ImageButton insta;
    public ImageButton git;
    public ImageButton mail;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.share_main_file);
        setupBottomNavigationView();
        Log.d("ONcreate", "onCreate: created a new onCreate in it");
        fb = (ImageButton)findViewById(R.id.facebook);
        insta = (ImageButton)findViewById(R.id.insta);
        git = (ImageButton)findViewById(R.id.github);
        mail = (ImageButton)findViewById(R.id.mail);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WebOpen = new Intent(Intent.ACTION_VIEW);
                Log.d("Facebook", "onClick: Created Intent action view for fb");
                WebOpen.setData(Uri.parse("http://facebook.com/yash.devikar"));
                Log.d("Facebook", "onClick:Uri Parsed");
                startActivity(Intent.createChooser(WebOpen, "Choose Browser"));
                Toast.makeText(ProfileActivity.this, "Facebook", Toast.LENGTH_LONG).show();
            }
        });
        insta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WebOpen = new Intent(Intent.ACTION_VIEW);
                Log.d("Facebook", "onClick: Created Intent action view for fb");
                WebOpen.setData(Uri.parse("http://instagram.com/the_iniquitous_scorpion"));
                Log.d("Facebook", "onClick:Uri Parsed");
                startActivity(Intent.createChooser(WebOpen, "Choose Browser"));
                Toast.makeText(ProfileActivity.this, "Instagram", Toast.LENGTH_LONG).show();
            }
        });
        git.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent WebOpen = new Intent(Intent.ACTION_VIEW);
                Log.d("Facebook", "onClick: Created Intent action view for fb");
                WebOpen.setData(Uri.parse("http://github.com/yash-sopho"));
                Log.d("Facebook", "onClick:Uri Parsed");
                startActivity(Intent.createChooser(WebOpen, "Choose Browser"));
                Toast.makeText(ProfileActivity.this, "Github", Toast.LENGTH_LONG).show();
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("mail", "onClick: MAIL started");
                String[] TO= {"yash.devikar00@gmail.com"};
                String[] CC= {""};
                Intent emailintent = new Intent(Intent.ACTION_SEND);
                emailintent.setData(Uri.parse("mailto:"));
                emailintent.setType("text/plain");
                emailintent.putExtra(Intent.EXTRA_EMAIL, TO);
                emailintent.putExtra(Intent.EXTRA_CC, CC);
                emailintent.putExtra(Intent.EXTRA_SUBJECT, "YOUR SUBJECT");
                emailintent.putExtra(Intent.EXTRA_TEXT, "Email Message");
                try{
                    startActivity(Intent.createChooser(emailintent, "Send Email"));
                    finish();
                } catch(android.content.ActivityNotFoundException ex){
                    Toast.makeText(ProfileActivity.this, "Email Client Not Installed on this device", Toast.LENGTH_LONG).show();
                }
                Toast.makeText(ProfileActivity.this, "Email", Toast.LENGTH_LONG).show();
            }
        });


    }






    private void setupBottomNavigationView(){
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_nav_view_bar);
        BottomNavigationVieHlper.setupBottomNavigationView(bottomNavigationViewEx);
        BottomNavigationVieHlper.enableNavigation(mContext, bottomNavigationViewEx);
        Menu menu = bottomNavigationViewEx.getMenu();
        MenuItem menuItem = menu.getItem(ACTIVITY_NO);
        menuItem.setChecked(true);
    }


}
