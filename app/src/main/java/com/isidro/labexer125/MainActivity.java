package com.isidro.labexer125;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etParagraph;
    Button btnSave, btnDisplay, btnClear;
    TextView display;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etParagraph=(EditText) findViewById(R.id.editText);
        btnSave=(Button) findViewById(R.id.button);
        btnClear=(Button) findViewById(R.id.button2);
        btnDisplay=(Button) findViewById(R.id.button3);
        display=(TextView) findViewById(R.id.textView2);
        preferences = getPreferences(Context.MODE_PRIVATE);
    }

    public void Save(View view){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Paragraph", etParagraph.getText().toString());
        editor.commit();
        Toast.makeText(this, "Data is Saved", Toast.LENGTH_SHORT).show();
    }

    public void Display(View view){
        String Paragraph = preferences.getString("Paragraph", "");
        display.setText(Paragraph);
    }

    public void clear(View view){
        etParagraph.setText("");
    }


}
