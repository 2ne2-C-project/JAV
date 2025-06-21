package Junpyo_Growing.C.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Embeddable
public class Player {

    private int Basic;
    private int frontend;
    private int backend;
    private int ios;

    @OneToOne
    private GameSession gameSession;

    @Id
    private String UUid;

    public void setUUid(String UUid) {
        this.UUid = UUid;
    }

    public String getUUid() {
        return UUid;
    }
}
