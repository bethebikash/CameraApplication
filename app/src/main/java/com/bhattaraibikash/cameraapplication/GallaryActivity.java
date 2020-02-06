package com.bhattaraibikash.cameraapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class GallaryActivity extends AppCompatActivity {

    private ImageView ivPictureGall;
    private Button btnOpenCameraGall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallary);

        ivPictureGall = findViewById(R.id.ivPictureGall);
        btnOpenCameraGall = findViewById(R.id.btnOpenCameraGall);

        btnOpenCameraGall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                browseImage();
            }
        });
    }

    private void browseImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if(data == null) {
                Toast.makeText(this, "Please select an Image", Toast.LENGTH_SHORT).show();
            }
        }

        Uri uri = data.getData();
        ivPictureGall.setImageURI(uri);
    }


}
