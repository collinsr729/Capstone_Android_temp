package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        homeViewModel.fillFakeGroups(10);
        String group0 = homeViewModel.getOne(0);
        final TextView textView0 = root.findViewById(R.id.card_0_text);
        textView0.setText(group0);
        String group1 = homeViewModel.getOne(1);
        final TextView textView1 = root.findViewById(R.id.card_1_text);
        textView1.setText(group1);
        String group2 = homeViewModel.getOne(2);
        final TextView textView2 = root.findViewById(R.id.card_2_text);
        textView2.setText(group2);
        String group3 = homeViewModel.getOne(3);
        final TextView textView3 = root.findViewById(R.id.card_3_text);
        textView3.setText(group3);
        String group4 = homeViewModel.getOne(4);
        final TextView textView4 = root.findViewById(R.id.card_4_text);
        textView4.setText(group4);
        String group5 = homeViewModel.getOne(5);
        final TextView textView5 = root.findViewById(R.id.card_5_text);
        textView5.setText(group5);
        String group6 = homeViewModel.getOne(6);
        final TextView textView6 = root.findViewById(R.id.card_6_text);
        textView6.setText(group6);
        String group7 = homeViewModel.getOne(7);
        final TextView textView7 = root.findViewById(R.id.card_7_text);
        textView7.setText(group7);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        return root;
    }
}