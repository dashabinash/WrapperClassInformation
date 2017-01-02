package com.dash.abinash.DemoProgram1;

public class WrapperClassDemoProgram1 {

	public static void main(String[] args) {

		 WrapperClassDemoProgram1 obj=new WrapperClassDemoProgram1();
		 
		/*
		 * @Param x : primitive data type representation
		 * 
		 * @param iref : Object representation
		 */
		int x = 10;
		Integer iref = new Integer(x);

		System.out.println("X = " + x);
		System.out.println("iref : " + iref);
		/*
		 * iref is a Integer and Object type refernce as Object is the Super
		 * class .
		 */
		if (iref instanceof Integer) {
			System.out.println("Iref is instance of Integer.");
		} else {
			System.out.println("Not instance of Integer.");
		}

		/*
		 * intValue() converts Object type to primitive data type .(Non-static
		 * method) valueOf() converts primitive type to Object type .(Static
		 * method)
		 */
		/*
		 * If programmer passes any other String rather than String having
		 * Integer format ,then java.lang.NumberFormatException Exception arises
		 * .
		 */
		
		int y = iref.intValue();
		Integer z = Integer.valueOf("12");
		System.out.println("y =" + y);
		System.out.println("z =" + z);

		/*
		 * @iref.getClass().getName() returns name of Wrapper Class it holds .
		 */
		System.out.println(iref.getClass().getName());

		char a = 'I';
		Character cref = new Character(a);
		System.out.println("Primitive char data type :" + cref.charValue());

		String floatinput = "18.45f";
		Float fref = new Float(floatinput);// fref--->First Float reference
		float f = fref.floatValue();
		Float fref1 = Float.valueOf(f);// fref1--->Second Float reference
		if (fref1 instanceof Float) {
			System.out.println("fref1 is instance of Float.");
		}
		
		/*
		 * parseFloat() converts String primitive Data type to float data type .
		 */
		Float f1 = Float.parseFloat(floatinput);
		System.out.println("After converting String to floating point Number :"
				+ " " + f1);
		/*
		 *  Below code snippet demonstration will clarify narrow conversion and broad conversion,implicit and
		 *  explicit typecasting .
		 *  And some parts of data type assignments . 
		 */
		
		
		/*
		 * 1 byte= 8 bits  
		 * boolean- 1 bit ::No range
		 * char   - 2 byte:: \u0000(0) to \uffff(65,535 inclusive)
		 * byte   - 1 byte::-128(-2^7) to +127(inclusive(2^7-1)
		 * short  - 2 byte::-32,768 (-2^15) to 32,767 (inclusive(2^15 -1))
		 * int    - 4 byte::- 2,147,483,648 (-2^31) to 2,147,483,647(inclusive(2^31 -1))
		 * long   - 8 byte::-9,223,372,036,854,775,808(-2^63) to 9,223,372,036,854,775,807(inclusive(2^63 -1))
		 * float  - 4 byte::No range
		 * double - 8 byte::No range
		 */
		
		/*
		 * Here as lint is of Long type and having memory of 8 bytes .and
		 * it has been assgined to an integer which is having memory of 4 bytes.So,automatically implicit type casting happened . 
		 * as iint is of Integer type and memory having 4 bytes which is smaller that long,programmer to has to type cast explicityly.
		 */
		
		/*
		 * NOTE :: When ever programming is doing any assignment through data type ,then he/she has to take care of two prospective below .
		 *                (i)Whether assignment is satisfying data type range criteria or not .
		 *                (ii)Whether narrow conversion or broad conversion.
		 *    For more information find the readme for this.
		 */
		long lint=12323;
		int iint=(int)1234l;
		System.out.println("lint ="+lint);
		System.out.println("iint ="+iint);
		
		/*
		 * Byte range is between -128 to +127 ,so within that range if any value programmer is assigning,
		 * then that value will be considered as byte value.Although it looks like int is getting assigned,
		 * actually it's not .
		 */
		byte b1=121;
		/*
		 * Now 131 is out of byte range,so will be considered a integer and you can see the concept of narrow conversion here .
		 * byte<-->int .So explicitly type casted required .
		 */
		byte b=(byte)131;
		//byte b2=(byte) 2147483648;//Error :-after type casting ,int is out of range .
		System.out.println("b ="+b);//Dobut on o/p how ?
		System.out.println("b1 ="+b1);
		
		long longvalue=9223372036854775807L;
		//long longvalue1=9223372036854775808L;----->out of long range
		//long longvalue4=9223372036854775807;---->out of int range
		/*
		 * It will be print O/P as 214748364 is in the int range .
		 */
		long longvalue5=214748364;
		System.out.println("longvalue ="+longvalue);
		System.out.println("longvalue5 ="+longvalue5);
		
		/*
		 * int to long ---> narrow conversion(explicitly type casted)
		 */
		int i=(int) 9223372036854775807L;
		System.out.println("i ="+i);
		
		/*
		 * Whenever programmer passes the arguments ,first it tries to search the exact match if any .
		 * If not found then ,it converts to the respective object type.
		 */
		obj.function1(100);
		Integer iref2=new Integer(200);
		obj.function1(iref2);
		
		/*
		 * If programmer passes long type argument then,as it does not find exact match and argument is getting converted from Long to int type
		 * which is also called narrow conversion,will be explicitly type casted.
		 */
		obj.function3((int)1265L);
		/*
		 * will not be any problem as i finds exact match of integer.
		 */
		obj.function3(1987);
		/*
		 * It is a broad conversion and argument is getting converted from int to long type
		 * which will be implicitly type casted.
		 */
		obj.function4(1234);
		/*
		 * Doubt on what priority basis ,while calling function5() ,long part is getting executed.
		 */
		obj.function5(134134);
		
		

	}
	
	public void function1(Integer iref){
		System.out.println("It is a Wrapper class reference.");
	}
	
	public void function1(int i){
		System.out.println("It is a primitive data type.");
	}
	
	public void function3(int i){
		System.out.println("It is a primitive data type");
	}
	
	public void function4(long l){
		System.out.println("It is long data type.");
	}
	public void function5(long l){
		System.out.println("It is long data type.");
	}
	public void function5(short s){
		System.out.println("It is short data type.");
	}
	public void function5(double d){
		System.out.println("It is double data type.");
	}
	public void function5(float f){
		System.out.println("It is float data type.");
	}
	
	
	
	
}
