package api.entities;

import java.util.ArrayList;
import java.util.List;

public class IconicCharacter {

    private String id;
    private String name;
    private String role;
    private List<Review> reviews = new ArrayList<>();

    public IconicCharacter(String name) {
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

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setId(String id) {
        this.id = id;
    }

    public IconicCharacter setName(String name) {
        this.name = name;
        return this;
    }

    public IconicCharacter setRole(String role) {
        this.role = role;
        return this;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(Integer.parseInt(review.getId()));
    }
}
