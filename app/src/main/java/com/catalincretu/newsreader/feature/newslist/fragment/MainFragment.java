package com.catalincretu.newsreader.feature.newslist.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.catalincretu.newsreader.databinding.NewsMainFragmentBinding;
import com.catalincretu.newsreader.feature.newslist.model.NewsListViewModel;

public class MainFragment extends Fragment {

    private NewsListViewModel viewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //viewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        viewModel = new ViewModelProvider(this).get(NewsListViewModel.class);
        getLifecycle().addObserver(viewModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        NewsMainFragmentBinding binding = NewsMainFragmentBinding.inflate(inflater, container, false);
        binding.setViewModel(viewModel);
        return binding.getRoot();

    }


}