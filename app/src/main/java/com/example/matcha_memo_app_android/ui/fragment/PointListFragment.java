package com.example.matcha_memo_app_android.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.matcha_memo_app_android.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PointListFragment extends Fragment {

    private ViewGroup mRootView;

    ListView mListView;

    private static final String[] FROM = {"price", "firstBuy", "point"};
    private static final int[] TO = {R.id.tvPoint, R.id.tvFirstBuy, R.id.tvPrice};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mRootView = (ViewGroup) inflater.inflate(R.layout.fragment_point_list, container, false);
        return mRootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // 画面要素を取得
        mListView = mRootView.findViewById(R.id.listView);

        // リストビューに値を定義
        List<Map<String, Object>> mPointList = pointMenuList();

        SimpleAdapter adapter = new SimpleAdapter(
                mRootView.getContext(),
                mPointList,
                R.layout.fragment_point_add_row,
                FROM,
                TO
        );

        mListView.setAdapter(adapter);

    }

    private List<Map<String, Object>> pointMenuList() {
        List<Map<String, Object>> menuList = new ArrayList<>();

        Map<String, Object> menu = new HashMap<>();
        menu.put("point", "1pt");
        menu.put("price", "¥120");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "10pt");
        menu.put("firstBuy", "初回購入者限定");
        menu.put("price", "¥240");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "6pt");
        menu.put("price", "¥610");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "13pt");
        menu.put("price", "¥1,100");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "32pt");
        menu.put("price", "¥2,440");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "80pt");
        menu.put("price", "¥4,900");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "184pt");
        menu.put("price", "¥10,000");
        menuList.add(menu);

        menu = new HashMap<>();
        menu.put("point", "255pt");
        menu.put("price", "¥12,000");
        menuList.add(menu);

        return menuList;
    }
}