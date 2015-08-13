package Aula13.ex131;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Iterator;

public class Organizacao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private MyList<Pais> paises;
	private String nome;
	
	public Organizacao(String nome){
		this.nome = nome;
		this.paises = new MyList<Pais>();
	}
	
	public boolean add(Pais p){
		if(paises.exists(p)){
			return false;
		}
		paises.add(p);
		return true;
	}
	
	public boolean exists(Pais p){
		return paises.exists(p);
	}
	
	public boolean remove(Pais p){
		return paises.remove(p);
	}

	public String getNome() {
		return nome;
	}
	
	public Iterator<Pais> iterator(){
		return paises.iterator();
	}
	
	public void saveOrganizacao(File file){
		try {
			FileOutputStream fo = new FileOutputStream(file);
			ObjectOutputStream os = new ObjectOutputStream(fo);
			os.writeObject(this);
			os.flush();
			os.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadOrganizacao(File file){
		try {
			FileInputStream fi = new FileInputStream(file);
			ObjectInputStream is = new ObjectInputStream(fi);
			Organizacao org = ((Organizacao)is.readObject());
			nome = org.nome;
			paises = org.paises;
			is.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Override public boolean equals(Object b){
		if(b==null){
			return false;
		}else if(b.getClass()!=getClass()){
			return false;
		}else{
			return (((Organizacao)b).nome).equals(nome) &&
					(((Organizacao)b).paises).equals(paises);
		}
	}
	
	@Override public String toString(){
		String out = "ORGANIZAÇÃO: "+nome+"\nLista:\n";
		Iterator<Pais> it = iterator();
		while(it.hasNext()){
			out += it.next();
		}
		return out;
	}
}
