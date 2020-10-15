package com.example.matcha_memo_app_android.enums;

import com.example.matcha_memo_app_android.R;

public enum OptionItem {
    CURRENT_VERSION(0, R.string.option_current_version),
    TERMS_OF_SERVICE(1, R.string.option_agreement),
    PRIVACY_POLICY(2, R.string.option_privacy_policy),
    LICENSE(3, R.string.option_license);

    private int value;
    private int label;

    OptionItem(int value, int label) {
        this.value = value;
        this.label = label;
    }

    /**
     * 指定されたvalueのアイテムを返します
     *
     * @param value
     * @return 見つからない場合はnullを返します
     */
    public static OptionItem valueOf(int value) {
        for (OptionItem type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public int getLabel() {
        return label;
    }
}
