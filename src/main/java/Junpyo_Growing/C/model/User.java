package Junpyo_Growing.C.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String UUid;

    public User(String UUid) {
        this.UUid = UUid;
    }

    public User(String part, String part1, String part2) {
    }

    public String getUUid() {
        return UUid;
    }

    public void setUUid(String UUid) {
        this.UUid = UUid;
    }
}
