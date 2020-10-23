package com.example.spacexapp.data.impl;

import com.example.spacexapp.data.Callback;
import com.example.spacexapp.domain.repository.SpaceXRepository;
import com.example.spacexapp.data.model.RocketData;

import java.util.ArrayList;
import java.util.List;

public class MockAsyncSpaceXRepository implements SpaceXRepository {

    private Callback<List<RocketData>> callback;
    private Thread backgroundThread;

    @Override
    public void fetchRocketsList(Callback<List<RocketData>> callback) {
        //Сохраняем колбек для дальнейшего его использования
        this.callback = callback;

        //Выводим в лог айди текущего потока для отладки
        System.out.println(Thread.currentThread().getId());

        //создаем новый поток
        backgroundThread = new Thread(new FetchRunnable());
        //запускаем новй поток
        backgroundThread.run();
    }

    //Реализация Runnable которая будет выполнена в паралельном потоке
    private class FetchRunnable implements Runnable {

        @Override
        public void run() {
            //Выводим в лог айди текущего потока для отладки
            System.out.println(Thread.currentThread().getId());

            //Иметируем задерку на 2 секунды призагрузке данных
            try {
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Имитируем ошибку
            if (isError()) {
                callback.onError("Oops, looser =P");
                return;
            }

            //иметируем пустой список
            if (isEmptyList()) {
                callback.onSuccess(new ArrayList<RocketData>());
                return;
            }

            //Создаем список с моковыми данными
            List<RocketData> resultList = new ArrayList();
            resultList.add(new RocketData("Falcon 1", "http://www.spacex.com/files//assets/img/Liftoff_south_FULL_QQ9L7636-480x723.jpg"));
            resultList.add(new RocketData("Falcon 1e", "http://michaelgr.wordpress.com/files/2008/09/spacex-falcon1.jpg"));
            resultList.add(new RocketData("Falcon 9 v1.0", "https://upload.wikimedia.org/wikipedia/commons/thumb/2/29/SpX_CRS-2_launch_-_further_-_cropped.jpg/954px-SpX_CRS-2_launch_-_further_-_cropped.jpg"));
            resultList.add(new RocketData("Falcon 9 v1.1", "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/Falcon_9_launch_with_DSCOVR.jpg/1024px-Falcon_9_launch_with_DSCOVR.jpg"));
            resultList.add(new RocketData("Falcon 9 Full Thrust", "https://upload.wikimedia.org/wikipedia/commons/6/60/ORBCOMM-2_%2823802549782%29.jpg"));
            resultList.add(new RocketData("Falcon Heavy", "https://i.wpimg.pl/O/593x450/d.wpimg.pl/525385494--961962968/spacex.png"));
            resultList.add(new RocketData("BFR", "https://upload.wikimedia.org/wikipedia/en/9/90/SpaceX_BFR_launch_vehicle.jpg"));

            //Передаем список с данными колбек
            callback.onSuccess(resultList);
        }

        private boolean isError() {
            return Math.random() < 0.2;
        }

        private boolean isEmptyList() {
            return Math.random() < 0.3;
        }
    }
}
