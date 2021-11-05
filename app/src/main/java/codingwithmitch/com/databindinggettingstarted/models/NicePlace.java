package codingwithmitch.com.databindinggettingstarted.models;

public class NicePlace {
    private String title;
    private String imageUrl;

    public NicePlace(String imageUrl, String title){
        this.title = title;
        this.imageUrl = imageUrl;
    }

    public NicePlace(){

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private String getImageUrl() { return imageUrl; }

    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
}
