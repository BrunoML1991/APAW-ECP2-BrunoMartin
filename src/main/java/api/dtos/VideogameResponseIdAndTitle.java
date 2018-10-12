package api.dtos;

public class VideogameResponseIdAndTitle {

    private String id;
    private String title;

    public VideogameResponseIdAndTitle (String id, String title){
        this.id = id;
        this.title = title;
    }

    @Override
    public String toString() {
        return "VideogameResponseIdAndTitle{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
