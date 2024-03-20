package com.example.juegomemoria;

import android.media.Image;
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

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    private ImageButton imgBtn1, imgBtn2, imgBtn3, imgBtn4, imgBtn5, imgBtn6, imgBtn7, imgBtn8, imgBtn9, imgBtn10, imgBtn11, imgBtn12;
    private int[] ids = new int[12];
    private ImageButton[] arrImgBtn;
    private int contadorGanar = 0;
    private int[] posiciones = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    private int[] prueba;
    private int contadorVolteos = 0;
    private Button btnRandom;
    private int[] arrImg = {R.drawable.memocharlie, R.drawable.memomarcia, R.drawable.memorerun, R.drawable.memosally, R.drawable.memoschroeder, R.drawable.memosnoopy};
    private int img1, img2, img3;
    private int pos1 = -1, pos2 = -1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        initComponent();






        generarImagenes();


        final Handler h = new Handler();
        for (int i = 0; i < arrImgBtn.length; i++) {
            arrImgBtn[i].setImageResource(arrImg[posiciones[i]]);
        }
        h.postDelayed(new Runnable(){
            @Override
            public void run(){
                imgBtn1.setImageResource(R.drawable.jmemoria);
                imgBtn2.setImageResource(R.drawable.jmemoria);
                imgBtn3.setImageResource(R.drawable.jmemoria);
                imgBtn4.setImageResource(R.drawable.jmemoria);
                imgBtn5.setImageResource(R.drawable.jmemoria);
                imgBtn6.setImageResource(R.drawable.jmemoria);
                imgBtn7.setImageResource(R.drawable.jmemoria);
                imgBtn8.setImageResource(R.drawable.jmemoria);
                imgBtn9.setImageResource(R.drawable.jmemoria);
                imgBtn10.setImageResource(R.drawable.jmemoria);
                imgBtn11.setImageResource(R.drawable.jmemoria);
                imgBtn12.setImageResource(R.drawable.jmemoria);
            };

            //img1 = 0;
            //img2 = 1;
            // img3 = 2;
        }, 2000);
    }



    public void initComponent() {
        imgBtn1 = findViewById(R.id.imgBtn1);
        imgBtn2 = findViewById(R.id.imgBtn2);
        imgBtn3 = findViewById(R.id.imgBtn3);
        imgBtn4 = findViewById(R.id.imgBtn4);
        imgBtn5 = findViewById(R.id.imgBtn5);
        imgBtn6 = findViewById(R.id.imgBtn6);
        imgBtn7 = findViewById(R.id.imgBtn7);
        imgBtn8 = findViewById(R.id.imgBtn8);
        imgBtn9 = findViewById(R.id.imgBtn9);
        imgBtn10 = findViewById(R.id.imgBtn10);
        imgBtn11 = findViewById(R.id.imgBtn11);
        imgBtn12 = findViewById(R.id.imgBtn12);

        btnRandom = findViewById(R.id.btnRandon);

        arrImgBtn = new ImageButton[]{imgBtn1, imgBtn2, imgBtn3, imgBtn4, imgBtn5, imgBtn6, imgBtn7, imgBtn8, imgBtn9, imgBtn10, imgBtn11, imgBtn12};


    }

    public void mirar(View v){
        contadorVolteos++;
        ImageButton imgBtn = (ImageButton) v;
        for(int i = 0; i < 12; i++){
            if(arrImgBtn[i].getId() == v.getId()){
                ((ImageButton) v).setImageResource(arrImg[posiciones[i]]);
                if(contadorVolteos == 1){
                    pos1 = i;
                }else {
                    pos2 = i;
                }
            }
        }
        if(pos1 != -1 && pos2 != -1){
            System.out.println(pos1 + " " + pos2);

            if(arrImg[posiciones[pos1]] == arrImg[posiciones[pos2]]){
                arrImgBtn[pos1].setVisibility(View.INVISIBLE);
                arrImgBtn[pos2].setVisibility(View.INVISIBLE);
                contadorGanar += 2;
                if (contadorGanar == 12){
                    Toast.makeText(this, "Ganaste", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                arrImgBtn[pos1].setImageResource(R.drawable.jmemoria);
                arrImgBtn[pos2].setImageResource(R.drawable.jmemoria);
                pos1 = -1;
                pos2 = -1;
                contadorVolteos = 0;
            }
        }




    }

    public void generarImagenes(){

        for(int i = 0; i < 6; i++){

            int imgRandom = (int) (Math.random() * 6);
            int c = 0;
            while (true){
                int btnRandom = (int) (Math.random() * 12);
                if(posiciones[btnRandom] == 0){
                    posiciones[btnRandom] = imgRandom;
                    c++;
                }
                if(c == 2){
                    break;
                }
            }

        }
    }

    public void reiniciar(View v){
        contadorGanar  = 0;
        // img1 = (int) (Math.random() * 6);
        // img2 = (int) (Math.random() * 6);
        // img3 = (int) (Math.random() * 6);

        for(int i = 0; i < 12; i++){
            posiciones[i] = 0;
        }
        generarImagenes();

        for (int i = 0; i < arrImgBtn.length; i++) {
            arrImgBtn[i].setVisibility(View.VISIBLE);
        }

        final Handler h = new Handler();
        for (int i = 0; i < arrImgBtn.length; i++) {
            arrImgBtn[i].setImageResource(arrImg[posiciones[i]]);
        }
        h.postDelayed(new Runnable(){
            @Override
            public void run(){
                imgBtn1.setImageResource(R.drawable.jmemoria);
                imgBtn2.setImageResource(R.drawable.jmemoria);
                imgBtn3.setImageResource(R.drawable.jmemoria);
                imgBtn4.setImageResource(R.drawable.jmemoria);
                imgBtn5.setImageResource(R.drawable.jmemoria);
                imgBtn6.setImageResource(R.drawable.jmemoria);
                imgBtn7.setImageResource(R.drawable.jmemoria);
                imgBtn8.setImageResource(R.drawable.jmemoria);
                imgBtn9.setImageResource(R.drawable.jmemoria);
                imgBtn10.setImageResource(R.drawable.jmemoria);
                imgBtn11.setImageResource(R.drawable.jmemoria);
                imgBtn12.setImageResource(R.drawable.jmemoria);
            };

            //img1 = 0;
            //img2 = 1;
            // img3 = 2;
        }, 2000);


        // imgBtn1.setImageResource(R.drawable.jmemoria);
        // imgBtn2.setImageResource(R.drawable.jmemoria);
        // imgBtn3.setImageResource(R.drawable.jmemoria);
    }

/*final Handler h = new Handler();
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
        */


}