package com.liuh.dialoglearn;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Date: 2018/2/3 09:02
 * Description:对话框是提示用户做出决定或者输入额外信息的小窗口,通常不会填充整个屏幕,用于进行一些额外交互
 * Dialog类是对话框的基类,但是我们应该避免直接实例化Dialog,而应使用其子类,比如:
 * <p>
 * AlertDialog:此对话框可显示标题、提示信息、按钮、可选择项列表或自定义布局等
 * <p>
 * DatePickerDialog或TimePickerDialog:此类对话框带有允许用户选择日期或时间的预定义UI
 * <p>
 * 这些类定义了对话框的样式和结构,但开发者应该将DialogFragment用作对话框的容器.
 * DialogFragment类提供了创建对话框和管理其外观所需的所有控件,而不是调用Dialog对象上的方法
 * <p>
 * 使用DialogFragment管理对话框可以确保它能正确处理生命周期事件,如用户按"返回"按钮或者旋转屏幕时.
 * 此外,DialogFragment类还允许将对话框的UI作为嵌入式组件在较大UI中重复使用,就像传统Fragment一样.
 * <p>
 * DialogFragment类最初是在Android 3.0(API 11)添加的,如果想要让其运行在API 11以前的设备上,应使用
 * android.support.v4.app.DialogFragment,如果应用支持的最低版本大于或等于API 11,则可以使用
 * android.app.DialogFragment.
 *
 * onCreateView:使用自定义的xml布局文件来展示Dialog
 * onCreateDialog:利用AlertDialog或者Dialog来创建Dialog
 */

public class MyDialogFragment extends DialogFragment {


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("DialogFragment >> AlertDialog")
                .setMessage("message")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        return builder.create();
    }
}
