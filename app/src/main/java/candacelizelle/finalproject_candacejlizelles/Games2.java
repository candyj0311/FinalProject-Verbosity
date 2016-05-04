package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Games2 extends AppCompatActivity {
    private String categoryName;
    private TextView word;
    private ImageButton topLeft;
    private ImageButton topRight;
    private ImageButton bottomLeft;
    private ImageButton bottomRight;
    public int score2;
    private TextView displayScore;
    private String word2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen2);

        Intent intent = getIntent();
        categoryName = getIntent().getStringExtra(BundleKey.NAME_KEY);
        score2 = intent.getIntExtra("score", 0);

        setTitle(categoryName);

        word = (TextView) findViewById(R.id.word);

        // ImageButtons
        topLeft = (ImageButton) findViewById(R.id.topLeft);
        topRight = (ImageButton) findViewById(R.id.topRight);
        bottomLeft = (ImageButton) findViewById(R.id.bottomLeft);
        bottomRight = (ImageButton) findViewById(R.id.bottomRight);

        displayScore = (TextView) findViewById(R.id.score);
        displayScore.setText("Score: " + score2);

        chooseGame(); // method below to display different content depending on category chosen
    }

    public void chooseGame() {
        if (categoryName.equals("Fruit")) {
            word2 = "apple";

            word.setText(word2);
            topLeft.setImageResource(R.drawable.banana);
            topRight.setImageResource(R.drawable.strawberry);
            bottomLeft.setImageResource(R.drawable.orange);
            bottomRight.setImageResource(R.drawable.apple);
        } else if (categoryName.equals("Animals")) {
            word2 = "cat";

            word.setText(word2);
            topLeft.setImageResource(R.drawable.rabbit);
            topRight.setImageResource(R.drawable.squirrel);
            bottomLeft.setImageResource(R.drawable.dog);
            bottomRight.setImageResource(R.drawable.cat);
        } else if (categoryName.equals("Colors")) {
            word2 = "green";

            word.setText(word2);
            topLeft.setImageResource(R.drawable.yellow);
            topRight.setImageResource(R.drawable.red);
            bottomLeft.setImageResource(R.drawable.blue);
            bottomRight.setImageResource(R.drawable.green);
        } else {
            word.setText("Something went wrong");
        }
    }

    public void quitGame(View view) {
        Intent intent = new Intent(Games2.this, MainActivity.class);
        startActivity(intent);
    }

    public void incorrectAnswer(View view) {
        Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games2.this, Games3.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                intent.putExtra("score", score2);
                startActivity(intent);
            }
        });
        topRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games2.this, Games3.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                intent.putExtra("score", score2);
                startActivity(intent);
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games2.this, Games3.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                intent.putExtra("score", score2);
                startActivity(intent);
            }
        });
    }

    public void correctAnswer(View view) {
        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        score2++;

        Intent intent = new Intent(Games2.this, Games3.class);
        intent.putExtra(BundleKey.NAME_KEY, categoryName);
        intent.putExtra("score", score2);
        startActivity(intent);
    }
}
