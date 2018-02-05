package com.liuh.dialoglearn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Date: 2018/2/5 08:55
 * Description:对DialogFragment进行的封装
 * <p>
 * DialogFragment类本身有一个show(FragmentManager manager,String tag)方法,用于显示对话框,
 * "tag"参数是系统用于保存Fragment的状态并在必要时进行恢复的唯一名称,该标记还允许通过调用findFragmentByTag()获取Fragment的句柄.
 */

public class ButtonDialogFragment extends DialogFragment {

    private DialogInterface.OnClickListener positiveCallback;
    private DialogInterface.OnClickListener negativeCallback;

    private String title;

    private String message;

    public void show(String title, String message, DialogInterface.OnClickListener positiveCallback,
                     DialogInterface.OnClickListener negativeCallback, FragmentManager fragmentManager) {
        this.title = title;
        this.message = message;
        this.positiveCallback = positiveCallback;
        this.negativeCallback = negativeCallback;
        show(fragmentManager, "ButtonDialogFragment");
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setMessage(message);
        builder.setPositiveButton("确定", positiveCallback);
        builder.setNegativeButton("取消", negativeCallback);
        return builder.create();
    }
}
