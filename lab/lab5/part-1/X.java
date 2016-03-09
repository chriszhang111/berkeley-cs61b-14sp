public class X{
	public String string;
	public int number;

	public X(){
		this.string = "X Constructor with no parameter. ";
		this.number = 111;
	}

	public X(String givenString, int givenNumber){
		this.string = givenString;
		this.number = givenNumber;
	}

	public static void X_method(){
		System.out.println("static X_method execution");
	}

	public void X_method_noStatic(){
		System.out.println("non static X_method execution");
	}
}