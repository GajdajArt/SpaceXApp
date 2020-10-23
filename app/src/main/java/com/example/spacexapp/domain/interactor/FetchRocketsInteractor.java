package com.example.spacexapp.domain.interactor;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.domain.repository.SpaceXRepository;
import com.example.spacexapp.data.model.RocketData;
import com.example.spacexapp.data.impl.MockAsyncSpaceXRepository;

import java.util.List;

public class FetchRocketsInteractor {

    private SpaceXRepository spaceXRepository;

    public FetchRocketsInteractor() {
        spaceXRepository = new MockAsyncSpaceXRepository();
    }

    public void fetchRocketsList(Callback<List<RocketData>> callback) {
        spaceXRepository.fetchRocketsList(callback);
    }
}
