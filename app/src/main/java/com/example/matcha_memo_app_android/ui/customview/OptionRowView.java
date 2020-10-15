package com.example.matcha_memo_app_android.ui.customview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.matcha_memo_app_android.R;
import com.example.matcha_memo_app_android.enums.OptionItem;

public class OptionRowView extends LinearLayout {

    private OptionItem mItemType;

    public OptionRowView(Context context) {
        this(context, null);
    }

    public OptionRowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public OptionRowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View rootView = inflate(context, R.layout.view_option_row, this);
        TextView mTitleView = rootView.findViewById(R.id.titleTv);
        TextView mValueView = rootView.findViewById(R.id.valueTv);
        ImageView mIconImageView = rootView.findViewById(R.id.iconIv);

        @SuppressLint("CustomViewStyleable") TypedArray typeArray = context.obtainStyledAttributes(attrs, R.styleable.OptionRowType, 0, 0);

        int type;
        try {
            type = typeArray.getInt(R.styleable.OptionRowType_option_type, 0);
        } finally {
            typeArray.recycle();
        }

        mItemType = OptionItem.valueOf(type);
        assert mItemType != null;
        mTitleView.setText(mItemType.getLabel());
        mIconImageView.setImageResource(getImageId());

    }

    private int getImageId() {
        int imageId = 0;
        switch (mItemType) {
            case CURRENT_VERSION:
                return R.drawable.ic_smartphone;
            case TERMS_OF_SERVICE:
                return R.drawable.ic_list;
            case PRIVACY_POLICY:
                return R.drawable.ic_list;
            case LICENSE:
                return R.drawable.ic_list;
        }
        return imageId;
    }
}
