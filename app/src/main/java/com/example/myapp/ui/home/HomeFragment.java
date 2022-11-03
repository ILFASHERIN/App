package com.example.myapp.ui.home;

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
import com.example.myapp.Student2;
import com.example.myapp.Student2;
import com.example.myapp.Studentadapter;
import com.example.myapp.databinding.FragmentHomeBinding;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    RecyclerView recyclerView;
    Studentadapter adapter;
    ArrayList<Student2> list=new ArrayList<>();
    int images[]={R.drawable.img_5,R.drawable.img_1,R.drawable.img,R.drawable.img_2,R.drawable.img_4};

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        RecyclerView recyclerView=root.findViewById(R.id.recycler_student);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        list=new ArrayList<>();
        addStudent();
        adapter=new Studentadapter(getActivity(),list,images);
        recyclerView.setAdapter(adapter);

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    private void addStudent(){
        Student2 stud=new Student2();
        stud.setName("RAM");
        stud.setCourse("Computer Science");
        stud.setEmail("ram@gmail.com");
        stud.setAge(25);
        stud.setPercentage(90);
        list.add(stud);

        Student2 stud2=new Student2();
        stud2.setName("ANU");
        stud2.setCourse("Maths");
        stud2.setEmail("anu@gmail.com");
        stud2.setAge(22);
        stud2.setPercentage(95);
        list.add(stud2);

        Student2 stud3=new Student2();
        stud3.setName("SHREELAKSHMI");
        stud3.setCourse("English");
        stud3.setEmail("shreelakshmi@gmail.com");
        stud3.setAge(23);
        stud3.setPercentage(85);
        list.add(stud3);

        Student2 stud4=new Student2();
        stud4.setName("MANU");
        stud4.setCourse("Malayalam");
        stud4.setEmail("manu@gmail.com");
        stud4.setAge(20);
        stud4.setPercentage(88);
        list.add(stud4);

        Student2 stud5=new Student2();
        stud5.setName("SHYAM");
        stud5.setCourse("History");
        stud5.setEmail("shyam@gmail.com");
        stud5.setAge(25);
        stud5.setPercentage(95);
        list.add(stud5);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}