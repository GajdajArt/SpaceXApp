package com.example.spacexapp.domain.repository;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.data.model.RocketData;

import java.util.List;

public interface SpaceXRepository {

    void fetchRocketsList(Callback<List<RocketData>> callback);
}
