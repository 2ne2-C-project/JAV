package Junpyo_Growing.C.service;

import Junpyo_Growing.C.entity.UserData;
import Junpyo_Growing.C.repository.UserDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDataService {
    @Autowired
    private UserDataRepository repository;


    public void save(UserData data) {
        repository.save(data);
    }

    public List<UserData> findALl() {
        return repository.findAll();
    }
}
