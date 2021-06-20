package one.digitalinnovation.classes.tipos.primitivos;

public class Primitivos {
//INTEIROS
    //byte, nullbyte=null;
    byte b;				//8bits
    byte b1 = 127;
    byte b2 = -128;
    //byte b3 = 129;	//too large

    char c;				//16 bits
    char c1 = 'A';
    char c2 = 15;
    //char c3 = 'AA';	//NOK
    //char c4 = -100;	//NOK

    short s;			//16 bits
    short s1 = 32767;
    short s2 = -32768;

    int i = 2147483647;			//32 bits
    int i2 = -2147483648;
    //int i3 = -2147483649;		//too large

    long l1 = 9223372036854775807L;	    //64 bits
    long l2 = -9223372036854775808L;
    //long l3 = 9223372036854775808L    //too large

    float f1 = 65f;			//32 bits
    float f2 = 65.0f;		//max 3.402,823,5 E+38
    float f3 = -0.5f;		//min 1.4 E-45

    double d1 = 1024.99;	//64 bits
    double d2 = 10.2456;		//4.9 E-324

//Booleano
    boolean bO1 = true;
    boolean b02 = false;
    //boolean b03 = 'false';	//NOK
    //boolean b04 = 'true';	//NOK
}
