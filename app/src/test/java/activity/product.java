package activity;

public class product {

    private String image;
    private String title;


    public product(){

    }

    public product(String image, String title, String shortDesc, double price, double rating) {
        this.image = image;
        this.title = title;

    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }


}