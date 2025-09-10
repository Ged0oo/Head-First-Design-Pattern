# RemoteControlAPI

## Overview
RemoteControlAPI is a Java project that demonstrates the **Command design pattern** through a remote control simulation. The project allows you to control various devices (Light, GarageDoor, Stereo) and supports advanced features like undo and macro commands (Party Mode).

## Architecture

### Design Principles
- **Decoupling:** The Command pattern separates the invoker (remote control) from the receivers (devices), allowing flexible assignment and execution of commands.
- **Extensibility:** New devices and commands can be added with minimal changes to existing code.
- **Undo Support:** Commands encapsulate both execution and undo logic.
- **Macro Commands:** Multiple commands can be grouped and executed together.

### Class Diagram

```
+----------------+        +-------------------+
|   RemoteControl|<>------|   Command         |
+----------------+        +-------------------+
        |                        ^
        |                        |
        v                        |
+----------------+        +-------------------+
|RemoteControl   |        |Concrete Commands  |
|WithUndo        |        +-------------------+
+----------------+        |LightOnCommand     |
                          |LightOffCommand    |
                          |GarageDoorUpCommand|
                          |GarageDoorDownCmd  |
                          |StereoOnWithCDCmd  |
                          |StereoOffCommand   |
                          |MacroCommand       |
                          |NoCommand          |
                          +-------------------+

+----------------+
| Receivers      |
+----------------+
| Light          |
| GarageDoor     |
| Stereo         |
+----------------+
```

## Class and Interface Details

### Command.java
- **Type:** Interface
- **Methods:**
  - `void execute()`: Executes the command.
  - `void undo()`: Reverts the command (default: may be empty for some commands).
- **Role:** Base for all command objects. Enables encapsulation of requests as objects, allowing parameterization and queuing of requests.

### Light.java
- **Type:** Receiver
- **Fields:**
  - Internal state (e.g., isOn)
- **Methods:**
  - `void on()`: Turns the light on.
  - `void off()`: Turns the light off.
- **Role:** Represents a light device. Contains the actual business logic for switching the light.

### LightOnCommand.java / LightOffCommand.java
- **Type:** Concrete Command
- **Fields:**
  - `Light light`: Reference to the receiver.
- **Methods:**
  - `execute()`: Calls `light.on()` or `light.off()`.
  - `undo()`: Calls the opposite action.
- **Role:** Encapsulates light actions. Implements the Command interface to allow the remote to control the light.

### GarageDoor.java
- **Type:** Receiver
- **Fields:**
  - Internal state (e.g., isOpen)
- **Methods:**
  - `void up()`: Opens the garage door.
  - `void down()`: Closes the garage door.
- **Role:** Represents a garage door device. Contains the actual business logic for opening/closing the door.

### GarageDoorUpCommand.java / GarageDoorDownCommand.java
- **Type:** Concrete Command
- **Fields:**
  - `GarageDoor garageDoor`: Reference to the receiver.
- **Methods:**
  - `execute()`: Calls `garageDoor.up()` or `garageDoor.down()`.
  - `undo()`: Calls the opposite action.
- **Role:** Encapsulates garage door actions. Implements the Command interface to allow the remote to control the garage door.

### Stereo.java
- **Type:** Receiver
- **Fields:**
  - Internal state (e.g., isOn, volume, mode)
- **Methods:**
  - `void on()`: Turns the stereo on.
  - `void off()`: Turns the stereo off.
  - `void setCD()`: Sets the stereo to CD mode.
  - `void setVolume(int level)`: Sets the volume.
- **Role:** Represents a stereo system. Contains the actual business logic for operating the stereo.

### StereoOnWithCDCommand.java / StereoOffCommand.java
- **Type:** Concrete Command
- **Fields:**
  - `Stereo stereo`: Reference to the receiver.
- **Methods:**
  - `execute()`: Turns stereo on, sets CD, sets volume.
  - `undo()`: Turns stereo off.
- **Role:** Encapsulates stereo actions. Implements the Command interface to allow the remote to control the stereo.

### MacroCommand.java
- **Type:** Concrete Command
- **Fields:**
  - `Command[] commands`: Array of commands to execute.
- **Methods:**
  - `execute()`: Executes all commands in order.
  - `undo()`: Undoes all commands in reverse order.
- **Role:** Allows batch execution/undo of commands (e.g., Party Mode). Useful for scenarios where multiple devices need to be controlled together.

### NoCommand.java
- **Type:** Null Object (Concrete Command)
- **Methods:**
  - `execute()`: Does nothing.
  - `undo()`: Does nothing.
- **Role:** Used for unassigned remote slots to avoid null checks. Implements the Command interface with empty methods.

### RemoteControl.java
- **Type:** Invoker
- **Fields:**
  - Arrays of on/off commands for each slot.
- **Methods:**
  - `setCommand(int slot, Command onCommand, Command offCommand)`: Assigns commands to slots.
  - `onButtonWasPressed(int slot)`: Executes the on command.
  - `offButtonWasPressed(int slot)`: Executes the off command.
- **Role:** Basic remote control for executing commands. Does not support undo.

### RemoteControlWithUndo.java
- **Type:** Invoker
- **Fields:**
  - Tracks last executed command for undo.
- **Methods:**
  - `undoButtonWasPressed()`: Calls `undo()` on last command.
- **Role:** Extends RemoteControl to support undo functionality. Remembers the last command executed and allows reverting it.

### Demo.java
- **Type:** Client
- **Role:** Sets up receivers, commands, and remote control. Demonstrates usage, including normal operations, undo, and macro commands. Example usage:

```java
RemoteControlWithUndo remote = new RemoteControlWithUndo();
Light livingRoomLight = new Light();
GarageDoor garageDoor = new GarageDoor();
Stereo stereo = new Stereo();
Command lightOn = new LightOnCommand(livingRoomLight);
Command lightOff = new LightOffCommand(livingRoomLight);
// ...
remote.setCommand(0, lightOn, lightOff);
remote.onButtonWasPressed(0);
remote.undoButtonWasPressed();
```

## Typical Interactions
1. **Client** creates receivers and commands.
2. **Client** assigns commands to remote control slots.
3. **User** presses remote buttons, triggering command execution.
4. **Undo** is available for the last command.
5. **MacroCommand** can trigger multiple device actions at once.

## Extending the Project
To add a new device or command:
1. **Create a Receiver class** (e.g., `Fan.java`).
2. **Implement Command classes** for actions (e.g., `FanOnCommand`, `FanOffCommand`).
3. **Assign commands** to the remote in `Demo.java`.

## Example Output
```
Light is ON
Light is OFF
Undo: Light is ON
Stereo is ON with CD
Stereo is OFF
--- Party Mode ---
Light is ON
Stereo is ON with CD
Garage Door is OPEN
Light is OFF
Stereo is OFF
Garage Door is CLOSED
Undo: Light is ON
Undo: Stereo is ON with CD
Undo: Garage Door is OPEN
```

## References
- [Head First Design Patterns](https://www.oreilly.com/library/view/head-first-design/0596007124/)
- [Command Pattern - Refactoring Guru](https://refactoring.guru/design-patterns/command)

## License
This project is for educational purposes.
