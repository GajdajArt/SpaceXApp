package com.example.spacexapp.data;

import com.example.spacexapp.data.data.RocketData;

import java.util.List;

public interface SpaceXRepository {

    void fetchRocketsList(Callback<List<RocketData>> callback);
}
