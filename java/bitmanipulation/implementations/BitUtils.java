package bitmanipulation.implementations;

public class BitUtils {
    
    public static boolean getBit(int number, int index) {
        // shift 1 leftwards by i bits -> 000100...00 where there are i zeros after the 1
        // perform logical AND with the number to clear all other bits
        // if the result is equal to zero, then that bit is zero so return false
        // if it is not equal to zero, then that bit is a one, so return true
        return ((number & (1 << index)) != 0);
    }
    
    public static int setBit(int number, int index, boolean on) {
        if(on) {
            // shift 1 leftwards by i bits -> 000100...00 where there are i zeros after the 1
            // perform logical OR with the number, so that other bits remain what they are
            // the ith bit will be turned to 1 (or remains 1 if it is already 1)
            return (number | (1 << index));
        } else {
            // shift 1 leftwards by i bits and negate -> 111011...11 where there are i ones after the 0
            // perform logical AND with the number, so that other bits remain what they are
            // the ith bit will be turned to a 0 (or remains 0 if it is already 0)
            int mask = ~(1 << index);
            return (number & mask);
        }
    }
    
    public static int setBitOn(int number, int index) {
        return setBit(number, index, true);
    }
    
    public static int setBitOff(int number, int index) {
        return setBit(number, index, false);
    }
    
    public static int clearBitsMSBToI(int number, int index) {
        // shift 1 leftwards by i bits and subtract 1 -> 000111...11 where there are i ones after the first 1
        // perform logical AND with the number, so that right bits remain but left bits become 0
        return number & ((1 << index) - 1);
    }
    
    public static int clearBitsIto0(int number, int index) {
        // create sequence of all 1s and shift left by i+1 bits -> 111100...00 where there are i zeros in total
        // perform logical AND with the number, so that left bits remain but right bits become 0
        return number & (-1 << (index));
    }

}
