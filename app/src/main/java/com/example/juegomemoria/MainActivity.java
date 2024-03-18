package com.example.juegomemoria;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ImageButton imgBtn1, imgBtn2, imgBtn3;
    private Button btnRandom;
    private int[] arrImg = {R.drawable.memocharlie, R.drawable.memomarcia, R.drawable.memorerun, R.drawable.memosally, R.drawable.memoschroeder, R.drawable.memosnoopy};
    private int img1, img2, img3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initComponent();

    }



    public void initComponent() {
        imgBtn1 = findViewById(R.id.imgBtn1);
        imgBtn2 = findViewById(R.id.imgBtn2);
        imgBtn3 = findViewById(R.id.imgBtn3);
        btnRandom = findViewById(R.id.btnRandon);
        img1 = 0;
        img2 = 1;
        img3 = 2;
    }

    public void mirar(View v){
        final Handler h = new Handler();
        ImageButton imgBtn = (ImageButton) v;
        int id = imgBtn.getId();
        int pos = 0;
        if(id == R.id.imgBtn1){
            pos = img1;
        }else if(id == R.id.imgBtn2){
            pos = img2;
        } else if(id == R.id.imgBtn3){
            pos = img3;
        }
        imgBtn.setImageResource(arrImg[pos]);
        System.out.println("imgBtn.getId() = " + imgBtn.getId());
        h.postDelayed(new Runnable(){
            @Override
            public void run(){
                imgBtn.setImageResource(R.drawable.jmemoria);
            }
        }, 1000);

    }

    public void random(View v){
        img1 = (int) (Math.random() * 6);
        img2 = (int) (Math.random() * 6);
        img3 = (int) (Math.random() * 6);
        // imgBtn1.setImageResource(R.drawable.jmemoria);
        // imgBtn2.setImageResource(R.drawable.jmemoria);
        // imgBtn3.setImageResource(R.drawable.jmemoria);
    }

}