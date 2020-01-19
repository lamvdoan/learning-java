package facade_pattern.device;

public class BluRayPlayer extends Electronics {
    public void playMovie(String movie) {
        System.out.println("Playing movie: " + movie);
    }

    public void stopMovie() {
        System.out.println("Stopping movie");
    }
}
