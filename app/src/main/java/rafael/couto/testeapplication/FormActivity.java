package rafael.couto.testeapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

import rafael.couto.testeapplication.model.User;

public class FormActivity extends AppCompatActivity {
    private EditText etName;
    private EditText etSurname;
    private EditText etAge;
    private EditText etAddress;
    private CheckBox cbNewsletter;
    private RadioGroup rgGender;
    private RadioButton rbMale;
    private Spinner spDevices;
    private Switch swMarried;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_activity);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etName = findViewById(R.id.etName);
        etSurname = findViewById(R.id.etSurname);
        etAge = findViewById(R.id.etAge);
        etAddress = findViewById(R.id.etAddress);
        cbNewsletter = findViewById(R.id.cbNewsletter);
        rgGender = findViewById(R.id.rgGender);
        rbMale = findViewById(R.id.rbMale);
        spDevices = findViewById(R.id.spDevices);
        swMarried = findViewById(R.id.swMarried);
        Button button = findViewById(R.id.btnSave);

        button.setOnClickListener((v) -> build());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return false;
    }

    private void build() {
        User u = new User(
                etName.getText().toString(),
                etSurname.getText().toString(),
                Integer.parseInt(etAge.getText().toString()),
                etAddress.getText().toString(),
                cbNewsletter.isChecked(),
                rgGender.getCheckedRadioButtonId() == rbMale.getId() ? "M" : "F",
                spDevices.getSelectedItem().toString(),
                swMarried.isChecked()
        );

        Toast.makeText(this, u.toString(), Toast.LENGTH_SHORT).show();
    }
}
