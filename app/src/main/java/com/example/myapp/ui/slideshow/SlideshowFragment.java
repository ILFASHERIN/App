package com.example.myapp.ui.slideshow;






import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapp.ParseDataActivity;
import com.example.myapp.R;
import com.example.myapp.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {
    Button btn;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root=inflater.inflate(R.layout.fragment_slideshow,container,false);
        btn= root.findViewById(R.id.buttonParse);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

              Intent intent=new Intent(getActivity(),ParseDataActivity.class);
              startActivity(intent);
            }
        });

        return root;
    }


}