package model;

import java.time.LocalTime;

public abstract class Producer extends User{

    private String name;
    private String url;
    private int amountReproduction;
    private LocalTime totalReprodutionTime;

    public Producer(String nickName, String id, String name, String url) {
        super(nickName, id);
        this.name = name;
        this.url = url;
        this.amountReproduction = 0;
        this.totalReprodutionTime = LocalTime.of(0, 0, 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getAmountReproduction() {
        return amountReproduction;
    }

    public void setAmountReproduction(int amountReproduction) {
        this.amountReproduction = amountReproduction;
    }

    public LocalTime getTotalReprodutionTime() {
        return totalReprodutionTime;
    }

    public void setTotalReprodutionTime(LocalTime totalReprodutionTime) {
        this.totalReprodutionTime = totalReprodutionTime;
    }
}
