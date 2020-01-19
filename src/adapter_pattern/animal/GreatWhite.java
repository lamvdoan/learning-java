package adapter_pattern.animal;

public class GreatWhite implements Shark {
    @Override
    public void bite() {
        System.out.println("Bites with jaw");
    }

    @Override
    public void breathe() {
        System.out.println("Breathe through gills");
    }
}
