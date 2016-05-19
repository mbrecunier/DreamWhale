package com.epicodus.dreamwhale.ui;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.epicodus.dreamwhale.R;
import com.epicodus.dreamwhale.adapters.FormPagerAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AddDreamActivity extends BaseActivity implements View.OnClickListener {
    FragmentPagerAdapter adapterViewPager;
    @Bind(R.id.left_nav) ImageView leftNav;
    @Bind(R.id.right_nav) ImageView rightNav;
    @Bind(R.id.vpPager) ViewPager vpPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dream);
        ButterKnife.bind(this);
        adapterViewPager = new FormPagerAdapter(getSupportFragmentManager());
        vpPager.setAdapter(adapterViewPager);
        leftNav.setOnClickListener(this);
        rightNav.setOnClickListener(this);
        hideExtraArrows();
    }

    @Override
    public void onClick(View v) {
        if (v == leftNav) {
            int tab = vpPager.getCurrentItem();
            if (tab > 0) {
                tab--;
                vpPager.setCurrentItem(tab);
            }
        }
        if (v == rightNav) {
            int tab = vpPager.getCurrentItem();
            tab++;
            vpPager.setCurrentItem(tab);
        }
        hideExtraArrows();
    }

    public void hideExtraArrows() {
        if (vpPager.getCurrentItem() == 0) {
            leftNav.setVisibility(View.INVISIBLE);
        }
        if (vpPager.getCurrentItem() == 2) {
            rightNav.setVisibility(View.INVISIBLE);
        }
    }

}


