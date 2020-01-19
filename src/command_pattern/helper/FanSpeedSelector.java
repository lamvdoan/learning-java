package command_pattern.helper;

import command_pattern.receiver.Fan;

public class FanSpeedSelector {

    public static void setSpeedToPreviousSpeed(Fan fan, int speed) {
        switch(speed) {
            case Fan.HIGH:
                fan.high();
                break;
            case Fan.MEDIUM:
                fan.medium();
                break;
            case Fan.LOW:
                fan.low();
                break;
            case Fan.OFF:
                fan.off();
                break;
            default:
                System.out.println("WARNING!");
        }
    }
}
