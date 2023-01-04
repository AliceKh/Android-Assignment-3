package com.example.class3demo2;

import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class BlueFragment extends Fragment {
    TextView titleTv;
    String title;
    String name;
    String ID;
    String birthday;
    String birthdayTime;

    public static BlueFragment newInstance(String title){
        BlueFragment frag = new BlueFragment();
        Bundle bundle = new Bundle();
        bundle.putString("TITLE",title);
        frag.setArguments(bundle);
        return frag;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){
            this.title = bundle.getString("TITLE");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blue, container, false);

        name = BlueFragmentArgs.fromBundle(getArguments()).getName();
        ID = BlueFragmentArgs.fromBundle(getArguments()).getId();

        birthday = BlueFragmentArgs.fromBundle(getArguments()).getBirthday();
//        birthdayTime = BlueFragmentArgs.fromBundle(getArguments()).getb;

        TextView nameEt = view.findViewById(R.id.editNameEt);
        TextView idEt = view.findViewById(R.id.editIdEt);
        TextView birthdayEt = view.findViewById(R.id.editBirthdayEt);
        if (name != null){
            nameEt.setText(name);
        }
        if (ID != null){
            idEt.setText(ID);
        }
        if (birthday != null){
            birthdayEt.setText(birthday);
        }

        View button = view.findViewById(R.id.bluefrag_back_btn);
        button.setOnClickListener((view1)->{
            Navigation.findNavController(view1).popBackStack();
        });
        return view;
    }

    public void setTitle(String title) {
        this.title = title;
        if (titleTv != null){
            titleTv.setText(title);
        }
    }
}