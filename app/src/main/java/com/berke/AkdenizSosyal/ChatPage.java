package com.berke.AkdenizSosyal;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

// 16/05 başlanılacak
public class ChatPage extends Fragment {

    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_chat_page, container, false);
        mViewPager = (ViewPager)rootView.findViewById(R.id.chat_page_viewPager);
        return rootView;
    }
}