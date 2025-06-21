package Junpyo_Growing.C.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class UserData {
    @Id
    private String UUid;

    private int level;
    private int exp;
    private int IQ;


    public UserData() {

    }

    public UserData(String UUid, int level, int exp, int IQ) {
        this.UUid = UUid;
        this.level = level;
        this.exp = exp;
        this.IQ = IQ;
    }


}
