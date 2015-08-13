package Aula12.ex121;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class Inspector {
	private Class<?> c;
	
	public Inspector(Class<?> c){
		this.c = c;
	}
	
	public String getCharacteristic(){
		String out = "";
		out += getClassModifiers();
		out += c.getSimpleName();
		out += getClassSuperClasses();
		out += getClassInterfaces();
		out += "{\n";
		out += getConstructors(c);
		out += "\n"+getAtributes();
		out += "\n"+getMethods();
		out += "\n}";
		return out;
	}
	
	public String getAtributes(){
		String out = "";
		
		for(Field f : c.getDeclaredFields()){
			out += "\t"+replacePackageName(f.toString())+";\n";
		}
		
		return out;
	}
	
	public String getMethods(){
		String out = "";
		
		for(Method m : c.getDeclaredMethods()){
			out += "\t"+replacePackageName(m.toString())+";\n";
		}
		
		return out;
	}
	
	public String getConstructors(Class<?> classe){
		String out = "";
		Constructor<?>[] list = classe.getConstructors();
		
		for(int i=0; i<list.length; i++){
			out += "\t"+replacePackageName(i+" - "+list[i].toString())+";\n";
		}
		
		return out;
	}
	
	public String getClassModifiers(){
		String out = "";
		
		int m = c.getModifiers();
		
		if (Modifier.isPublic(m)){
		         out += "public ";
		}
		
		if (Modifier.isAbstract(m)){
		         out += "abstract ";
		}
		
		if (Modifier.isFinal(m)){ 
		         out += "final "; 
		}
		
		return out;
	}
	
	public String getClassSuperClasses(){
		Class<?> clas = c.getSuperclass();
		if(clas.getSimpleName()==null || clas.getSimpleName().length()==0 ||  clas.getSimpleName().equals("Object")){
			return "";
		}
		return " extends "+clas.getSimpleName();
	}
	
	public String getClassInterfaces(){
		String out = "";
		
		if(c.getInterfaces().length!=0){
			out += " implements";
		}
		
		for(Class<?> clas : c.getInterfaces()){
			out += " "+clas.getSimpleName();
		}
		return out;
	}
	
	private String replacePackageName(String name){
		return name.replace(c.getPackage().getName()+"."+c.getSimpleName()+".", "");
	}
	
	public Object instance(){
		return instanceByConstructor(c);
	}
	
	private Object instanceByConstructor(Class<?> p){
		System.out.println(getConstructors(c));
		System.out.print("Número do construtor: ");
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();//= 0; //default!
		
		Object inst = createObject(p.getDeclaredConstructors()[n]);
		return inst;
	}
	
	//cria o objecto através do constructor selecionado
	private Object createObject(Constructor<?> cl) {
		Class<?>[] paramTypes = cl.getParameterTypes(); //paramTypes
		Object[] paramsObj = new Object[paramTypes.length]; //paramsObj
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); //Scanner
		
		for(int i=0; i < paramTypes.length; i++){
			System.out.print(paramTypes[i].getSimpleName()+": ");
			
			switch(paramTypes[i].getSimpleName()){
				case "double":
					paramsObj[i] = sc.nextDouble();
					break;
				case "int":
					paramsObj[i] = sc.nextInt();
					break;
				case "char":
					paramsObj[i] = sc.next().charAt(0);
					break;
				case "String":
					paramsObj[i] = sc.next();
					break;
				default:
					paramsObj[i] = instanceByConstructor(paramTypes[i]);
					break;
			}
		}
		
		Object obj = new Object(); //retorno
		
		try {
			obj = cl.newInstance(paramsObj);
		} catch (InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException e) {
			e.printStackTrace();
		}
		return  obj;
	}
	
}
