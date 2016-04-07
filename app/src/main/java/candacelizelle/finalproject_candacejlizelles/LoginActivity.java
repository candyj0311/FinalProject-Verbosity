
package candacelizelle.finalproject_candacejlizelles;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.AuthData;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private Firebase firebase;
    private EditText emailEditText;
    private EditText passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Log in");

        firebase = new Firebase("https://finalprojectcjls.firebaseio.com/");
        emailEditText = (EditText) findViewById(R.id.edit_text_email);
        passwordEditText = (EditText) findViewById(R.id.edit_text_password);
    }

    public void LogIn(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        firebase.authWithPassword(email, password, new Firebase.AuthResultHandler() {
            @Override
            public void onAuthenticated(AuthData authData) {
                Toast.makeText(LoginActivity.this, "We would not include login IRL, only in class", Toast.LENGTH_LONG).show();
                finish();
            }

            @Override
            public void onAuthenticationError(FirebaseError firebaseError) {
                Toast.makeText(LoginActivity.this, "Unable to log in", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void SignUp(View view) {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        firebase.createUser(email, password, new Firebase.ValueResultHandler<Map<String, Object>>() {
            @Override
            public void onSuccess(Map<String, Object> result) {
                Toast.makeText(LoginActivity.this, "Successfully created user account with uid: " + result.get("uid"), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onError(FirebaseError firebaseError) {
                Toast.makeText(LoginActivity.this, "Unable to Sign Up: " + firebaseError.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}