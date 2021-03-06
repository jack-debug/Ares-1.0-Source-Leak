package javassist.bytecode;

import java.util.Map;
import java.io.IOException;
import java.io.DataInputStream;

public class DeprecatedAttribute extends AttributeInfo
{
    public static final String tag = "Deprecated";
    
    DeprecatedAttribute(final ConstPool a1, final int a2, final DataInputStream a3) throws IOException {
        super(a1, a2, a3);
    }
    
    public DeprecatedAttribute(final ConstPool a1) {
        super(a1, "Deprecated", new byte[0]);
    }
    
    @Override
    public AttributeInfo copy(final ConstPool a1, final Map a2) {
        /*SL:54*/return new DeprecatedAttribute(a1);
    }
}
