package RemoteControl;

public class Demo {
    public static void main(String[] args) {
        RemoteControlWithUndo remote = new RemoteControlWithUndo();

        Light livingRoomLight = new Light();
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        Command lightOn = new LightOnCommand(livingRoomLight);
        Command lightOff = new LightOffCommand(livingRoomLight);

        Command garageUp = new GarageDoorUpCommand(garageDoor);
        Command garageDown = new GarageDoorDownCommand(garageDoor);

        Command stereoOn = new StereoOnWithCDCommand(stereo);
        Command stereoOff = new StereoOffCommand(stereo);

        remote.setCommand(0, lightOn, lightOff);
        remote.setCommand(1, garageUp, garageDown);
        remote.setCommand(2, stereoOn, stereoOff);

        // test normal usage
        remote.onButtonWasPressed(0);
        remote.offButtonWasPressed(0);
        remote.undoButtonWasPressed();

        remote.onButtonWasPressed(2);
        remote.offButtonWasPressed(2);

        // Party Mode
        Command[] partyOn = { lightOn, stereoOn, garageUp };
        Command[] partyOff = { lightOff, stereoOff, garageDown };
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remote.setCommand(3, partyOnMacro, partyOffMacro);

        System.out.println("--- Party Mode ---");
        remote.onButtonWasPressed(3);
        remote.offButtonWasPressed(3);
        remote.undoButtonWasPressed();
    }


}
