package com.example.pizzadelivery;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.SharedMemory;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addTopping,clearPizza,checkout;
    ProgressBar progressBar;
    LinearLayout linearlayout;
    Integer images[]={R.drawable.bacon,R.drawable.cheese,R.drawable.garlic,R.drawable.green_pepper,R.drawable.mashroom,R.drawable.olive,R.drawable.onion,R.drawable.red_pepper};
    String items[]={"bacon","cheese","garlic","green_pepper","mashroom","olive","onion","red_pepper"};
    int progress=0;
    ImageView top1,top2,top3,top4,top5,top6,top7,top8,top9,top10;
    double baseprice=6.5;
    double topping_price;
    double delivery_cost=0;
    double total_cost;
    CheckBox delivery;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearlayout=(LinearLayout)findViewById(R.id.linear_layout);
        addTopping=(Button)findViewById(R.id.addTopping);
        clearPizza=(Button)findViewById(R.id.clearpizza);
        checkout=(Button)findViewById(R.id.checkout);
        progressBar=(ProgressBar)findViewById(R.id.progressBar3);
        delivery=(CheckBox)findViewById(R.id.deliverycheckbox);
        progressBar.setMin(0);
        progressBar.setMax(100);



      //  int toptag= (int) toppings.get(2).getTag();
        delivery.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(compoundButton.isChecked()){
                    delivery_cost=4.0;
                }else{
                    delivery_cost=0;
                }
                Log.i("delivery", String.valueOf(delivery_cost));
            }
        });







        addTopping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(progress<100){
                    progress += 10;
                    final AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Choose a Topping")
                            .setItems(items, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    topping_price=+1.5;
                                    ImageView imageView=new ImageView(linearlayout.getContext());
                                    if(linearlayout.getChildCount()<5) {
                                        imageView.setImageResource(images[which]);
                                        linearlayout.addView(imageView);
                                        progressBar.setProgress(progress);

                                    }
                                    }
                            });
                    AlertDialog alert=builder.create();
                    alert.show();
                }
                else {
                    Toast.makeText(MainActivity.this, "Maximum Topping capacity reached!", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
}
