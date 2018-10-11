package api.dtos;

import api.entities.Review;

import java.util.ArrayList;
import java.util.List;

public class IconicCharacterDto implements Dto{

    private String id;
    private String name;
    private String role;
    private List<Review> reviews = new ArrayList<>();

    public IconicCharacterDto(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "IconicCharacter{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }

    public String getRole() {
        return role;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
