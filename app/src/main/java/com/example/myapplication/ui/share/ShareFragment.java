package com.example.myapplication.ui.share;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Pop;
import com.example.myapplication.R;
import com.example.myapplication.ui.home.HomeFragment;

public class ShareFragment extends Fragment {

    private ShareViewModel shareViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(ShareViewModel.class);
        View root = inflater.inflate(R.layout.fragment_share, container, false);
//        final TextView textView = root.findViewById(R.id.text_schedule);
//        shareViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
        ImageButton button =  root.findViewById(R.id.tuesday_edit);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), Pop.class));
            }
        });
        makeFakeData(root);
        return root;
    }

    private void makeFakeData(View root) {
        final TextView textView = root.findViewById(R.id.monday_schedule);
        textView.setText("8:30am   SUNY Oswego to Downtown\n10:30am  Downtown to SUNY Oswego");
        final TextView textView1 = root.findViewById(R.id.tuesday_schedule);
        textView1.setText("7:30am  Downtown to SUNY Oswego\n10:30am SUNY Oswego to Downtown\n12pm  Downtown to SUNY Oswego\n3:50pm SUNY Oswego to Downtown");
        final TextView textView2 = root.findViewById(R.id.wednesday_schedule);
        textView2.setText("8:30am   SUNY Oswego to Downtown\n10:30am  Downtown to SUNY Oswego");
        final TextView textView3 = root.findViewById(R.id.thursday_schedule);
        textView3.setText("7:30am  Downtown to SUNY Oswego\n10:30am SUNY Oswego to Downtown\n12pm  Downtown to SUNY Oswego\n3:50pm SUNY Oswego to Downtown");
        final TextView textView4 = root.findViewById(R.id.friday_schedule);
        textView4.setText("8:30am   SUNY Oswego to Downtown\n10:30am  Downtown to SUNY Oswego");
        final TextView textView5 = root.findViewById(R.id.saturday_schedule);
        textView5.setText("");
        final TextView textView6 = root.findViewById(R.id.sunday_schedule);
        textView6.setText("");

    }
}