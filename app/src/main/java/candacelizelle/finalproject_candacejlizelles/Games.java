package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Games extends AppCompatActivity {
    private String categoryName;
    private TextView word;
    private ImageButton topLeft;
    private ImageButton topRight;
    private ImageButton bottomLeft;
    private ImageButton bottomRight;
    public int score = 0;
    private TextView displayScore;
    private String word1;

    MediaPlayer wordAudio;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen1);

        // ref = new Firebase("https://finalprojectcjls.firebaseio.com/");

        Intent intent = getIntent();
        categoryName = getIntent().getStringExtra(BundleKey.NAME_KEY);
        setTitle(categoryName);

        word = (TextView) findViewById(R.id.word);

        // ImageButtons
        topLeft = (ImageButton) findViewById(R.id.topLeft);
        topRight = (ImageButton) findViewById(R.id.topRight);
        bottomLeft = (ImageButton) findViewById(R.id.bottomLeft);
        bottomRight = (ImageButton) findViewById(R.id.bottomRight);

        displayScore = (TextView) findViewById(R.id.score);
        displayScore.setText("Score: " + score);

        chooseGame(); // method below to display different content depending on category chosen
    }

    // Get game content - successfully changed words depending on Category chosen, now need to read content from Firebase
    public void chooseGame() {
        if (categoryName.equals("Fruit")) {
            word1 = "banana";
            word.setText(word1);
            wordAudio = MediaPlayer.create(this, R.raw.banana);

            topLeft.setImageResource(R.drawable.apple);
            topRight.setImageResource(R.drawable.banana);
            bottomLeft.setImageResource(R.drawable.orange);
            bottomRight.setImageResource(R.drawable.strawberry);
        } else if (categoryName.equals("Animals")) {
            word1 = "dog";
            word.setText(word1);
            wordAudio = MediaPlayer.create(this, R.raw.dog);

            topLeft.setImageResource(R.drawable.cat);
            topRight.setImageResource(R.drawable.dog);
            bottomLeft.setImageResource(R.drawable.squirrel);
            bottomRight.setImageResource(R.drawable.rabbit);
        } else if (categoryName.equals("Colors")) {
            word1 = "red";
            word.setText(word1);
            wordAudio = MediaPlayer.create(this, R.raw.red);

            topLeft.setImageResource(R.drawable.blue);
            topRight.setImageResource(R.drawable.red);
            bottomLeft.setImageResource(R.drawable.green);
            bottomRight.setImageResource(R.drawable.yellow);
        } else {
            word.setText("Something went wrong");
        }
    }

    public void playAudio(View view) {
        wordAudio.start();
    }

    public void quitGame(View view) {
        Intent intent = new Intent(Games.this, MainActivity.class);
        startActivity(intent);
    }

    public void incorrectAnswer(View view) {
        Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
        // this allows users to have one more try
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games.this, Games2.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games.this, Games2.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games.this, Games2.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                intent.putExtra("score", score);
                startActivity(intent);
            }
        });
    }

    public void correctAnswer(View view) {
        score = 1;

        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Games.this, Games2.class);
        intent.putExtra(BundleKey.NAME_KEY, categoryName);
        intent.putExtra("score", score);
        startActivity(intent);
    }
}

