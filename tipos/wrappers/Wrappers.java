package one.digitalinnovation.classes.tipos.wrappers;

public class Wrappers {
    //AUTOBOXING
    //Has the same ruling as primitive types, but as a class, they can receive null.
    //Also have some methods alltogether.
    Byte b;				//byte
    Byte b1 = 127;
    Byte b2 = -128;

    Character c;		//char
    Character c1 = 'A';
    Character c2 = 15;

    Short s;			//short
    Short s1 = 32767;
    Short s2 = -32768;

    Integer i = 2147483647;			    //int
    Integer i2 = -2147483648;

    Long l1 = 9223372036854775807L;	    //long
    Long l2 = -9223372036854775808L;

    Float f1 = 65f;			//float
    Float f2 = 65.0f;
    Float f3 = -0.5f;

    Double d1 = 1024.99;	//double
    Double d2 = 10.2456;

    //Booleano
    Boolean bO1 = true;
    Boolean b02 = false;
    Boolean b03 = Boolean.valueOf("false");

}
