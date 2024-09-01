package util;

import java.io.Serializable;

public class Order implements Serializable{
    private final int quantity;
    private final int fluid_1;
    private final int fluid_2;
    private final int fluid_3;
    private final int fluid_4;


    public Order(int quantity, int fluid_1, int fluid_2, int fluid_3, int fluid_4) {
        this.quantity = quantity;
        this.fluid_1 = fluid_1;
        this.fluid_2 = fluid_2;
        this.fluid_3 = fluid_3;
        this.fluid_4 = fluid_4;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public int getFluid(int fluid_num) {
    	switch(fluid_num)
    	{
    	case 1:
    		return this.fluid_1;
    	case 2:
    		return this.fluid_2;
    	case 3:
    		return this.fluid_3;
    	case 4:
    		return this.fluid_4;
    	default:
    		break;
    	}
    	   
        return 0;
    }
}