package com.example.syallbus;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main2Activity extends Activity {
    InputStream in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView tv1 = (TextView) findViewById(R.id.textView3);
        tv1.setMovementMethod(new ScrollingMovementMethod());
        String file = getIntent().getStringExtra("file");



        AssetManager assetManager = getAssets();
        try {
            in = assetManager.open(file);
        } catch (IOException e) {
            e.printStackTrace();
        }

        tv1.setText(readTxt(in));
       // Toast.makeText(this, selectBranch + "<::>" + selectSem, Toast.LENGTH_SHORT).show();
    }

    private CharSequence readTxt(InputStream inputStream) {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return byteArrayOutputStream.toString();
    }
}
