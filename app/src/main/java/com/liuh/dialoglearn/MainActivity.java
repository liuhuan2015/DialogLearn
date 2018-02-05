package com.liuh.dialoglearn;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements CustomDialogFragment.ResultCallback {
    int yourChoice = -1;
    List<String> yourChoose = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_normal_dialog, R.id.btn_list_dialog, R.id.btn_singlechoose_dialog, R.id.btn_multichoose_dialog,
            R.id.btn_wait_progressdialog, R.id.btn_progress_progressdialog, R.id.btn_editable_alertdialog,
            R.id.btn_custom_alertdialog, R.id.btn_override_method_alertdialog, R.id.btn_DialogFragment_alertdialog,
            R.id.btn_DialogFragment_encapsulation_alertdialog, R.id.btn_listDialogFragment_encapsulation_alertdialog,
            R.id.btn_customDialogFragment_encapsulation_alertdialog})
    void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_normal_dialog:
                //普通的AlertDialog
                showNormalAlertDialog();
                break;
            case R.id.btn_list_dialog:
                //列表类型的AlertDialog
                showListAlertDialog();
                break;
            case R.id.btn_singlechoose_dialog:
                //单选类型的AlertDialog
                showSingleChooseAlertDialog();
                break;
            case R.id.btn_multichoose_dialog:
                //多选类型的AlertDialog
                showMultiChooseAlertDialog();
                break;
            case R.id.btn_wait_progressdialog:
                //等待的ProgressDialog
                showWaitProgressDialog();
                break;
            case R.id.btn_progress_progressdialog:
                //进度表示的ProgressDialog
                showProgressProgressDialog();
                break;
            case R.id.btn_editable_alertdialog:
                //可以编辑的AlertDialog
                showEditableAlertDialog();
                break;
            case R.id.btn_custom_alertdialog:
                //自定义布局的AlertDialog
                showCustomAlertDialog();
                break;
            case R.id.btn_override_method_alertdialog:
                //重写部分方法的AlertDialog
                showOverrideMethodAlertDialog();
                break;
            case R.id.btn_DialogFragment_alertdialog:
                //使用DialogFragment形式的AlertDialog
                showDialogFragmentAlertDialog();
                break;
            case R.id.btn_DialogFragment_encapsulation_alertdialog:
                //封装DialogFragment形式的AlertDialog
                showEncapsulationDialogFragment();
                break;
            case R.id.btn_listDialogFragment_encapsulation_alertdialog:
                //列表形式的(封装DialogFragment形式的AlertDialog)
                showListDialogFragment();
                break;
            case R.id.btn_customDialogFragment_encapsulation_alertdialog:
                //自定义布局形式的(封装DialogFragment形式的AlertDialog)
                showCustomDialogFragment();
                break;
        }
    }

    private void showNormalAlertDialog() {
        AlertDialog.Builder normalAlertDialog = new AlertDialog.Builder(MainActivity.this);

        normalAlertDialog.setTitle("普通AlertDialog");

        normalAlertDialog.setMessage("我是一个普通的AlertDialog");

        normalAlertDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        normalAlertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        normalAlertDialog.setCancelable(false);

        normalAlertDialog.show();
    }

    //如果有setMessage,则setItems将不起作用
    private void showListAlertDialog() {
        String[] items = {"item0", "item1", "item2", "item3"};
        AlertDialog.Builder listAlertDialog = new AlertDialog.Builder(MainActivity.this);
//        listAlertDialog.setTitle("请选择");
//        listAlertDialog.setMessage("哈哈哈哈哈哈哈哈哈");
        listAlertDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                switch (which) {
                    case 0:
                        Toast.makeText(MainActivity.this, "item0", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "item3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        listAlertDialog.show();
    }

    private void showSingleChooseAlertDialog() {

        final String[] items = {"item0", "item1", "item2", "item3"};

        AlertDialog.Builder singleChooseAlertDialog = new AlertDialog.Builder(MainActivity.this);
        singleChooseAlertDialog.setTitle("单选AlertDialog");

        singleChooseAlertDialog.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                yourChoice = which;
                switch (which) {
                    case 0:
                        Toast.makeText(MainActivity.this, "item0", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "item1", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "item2", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "item3", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

        singleChooseAlertDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        singleChooseAlertDialog.show();
    }

    private void showMultiChooseAlertDialog() {

        final String[] items = {"item0", "item1", "item2", "item3"};
        boolean[] initChoicesState = {false, false, false, false};
        yourChoose.clear();

        AlertDialog.Builder multiChooseDialog = new AlertDialog.Builder(MainActivity.this);
        multiChooseDialog.setTitle("我是一个多选AlertDialog");

        multiChooseDialog.setMultiChoiceItems(items, initChoicesState, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) {
                    yourChoose.add(items[which]);
                } else {
                    yourChoose.remove(items[which]);
                }
            }
        });
        multiChooseDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                StringBuilder str = new StringBuilder();
                for (String itemStr : yourChoose) {
                    str.append(itemStr);
                }
                Toast.makeText(MainActivity.this, str.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        multiChooseDialog.show();
    }


    private void showWaitProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
//        progressDialog.setTitle("我是一个等待Dialog");
        progressDialog.setMessage("等待中...");
//        progressDialog.setIndeterminate(true);
        progressDialog.setCancelable(true);
        progressDialog.show();
    }

    private void showProgressProgressDialog() {
        final int MAX_PROGRESS = 100;
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);

        progressDialog.setProgress(0);
        progressDialog.setTitle("我是一个进度条Dialog");
        progressDialog.setMax(MAX_PROGRESS);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);

        progressDialog.show();

        //模拟进度增加的线程
        new Thread() {
            @Override
            public void run() {
                int progress = 0;
                while (progress < MAX_PROGRESS) {
                    try {
                        Thread.sleep(1000);
                        progress++;
                        progressDialog.setProgress(progress);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                //进度达到最大值后,窗口消失
                progressDialog.dismiss();

            }
        }.start();
    }

    private void showEditableAlertDialog() {
        final EditText editText = new EditText(MainActivity.this);
        AlertDialog.Builder inputBuilder = new AlertDialog.Builder(MainActivity.this);

        inputBuilder.setTitle("我是一个可输入的AlertDialog").setView(editText);
        inputBuilder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, editText.getText().toString().trim(), Toast.LENGTH_SHORT).show();
            }
        });
        inputBuilder.show();
    }

    //使用setView可以给AlertDialog设置一个布局
    private void showCustomAlertDialog() {

        AlertDialog.Builder customDialog = new AlertDialog.Builder(MainActivity.this);
        final View dialogView = LayoutInflater.from(MainActivity.this).inflate(R.layout.layout_custom, null);
        customDialog.setTitle("我是一个自定义的AlertDialog");
        customDialog.setView(dialogView);
        customDialog.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                EditText et = dialogView.findViewById(R.id.et_input);
                Toast.makeText(MainActivity.this, et.getText().toString().trim(), Toast.LENGTH_SHORT).show();

            }
        });
        customDialog.show();
    }

    private void showOverrideMethodAlertDialog() {
        final String[] items = {"item", "item1", "item2", "item3"};
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this) {
            @Override
            public AlertDialog create() {
                items[0] = "我是item";
                return super.create();
            }

            @Override
            public AlertDialog show() {
                items[1] = "I am item1";
                return super.show();
            }
        };

        builder.setTitle("我是一个列表AlertDialog");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                Toast.makeText(MainActivity.this, "builder被销毁了", Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    private void showDialogFragmentAlertDialog() {
        MyDialogFragment myDialogFragment = new MyDialogFragment();
        myDialogFragment.show(getFragmentManager(), "MyDialogFragment");
    }

    private void showEncapsulationDialogFragment() {
        ButtonDialogFragment buttonDialogFragment = new ButtonDialogFragment();
        buttonDialogFragment.show("Hi,nihao", "我是硕风和叶,我是铁沁,我是大地之王", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "确定按钮被点击了", Toast.LENGTH_SHORT).show();
            }
        }, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "取消按钮被点击了", Toast.LENGTH_SHORT).show();
            }
        }, getFragmentManager());
    }

    private void showListDialogFragment() {
        ListDialogFragment listDialogFragment = new ListDialogFragment();
        final String[] items = new String[]{"我是牧云笙", "我是穆如寒江", "我是硕风和叶", "我是大反派"};
        listDialogFragment.show("Hi,nihao", items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, items[which], Toast.LENGTH_SHORT).show();
                    }
                },
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                }, getFragmentManager());
    }

    private void showCustomDialogFragment() {
        CustomDialogFragment customDialogFragment = new CustomDialogFragment();
        customDialogFragment.show(this, getFragmentManager());
    }

    @Override
    public void getResult(String name, String password) {
        Toast.makeText(this, "用户名:" + name + "密码:" + password, Toast.LENGTH_SHORT).show();
    }
}
