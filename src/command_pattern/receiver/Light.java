package command_pattern.receiver;

public class Light {
    private String source;

    public Light(String source) {
        this.source = source + " ";
    }

    public Light() {
        source = "";
    }

    public void on() {
        System.out.println(source + "Light is on!");
    }

    public void off() {
        System.out.println(source + "Light is off!");
    }
}
