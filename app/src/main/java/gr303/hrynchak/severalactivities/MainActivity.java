package gr303.hrynchak.severalactivities;

import static android.app.PendingIntent.getActivity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
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
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        View view = getLayoutInflater().inflate(R.layout.my_dialog, null);
        builder.setView(view);

        TextView title = view.findViewById(R.id.textView_title);
        title.setText(R.string.dialogTitle);
        TextView content = view.findViewById(R.id.textView_content);
        content.setText(R.string.dialogContent);

        AlertDialog dialog = builder.show();

        Button btnOk = view.findViewById(R.id.dialogBtn_ok);
        btnOk.setText(R.string.dialogPositive);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button btnCancel = view.findViewById(R.id.dialogBtn_cancel);
        btnCancel.setText(R.string.dialogNegative);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
}