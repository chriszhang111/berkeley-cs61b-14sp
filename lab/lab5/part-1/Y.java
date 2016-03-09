// Y is a subclass of X.
public class Y extends X{
	//Y, as subclass of X, has three three fields:
	//string, number, which are fileds inherited from X
	//and string_Y and number_Y which are self defined.
	public String string_Y;
	public int number_Y;

	// when exexture Y constructor, Java always firstly excute zero-parameter constructor X()
	// Y constructor can explicily call any cnstructor for its supervlass X by using "super" such that zero-parameter X() no called.
	public Y(){
		super("call super from Y ",112);
		this.string_Y = "Y with no parameter";
		this.number_Y = 222;
	}

	//override
	public static void X_method(){
		System.out.println("overriden static X_method execution from Y");
	}

	public void new_Y_method(){
		System.out.println("new_Y_method execution");
	}


}