package Junpyo_Growing.C.controller;


import Junpyo_Growing.C.entity.UserData;
import Junpyo_Growing.C.service.UserDataService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
public class UserDataController {
   private final UserDataService service;

    public UserDataController(UserDataService service) {
        this.service = service;
    }


    @PostMapping("/save")
    public String saveData(@RequestBody UserData userData) {
        service.save(userData);
        return "Saved to h2 DB!";
    }
}
