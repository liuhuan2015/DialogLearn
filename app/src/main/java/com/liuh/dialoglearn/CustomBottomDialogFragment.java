package com.liuh.dialoglearn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;

/**
 * Date: 2018/2/5 10:14
 * Description:自定义对话框
 * 自定义对话框其实就是使用AlertDialog类的setView方法把自定义的布局设置进去,然后使用回调方法进行一些回调处理
 */
public class CustomBottomDialogFragment extends DialogFragment {

    public interface ResultCallback {
        void getResult(String name, String password);
    }

    private ResultCallback resultCallback;


    public void show(ResultCallback resultCallback, FragmentManager fragmentManager) {
        this.resultCallback = resultCallback;
        show(fragmentManager, "CustomBottomDialogFragment");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View view = View.inflate(getActivity(), R.layout.layout_bottom_dialog, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.windowAnimationStyle);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();

        Window window = alertDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();
        wlp.height = WindowManager.LayoutParams.WRAP_CONTENT;

        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);

        return alertDialog;
    }
}
