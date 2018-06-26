package rafael.couto.testeapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnList = findViewById(R.id.btnList);
        Button btnForm = findViewById(R.id.btnForm);

        btnList.setOnClickListener(
                (v) -> startActivity(new Intent(MainActivity.this, ListActivity.class))
        );

        btnForm.setOnClickListener(
                (v) -> startActivity(new Intent(MainActivity.this, FormActivity.class))
        );
    }
}