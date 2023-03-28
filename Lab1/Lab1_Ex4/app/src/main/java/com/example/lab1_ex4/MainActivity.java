package com.example.lab1_ex4;

import androidx.appcompat.app.AppCompatActivity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder alert_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText edit_text = findViewById(R.id.edit_text);
        alert_dialog = new AlertDialog.Builder(MainActivity.this);

        edit_text.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                    String message = edit_text.getText().toString();
                    alert_dialog.setMessage(message);
                    alert_dialog.show();
                    return true;
                }
                return false;
            }
        });
    }
}
