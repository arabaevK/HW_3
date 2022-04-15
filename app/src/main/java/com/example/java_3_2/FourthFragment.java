package com.example.java_3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.java_3_2.databinding.FragmentFourthBinding;
import com.example.java_3_2.databinding.FragmentThirdBinding;

public class FourthFragment extends Fragment {
    private FragmentFourthBinding binding;
    public final static String USERNAME_KEY4 = "key";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentFourthBinding.inflate(LayoutInflater.from(requireContext()), container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            String username = getArguments().getString(ThirdFragment.USERNAME_KEY3);
            binding.tData.setText(username);
        }
        binding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();

                FifthFragment fifthFragment = new FifthFragment();
                if (binding.editText != null){
                    fifthFragment.setArguments(bundle);
                    bundle.putString(USERNAME_KEY4, binding.editText.getText().toString());
                    fifthFragment.setArguments(bundle);
                    requireActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, fifthFragment).commit();
                }else binding.tData.setError("Ошибка, введите текст");

            }
        });
    }
}