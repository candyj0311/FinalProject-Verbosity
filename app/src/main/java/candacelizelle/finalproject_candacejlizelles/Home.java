package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void playGame(View view) {
        // Create an intent to load the CategoryViewHolder activity
        Intent intent = new Intent(Home.this, CategoriesPage.class);
        startActivity(intent);
    }

    public void changeSettings(View view) {
        // Go to Settings page
        Toast.makeText(Home.this, "We'll ask Xi Wei about this stuff", Toast.LENGTH_SHORT).show();
    }

    public void showStickers(View view) {
        // Go to Stickers page
        Toast.makeText(Home.this, "This is a possible enhancement", Toast.LENGTH_SHORT).show();
    }

    public void createGame(View view) {
        Intent intent = new Intent(Home.this, CreateGame.class);
        startActivity(intent);
    }
}
