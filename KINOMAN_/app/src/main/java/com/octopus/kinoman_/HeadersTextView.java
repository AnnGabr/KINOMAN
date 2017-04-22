package com.octopus.kinoman_;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by katsiarynazaitsava on 01.04.17.
 */

public class HeadersTextView extends AppCompatTextView {
    public HeadersTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/CountryWestern.ttf"));
    }
}