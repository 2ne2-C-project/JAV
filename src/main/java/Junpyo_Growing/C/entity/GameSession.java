package Junpyo_Growing.C.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class GameSession {
    @Id
    private String UUid; // 고유 번호

    private int IQ;
    private int exp;
    private int level;

    private String major;

    @ElementCollection
    private List<String> ownedItems = new ArrayList<>();

    private LocalDateTime lastUpdated;

    public void setUUid(String UUid) {
        this.UUid = UUid;
    }


    public void setLastUpdated(LocalDateTime now) {
        this.lastUpdated = now;
    }


    private Player player;


}
