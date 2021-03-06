package com.ares.gui.guis.containergui.buttons;

import com.ares.gui.buttons.ToggleButton;
import com.ares.gui.guis.AresGui;
import com.ares.hack.hacks.BaseHack;
import com.ares.gui.buttons.Button;

public class HackToggleButton extends Button
{
    private BaseHack hack;
    
    public HackToggleButton(final AresGui a1, final int a2, final int a3, final int a4, final int a5, final BaseHack a6) {
        super(a1, a2, a3, a4, a5, "");
        this.hack = a6;
    }
    
    public BaseHack getHack() {
        /*SL:21*/return this.hack;
    }
    
    public void setToggle(final boolean a1) {
        /*SL:26*/this.hack.setEnabled(a1);
    }
    
    public boolean getToggled() {
        /*SL:31*/return this.hack.getEnabled();
    }
    
    public void toggle() {
        /*SL:36*/this.setToggle(!this.getToggled());
    }
    
    public void draw() {
        /*SL:42*/if (this.hack.getEnabled()) {
            HackToggleButton.mc.func_110434_K().func_110577_a(ToggleButton.ON_SWITCH);
        }
        else {
            HackToggleButton.mc.func_110434_K().func_110577_a(ToggleButton.OFF_SWITCH);
        }
        func_146110_a(/*EL:51*/this.field_146128_h, this.field_146129_i, 0.0f, 0.0f, this.field_146120_f, this.field_146121_g, (float)this.field_146120_f, (float)this.field_146121_g);
    }
}
