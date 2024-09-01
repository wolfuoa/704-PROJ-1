package util;

import java.io.Serializable;

public class Order implements Serializable{
    private final int quantity;
    private final int fluid_0;
    private final int fluid_1;
    private final int fluid_2;
    private final int fluid_3;


    public Order(int quantity, int fluid_0, int fluid_1, int fluid_2, int fluid_3) {
        this.quantity = quantity;
        this.fluid_0 = fluid_0;
        this.fluid_1 = fluid_1;
        this.fluid_2 = fluid_2;
        this.fluid_3 = fluid_3;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getFluid(int fluid_num) {
    	switch(fluid_num)
    	{
    	case 0:
    		return this.fluid_0;
    	case 1:
    		return this.fluid_1;
    	case 2:
    		return this.fluid_2;
    	case 3:
    		return this.fluid_3;
    	default:
    		break;
    	}
    	   
        return 0;
    }
}