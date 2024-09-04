package util;

import java.io.Serializable;

public class RoboticArm implements Serializable {
    private ArmStatus armStatus;
    private GripperStatus gripperStatus;

    public RoboticArm() {
        this.armStatus = ArmStatus.IDLE;
        this.gripperStatus = gripperStatus.OPEN;
    }

    public enum ArmStatus {
        IDLE,
        ABOVE_COLLECTION_POINT,
        ON_COLLECTION_POINT,
        ABOVE_CONVEYOR_START,
        ON_CONVEYOR_START,
        ABOVE_REMOVAL_POINT,
        ON_REMOVAL_POINT,
        ABOVE_PACKAGE,
        ON_PACKAGE,
        ABOVE_LID_SURPLUS,
        ON_LID_SURPLUS,
        ABOVE_POSITION_THREE,
        ON_POSITION_THREE,
        ABOVE_ROTARY_TURNTABLE,
        ON_ROTARY_TURNTABLE;
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
        case "IDLE":
            this.armStatus = armStatus.IDLE;
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