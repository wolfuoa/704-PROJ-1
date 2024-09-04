package util;

import java.io.Serializable;

public class RoboticArm implements Serializable {
    private ArmStatus armStatus;
    private GripperStatus gripperStatus;

    public RoboticArm() {
        this.armStatus = ArmStatus.IDLE;
        this.gripperStatus = GripperStatus.OPEN;
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
            this.armStatus = ArmStatus.IDLE;
            break;
        case "ABOVE_COLLECTION_POINT":
            this.armStatus = ArmStatus.ABOVE_COLLECTION_POINT;
            break;
        case "ON_COLLECTION_POINT":
            this.armStatus = ArmStatus.ON_COLLECTION_POINT;
            break;
        case "ABOVE_CONVEYOR_START":
            this.armStatus = ArmStatus.ABOVE_CONVEYOR_START;
            break;
        case "ON_CONVEYOR_START":
            this.armStatus = ArmStatus.ON_CONVEYOR_START;
            break;
        case "ABOVE_REMOVAL_POINT":
            this.armStatus = ArmStatus.ABOVE_REMOVAL_POINT;
            break;
        case "ON_REMOVAL_POINT":
            this.armStatus = ArmStatus.ON_REMOVAL_POINT;
            break;
        case "ABOVE_PACKAGE":
            this.armStatus = ArmStatus.ABOVE_PACKAGE;
            break;
        case "ON_PACKAGE":
            this.armStatus = ArmStatus.ON_PACKAGE;
            break;
        case "ABOVE_LID_SURPLUS":
            this.armStatus = ArmStatus.ABOVE_LID_SURPLUS;
            break;
        case "ON_LID_SURPLUS":
            this.armStatus = ArmStatus.ON_LID_SURPLUS;
            break;
        case "ABOVE_POSITION_THREE":
            this.armStatus = ArmStatus.ABOVE_POSITION_THREE;
            break;
        case "ON_POSITION_THREE":
            this.armStatus = ArmStatus.ON_POSITION_THREE;
            break;
        case "ABOVE_ROTARY_TURNTABLE":
            this.armStatus = ArmStatus.ABOVE_ROTARY_TURNTABLE;
            break;
        case "ON_ROTARY_TURNTABLE":
            this.armStatus = ArmStatus.ON_ROTARY_TURNTABLE;
            break;
        default:
            break;
        }
    }

    public void setGripperStatus(String status) {
        switch(status)
        {
        case "OPEN":
            this.gripperStatus = GripperStatus.OPEN;
            break;
        case "CLOSED":
            this.gripperStatus = GripperStatus.CLOSED;
            break;
        default:
            break;
        }
    }
}