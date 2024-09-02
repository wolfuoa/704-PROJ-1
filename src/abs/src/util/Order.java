package util;

import java.io.Serializable;

public class Order implements Serializable{
    private final int quantity;
    private final int volume_liquid_0;
    private final int volume_liquid_1;
    private final int volume_liquid_2;
    private final int volume_liquid_3;


    public Order(int quantity, int volume_liquid_0, int volume_liquid_1, int volume_liquid_2, int volume_liquid_3) {
        this.quantity = quantity;
        this.volume_liquid_0 = volume_liquid_0;
        this.volume_liquid_1 = volume_liquid_1;
        this.volume_liquid_2 = volume_liquid_2;
        this.volume_liquid_3 = volume_liquid_3;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getLiquidVolume(int liquid_num) {
    	switch(liquid_num)
    	{
    	case 0:
    		return this.volume_liquid_0;
    	case 1:
    		return this.volume_liquid_1;
    	case 2:
    		return this.volume_liquid_2;
    	case 3:
    		return this.volume_liquid_3;
    	default:
    		break;
    	}
    	   
        return 0;
    }
}