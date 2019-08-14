package com.sulaiman.yuyu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class Details extends AppCompatActivity {
    String imageName,imageFrom,imageUrl,imageIstri,imageHidup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        imageName=getIntent().getStringExtra("name");
        imageFrom=getIntent().getStringExtra("from");
        imageIstri=getIntent().getStringExtra("istri");
        imageHidup=getIntent().getStringExtra("hidup");
        imageUrl=getIntent().getStringExtra("url_img");

        TextView name = findViewById(R.id.tv_item_name);
        TextView from = findViewById(R.id.tv_item_from);
        TextView istri = findViewById(R.id.tv_item_pasangan);
        TextView hidup = findViewById(R.id.tv_item_hidup);
        name.setText(imageName);
        from.setText(imageFrom);
        istri.setText(imageIstri);
        hidup.setText(imageHidup);

        ImageView image = findViewById(R.id.img_item_photo);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);

    }

}

