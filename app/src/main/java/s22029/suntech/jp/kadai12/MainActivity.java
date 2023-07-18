package s22029.suntech.jp.kadai12;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btConfirm = findViewById(R.id.btConfirm);
        MailListener listener = new MailListener();
        btConfirm.setOnClickListener(listener);
        Button btSend = findViewById(R.id.btSend);
        btSend.setOnClickListener(listener);
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
    }
    private class MailListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            EditText inputTitle = findViewById(R.id.etTitle);
            EditText inputName = findViewById(R.id.etName);
            EditText inputMail = findViewById(R.id.etMail);
            EditText inputComment = findViewById(R.id.etComment);
            String name = inputName.getText().toString();
            String title = inputTitle.getText().toString();
            String mail = inputMail.getText().toString();
            String comment = inputComment.getText().toString();
            String show = "名前：" + name + "タイトル：" + title +
                    "メールアドレス：" + mail + "質問内容：" + comment;
            int id = v.getId();
            if(id == R.id.btSend){
                Snackbar.make(v,show,Snackbar.LENGTH_LONG).show();
            }
            else if(id == R.id.btConfirm){
                MailConfirmDialogFragment dialogFragment = new MailConfirmDialogFragment();
                dialogFragment.show(getSupportFragmentManager(),"MailConfirmDialogFragment");
            }
            else if(id == R.id.btClear){
                inputTitle.setText("");
                inputName.setText("");
                inputMail.setText("");
                inputComment.setText("");
            }
        }
    }
}
