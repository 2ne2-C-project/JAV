package Junpyo_Growing.C.entity;

import jakarta.persistence.*;

@Entity
public class OwnedItem {

    @ManyToOne
    private GameSession session;

    private boolean used = false;
    @Id
    private String UUid;


    public void setUUid(String UUid) {
        this.UUid = UUid;
    }

    public String getUUid() {
        return UUid;
    }
}
