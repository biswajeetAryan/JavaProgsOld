package temp;

import java.util.ArrayList;
import java.util.List;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;

public class Temp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Object i = new ArrayList().listIterator();
		System.out.println(i instanceof List);
	}

}
