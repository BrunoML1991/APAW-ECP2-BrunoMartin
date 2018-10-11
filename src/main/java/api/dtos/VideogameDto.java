package api.dtos;

import api.entities.Category;

public class VideogameDto implements Dto {

    private String id;
    private String title;
    private String synopsis;
    private String company;
    private String iconicCharacterId;
    private Category category;

    public VideogameDto(String title, String iconicCharacterId) {
        this.title = title;
        this.iconicCharacterId = iconicCharacterId;
    }

    public String getCompany() {
        return company;
    }

    public void setId(String id) {
        this.id = id;
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

    public Category getCategory() {
        return category;
    }

    public VideogameDto setSynopsis(String synopsis) {
        this.synopsis = synopsis;
        return this;
    }

    public VideogameDto setCompany(String company) {
        this.company = company;
        return this;
    }

    public VideogameDto setCategory(Category category) {
        this.category = category;
        return this;
    }

    public String getIconicCharacterId() {
        return iconicCharacterId;
    }

    @Override
    public String toString() {
        return "VideogameDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", synopsis='" + synopsis + '\'' +
                ", company='" + company + '\'' +
                ", iconicCharacterId='" + iconicCharacterId + '\'' +
                ", category=" + category +
                '}';
    }

}
