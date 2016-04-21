package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class Games extends AppCompatActivity {
    private String categoryName;
    private TextView word1;
    Firebase ref;

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
        chooseGame();
    }

    // Get game content - successfully changed words depending on Category chosen, now need to read content from Firebase

    public void chooseGame() {
        if (categoryName.equals("Fruit")) {
            word1.setText("banana");
        } else if (categoryName.equals("Animals")) {
            word1.setText("cat");
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

    public void playAudio(View view) {
        // Toast.makeText(Games.this, "Change this to play audio", Toast.LENGTH_SHORT).show();
        Firebase messagesRef = ref.child("Category/Tests");
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
