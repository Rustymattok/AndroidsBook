package app.com.application.rustymattok.geoquez;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {


    final static String KEY_ANSWER = "app.com.application.rustymattok.geoquez";
    final static String KEY_ANSWER_SHOW = "app.com.application.rustymattok.geoquez.answer_show";
    private boolean answer = false;
    private Button showButton;
    private TextView textView ;

    private void setAnswerShowRezult(boolean isShow){
        Intent data = new Intent();
        data.putExtra(KEY_ANSWER_SHOW,isShow);
        setResult(RESULT_OK,data);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        answer = getIntent().getBooleanExtra(KEY_ANSWER,false);
        textView = (TextView) findViewById(R.id.text_show);
        showButton = (Button) findViewById(R.id.button_show);
        setAnswerShowRezult(false);
        showButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAnswerShowRezult(true);
                if (answer){
                    textView.setText(R.string.true_button);
                }else {
                    textView.setText(R.string.false_button);
                }
            }
        });

    }


}
