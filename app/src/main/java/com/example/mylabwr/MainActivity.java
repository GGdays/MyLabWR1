package com.example.mylabwr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.app.ActionBar.LayoutParams;
import android.graphics.Color;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewSwitcher.ViewFactory;

public class MainActivity extends AppCompatActivity {
    private ImageSwitcher imageSwitcher;

    private final String[] imageNames={"hotel4", "hotel2", "hotel3","hotel1", "hotel5", "hotel6","hotel7", "hotel8"};
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button buttonPrevious = (Button) findViewById(R.id.button_previous);
        Button buttonNext = (Button) findViewById(R.id.button_next);

        imageSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher);

        // Animation when switching to another image.
        Animation out= AnimationUtils.loadAnimation(this, android.R.anim.fade_out);
        Animation in= AnimationUtils.loadAnimation(this, android.R.anim.fade_in);

        // Set animation when switching images.
        imageSwitcher.setInAnimation(in);
        imageSwitcher.setOutAnimation(out);

        //
        imageSwitcher.setFactory(new ViewFactory() {

            // Returns the view to show Image
            // (Usually should use ImageView)
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());

                imageView.setBackgroundColor(Color.LTGRAY);
                imageView.setScaleType(ImageView.ScaleType.CENTER);

                ImageSwitcher.LayoutParams params= new ImageSwitcher.LayoutParams(
                        LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                imageView.setLayoutParams(params);
                return imageView;
            }
        });

        this.currentIndex=0;
        this.showImage(this.currentIndex);

        buttonPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousImage();
            }
        });

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextImage();
            }
        });
    }


    private void previousImage()  {
        if(currentIndex > 0) {
            currentIndex--;
        }else  {
            Toast.makeText(getApplicationContext(), "No Previous Image", Toast.LENGTH_SHORT).show();
            return;
        }
        this.showImage(currentIndex);
    }

    private void nextImage()  {
        if(currentIndex < this.imageNames.length-1) {
            currentIndex++;
        }else  {
            Toast.makeText(getApplicationContext(), "No Next Image", Toast.LENGTH_SHORT).show();
            return;
        }
        this.showImage(currentIndex);
    }


    private void showImage(int imgIndex)  {
        String imageName= this.imageNames[imgIndex];

        int resId= getDrawableResIdByName(imageName);
        if(resId!=  0) {
            this.imageSwitcher.setImageResource(resId);
        }
    }

    // Find Image ID corresponding to the name of the image (in the drawable folder).
    public int getDrawableResIdByName(String resName)  {
        String pkgName = this.getPackageName();
        // Return 0 if not found.
        int resID = this.getResources().getIdentifier(resName , "drawable", pkgName);
        Log.i("MyLog", "Res Name: " + resName + "==> Res ID = " + resID);
        return resID;
    }

    public void onBtnClick(View view){
        //проба работы кнопки с уведомлением
//        CharSequence text = "You have pressed the button.";
//        int duration = Toast.LENGTH_LONG; //класс-виджет - всплыв уведомление, продолжительность
//        Toast toast = Toast.makeText(this,text,duration);
//        toast.show();
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String htlCity = (String) spinner.getSelectedItem();

        String txtHotels = "";
        for(Hotel h: Hotel.getHotels(htlCity)) {
            txtHotels += h.getStreet() + " " + h.getHotelNumber() + "\n";
        }
        TextView textAddress = (TextView) findViewById(R.id.textAddress);
        textAddress.setText("Addresses:");
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(txtHotels);
    }
    public void onBtnNextClick(View view){
        CharSequence text = "The database update may take several minutes.";
        int duration = Toast.LENGTH_LONG; //класс-виджет - всплыв уведомление, продолжительность
        Toast toast = Toast.makeText(this,text,duration);
        toast.show();
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}