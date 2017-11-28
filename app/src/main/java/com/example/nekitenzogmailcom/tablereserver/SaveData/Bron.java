package com.example.nekitenzogmailcom.tablereserver.SaveData;

/**
 * Created by artem on 28.11.2017.
 */


//Модель нашей брони
public class Bron {
    //поля нашей модели
    private int id;
    private String name;
    private int people;
    private String time;

    //пустой конструктор для firebase
    public Bron() {

    }

    public Bron(int id, String name, int people, String time) {
        this.id = id;
        this.name = name;
        this.people = people;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public int getPeople() {
        return people;
    }

    public String getName() {
        return name;
    }

    public String getTime() {
        return time;
    }
}
