package com.example.spacexapp.domain.impl;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.domain.repository.SpaceXRepository;
import com.example.spacexapp.data.model.RocketData;
import com.example.spacexapp.data.impl.MockSpaceXRepository;
import com.example.spacexapp.domain.FetchRocketsInteractor;

import java.util.List;

public class FetchRocketsInteractorImpl implements FetchRocketsInteractor {

    private SpaceXRepository spaceXRepository;

    public FetchRocketsInteractorImpl() {
        spaceXRepository = new MockSpaceXRepository();
    }

    @Override
    public void fetchRocketsList(Callback<List<RocketData>> callback) {
        spaceXRepository.fetchRocketsList(callback);
    }
}
