package com.yonevas.gpcalc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.yonevas.gpcalc.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        View view = binding.getRoot();


//      setup adapter for destination spinner and populate its list
        ArrayAdapter<CharSequence> studentSpinnerAdapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.students, android.R.layout.simple_spinner_item
        );
        studentSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner.setAdapter(studentSpinnerAdapter);

        ArrayAdapter<CharSequence> gpaSpinnerAdapter = ArrayAdapter.createFromResource(
                requireContext(), R.array.base_gpa, android.R.layout.simple_spinner_item
        );
        gpaSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        binding.spinner2.setAdapter(gpaSpinnerAdapter);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.btnLogout.setOnClickListener(view1 -> NavHostFragment.findNavController(SecondFragment.this)
                .navigate(R.id.action_GPAFragment_to_LoginFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void onButtonClick(View view) {
    }
}