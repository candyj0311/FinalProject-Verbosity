package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);
    }

    public void playAgain(View view) {
        Toast.makeText(Results.this, "How do I do this?", Toast.LENGTH_SHORT).show();
    }

    public void chooseAnotherGame(View view) {
        Intent intent = new Intent(Results.this, CategoriesPage.class);
        startActivity(intent);
    }
}