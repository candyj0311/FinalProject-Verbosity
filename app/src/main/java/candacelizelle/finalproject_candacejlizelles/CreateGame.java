package candacelizelle.finalproject_candacejlizelles;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;

public class CreateGame extends AppCompatActivity {
    private Firebase rootRef;
    private Firebase userRef;
    private Firebase.AuthStateListener authStateListener;

    private EditText categoryNameEditText;
//    private EditText valueEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_game);

        categoryNameEditText = (EditText) findViewById(R.id.edit_category_name);
        //add more entries for the words
        //Do we need a value?
        //valueEditText = (EditText) findViewById(R.id.edit_text_value);

        Firebase.setAndroidContext(this);
        rootRef = new Firebase("https://finalprojectcjls.firebaseio.com");

        authStateListener = new Firebase.AuthStateListener() {
            @Override
            public void onAuthStateChanged(AuthData authData) {
                if (authData != null) {
                    userRef = rootRef.child("users/" + authData.getUid());
                } else {
                    Intent intent = new Intent(CreateGame.this, LoginActivity.class);
                    startActivity(intent);
                }
            }
        };
    }

    public void writeToCloud(View view) {
        if (userRef != null)
            userRef.child(categoryNameEditText.getText().toString()).setValue("category");
    }

    @Override
    protected void onResume() {
        super.onResume();
        rootRef.addAuthStateListener(authStateListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        rootRef.removeAuthStateListener(authStateListener);
    }

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
                categoryNameEditText.setText("");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void goHome(View view) {
        Intent intent = new Intent(CreateGame.this, Home.class);
        startActivity(intent);
    }
}
