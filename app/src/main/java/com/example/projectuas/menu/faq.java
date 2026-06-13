package com.example.projectuas.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.projectuas.R;

public class faq extends AppCompatActivity {
    TextView details1,details2,details3;
    LinearLayout layout1,layout2,layout3;
    ImageView imageView;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        details1=findViewById(R.id.details1);
        details2=findViewById(R.id.details2);
        details3=findViewById(R.id.details3);

        layout1=findViewById(R.id.Layout1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout2=findViewById(R.id.Layout2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        layout3=findViewById(R.id.Layout3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);

        imageView=findViewById(R.id.exitIcon);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void expand(View view) {
        if (view.getId() == R.id.card1) {
            toggleVisibility(details1, layout1);
        } else if (view.getId() == R.id.card2) {
            toggleVisibility(details2, layout2);
        } else if (view.getId() == R.id.card3) {
            toggleVisibility(details3, layout3);
        }
    }

    private void toggleVisibility(TextView details, LinearLayout layout) {
        int visibility = (details.getVisibility() == View.GONE) ? View.VISIBLE : View.GONE;
        TransitionManager.beginDelayedTransition(layout, new AutoTransition());
        details.setVisibility(visibility);
    }
}