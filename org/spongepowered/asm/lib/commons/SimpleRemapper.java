package org.spongepowered.asm.lib.commons;

import java.util.Collections;
import java.util.Map;

public class SimpleRemapper extends Remapper
{
    private final Map<String, String> mapping;
    
    public SimpleRemapper(final Map<String, String> a1) {
        this.mapping = a1;
    }
    
    public SimpleRemapper(final String a1, final String a2) {
        this.mapping = Collections.<String, String>singletonMap(a1, a2);
    }
    
    public String mapMethodName(final String a1, final String a2, final String a3) {
        final String v1 = /*EL:55*/this.map(a1 + '.' + a2 + a3);
        /*SL:56*/return (v1 == null) ? a2 : v1;
    }
    
    public String mapInvokeDynamicMethodName(final String a1, final String a2) {
        final String v1 = /*EL:61*/this.map('.' + a1 + a2);
        /*SL:62*/return (v1 == null) ? a1 : v1;
    }
    
    public String mapFieldName(final String a1, final String a2, final String a3) {
        final String v1 = /*EL:67*/this.map(a1 + '.' + a2);
        /*SL:68*/return (v1 == null) ? a2 : v1;
    }
    
    public String map(final String a1) {
        /*SL:73*/return this.mapping.get(a1);
    }
}
