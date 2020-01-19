package facade_pattern.device;

public abstract class Electronics {
    private String name;

    public Electronics() {
        this.name = this.getClass().getSimpleName();
    }

    public void on() {
        System.out.println("Turning " + name + " on.");
    }

    public void off() {
        System.out.println("Turning " + name + " off.");
    }
}
