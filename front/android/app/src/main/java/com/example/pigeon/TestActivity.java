package com.example.pigeon;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import com.example.pigeon.Util.webViewUtil;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;
    ImageView imageView1;
    String fileName;
    TextView textView;
    Bitmap photofile = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        button = (Button)findViewById(R.id.btnCamera);
        imageView = (ImageView)findViewById(R.id.imageViewCamera);
        imageView1 = (ImageView)findViewById(R.id.imageViewCamera1);
        textView = (TextView)findViewById(R.id.textCamera);
        textView.setText("HelloWorld");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File dir = Environment.getExternalStorageDirectory();
                fileName = System.currentTimeMillis()+".jpg";
                File file = new File(dir,fileName);
                Uri uri = FileProvider.getUriForFile(TestActivity.this,getPackageName()+".provider",file);
                intent.putExtra(MediaStore.EXTRA_OUTPUT,uri);

                startActivityForResult(intent,0);
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == 0 && resultCode == RESULT_OK){

            File dir = Environment.getExternalStorageDirectory();
            File file = new File(dir, fileName);
            Uri uri = FileProvider.getUriForFile(TestActivity.this,getPackageName()+".provider",file);
            try {
                photofile = BitmapFactory.decodeStream(TestActivity.this.getContentResolver().openInputStream(uri));
                imageView1.setImageBitmap(photofile);
                String test = bitmapToBase64(photofile);
                textView.setText(test);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageView.setImageURI(uri);
        }
    }
    private static String bitmapToBase64(Bitmap bitmap) {
        String result = null;
        ByteArrayOutputStream baos = null;
        try {
            if (bitmap != null) {
                baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);

                baos.flush();
                baos.close();

                byte[] bitmapBytes = baos.toByteArray();
                result = Base64.encodeToString(bitmapBytes, Base64.DEFAULT);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }


}
