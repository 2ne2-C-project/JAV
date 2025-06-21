package Junpyo_Growing.C.entity;

import jakarta.persistence.*;

@Entity
public class Item {

    private String item_name;
    private int price;
    private String effect; // score + 10
    @Id
    private String UUid;

    public Item(String itemName) {
        item_name = itemName;
    }

    public Item() {

    }


    public int getPrice() {
        return 0;
    }

    public String getItem_name() {
        return null;
    }

    public void setUUid(String UUid) {
        this.UUid = UUid;
    }

    public String getUUid() {
        return UUid;
    }
}
