package com.example.spacexapp.domain;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.data.RocketData;

import java.util.List;

public interface FetchRocketsInteractor {

    void fetchRocketsList(Callback<List<RocketData>> callback);
}
