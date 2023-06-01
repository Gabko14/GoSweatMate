package ch.bbcag.gosweatmate.helper;

public class ExerciseModelStorage {
    String name = "";
    Integer id = null;

    public ExerciseModelStorage(String name, Integer id) {
        this.name = name;
        this.id = id;
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
}
