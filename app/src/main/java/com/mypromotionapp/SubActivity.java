package com.mypromotionapp;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;

public class SubActivity extends AppCompatActivity {

    private static final String TAG = SubActivity.class.getName();
    private ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sub_activity);
        final Promotion promotion = (Promotion) getIntent().getParcelableExtra("myData");

        ImageView imageView = (ImageView) findViewById(R.id.subImageView);
        imageLoader = MyPromotionCardApplication.getInstance().getImageLoader();
        imageLoader.get(promotion.getImageUrl(), ImageLoader.getImageListener(
                imageView, R.mipmap.ic_launcher, android.R.drawable.ic_dialog_alert));

        TextView titleView = (TextView) findViewById(R.id.subTitleView);
        String title = promotion.getTitle();
        if (titleView != null && title != null) {
            titleView.setText(title);
        }

        TextView descriptionView = (TextView) findViewById(R.id.subDescriptionView);
        String description = promotion.getDescription();
        if (descriptionView != null && description != null) {
            descriptionView.setText(description);
        }

        TextView footerView = (TextView) findViewById(R.id.subFooterView);
        String footer = promotion.getFooter();
        if (footerView != null && footer != null) {
            footerView.setText(Html.fromHtml(footer));
            footerView.setMovementMethod(LinkMovementMethod.getInstance());
        }

        Button button = (Button) findViewById(R.id.subButton);
        String buttonText = promotion.getButtonTitle();
        if (button != null && buttonText != null) {
            button.setText(buttonText);
            button.setTextColor(Color.WHITE);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String myWebUrl = promotion.getButtonWebUrl();
                    if (myWebUrl != null) {
                        Intent intent = new Intent(v.getContext(), WebViewActivity.class);
                        intent.putExtra("myWebUrl", myWebUrl);
                        startActivity(intent);
                    }
                }
            });
        }
    }
}
