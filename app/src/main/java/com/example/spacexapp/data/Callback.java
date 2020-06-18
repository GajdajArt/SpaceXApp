package com.example.spacexapp.data;

public interface Callback<T> {

    void onSuccess(T result);

    void onError(String errorMessage);
}
