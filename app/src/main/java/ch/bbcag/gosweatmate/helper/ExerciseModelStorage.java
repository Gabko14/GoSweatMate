package ch.bbcag.gosweatmate.helper;

public class ExerciseModelStorage {
    Integer id = null;
    String name = "";
    String imageLink = "";

    public ExerciseModelStorage(String name, Integer id) {
        this.name = name;
        this.id = id;
    }

    public ExerciseModelStorage(String name, Integer id, String imageLink) {
        this.name = name;
        this.id = id;
        this.imageLink = imageLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageLink() {
        return imageLink;
    }

    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
}
