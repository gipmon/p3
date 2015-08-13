package Aula11.ex112;
/**
 * @author Ant?nio Rafael Ferreira
 * nmec 67405
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

import Aula11.ex112.Ementa.DiaSemana;
import Aula11.ex112.alimentos.Alimento;
import Aula11.ex112.pratos.Prato;
import Aula11.ex112.pratos.PratoDieta;
import Aula11.ex112.pratos.PratoVegetariano;

public class GerirEmenta implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private LinkedHashMap<Integer, Alimento> ingredientes = new LinkedHashMap<Integer, Alimento>();
	private LinkedHashMap<String, Prato> pratos = new LinkedHashMap<String, Prato>();
	private Ementa ementa = new Ementa("Ementa", "Restaurante");
	
	public void adicionarIngrediente(Alimento add){
		ingredientes.put(ingredientes.size(), add);
	}
	
	public void seralizeObject(File f){
		try {
			FileOutputStream out = new FileOutputStream(f.getPath()); 
			ObjectOutputStream s = new ObjectOutputStream(out);
			s.writeObject(ingredientes);
			s.writeObject(pratos);
			s.writeObject(ementa);
			s.flush();
			s.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("unchecked") public void unserializeObject(File f){
		FileInputStream in = null;
		try {
			in = new FileInputStream(f.getPath());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    ObjectInputStream s = null;
		try {
			s = new ObjectInputStream(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    try {
			ingredientes = (LinkedHashMap<Integer, Alimento>)s.readObject();
		    pratos = (LinkedHashMap<String, Prato>)s.readObject();
		    ementa = (Ementa)s.readObject();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	}
	
	public void criarPrato(String nome, String tipo){
		if(nome.length()==0){
			throw new IllegalArgumentException("Nome do prato inválido!");
		}
		if(tipo.equals("Normal")){
			pratos.put(nome, new Prato(nome));
		}else if(tipo.equals("Dieta")){
			pratos.put(nome, new PratoDieta(nome, 400));
		}else if(tipo.equals("Vegetariano")){
			pratos.put(nome, new PratoVegetariano(nome));
		}
	}
	
	public void apagarPrato(String nome){
		if(!pratos.containsKey(nome)){
			throw new IllegalArgumentException("Prato não existe!");
		}
		pratos.remove(nome);
	}
	
	public void addIngredienteToPrato(int ingredienteKey, String prato){
		if(!ingredientes.containsKey(ingredienteKey)){
			throw new IllegalArgumentException("Não existe esse ingrediente!");
		}
		if(!pratos.containsKey(prato)){
			throw new IllegalArgumentException("Não existe esse prato!");
		}
		Alimento a = ingredientes.get(ingredienteKey);
		Prato p = pratos.get(prato);
		p.addIngrediente(a);
	}
	
	public void removeIngredienteOfPrato(int ingredienteKey, String prato){
		if(!ingredientes.containsKey(ingredienteKey)){
			throw new IllegalArgumentException("Não existe esse ingrediente!");
		}
		if(!pratos.containsKey(prato)){
			throw new IllegalArgumentException("Não existe esse prato!");
		}
		Prato p = pratos.get(prato);
		p.removeIngrediente(ingredienteKey);
	}
	
	public String verIngredientes(){
		String out = "";
		for(Entry<Integer, Alimento> a : ingredientes.entrySet()){
			out += "ID: "+a.getKey()+" - "+a.getValue()+"\n";
		}
		return out;
	}

	public Alimento[] ingredientesOfPrato(String prato){
		if(!pratos.containsKey(prato)){
			throw new IllegalArgumentException("N?o existe esse prato!");
		}
		return pratos.get(prato).getAlimentos();
	}
	
	public String ingredientsOfPratoToString(String prato){
		return pratos.get(prato).toString();
	}
	
	public String verPratos(){
		String out = "";
		for(Entry<String, Prato> p : pratos.entrySet()){
			out += p.getKey()+" - "+p.getValue();
		}
		return out;
	}
	
	public void addPratoToEmenta(String prato, DiaSemana dia){
		if(!pratos.containsKey(prato)){
			throw new IllegalArgumentException("N?o existe esse prato!");
		}
		Prato p = pratos.get(prato);
		ementa.addPrato(p, dia);
	}
	
	public void removePratoFromEmenta(String prato, DiaSemana dia){
		if(!pratos.containsKey(prato)){
			throw new IllegalArgumentException("N?o existe esse prato!");
		}
		Prato p = pratos.get(prato);
		ementa.removePrato(dia , p);
	}
	
	public String printEmenta(){
		return ementa.toString();
	}
}
