package util;

import java.io.Serializable;

public class RoboticArm implement Serializable {
    private ArmStatus armStatus;
    private GripperStatus gripperStatus;

    public RoboticArm() {
        this.armStatus = ArmStatus.POSITION_IDLE;
        this.gripperStatus = gripperStatus.OPEN;
    }

    public enum ArmStatus {
        POSITION_IDLE,
        POSITION_ABOVE_COLLECTION_POINT,
        POSITION_ON_COLLECTION_POINT,
        POSITION_ABOVE_CONVEYOR_START,
        POSITION_ON_CONVEYOR_START,
        POSITION_ABOVE_REMOVAL_POINT,
        POSITION_ON_REMOVAL_POINT,
        POSITION_ABOVE_PACKAGE,
        POSITION_ON_PACKAGE,
        POSITION_ABOVE_LID_SURPLUS,
        POSITION_ON_LID_SURPLUS,
        POSITION_ABOVE_POSITION_THREE,
        POSITION_ON_POSITION_THREE,
        POSITION_ABOVE_ROTARY_TURNTABLE,
        POSITION_ON_ROTARY_TURNTABLE;
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