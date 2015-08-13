package treino.pratico.headers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class HeadersWriter{
	
	private List<File> dirs = new LinkedList<>();
	private static List<File> ignore;
	private static String path;
	@SuppressWarnings("unused")
	private static File initFolder;
	@SuppressWarnings("unused")
	private static String extension;
	
	public HeadersWriter(String pathT){
		path = pathT;
		getOptions();
		
		File dir = new File(path);
		
		ignore = getIgnoreDirs();
		
		for(File f : dir.listFiles()){
			if(!ignore.contains(f) && f.isDirectory()){
				dirs.add(f);
			}
		}
	}
	
	public HeadersWriter(){
		this(".");
	}
	
	static{
		path = ".";
		initFolder = new File(path+"/src");
		extension = "java";
	}
	
	private void getOptions(){
		Scanner sc = new Scanner(System.in);
		
		File tmp;
		
		do{
			System.out.print("Change the path? (Default: "+path+")  ");
			String help = sc.nextLine();
			if(help.length()!=0){
				path = help;
			}
			tmp = new File(path);
		}while(!tmp.exists() || !tmp.isDirectory());
		
		System.out.print("What is the extension? (Default: *.java) ");
		String help = sc.nextLine();
		if(help.length()!=0){
			extension = help;
		}
		
		System.out.print("What is the folder to init printing headers in? (Default: src)  ");
		help = sc.nextLine();
		if(help.length()!=0){
			extension = help;
		}
		
		sc.close();
	}
	
	private static List<File> getIgnoreDirs() {
		List<File> ignoredFiles = new LinkedList<>();
		File list = new File(path+"/code_headers/ignore.txt");
		
		if(!list.exists()){
			System.out.println("Ignore list File not configured! - "+list.getPath());
		}else{
			try {
				Scanner sc = new Scanner(list);
				while(sc.hasNextLine()){
					File dir = new File(path+"/"+sc.next());
					if(dir.exists()){
						ignoredFiles.add(dir);
					}
				}
				sc.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		
		return ignoredFiles;
	}
	
	public void printDirectoryList(){
		System.out.println("\n-- Directory List: --");
		System.out.println(printDirectoryTree(new File(path)));
	}
	
	public static String printDirectoryTree(File folder) {
	    if (!folder.isDirectory()) {
	        throw new IllegalArgumentException("This is not a Directory!");
	    }
	    return printDirectoryTree(folder, "");
	}

	private static String printDirectoryTree(File folder, String indent) {
	    if (!folder.isDirectory()) {
	        throw new IllegalArgumentException("folder is not a Directory");
	    }
	    
	    String out = "";
	    
	    for (File file : folder.listFiles()) {
	        if (file.isDirectory() && !ignore.contains(file)) {
	            out += printDirectoryTree(file, indent + "|  ");
	        }
	    }
	    
	    return indent + "+--" + folder.getName() + "/\n" + out;
	}
}
