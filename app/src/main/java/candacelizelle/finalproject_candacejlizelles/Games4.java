package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Games4 extends AppCompatActivity {
    private String categoryName;
    private TextView word;
    private ImageButton topLeft;
    private ImageButton topRight;
    private ImageButton bottomLeft;
    private ImageButton bottomRight;
    public Score finalScore;
    private String word4;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen4);

        Intent intent = getIntent();
        categoryName = getIntent().getStringExtra(BundleKey.NAME_KEY);
        setTitle(categoryName);

        word = (TextView) findViewById(R.id.word);

        // ImageButtons
        topLeft = (ImageButton) findViewById(R.id.topLeft);
        topRight = (ImageButton) findViewById(R.id.topRight);
        bottomLeft = (ImageButton) findViewById(R.id.bottomLeft);
        bottomRight = (ImageButton) findViewById(R.id.bottomRight);

        chooseGame(); // method below to display different content depending on category chosen
        setScore();
    }

    // Get game content - successfully changed words depending on Category chosen, now need to read content from Firebase
    public void chooseGame() {
        if (categoryName.equals("Fruit")) {
            word4 = "strawberry";
            word.setText(word4);

            topLeft.setImageResource(R.drawable.banana);
            topRight.setImageResource(R.drawable.apple);
            bottomLeft.setImageResource(R.drawable.orange);
            bottomRight.setImageResource(R.drawable.strawberry);
        } else if (categoryName.equals("Animals")) {
            word4 = "squirrel";
            word.setText(word4);

            topLeft.setImageResource(R.drawable.cat);
            topRight.setImageResource(R.drawable.rabbit);
            bottomLeft.setImageResource(R.drawable.dog);
            bottomRight.setImageResource(R.drawable.squirrel);
        } else if (categoryName.equals("Colors")) {
            word4 = "yellow";
            word.setText(word4);

            topLeft.setImageResource(R.drawable.green);
            topRight.setImageResource(R.drawable.red);
            bottomLeft.setImageResource(R.drawable.yellow);
            bottomRight.setImageResource(R.drawable.yellow);
        } else {
            word.setText("Something went wrong");
        }
    }

    // We need to add a counter for the scoring -- FIX THIS! Should pass an intent to the results page
    public void setScore() {
        finalScore = new Score(0);
    }

    public void showResults(View view) {
        Intent intent = new Intent(Games4.this, Results.class);
        startActivity(intent);
    }

    public void incorrectAnswer(View view) {
        Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
        // this allows users to have one more try – otherwise, nothing will happen until you click the correct answer. Could eliminate need for scoring
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games4.this, Results.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games4.this, Results.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games4.this, Results.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
    }

    public void correctAnswer(View view) {
        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Games4.this, Results.class);
        intent.putExtra(BundleKey.NAME_KEY, categoryName);
        startActivity(intent);
    }
}

