package s22029.suntech.jp.kadai12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;


public class MailConfirmDialogFragment extends DialogFragment {
    @NonNull
    public Dialog onCreateDialog(@NonNull Bundle saveInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title);
        builder.setMessage(R.string.dialog_msg);
        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;
    }

    private class DialogButtonClickListener implements DialogInterface.OnClickListener{
        @Override
        public void onClick(DialogInterface dialog, int which) {
            EditText inputTitle = getActivity().findViewById(R.id.etTitle);
            EditText inputName = getActivity().findViewById(R.id.etName);
            EditText inputMail = getActivity().findViewById(R.id.etMail);
            EditText inputComment = getActivity().findViewById(R.id.etComment);
            String name = inputName.getText().toString();
            String title = inputTitle.getText().toString();
            String mail = inputMail.getText().toString();
            String comment = inputComment.getText().toString();
            String show = "名前：" + name + "タイトル：" + title +
                    "メールアドレス：" + mail + "質問内容：" + comment;
            String msg = "";
            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:
                    msg = show;
                    break;
                case DialogInterface.BUTTON_NEGATIVE:
                    msg = getString(R.string.dialog_ng_toast);
                    break;
            }
            Toast.makeText(getActivity(),msg,Toast.LENGTH_LONG).show();
        }
    }
}
