package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvScreenName;
    ImageView ivProfile;
    TextView tvText;
    Tweet tweet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        tvName = findViewById(R.id.tvName);
        tvScreenName = findViewById(R.id.tvScreenName);
        ivProfile = findViewById(R.id.ivProfile);
        tvText = findViewById(R.id.tvText);

        tvName.setText(tweet.user.name);
        tvScreenName.setText(tweet.user.screenName);
        tvText.setText(tweet.body);
        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfile);
    }
}