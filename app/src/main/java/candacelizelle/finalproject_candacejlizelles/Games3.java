package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Games3 extends AppCompatActivity {
    private String categoryName;
    private TextView word;
    private ImageButton topLeft;
    private ImageButton topRight;
    private ImageButton bottomLeft;
    private ImageButton bottomRight;
    public Score finalScore;
    private String word3;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen3);

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
            word3 = "orange";
            word.setText(word3);

            topLeft.setImageResource(R.drawable.orange);
            topRight.setImageResource(R.drawable.strawberry);
            bottomLeft.setImageResource(R.drawable.apple);
            bottomRight.setImageResource(R.drawable.banana);
        } else if (categoryName.equals("Animals")) {
            word3 = "rabbit";
            word.setText(word3);

            topLeft.setImageResource(R.drawable.rabbit);
            topRight.setImageResource(R.drawable.squirrel);
            bottomLeft.setImageResource(R.drawable.cat);
            bottomRight.setImageResource(R.drawable.dog);
        } else if (categoryName.equals("Colors")) {
            word3 = "blue";
            word.setText(word3);

            topLeft.setImageResource(R.drawable.blue);
            topRight.setImageResource(R.drawable.yellow);
            bottomLeft.setImageResource(R.drawable.red);
            bottomRight.setImageResource(R.drawable.green);
        } else {
            word.setText("Something went wrong");
        }
    }

    // We need to add a counter for the scoring -- FIX THIS! Should pass an intent to the results page
    public void setScore() {
        finalScore = new Score(0);
    }

    public void showResults(View view) {
        Intent intent = new Intent(Games3.this, Results.class);
        startActivity(intent);
    }

    public void incorrectAnswer(View view) {
        Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
        // this allows users to have one more try – otherwise, nothing will happen until you click the correct answer. Could eliminate need for scoring
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games3.this, Games4.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games3.this, Games4.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games3.this, Games4.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
    }

    public void correctAnswer(View view) {
        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Games3.this, Games4.class);
        intent.putExtra(BundleKey.NAME_KEY, categoryName);
        startActivity(intent);
    }
}

