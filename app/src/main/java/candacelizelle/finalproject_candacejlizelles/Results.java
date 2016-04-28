package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {
    private TextView showScore;
    private TextView showMessage;
    private ImageView showSticker;
    public Score finalScore;
    public String numberAsString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.results);

        showScore = (TextView) findViewById(R.id.score);
        showMessage = (TextView) findViewById(R.id.message);
        showSticker = (ImageView) findViewById(R.id.victorySticker);

        // Created a Score class -- need to tie this to Games activity
        finalScore = new Score(0); // fix this -- should pass intent from Games score
        numberAsString = String.valueOf(finalScore.getScore());

        // Set message and sticker depending on score
        if (finalScore.getScore() == 4) {
            showScore.setText("You got " + numberAsString + "/4!");
            showMessage.setText(R.string.perfect);
            showSticker.setImageResource(R.drawable.trophy);
        } else if (finalScore.getScore() >= 3) {
            showScore.setText("You got " + numberAsString + "/4!");
            showMessage.setText(R.string.great_job);
            showSticker.setImageResource(R.drawable.trophy);
        } else if (finalScore.getScore() <= 2) {
            showScore.setText("You got " + numberAsString + "/4");
            showMessage.setText(R.string.keep_trying);
            showSticker.setImageResource(R.drawable.star);
        }
    }

    public void playAgain(View view) {
        Toast.makeText(Results.this, "How do I do this?", Toast.LENGTH_SHORT).show();
    }

    public void chooseAnotherGame(View view) {
        Intent intent = new Intent(Results.this, CategoriesPage.class);
        startActivity(intent);
    }
}