package Junpyo_Growing.C.repository;


import Junpyo_Growing.C.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  UserDataRepository extends JpaRepository<UserData, String> {
}
