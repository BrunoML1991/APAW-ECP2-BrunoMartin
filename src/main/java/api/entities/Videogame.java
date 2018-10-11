package api.entities;

public class Videogame {

    private String id;
    private String title;
    private String synopsis;
    private String company;
    private IconicCharacter iconicCharacter;
    private Category category;

    public Videogame(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public String getCompany() {
        return company;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Videogame setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public Videogame setCompany(String company) {
        this.company = company;
        return this;
    }

    public void setIconicCharacter(IconicCharacter iconicCharacter) {
        this.iconicCharacter = iconicCharacter;
    }

    public Videogame setCategory(Category category) {
        this.category = category;
        return this;
    }

    @Override
    public String toString() {
        return "Videogame{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", company='" + company + '\'' +
                ", iconicCharacter=" + iconicCharacter +
                ", category=" + category +
                '}';
    }

}
