package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Games extends AppCompatActivity {
    private String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen1);

        Intent intent = getIntent();
        categoryName = getIntent().getStringExtra(BundleKey.NAME_KEY);
        setTitle(categoryName);

// Why is this so complex?
//        if (categoryName.equals("Fruit")) {}
    }


    public void showResults(View view) {
        Intent intent = new Intent(Games.this, Results.class);
        startActivity(intent);
    }
}