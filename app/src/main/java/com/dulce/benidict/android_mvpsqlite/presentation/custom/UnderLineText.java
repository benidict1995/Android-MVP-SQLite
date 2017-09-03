package com.dulce.benidict.android_mvpsqlite.presentation.custom;

import android.graphics.Paint;
import android.widget.TextView;

/**
 * Created by benidict on 24/08/2017.
 */

public class UnderLineText {

    private TextView mTextView;

    public UnderLineText(TextView textView){
        this.mTextView = textView;
        if (mTextView != null){
            PaintText(mTextView);
        }
    }

    private void PaintText(TextView textView){
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
    }

}
