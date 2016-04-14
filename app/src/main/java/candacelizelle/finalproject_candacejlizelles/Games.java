package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Games extends AppCompatActivity {
    private String categoryName;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen1);

        Intent intent = getIntent();
        categoryName = getIntent().getStringExtra(BundleKey.NAME_KEY);
        setTitle(categoryName);

// Get game content - which way do we want to do this? Xi says not to use Firebase
        //We need to add a counter for the scoring

    }

    public void showResults(View view) {
        Intent intent = new Intent(Games.this, Results.class);
        startActivity(intent);
    }

    public void playAudio(View view) {
        Toast.makeText(Games.this, "Change this to play audio", Toast.LENGTH_SHORT).show();
    }
}
