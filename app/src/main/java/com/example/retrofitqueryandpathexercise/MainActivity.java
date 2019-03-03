package com.example.retrofitqueryandpathexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.retrofitqueryandpathexercise.frag.MainFragment;

public class MainActivity extends AppCompatActivity {
    public static final String NUMBER = "number";
    TextView textView;
    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.pick_number_textview);
        editText = findViewById(R.id.enter_num_edittext);
        button = findViewById(R.id.submit_button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(editText.getText().toString());
                moveToFragment(number);
            }
        });

    }

    public void moveToFragment(int number) {
        MainFragment mainFragment = MainFragment.newInstance();
        Bundle args = new Bundle();
        args.putInt(NUMBER, number);
        mainFragment.setArguments(args);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_container, mainFragment)
                .addToBackStack(null)
                .commit();
    }
}
