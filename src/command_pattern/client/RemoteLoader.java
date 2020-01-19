package command_pattern.client;

import command_pattern.command.*;
import command_pattern.invoker.RemoteController;
import command_pattern.receiver.Fan;
import command_pattern.receiver.Light;

import java.util.Arrays;
import java.util.List;

public class RemoteLoader {
    public static void main(String[] args) {
        RemoteController remote = setUpRemote();

        remote.onButtonPressed(2);
        remote.offButtonPressed(2);
        remote.undoButtonPressed();

        remote.onButtonPressed(3);
        remote.undoButtonPressed();
        remote.onButtonPressed(4);
        remote.undoButtonPressed();
    }

    public static RemoteController setUpRemote() {
        Light livingRoomLight = new Light("Living Room");
        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);

        Fan fan = new Fan();
        FanLowCommand fanLow = new FanLowCommand(fan);
        FanMediumCommand fanMedium = new FanMediumCommand(fan);
        FanHighCommand fanHigh = new FanHighCommand(fan);
        FanOffCommand fanOff = new FanOffCommand(fan);

        List<Command> partyOn = Arrays.asList(livingRoomLightOn, fanHigh);
        List<Command> partyOff = Arrays.asList(livingRoomLightOff, fanOff);
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        RemoteController remote = new RemoteController();
        remote.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remote.setCommand(1, fanLow, fanOff);
        remote.setCommand(2, fanMedium, fanOff);
        remote.setCommand(3, fanHigh, fanOff);
        remote.setCommand(4, partyOnMacro, partyOffMacro);

        return remote;
    }
}
