package com.example.mapproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

//package com.example.card_view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.w3c.dom.Text;

public class ItemDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);


        final Item item = (Item)getIntent().getSerializableExtra("Send");
        int imgRefB = item.getImgRefB();

        ImageView imageC = (ImageView)findViewById(R.id.imageB);
        imageC.setImageResource(imgRefB);

        TextView name = (TextView)findViewById(R.id.name);
        name.setText(item.getImgTitle());

        TextView price = (TextView)findViewById(R.id.price);
        price.setText(item.getRate()+"");

        TextView location = (TextView)findViewById(R.id.location);
        location.setText(item.getLoc());

        TextView description = (TextView)findViewById(R.id.des_para);
        description.setText(item.getDes());

        TextView farmer = (TextView)findViewById(R.id.farmer);
        farmer.setText(item.getfName());

        TextView phoneN = (TextView)findViewById(R.id.phone);
        phoneN.setText(item.getPno());


        ImageView phn_icon = findViewById(R.id.phone_image);
        phn_icon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1  = new Intent(Intent.ACTION_CALL);
                String contact  = item.getPno();
                Uri uri = Uri.parse("tel:91"+contact);
                intent1.setData(uri);
                String []perms = {Manifest.permission.CALL_PHONE};

                if(ContextCompat.checkSelfPermission(ItemDetails.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(ItemDetails.this,perms,100);
                }
                startActivity(intent1);
            }
        });
    }
}
