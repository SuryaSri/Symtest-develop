<<<<<<< HEAD
package expression;

import java.util.LinkedHashSet;
import java.util.Set;

public class Type {
	public static final String BOOLEAN = "boolean";
	public static final String INT = "int";

    private static Type mType = null;
	private static Set<String> mTypes = new LinkedHashSet<String>();
	
	private Type() {
		Type.mTypes.add(Type.BOOLEAN);
		Type.mTypes.add(Type.INT);
	}
	
	public static void addType(String typeName) {
		if(Type.mType == null) {
			Type.mType = new Type();
		}
		Type.mTypes.add(typeName);
	}
	
	public static boolean hasType(String name) {
		if(Type.mType == null) {
			Type.mType = new Type();
		}
		return Type.mTypes.contains(name);
	}
	
	public static Type getInstance() {
		if(Type.mType == null) {
			Type.mType = new Type();
		}
		return Type.mType;
	}
}
=======
package expression;

import java.util.LinkedHashSet;
import java.util.Set;

public class Type {
	public static final String BOOLEAN = "boolean";
	public static final String INT = "int";

    private static Type mType = null;
	private static Set<String> mTypes = new LinkedHashSet<String>();
	
	private Type() {
		Type.mTypes.add(Type.BOOLEAN);
		Type.mTypes.add(Type.INT);
	}
	
	public static void addType(String typeName) {
		if(Type.mType == null) {
			Type.mType = new Type();
		}
		Type.mTypes.add(typeName);
	}
	
	public static boolean hasType(String name) {
		if(Type.mType == null) {
			Type.mType = new Type();
		}
		return Type.mTypes.contains(name);
	}
	
	public static Type getInstance() {
		if(Type.mType == null) {
			Type.mType = new Type();
		}
		return Type.mType;
	}
}
>>>>>>> 25ebf124fd450adaed57ee1006dedb1a7734bcf9
