package com.yuqinyidev.android.yyandroid.ui.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.yuqinyidev.android.yyandroid.R;

public class MainMenuActivity extends AppCompatActivity {
    private TextView mTxvMessage;

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTxvMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTxvMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTxvMessage.setText(R.string.title_notifications);
                    return true;
                case R.id.navigation_about_me:
                    mTxvMessage.setText(R.string.title_about_me);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mTxvMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        Button btn_test_dabk = (Button) findViewById(R.id.btn_test_dabk);
        btn_test_dabk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(MainMenuActivity.this, TestDBDIActivity.class);
//                startActivity(intent);
                Toast.makeText(MainMenuActivity.this, stringFromJNI(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
}
