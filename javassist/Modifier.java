package javassist;

import java.lang.reflect.Modifier;

public class Modifier
{
    public static final int PUBLIC = 1;
    public static final int PRIVATE = 2;
    public static final int PROTECTED = 4;
    public static final int STATIC = 8;
    public static final int FINAL = 16;
    public static final int SYNCHRONIZED = 32;
    public static final int VOLATILE = 64;
    public static final int VARARGS = 128;
    public static final int TRANSIENT = 128;
    public static final int NATIVE = 256;
    public static final int INTERFACE = 512;
    public static final int ABSTRACT = 1024;
    public static final int STRICT = 2048;
    public static final int ANNOTATION = 8192;
    public static final int ENUM = 16384;
    
    public static boolean isPublic(final int a1) {
        /*SL:53*/return (a1 & 0x1) != 0x0;
    }
    
    public static boolean isPrivate(final int a1) {
        /*SL:61*/return (a1 & 0x2) != 0x0;
    }
    
    public static boolean isProtected(final int a1) {
        /*SL:69*/return (a1 & 0x4) != 0x0;
    }
    
    public static boolean isPackage(final int a1) {
        /*SL:77*/return (a1 & 0x7) == 0x0;
    }
    
    public static boolean isStatic(final int a1) {
        /*SL:85*/return (a1 & 0x8) != 0x0;
    }
    
    public static boolean isFinal(final int a1) {
        /*SL:93*/return (a1 & 0x10) != 0x0;
    }
    
    public static boolean isSynchronized(final int a1) {
        /*SL:101*/return (a1 & 0x20) != 0x0;
    }
    
    public static boolean isVolatile(final int a1) {
        /*SL:109*/return (a1 & 0x40) != 0x0;
    }
    
    public static boolean isTransient(final int a1) {
        /*SL:117*/return (a1 & 0x80) != 0x0;
    }
    
    public static boolean isNative(final int a1) {
        /*SL:125*/return (a1 & 0x100) != 0x0;
    }
    
    public static boolean isInterface(final int a1) {
        /*SL:133*/return (a1 & 0x200) != 0x0;
    }
    
    public static boolean isAnnotation(final int a1) {
        /*SL:143*/return (a1 & 0x2000) != 0x0;
    }
    
    public static boolean isEnum(final int a1) {
        /*SL:153*/return (a1 & 0x4000) != 0x0;
    }
    
    public static boolean isAbstract(final int a1) {
        /*SL:161*/return (a1 & 0x400) != 0x0;
    }
    
    public static boolean isStrict(final int a1) {
        /*SL:169*/return (a1 & 0x800) != 0x0;
    }
    
    public static int setPublic(final int a1) {
        /*SL:177*/return (a1 & 0xFFFFFFF9) | 0x1;
    }
    
    public static int setProtected(final int a1) {
        /*SL:185*/return (a1 & 0xFFFFFFFC) | 0x4;
    }
    
    public static int setPrivate(final int a1) {
        /*SL:193*/return (a1 & 0xFFFFFFFA) | 0x2;
    }
    
    public static int setPackage(final int a1) {
        /*SL:200*/return a1 & 0xFFFFFFF8;
    }
    
    public static int clear(final int a1, final int a2) {
        /*SL:207*/return a1 & ~a2;
    }
    
    public static String toString(final int a1) {
        /*SL:217*/return java.lang.reflect.Modifier.toString(a1);
    }
}