package com.example.project_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edWorld;
    ImageView logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        logo =findViewById(R.id.imgLogo);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getBaseContext(),R.string.WelCome,Toast.LENGTH_LONG).show();
            }
        });
        edWorld = findViewById(R.id.edWorld);
        // hide keyboard
        edWorld.setInputType(InputType.TYPE_NULL);

// show keyboard when click on editext
        edWorld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edWorld.setInputType(InputType.TYPE_CLASS_TEXT);
                edWorld.requestFocus();
                InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                mgr.showSoftInput(edWorld, InputMethodManager.SHOW_FORCED);
            }
        });
        edWorld.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH){
                    edWorld.onEditorAction(EditorInfo.IME_ACTION_DONE);
                    Toast.makeText(getBaseContext(),edWorld.getText().toString(),Toast.LENGTH_LONG).show();
                    return true;
                }
                return false;
            }

        });


    }
}
