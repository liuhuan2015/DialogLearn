package com.liuh.dialoglearn;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Date: 2018/2/5 09:37
 * Description:列表对话框
 */

public class ListDialogFragment extends DialogFragment {
    private String title;

    private String[] items;


    private DialogInterface.OnClickListener itemClickCallback;
    private DialogInterface.OnClickListener negativeCallback;

    public void show(String title, String[] items, DialogInterface.OnClickListener itemClickCallback,
                     DialogInterface.OnClickListener negativeCallback,
                     FragmentManager fragmentManager) {
        this.title = title;
        this.items = items;
        this.itemClickCallback = itemClickCallback;
        this.negativeCallback = negativeCallback;
        this.show(fragmentManager, "ListDialogFragment");
    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title);
        builder.setItems(items, itemClickCallback);
        builder.setNegativeButton("取消", negativeCallback);
        return builder.create();
    }
}
