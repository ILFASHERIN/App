package com.example.myapp.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapp.R;
import com.example.myapp.RecyclerAdapter;
import com.example.myapp.databinding.FragmentGalleryBinding;

public class GalleryFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerAdapter recyclerAdapter;
    String[] fruits={"MANGO","APPLE","BANANA","WATER MELON","ORANGE"};

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView=root.findViewById(R.id.recycler_fruit);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        RecyclerAdapter adapter=new RecyclerAdapter(this.fruits);
        recyclerView.setAdapter(adapter);



//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}