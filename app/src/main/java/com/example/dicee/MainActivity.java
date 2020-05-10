package com.example.dicee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int mcount=0,fcount=0;
    String strmcount=""; String strfcount="";
    TextView cmale;
    TextView cfemale;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button rollbutton = findViewById(R.id.rollbutton);



        final ImageView applogo = findViewById(R.id.applogo);
        final ImageView leftDice=findViewById(R.id.image_leftDice);
        final ImageView rightDice=findViewById(R.id.image_rightDice);

        cmale=(TextView)findViewById(R.id.textView3);
        cfemale=(TextView)findViewById(R.id.textView4);





        final int[] diceArray={R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6};

        final int[] winArray={R.drawable.malewins,R.drawable.femalewins,R.drawable.malefemaletie};

        rollbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random randomnumberGenerator = new Random();
                int noleftDice= randomnumberGenerator.nextInt(6);
                leftDice.setImageResource(diceArray[noleftDice]);
                Log.d("Left no","The left no is"+noleftDice);

                int norightDice=randomnumberGenerator.nextInt(6);
                rightDice.setImageResource(diceArray[norightDice]);
                Log.d("Right no","The right no is"+norightDice);

                if(noleftDice>norightDice){
                    applogo.setImageResource(winArray[0]);
                    mcount=mcount+1;
                    fcount=fcount-1;
                    strmcount= String.valueOf(mcount);
                    strfcount= String.valueOf(fcount);
                    cmale.setText(strmcount);
                    cfemale.setText(strfcount);

                }
                else if(noleftDice<norightDice){
                    applogo.setImageResource(winArray[1]);
                    mcount=mcount-1;
                    fcount=fcount+1;
                    strmcount= String.valueOf(mcount);
                    strfcount= String.valueOf(fcount);
                    cmale.setText(strmcount);
                    cfemale.setText(strfcount);

                }
                if(noleftDice==norightDice){
                    applogo.setImageResource(winArray[2]);
                }





            }
        });
    }
}
