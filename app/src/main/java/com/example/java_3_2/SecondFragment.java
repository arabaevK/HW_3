package com.example.java_3_2;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.java_3_2.databinding.FragmentMainBinding;
import com.example.java_3_2.databinding.FragmentSecondBinding;
import com.google.android.material.textfield.TextInputEditText;


public class SecondFragment extends Fragment {
    private FragmentSecondBinding binding;
    public final static String USERNAME_KEY2 = "key";


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null){
            String username = getArguments().getString(MainFragment.USERNAME_KEY);
            binding.textData.setText(username);
        }
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                ThirdFragment thirdFragment= new ThirdFragment();
                if (binding.editText != null){
                    thirdFragment.setArguments(bundle);
                    bundle.putString(USERNAME_KEY2, binding.editText.getText().toString());
                    thirdFragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, thirdFragment).commit();
                }else binding.textData.setError("Ошибка, введите текст");
            }
        });

    }
}