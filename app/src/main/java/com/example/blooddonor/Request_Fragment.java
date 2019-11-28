package com.example.blooddonor;

import android.content.Context;
import android.icu.text.CaseMap;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;


public class Request_Fragment extends Fragment {
    View myFragment;

    TabLayout tabLayout1;
    ViewPager viewPager1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        myFragment = inflater.inflate(R.layout.fragment_request_,container,false);

        viewPager1  = myFragment.findViewById(R.id.viewPager1);
        tabLayout1  = myFragment.findViewById(R.id.tablayout1);

    return myFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setUpViewPager(viewPager1);
        tabLayout1.setupWithViewPager(viewPager1);

        tabLayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
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

    private void setUpViewPager(ViewPager viewPager1) {
        PageAdapter adapter = new PageAdapter(getChildFragmentManager());

        adapter.addFragment(new My_Request_Fragment(),"My Requests");
        adapter.addFragment(new Receive_Request_Fragment(),"Received Requests");

        viewPager1.setAdapter(adapter);
    }

}
