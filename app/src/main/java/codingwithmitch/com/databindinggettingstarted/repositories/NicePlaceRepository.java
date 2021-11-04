package codingwithmitch.com.databindinggettingstarted.repositories;

import androidx.lifecycle.MutableLiveData;

import java.util.List;

import codingwithmitch.com.databindinggettingstarted.models.NicePlace;

public class NicePlaceRepository {

    public static NicePlaceRepository getInstance() {
        return new NicePlaceRepository();
    }

    public MutableLiveData<List<NicePlace>> getNicePlaces() {
        return new MutableLiveData<List<NicePlace>>();
    }
}
