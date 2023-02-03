package gr303.hrynchak.severalactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    TextView txt;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = findViewById(R.id.editText2);
        switch1 = findViewById(R.id.switch_1);
        switch2 = findViewById(R.id.switch_2);

        Intent i = getIntent();

        String s = i.getStringExtra("text");
        Boolean state1 = i.getBooleanExtra("cb1", false);
        Boolean state2 = i.getBooleanExtra("cb2", false);

        txt.setText(s);
        switch1.setChecked(state1);
        switch2.setChecked(state2);
    }

    public void ok_OnClick(View v) {
        Intent i = new Intent();

        String s = txt.getText().toString();
        Boolean state1 = switch1.isChecked();
        Boolean state2 = switch2.isChecked();

        i.putExtra("text_return", s);
        i.putExtra("cb1_return", state1);
        i.putExtra("cb2_return", state2);

        setResult(RESULT_OK, i);
        finish();
    }

    public void cancel_OnClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}