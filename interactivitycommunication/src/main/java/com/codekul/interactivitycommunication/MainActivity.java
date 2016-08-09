package com.codekul.interactivitycommunication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_MY_NAME = "myName";
    private static final int REQ_NEXT = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOkay = (Button) findViewById(R.id.btnNext);
        btnOkay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Class cls = NextActivity.class;

                Intent intent =
                        new Intent(MainActivity.this,cls);

                Bundle bundle =
                        new Bundle();
                bundle.putString(KEY_MY_NAME,getMyName());
                intent.putExtras(bundle);

                //startActivity(intent);
                startActivityForResult(intent,REQ_NEXT);
            }
        });
    }

    private String getMyName(){

        return ((EditText)findViewById(R.id.edtName))
                .getText()
                .toString();
    }

    private void setMyName(String text){
        ((EditText)findViewById(R.id.edtName)).setText(text);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQ_NEXT){

            if(resultCode == RESULT_OK){

                Bundle bundle = data.getExtras();
                String res = bundle.getString(NextActivity.KEY_DATA_RESULT);

                setMyName(res);
            }
        }
    }
}
