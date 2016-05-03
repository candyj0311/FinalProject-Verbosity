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
    public Score finalScore;
    private String word2;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen2);

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
    }

    // Get game content - successfully changed words depending on Category chosen, now need to read content from Firebase
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

    // We need to add a counter for the scoring -- FIX THIS! Should pass an intent to the results page
    public void setScore() {
        finalScore = new Score(0);
        finalScore.addPoint();
    }

    public void showResults(View view) {
        Intent intent = new Intent(Games2.this, Results.class);
        startActivity(intent);
    }

    public void incorrectAnswer(View view) {
        Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games2.this, Games3.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
    }

    public void correctAnswer(View view) {
        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Games2.this, Games3.class);
        intent.putExtra(BundleKey.NAME_KEY, categoryName);
        startActivity(intent);
    }
}
