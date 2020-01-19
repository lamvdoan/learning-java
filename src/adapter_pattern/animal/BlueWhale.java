package adapter_pattern.animal;

public class BlueWhale implements Whale {
    @Override
    public void swallow() {
        System.out.println("Opens mouth");
    }

    @Override
    public void breathe() {
        System.out.println("Swims up for air");
    }
}
