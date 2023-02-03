package gr303.hrynchak.severalactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txt;

    CheckBox chk1, chk2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.editText);

        chk1 = findViewById(R.id.checkBox_1);
        chk2 = findViewById(R.id.checkBox_2);
    }

    public void OpenDialog_OnClick(View v) {
        String s = txt.getText().toString();
        Boolean state1 = chk1.isChecked();
        Boolean state2 = chk2.isChecked();

        Intent i = new Intent(this, MainActivity2.class);
        i.putExtra("text", s);
        i.putExtra("cb1", state1);
        i.putExtra("cb2", state2);

        startActivityForResult(i, 555);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 555) {
            if (data != null) {
                String s = data.getStringExtra("text_return");
                Boolean state1 = data.getBooleanExtra("cb1_return", false);
                Boolean state2 = data.getBooleanExtra("cb2_return", false);

                Toast.makeText(this, s, Toast.LENGTH_SHORT).show();

                txt.setText(s);
                chk1.setChecked(state1);
                chk2.setChecked(state2);
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public void ExitApp_OnClick(View v) {
        //ToDo LayoutInflater
        finish();
    }
}