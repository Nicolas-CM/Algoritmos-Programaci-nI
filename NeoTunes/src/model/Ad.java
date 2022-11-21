package model;

import java.util.Random;

public enum Ad implements Playable{
    Nike_Just_Do_It, CocaCola_Open_Happiness, MyMs_Melts_in_Your_Mouth_Not_in_Your_Hands;

    @Override
    public String reproducer() {
        Random random = new Random();
        return "\n---- Ad: "+ Ad.values()[random.nextInt(3)] +" ----";
    }

}
