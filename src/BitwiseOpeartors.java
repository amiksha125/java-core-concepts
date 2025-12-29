public class BitwiseOpeartors {
    public static void main(String[] args) {
        //Computers tore data in bits[ 0 / 1 ] only
        int a = 5;
        //System.out.println(Integer.toBinaryString(a)); // 32-bit numbers with leading zeros removed
        // 5 is stored as:
        //00000000 00000000 00000000 00000101
        // Bitwise operators allows us to modify and access these bits
        // operations become faster than arithmetic as we are directly modifying the bits stored
        // operands of bitwise operators are --> byte short int long
        // no operand should be in decimal
        // because the bits of floating-point numbers are divided into parts like sign, exponent, significant.

//        following are bitwise operators in Java

        // and operator &
        // or operator |
        // xor ^
        // not ~
        // left shift <<
        // right shift >>
        // unsigned right shift >>>

        int c = 5 & 4;
        System.out.println("and operator:");
        System.out.println(" 5 binary: "+Integer.toBinaryString(5));
        System.out.println(" 4 binary: "+Integer.toBinaryString(4));
        // 101 & 100 = 100 = 2^2 = 4
        System.out.println(" and: "+Integer.toBinaryString(c));
        System.out.println(" 5 & 4 = "+c);

        int or = 5 | 7;
        System.out.println("or operator:");
        System.out.println(" 5 binary: "+Integer.toBinaryString(5));
        System.out.println(" 7 binary: "+Integer.toBinaryString(7));
        // 101 | 111 = 111 = 2^2 + 2^1 + 2^0 = 4 + 2 + 1 = 7
        System.out.println(" or: "+Integer.toBinaryString(or));
        System.out.println(" 5 | 7 = "+or);

        int xor = 5 | 2;
        System.out.println("xor operator:"); // if the bits are different then only result is 1
        System.out.println(" 5 binary: "+Integer.toBinaryString(5));
        System.out.println(" 2 binary: "+Integer.toBinaryString(2));
        // 100 ^ 010 = 111 = 7 in decimal
        System.out.println(" xor: "+Integer.toBinaryString(xor));
        System.out.println(" 5 | 2 = "+xor);

        int not = ~5;
        System.out.println("not operator"); // It does not need two operand
        System.out.println(" 5 binary: "+Integer.toBinaryString(5));
        //101 = 010, leading zeros will also convert to 1
        System.out.println(" not: "+Integer.toBinaryString(not));
        System.out.println(" ~5 = "+not);

        int leftShift = 5 << 1;
        System.out.println("left shift operator"); // It does not need two operand
        System.out.println(" 5 binary: "+Integer.toBinaryString(5));
        //101 = 010, leading zeros will also convert to 1
        System.out.println(" left shift: "+Integer.toBinaryString(leftShift));
        System.out.println(" 5 << 1 = "+leftShift);

        int rightShift = 5 >> 2;
        System.out.println("right shift operator"); // It does not need two operand
        System.out.println(" 5 binary: "+Integer.toBinaryString(5));
        //101 = 010, leading zeros will also convert to 1
        System.out.println(" right shift: "+Integer.toBinaryString(rightShift));
        System.out.println(" 5 >> 2 = "+rightShift);

        int unignedRightShift = -5 >>> 1;
        System.out.println("unsigned right shift"); // same as right shift, it shifts the bits to right based on the specified position
        //Right shift operator: It changes LSB(Least Significant Bit) that represent the sign, if positive then 0 for negative its 1
       // But unsigned right shift will the LSB with 0 in case of negative number
        int rightNeg = -5 >> 1;
        System.out.println(" -5 >> 1 = "+Integer.toBinaryString(rightNeg));
        System.out.println(" -5 >>> 1 = "+Integer.toBinaryString(unignedRightShift)); // 1 bit is less its LSB is 0
        // unsigned --> not signed
    }
}
