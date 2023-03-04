package com.example.KursDiplomSite.models;

import javax.persistence.*;

@Entity
public class Ssilki
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // я сначала проморочался 3 часа, решил проблему, а потом прочитал
    // описание: как всегда
    private Long id;

    private String fullart, smallart;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getFullart() {return fullart;}

    public void setFullart(String fullart) {this.fullart = fullart;}

    public String getSmallart() {return smallart;}

    public void setSmallart(String smallart) {this.smallart = smallart;}

    public Ssilki() { }

    public Ssilki(String fullart, String smallart)
    {
        this.fullart = fullart;
        this.smallart = smallart;
    }

}
