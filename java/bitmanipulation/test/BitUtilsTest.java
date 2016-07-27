package bitmanipulation.test;

import org.junit.Test;

import bitmanipulation.implementations.BitUtils;
import org.junit.Assert;
import playgroundutils.BaseTest;
import playgroundutils.TestData;

public class BitUtilsTest extends BaseTest {
    
    @Test
    public void testGetBit() {
        int count = TestData.getScaleCount();
        for (int i = 0; i < count; i++) {
            int number = TestData.getInt();
            String binary = Integer.toBinaryString(number);
            int index = TestData.getInt(binary.length());
            Assert.assertEquals(binary.charAt(binary.length() - index - 1) == '1',
                                BitUtils.getBit(number, index));
        }
    }
    
    @Test
    public void testSetBit() {
        int count = TestData.getScaleCount();
        for (int i = 0; i < count; i++) {
            int number = TestData.getInt();
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(number));
            int index = TestData.getInt(binary.length());
            boolean on = TestData.getBoolean();
            char bit = on ? '1' : '0';
            binary.setCharAt(binary.length() - index - 1, bit);
            Assert.assertEquals(Integer.parseUnsignedInt(binary.toString(), 2), BitUtils.setBit(number, index, on));
        }
    }
    
    @Test
    public void testClearBitsMSBThroughI() {
        int count = TestData.getScaleCount();
        for (int i = 0; i < count; i++) {
            int number = TestData.getInt();
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(number));
            int index = TestData.getInt(binary.length());
            for(int j = 0; j < binary.length() - index; j++) {
                binary.setCharAt(j, '0');
            }
            Assert.assertEquals(Integer.parseUnsignedInt(binary.toString(), 2), BitUtils.clearBitsMSBToI(number, index));
        }
    }

    @Test
    public void testClearBitsIThrough0() {
        int count = TestData.getScaleCount();
        for (int i = 0; i < count; i++) {
            int number = TestData.getInt();
            StringBuilder binary = new StringBuilder(Integer.toBinaryString(number));
            int index = TestData.getInt(binary.length());
            for(int j = binary.length() - 1; j > binary.length() - index - 1; j--) {
                binary.setCharAt(j, '0');
            }
            Assert.assertEquals(Integer.parseUnsignedInt(binary.toString(), 2), BitUtils.clearBitsIto0(number, index));
        }
    }

}
