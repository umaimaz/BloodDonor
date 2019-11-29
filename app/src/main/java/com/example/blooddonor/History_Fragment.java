package com.example.blooddonor;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;


public class History_Fragment extends Fragment {
    View Fragment1;

    TabLayout tabLayout2;
    ViewPager viewPager2;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Fragment1 = inflater.inflate(R.layout.fragment_history_,container,false);

        viewPager2  = Fragment1.findViewById(R.id.viewPager2);
        tabLayout2  = Fragment1.findViewById(R.id.tablayout2);

        return Fragment1;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager2);
        tabLayout2.setupWithViewPager(viewPager2);

        tabLayout2.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setUpViewPager(ViewPager viewPager2) {
        History_PageAdapter adapter1 = new History_PageAdapter(getChildFragmentManager());

        adapter1.addFragment(new Recent_Donations_Fragment(),"Recent Donations");
        adapter1.addFragment(new My_Donations_Fragment(),"My Donations");

        viewPager2.setAdapter(adapter1);
    }
}
