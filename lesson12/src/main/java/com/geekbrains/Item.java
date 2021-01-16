package com.geekbrains;

import javax.persistence.*;

@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "val")
    int val;

    @Version
    long version;

    public void setVal(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public long getVersion() {
        return version;
    }

    public Item() {
    }

    public Item(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return String.format("Item [ id = %d, val = %d, version = %d]", id,
                val, version);
    }

}
