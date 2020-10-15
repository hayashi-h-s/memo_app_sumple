package com.example.matcha_memo_app_android.ui.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matcha_memo_app_android.R;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemoListFragment extends Fragment {

    private ViewGroup mRootView;
    LinearLayout addMemoBt;
    ListView mListView;

    private static final String[] FROM = {"date", "memo"};
    private static final int[] TO = {R.id.tvDate, R.id.tvMemo};

    String dateFormat;

    EditText memoName;
    View view;
    Map<String, Object> menu;

    SimpleDateFormat format = new SimpleDateFormat( "yyyy/MM/dd HH:mm" );
    List<Map<String, Object>> memoList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_memo_list, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 画面要素を取得
        mListView = mRootView.findViewById(R.id.listView);
        addMemoBt = mRootView.findViewById(R.id.addMeBt);

        // リストビューに値を定義
        mListView.setAdapter(getAdapter());

        addMemoBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mListView.getContext());
                builder.setTitle("メモをする");
                view = getLayoutInflater().inflate(R.layout.dialog_memo_list, null);
                builder.setView(view);

                builder.setPositiveButton("追加", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // ボタンをクリックしたときの動作
                        dateFormat = format.format(new Date());
                        memoName = view.findViewById(R.id.evMemo);
                        mListView.setAdapter(getAdapter());
                    }
                });
                builder.setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();
            }
        });
    }

    private SimpleAdapter getAdapter() {

        List<Map<String, Object>> mMemoList = createMemoList();

        return new SimpleAdapter(
                mRootView.getContext(),
                mMemoList,
                R.layout.fragment_memo_row,
                FROM,
                TO
        );
    }

    // ListViewに値を定義するメソッド
    private List<Map<String, Object>> createMemoList() {

        if (memoName != null) {
            String memo = memoName.getText().toString();
            menu = new HashMap<>();
            menu.put("memo", memo);
            menu.put("date", dateFormat);
            memoList.add(menu);
        }
        return memoList;
    }


}