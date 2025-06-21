package Junpyo_Growing.C.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GameSessionDto {
    public int exp;
    public int IQ;
    public int level;
    public String major;
    public List<String> ownedItems;

}
