package Junpyo_Growing.C.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Entity
public class Upgrade {
    @Id
    @GenericGenerator(name = "")
    private String UUid;

    private String upgrade_name;
    private int cost;
    private String effect; // score_level + 1

    @Embedded
    private Player player;


    public Object getEffect() {
        return null;
    }
}
