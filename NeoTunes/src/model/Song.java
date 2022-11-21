package model;

public class Song extends Audio {

    private String album;
    private double saleValue;
    private int amountSale;
    private TypeGenre typeGenre;

    public Song(String name, String url, int duration, String album, double saleValue, int typeGenre) {
        super(name, url, duration);
        this.album = album;
        this.saleValue = saleValue;
        this.amountSale = 0;
        this.typeGenre = TypeGenre.values()[typeGenre];
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public double getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(double saleValue) {
        this.saleValue = saleValue;
    }

    public int getAmountSale() {
        return amountSale;
    }

    public void setAmountSale(int amountSale) {
        this.amountSale += amountSale;
    }

    public TypeGenre getTypeGenre() {
        return typeGenre;
    }

    public void setTypeGenre(TypeGenre typeGenre) {
        this.typeGenre = typeGenre;
    }

    /* 
    * Description: Allows Reproducer
    */
    @Override
    public String reproducer() {
        // TODO Auto-generated method stub
        return "Playing the Song " + this.getName();
    }

}
