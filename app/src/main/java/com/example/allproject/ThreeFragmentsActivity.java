// ThreeFragmentsActivity.java

package com.example.allproject;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.allproject.ViewAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class ThreeFragmentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_fragments);

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabs = findViewById(R.id.tabs);

        ViewAdapter viewAdapter = new ViewAdapter(this);
        viewPager.setAdapter(viewAdapter);

        new TabLayoutMediator(tabs, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Action");
                            break;
                        case 1:
                            tab.setText("Sci-Fi");
                            break;
                        case 2:
                            tab.setText("Comedy");
                            break;
                    }
                }
        ).attach();
    }
}
