import java.io.*;
public class part1{
	public static void main(String[] args){
		X x = new X();
		X x_para = new X("x_para", 124);

		// System.out.println(x.string); //X Constructor with no parameter. 
		// System.out.println(x.number); // 111
		// System.out.println(x_para.string); //x_para
		// System.out.println(x_para.number); // 124

		// Y y = new Y();
		// System.out.println(y.string); //call super from Y 
		// System.out.println(y.number); //112
		// System.out.println(y.string_Y); //Y with no parameter
		// System.out.println(y.number_Y); //222


		// following 4 print states all have run-time error since x reference an object that isnt a Y.
		//error : Exception in thread "main" java.lang.ClassCastException: X cannot be cast to Y
		//at part1.main(part1.java:19)
		// Y y2 = new Y();
		// y2 = (Y)x; //run-time error
		// System.out.println(y2.string);
		// System.out.println(y2.number); 
		// System.out.println(y2.string_Y);
		// System.out.println(y2.number_Y);

		// X x2 = new Y();
		// System.out.println(x2.string); //call super from Y  
		// System.out.println(x2.number); // 112
		// System.out.println(x2.string_Y); //compile error: cannot find symbol . Since class X don't have filed string_Y
		// System.out.println(x2.number_Y); //compile error: cannot find symbol . Since class X don't have filed number_Y


		// X x3 = new X();
		// Y y3 = new Y();
		// Y y4 = new Y();
		// //y3 = (Y)x3; //run-time error : Exception in thread "main" java.lang.ClassCastException: X cannot be cast to Yat part1.main(part1.java:39)
		// y4.new_Y_method(); //new_Y_method execution
		// Y.X_method(); //overriden static X_method execution from Y
		// y4.X_method(); //also can work; still print : overriden static X_method execution from Y

		//start lab5 part1
		X[] xa = new X[5];
		Y[] ya = new Y[5];

		// for (int i = 0 ; i<5; i++){
		// 	System.out.println(xa[i]); //no compile/run error, all print "null";
		// }

		//initialization xa and ya
		for (int i =0; i<5; i++){
			xa[i] = new X();
			ya[i] = new Y();
		}

		// for (int i = 0 ; i<5; i++){
		// 	System.out.println(xa[i]); // print out object addr like : X@1540e19d
		// 	System.out.println(ya[i]); //// print out object addr like : Y@677327b6
		// }

		// System.out.println(xa[0].string);//X Constructor with no parameter. 
		// System.out.println(xa[0].number);//111
		// System.out.println(ya[0].string);//call super from Y 
		// System.out.println(ya[0].number);//112
		// System.out.println(ya[0].string_Y); //Y with no parameter
		// System.out.println(ya[0].number_Y); //222

		//assign xa to ya  per element// compile-error : error: incompatible types: X cannot be converted to Y
		// for (int i = 0 ;i < 5; i++){
		// 	ya[i] = xa[i];
		// }

		// //assign xa to ya by case w/out cast
		// ya = xa; //compile error: incompatible types: X[] cannot be converted to Y[]

		// //assign xa to ya by case w/out cast
		// ya = (Y[]) xa; // run-time error :Exception in thread "main" java.lang.ClassCastException: [LX; cannot be cast to [LY;

		// for (int i = 0 ; i<5; i++){
		// 	System.out.println(xa[i]); // print out object addr like : X@1540e19d
		// 	System.out.println(ya[i]); //// print out object addr like : Y@677327b6
		// }

		// //assign ya to xa, w/out cast.
		// xa  = ya;

		// // for (int i = 0 ; i<5; i++){ // print out after-assigned reuslts
		// // 	System.out.println(xa[i]); // still print out object addr like : X@1540e19d
		// // 	System.out.println(ya[i]); //// still print out object addr like : Y@677327b6
		// // }

		// System.out.println(xa[0].string);//call super from Y 
		// System.out.println(xa[0].number);//112	
		// xa[0].X_method();//static X_method execution
		// ya[0].X_method(); //overriden static X_method execution from Y

		// //assign xa to ya w/out Cast
		// for (int i = 0 ;i < 5; i++){
		// 	ya[i] = xa[i]; //complie error : X cannot be converted to Y
		// }

		// //assign xa to ya w/ Cast
		ya = (Y[])xa;
		// System.out.println(ya[0].string);//call super from Y 
		// System.out.println(ya[0].number);//112	
		// ya[0].X_method();//overriden static X_method execution from Y
		// ya[0].new_Y_method(); //new_Y_method execution
		
		//then assign it back
		xa = ya; //run-time error:Exception in thread "main" java.lang.ClassCastException: [LX; cannot be cast to [LY;
		System.out.println(xa[0].string);//call super from Y 
		System.out.println(xa[0].number);//112	
		xa[0].X_method();//static X_method execution
		ya[0].X_method(); //overriden static X_method execution from Y



	}
}