package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NextActivity extends AppCompatActivity {

    public static final String KEY_DATA_RESULT = "result";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        Intent responsibleIntent = getIntent();
        Bundle bundle = responsibleIntent.getExtras();
        if(bundle != null)
            setData(bundle.getString(MainActivity.KEY_MY_NAME));

        final Button btnOkay = (Button) findViewById(R.id.btnOkay);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =
                        new Intent();
                Bundle bundle =
                        new Bundle();
                bundle.putString(KEY_DATA_RESULT,getData());

                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }

    private void setData(String text){
        ((EditText)findViewById(R.id.edtData)).setText(text);
    }

    private String getData(){
        return  ((EditText)findViewById(R.id.edtData))
                .getText()
                .toString();
    }
}
