package com.sun.jna.ptr;

public class DoubleByReference extends ByReference
{
    public DoubleByReference() {
        this(0.0);
    }
    
    public DoubleByReference(final double a1) {
        super(8);
        this.setValue(a1);
    }
    
    public void setValue(final double a1) {
        /*SL:37*/this.getPointer().setDouble(0L, a1);
    }
    
    public double getValue() {
        /*SL:41*/return this.getPointer().getDouble(0L);
    }
}
