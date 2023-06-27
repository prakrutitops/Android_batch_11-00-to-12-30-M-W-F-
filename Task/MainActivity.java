package com.example.nnumberedittext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private LinearLayout lnrDynamicEditTextHolder;
    private EditText edtNoCreate;
    private Button btnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        lnrDynamicEditTextHolder = (LinearLayout) findViewById(R.id.lnrDynamicEditTextHolder);
        edtNoCreate = (EditText) findViewById(R.id.edtNoCreate);
        btnCreate = (Button) findViewById(R.id.btnCreate);


        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edtNoCreate.getText().toString().length()>0) {
                    try {
                        lnrDynamicEditTextHolder.removeAllViews();
                    } catch (Throwable e) {
                        e.printStackTrace();
                    }

                    int length = Integer.parseInt(edtNoCreate.getText().toString());

                    for (int i=0;i<length;i++){
                        EditText editText = new EditText(MainActivity.this);
                        editText.setId(i+1);
                        editText.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                        editText.setHint("EditText "+(i+1));
                        lnrDynamicEditTextHolder.addView(editText);
                    }
                }
            }
        });
    }
}
