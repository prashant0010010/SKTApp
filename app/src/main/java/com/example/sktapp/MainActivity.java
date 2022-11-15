package com.example.sktapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;

import android.app.Activity;
import android.os.Bundle;
import android.widget.GridLayout;

import com.example.sktapp.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
       replaceFragment(new HomeFragment());

        binding.bottomNavigationView.setOnItemSelectedListener(item ->{

            switch (item.getItemId()){
                case R.id.home:
                    replaceFragment(new HomeFragment());
                    break;
                case R.id.about:
                    replaceFragment(new AboutFragment());
                    break;
                case R.id.services:
                    replaceFragment(new ServicesFragment());
                    break;
                case R.id.contact:
                    replaceFragment(new ContactFragment());
                    break;
            }

            return true;
        });

        ArrayList<CategoryModel> categories = new ArrayList<>();
        categories.add(new CategoryModel("","Generator","http://sktnepal.com.np/backend/web/img/2060063859Tractor-Operated-Multicrop-Threshers.jpg"));
        categories.add(new CategoryModel("","Piller","http://sktnepal.com.np/backend/web/img/2060063859Tractor-Operated-Multicrop-Threshers.jpg"));
        categories.add(new CategoryModel("","Thriller","http://sktnepal.com.np/backend/web/img/2060063859Tractor-Operated-Multicrop-Threshers.jpg"));
        categories.add(new CategoryModel("","Threshor",""));
        CategoryAdapter adapter = new CategoryAdapter(this, categories);

        binding.categoryList.setLayoutManager(new GridLayoutManager(this,1));
        binding.categoryList.setAdapter(adapter);
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
}