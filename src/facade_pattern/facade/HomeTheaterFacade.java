package facade_pattern.facade;

import facade_pattern.device.Amplifier;
import facade_pattern.device.BluRayPlayer;
import facade_pattern.device.TV;
import facade_pattern.device.TheaterLights;

public class HomeTheaterFacade {
    private Amplifier amp;
    private BluRayPlayer bluRay;
    private TheaterLights lights;
    private TV tv;

    public HomeTheaterFacade() {
        this.amp = new Amplifier();
        this.bluRay = new BluRayPlayer();
        this.lights = new TheaterLights();
        this.tv = new TV();
    }

    public void watchTv() {
        System.out.println("\nGetting ready to watch TV");
        System.out.println("----------------------------");
        amp.on();
        amp.inputSelector("Blu Ray");
        amp.setVolume(7);
        bluRay.on();
        bluRay.playMovie("Big Bang Theory");
        tv.on();
        lights.on();
    }

    public void endTv() {
        System.out.println("\nShutting down home theater");
        System.out.println("----------------------------");
        amp.off();
        bluRay.stopMovie();
        bluRay.off();
        tv.off();
        lights.off();
    }
}
