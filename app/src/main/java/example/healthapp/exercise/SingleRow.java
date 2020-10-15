package example.healthapp.exercise;

public class SingleRow {
    private int image;
    private String excercise,time;


    public SingleRow(String time) {
        this.time = time;
    }

    public SingleRow(int image, String excercise, String time) {
        this.image = image;
        this.excercise = excercise;
        this.time = time;
    }

    public int getImage() {
        return image;
    }

    public String getExcercise() {
        return excercise;
    }

    public String getTime() {
        return time;
    }
}
