package exercise.z_learning;

public class ArrayTest {
    public static void main(String[] args) {
        String[] movies = new String[]{"Die Hard", "It", "Hard Die", "Star Wars", "Hard Hi Die"};
        String[] movieCopy = new String[movies.length];
        System.arraycopy(movies, 0, movieCopy, 0, movies.length);

        for (String s : movieCopy) {
            System.out.println(s);
        }
    }
}
