package uds.pm.td3bon;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LevelActivity extends AppCompatActivity {

    private int level ;
    private TextView levelTextView;
    private TextView instanceCounterTextView;

    private Button backButton;

    static public int nInstance = 0;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        nInstance++;
        super.onCreate(savedInstanceState);
        Log.println(Log.INFO , "methodes de levelActivity" , "onCreate declenche");
        setContentView(R.layout.activity_level);
        Intent actualIntent = this.getIntent();
        level = actualIntent.getIntExtra("level" , 1);
        levelTextView = findViewById(R.id.scoreTextView2);
        levelTextView.setText(String.format("%d",level));

        instanceCounterTextView = findViewById(R.id.nbInstanceCounter);
        instanceCounterTextView.setText(String.format("%d",nInstance));

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.println(Log.INFO , "methodes de levelActivity" , "onStart declenche");
    }

    @Override
    protected void onStop() {
        Log.println(Log.INFO , "methodes de levelActivity" , "onStop declenche");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.println(Log.INFO , "methodes de levelActivity" , "onDestroy declenche");
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        Log.println(Log.INFO , "methodes de levelActivity" , "onPause declenche");
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.println(Log.INFO , "methodes de levelActivity" , "onResume declenche");
    }


    public void finish(){
        Intent intent = new Intent();

        intent.putExtra("backMsg" , "here we goo!");
        intent.putExtra("launches" , nInstance);
        setResult(RESULT_OK , intent);

        super.finish();
    }


}