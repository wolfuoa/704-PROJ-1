package util;

public class RoboticArm {
    private ArmStatus armStatus;
    private GripperStatus gripperStatus;

    public RoboticArm() {
        this.armStatus = POSITION_A;
        this.gripperStatus = OPEN;
    }

    public enum ArmStatus {
        POSITION_A,
        POSITION_B,
        POSITION_C;
    }

    public enum GripperStatus {
        OPEN,
        CLOSED;
    }

    public ArmStatus getArmStatus() {
        return this.armStatus;
    }

    public GripperStatus getGripperStatus() {
        return this.gripperStatus;
    }

    public setArmStatus(String status) {
        switch(status)
        {
        case "A":
            this.armStatus = POSITION_A;
            break;
        default:
            break;
        }
    }

    public setGripperStatus(String status) {
        switch(status)
        {
        case "open":
            this.gripperStatus=OPEN;
            break;
        case "closed":
            this.gripperStatus=CLOSED;
            break;
        default:
            break;
        }
    }
}