package app.com.application.rustymattok.geoquez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class GeoActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private ImageButton nextButton;
    private ImageButton backButton;
    private Button cheatButton;
    private TextView textView;
    private int index = 0;
    private ArrayList<TrueFalse> listQuestions = new ArrayList<>();
    private final static String TAG = "GeoActivity";
    private final static String KEY_INDEX = "index";
    private boolean ischeat;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "on creat(Bundle) ");
        setContentView(R.layout.activity_geo);
        if (savedInstanceState != null){
           index = savedInstanceState.getInt(KEY_INDEX,0);
        }
        listQuestions.add(new TrueFalse(R.string.question_index1, true));
        listQuestions.add(new TrueFalse(R.string.question_index2, false));
        listQuestions.add(new TrueFalse(R.string.question_index3,false));
        listQuestions.add(new TrueFalse(R.string.question_index4,true));
        listQuestions.add(new TrueFalse(R.string.question_index5,false));

        trueButton = (Button) findViewById(R.id.trueButton);
        falseButton = (Button) findViewById(R.id.falseButton);
        nextButton = (ImageButton) findViewById(R.id.nextButton);
        backButton = (ImageButton) findViewById(R.id.backButton);
        textView = (TextView) findViewById(R.id.question_index);
        textView.setText(listQuestions.get(index).getIndexQuestions());
        cheatButton = (Button) findViewById(R.id.button_cheat);
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in = new Intent(GeoActivity.this,CheatActivity.class);
                boolean answer = listQuestions.get(index).isQuestion();
                in.putExtra(CheatActivity.KEY_ANSWER,answer);
                startActivityForResult(in, 0);
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                index --;
                if(index % listQuestions.size() == 0 || index < 0){
                    index = 0;
                }
                textView.setText(listQuestions.get(index).getIndexQuestions());
                ischeat = false;
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextQuestion();
            }
        });
        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ischeat){
                    Toast.makeText(GeoActivity.this,  R.string.toast_alarm, Toast.LENGTH_SHORT).show();
                }
                  else if(listQuestions.get(index).isQuestion()) {
                    Toast.makeText(GeoActivity.this, R.string.correct_item, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(GeoActivity.this, R.string.uncorrect_item, Toast.LENGTH_SHORT).show();
                }
            }
        });
        falseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ischeat){
                    Toast.makeText(GeoActivity.this, R.string.toast_alarm, Toast.LENGTH_SHORT).show();
                }
                else if(!listQuestions.get(index).isQuestion()) {
                    Toast.makeText(GeoActivity.this, R.string.correct_item, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(GeoActivity.this, R.string.uncorrect_item, Toast.LENGTH_SHORT).show();
                }
            }
        });
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ischeat = false;
              nextQuestion();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data == null){
            return;
        }
        ischeat = data.getBooleanExtra(CheatActivity.KEY_ANSWER_SHOW,false);
    }

    @Override
    protected  void onStart(){
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }


    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG,"onSaveInstanceState called");
        outState.putInt(KEY_INDEX,index);
    }

    public void nextQuestion(){
        index ++;
        if(index % listQuestions.size() == 0){
            index = 0;
        }
        textView.setText(listQuestions.get(index).getIndexQuestions());
    }
}
