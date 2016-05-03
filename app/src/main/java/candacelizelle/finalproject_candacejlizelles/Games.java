package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class Games extends AppCompatActivity {
    private String categoryName;
    private TextView word;
    Firebase ref;
    private ImageButton topLeft;
    private ImageButton topRight;
    private ImageButton bottomLeft;
    private ImageButton bottomRight;
    private Question q1;
    public Score finalScore;
    private String word1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen1);

        ref = new Firebase("https://finalprojectcjls.firebaseio.com/");

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
            word1 = "banana";
            word.setText(word1);

            topLeft.setImageResource(R.drawable.apple);
            topRight.setImageResource(R.drawable.banana);
            bottomLeft.setImageResource(R.drawable.orange);
            bottomRight.setImageResource(R.drawable.strawberry);
        } else if (categoryName.equals("Animals")) {
            word1 = "dog";
            word.setText(word1);

            topLeft.setImageResource(R.drawable.cat);
            topRight.setImageResource(R.drawable.dog);
            bottomLeft.setImageResource(R.drawable.squirrel);
            bottomRight.setImageResource(R.drawable.rabbit);
        } else if (categoryName.equals("Colors")) {
            word1 = "red";
            word.setText(word1);

            topLeft.setImageResource(R.drawable.blue);
            topRight.setImageResource(R.drawable.red);
            bottomLeft.setImageResource(R.drawable.green);
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
        Intent intent = new Intent(Games.this, Results.class);
        startActivity(intent);
    }

//    public void readAnimalData() {
//        Firebase messagesRef = ref.child("Category/TestAnimals/"); // another test copying Xi's code
//        messagesRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Object obj = dataSnapshot.getValue();
//                q1 = dataSnapshot.getValue(Question.class);
//                // Log.d("xizz", q1.question);
//                // Word w = q1.words.get("w1");
//                word.setText(q1.question);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//    }
//
//    public void playAudio(View view) {
//        Firebase messagesRef = ref.child("Category/Tests"); // this was the test Xi created in class
//        messagesRef.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
//                Object obj = dataSnapshot.getValue();
//                q1 = dataSnapshot.getValue(Question.class);
//                Log.d("xizz", q1.question);
//                Word w = q1.words.get("w1");
//                word.setText(q1.question);
//            }
//
//            @Override
//            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(DataSnapshot dataSnapshot, String s) {
//
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//
//            }
//        });
//    }

    public void incorrectAnswer(View view) {
        Toast.makeText(this, "Try again!", Toast.LENGTH_SHORT).show();
        // this allows users to have one more try – otherwise, nothing will happen until you click the correct answer. Could eliminate need for scoring
        topLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games.this, Games2.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
        bottomLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games.this, Games2.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
        bottomRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Games.this, Games2.class);
                intent.putExtra(BundleKey.NAME_KEY, categoryName);
                startActivity(intent);
            }
        });
    }

    public void correctAnswer(View view) {
        finalScore.addPoint();
        finalScore.getScore();

        Toast.makeText(this, ":)", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Games.this, Games2.class);
        intent.putExtra(BundleKey.NAME_KEY, categoryName);
        startActivity(intent);
    }
}

