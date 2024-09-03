package util;

public class RoboticArm {
    private ArmStatus armStatus;
    private GripperStatus gripperStatus;

    public RoboticArm() {
        this.armStatus = ArmStatus.POSITION_A;
        this.gripperStatus = gripperStatus.OPEN;
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

    public void setArmStatus(String status) {
        switch(status)
        {
        case "A":
            this.armStatus = armStatus.POSITION_A;
            break;
        default:
            break;
        }
    }

    public void setGripperStatus(String status) {
        switch(status)
        {
        case "open":
            this.gripperStatus = gripperStatus.OPEN;
            break;
        case "closed":
            this.gripperStatus = gripperStatus.CLOSED;
            break;
        default:
            break;
        }
    }
}