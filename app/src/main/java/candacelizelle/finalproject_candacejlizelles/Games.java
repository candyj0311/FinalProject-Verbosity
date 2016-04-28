package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Games extends AppCompatActivity {
    private String categoryName;
    private TextView word1;
    Firebase ref;
    private ImageButton topLeft;
    private ImageButton topRight;
    private ImageButton bottomLeft;
    private ImageButton bottomRight;
    private Question q1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_screen1);

        ref = new Firebase("https://finalprojectcjls.firebaseio.com/");

        Intent intent = getIntent();
        categoryName = getIntent().getStringExtra(BundleKey.NAME_KEY);
        setTitle(categoryName);

        // Repeat this process for words 2-4
        word1 = (TextView) findViewById(R.id.word);

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
            word1.setText("banana");
        } else if (categoryName.equals("Animals")) {
            readAnimalData(); // method I created below to read Firebase test data
            topLeft.setImageResource(R.drawable.cat);
            topRight.setImageResource(R.drawable.dog);
            bottomLeft.setImageResource(R.drawable.squirrel);
            bottomRight.setImageResource(R.drawable.rabbit);
        } else if (categoryName.equals("Colors")) {
            word1.setText("orange");
        } else {
            word1.setText("Something went wrong");
        }
    }

    //We need to add a counter for the scoring

    public void showResults(View view) {
        Intent intent = new Intent(Games.this, Results.class);
        startActivity(intent);
    }

    public void readAnimalData() {
        Firebase messagesRef = ref.child("Category/TestAnimals/"); // another test copying Xi's code
        messagesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Object obj = dataSnapshot.getValue();
                q1 = dataSnapshot.getValue(Question.class);
                // Log.d("xizz", q1.question);
                // Word w = q1.words.get("w1");
                word1.setText(q1.question);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void playAudio(View view) {
        Firebase messagesRef = ref.child("Category/Tests"); // this was the test Xi created in class
        messagesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Object obj = dataSnapshot.getValue();
                q1 = dataSnapshot.getValue(Question.class);
                Log.d("xizz", q1.question);
                Word w = q1.words.get("w1");
                word1.setText(q1.question);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    public void button1Pressed(View view) {
        Toast.makeText(this, "This is a test", Toast.LENGTH_SHORT);
        // Test to use our actual info
        Firebase messagesRef = ref.child("Category/Tests"); // this was the test Xi created in class
        messagesRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Object obj = dataSnapshot.getValue();
                Question question = dataSnapshot.getValue(Question.class);
                Log.d("xizz", question.question);
                Word w = question.words.get("w1");
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }
}
