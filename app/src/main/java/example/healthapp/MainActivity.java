package example.healthapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void click(View view) {
        Intent intent = new Intent(MainActivity.this, Login_Screen.class);
        startActivity(intent);
    }

    public void clickRegister(View view) {
        Intent intent = new Intent(MainActivity.this, Register.class);
        startActivity(intent);
    }
}
