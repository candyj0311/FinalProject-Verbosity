package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.firebase.client.Firebase;

public class MainActivity extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

//    private EditText keyEditText;
//    private EditText valueEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        keyEditText = (EditText) findViewById(R.id.edit_text_key);
//        valueEditText = (EditText) findViewById(R.id.edit_text_value);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://finalprojectcjls.firebaseio.com");

/*
        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
*/
    }

    public void playGame(View view) {
        // Create an intent to load the CategoryViewHolder activity
        Intent intent = new Intent(MainActivity.this, CategoriesPage.class);
        startActivity(intent);
    }

    public void showStickers(View view) {
        // Go to Stickers page
        Toast.makeText(MainActivity.this, "This is a possible enhancement", Toast.LENGTH_SHORT).show();
    }

//    public void readFromCloud(View view) {
//        if (userRef == null) return;
//        userRef.child(keyEditText.getText().toString()).addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot snapshot) {
//                if (snapshot.getValue() != null) {
//                    valueEditText.setText(snapshot.getValue().toString());
//                } else {
//                    valueEditText.setText("");
//                    Toast.makeText(MainActivity.this, "Nope: " + keyEditText.getText().toString(), Toast.LENGTH_LONG).show();
//                }
//            }
//
//            @Override
//            public void onCancelled(FirebaseError error) {
//                Toast.makeText(MainActivity.this, "Error: " + error.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
//
//    @Override
//    protected void onResume() {
//        super.onResume();
//        rootRef.addAuthStateListener(authStateListener);
//    }
//
//    @Override
//    protected void onPause() {
//        super.onPause();
//        rootRef.removeAuthStateListener(authStateListener);
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.log_out:
                rootRef.unauth();
//                keyEditText.setText("");
//                valueEditText.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
