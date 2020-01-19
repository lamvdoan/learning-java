package facade_pattern.device;

public class Amplifier extends Electronics {
    public void inputSelector(String input) {
        System.out.println("Amplifier input: " + input);
    }

    public void setVolume(int volume) {
        System.out.println("Setting volume level: " + volume);
    }
}
