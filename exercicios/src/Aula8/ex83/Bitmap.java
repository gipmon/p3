/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex83;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

public class Bitmap {
	private BitmapFileHeader bitmapFileHeader;
    private BitmapInfoHeader bitmapInfoHeader;
    private Pixel[][] pixelData; // pixel data, only for 24bits, 3 bytes R G B
    private String nameOfFile;
    
    public Bitmap(BitmapFileHeader bitmapFileHeader, 
    		BitmapInfoHeader bitmapInfoHeader,
    		Pixel[][] newpixelData,
    		String nameOfFile){
    	this.bitmapFileHeader = bitmapFileHeader;
    	this.bitmapInfoHeader = bitmapInfoHeader;
    	this.pixelData = newpixelData;
    	this.nameOfFile = nameOfFile;
    }
    
    public Bitmap(File bitmapfile){
    	nameOfFile = bitmapfile.getName();
    	try{
			RandomAccessFile file = new RandomAccessFile(bitmapfile, "r");
			//get File Header
			ByteBuffer fileHeader = ByteBuffer.allocate(14);
			
		    fileHeader.putShort(Short.reverseBytes(file.readShort()));
		    fileHeader.putInt(Integer.reverseBytes(file.readInt()));
		    fileHeader.putShort(Short.reverseBytes(file.readShort()));
		    fileHeader.putShort(Short.reverseBytes(file.readShort()));
		    fileHeader.putInt(Integer.reverseBytes(file.readInt()));
		    
		    bitmapFileHeader = new BitmapFileHeader(fileHeader.array());
		    //get Info Header
			ByteBuffer infoHeader = ByteBuffer.allocate(40);
			
			for(int i=0; i<3; i++)
				infoHeader.putInt(Integer.reverseBytes(file.readInt()));
			infoHeader.putShort(Short.reverseBytes(file.readShort()));
			infoHeader.putShort(Short.reverseBytes(file.readShort()));
			for(int i=0; i<6; i++)
				infoHeader.putInt(Integer.reverseBytes(file.readInt()));
			
			bitmapInfoHeader = new BitmapInfoHeader(infoHeader.array());
			//get Data
			byte[] data = new byte[Math.abs(bitmapInfoHeader.getHeight()*bitmapInfoHeader.getWidth()*3)];
			file.read(data);
		    file.close();
			//Pixeldata (Pixel)
			pixelData = new Pixel[Math.abs(bitmapInfoHeader.getHeight())][Math.abs(bitmapInfoHeader.getWidth())];
			
			int t = 0;
			for(int i = 0; i < pixelData.length; i++){
				for(int j = 0; j < pixelData[i].length; j++){
					pixelData[i][j] = new Pixel(data[t++], data[t++], data[t++]);
				}
			}
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void write(File dst){
    	try{
    		RandomAccessFile file = new RandomAccessFile(dst, "rw");
    		file.write(bitmapFileHeader.getFileHeaderReversed());
    		file.write(bitmapInfoHeader.getInfoHeaderReversed());
    		for(int i=0; i < pixelData.length; i++){
    			for(int j=0; j < pixelData[i].length; j++){
    				if(pixelData[i][j]!=null)
    					file.write(pixelData[i][j].getBytesReversed());
    			}
    		}
    		file.close();
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    public void resize025(File dst){
    	Bitmap resized = new Bitmap(new BitmapFileHeader(bitmapFileHeader.getFileHeader()), 
    			new BitmapInfoHeader(bitmapInfoHeader.getInfoHeader()), pixelData.clone(), dst.getName());
    	
    	//aten‹o que diminuir para 1/4 Ž o mesmo q dividir por 2 em cada um dos lados!
    	resized.bitmapInfoHeader.setWidth((int) (resized.bitmapInfoHeader.getWidth()*0.5));
    	resized.bitmapInfoHeader.setHeight((int) (resized.bitmapInfoHeader.getHeight()*0.5));
    	int proportion = 2;
    	
    	Pixel[][] newPixelData = new Pixel[Math.abs(resized.bitmapInfoHeader.getHeight())][Math.abs(resized.bitmapInfoHeader.getWidth())];
    	int ci = 1, cj = 1;
    	for(int ik = 0, i = 0; i < pixelData.length && ik < newPixelData.length; i++, cj=1){
    		if(ci==proportion){
    			ci = 1;
    			continue;
    		}else{
    			for(int jk = 0, j=0; j < pixelData[i].length && jk < newPixelData[ik].length; j++){
        			if(cj==proportion){
        				cj = 1;
        			}else{
        				newPixelData[ik][jk] = resized.pixelData[i][j];
        				cj++;
        				jk++;
        			}
        		}
    			ik++;
    			ci++;
    		}
    	}
    	
    	resized.bitmapFileHeader.setSize(Math.abs(resized.bitmapInfoHeader.getWidth()*3*resized.bitmapInfoHeader.getHeight()));
    	resized.pixelData = newPixelData;
    	resized.write(dst);
    }
    
    public void flipVertical(File dst){
    	Bitmap fliped = new Bitmap(new BitmapFileHeader(bitmapFileHeader.getFileHeader()), 
    			new BitmapInfoHeader(bitmapInfoHeader.getInfoHeader()), pixelData.clone(), dst.getName());
    	Pixel[][] newPixelData = new Pixel[Math.abs(fliped.bitmapInfoHeader.getHeight())][Math.abs(fliped.bitmapInfoHeader.getWidth())];
    	
    	for(int i=pixelData.length-1, ik=0; i>=0; i--, ik++){
    		for(int j=0; j<pixelData[i].length; j++){
    			newPixelData[ik][j] = pixelData[i][j].clone();
    		}
    	}
    	
    	fliped.pixelData = newPixelData;
    	fliped.write(dst);
    
    }
    
    public void flipHorizontal(File dst){
    	Bitmap fliped = new Bitmap(new BitmapFileHeader(bitmapFileHeader.getFileHeader()), 
    			new BitmapInfoHeader(bitmapInfoHeader.getInfoHeader()), pixelData.clone(), dst.getName());
    	
    	Pixel[][] newPixelData = new Pixel[Math.abs(fliped.bitmapInfoHeader.getHeight())][Math.abs(fliped.bitmapInfoHeader.getWidth())];
    	
    	for(int i=0; i<newPixelData.length; i++){
    		for(int j=newPixelData[i].length-1, jk=0; j>=0; j--, jk++){
    			newPixelData[i][j] = pixelData[i][jk].clone();
    		}
    	}
    	
    	fliped.pixelData = newPixelData;
    	fliped.write(dst);
    }
    
    public void getBmpRaw(File dst){
    	try{
    		RandomAccessFile file = new RandomAccessFile(dst, "rw");
    		for(int i=0; i < pixelData.length; i++){
    			for(int j=0; j < pixelData[i].length; j++){
    				file.write(pixelData[i][j].getBytes()); // not reversed
    			}
    		}
    		file.close();
    	}catch(FileNotFoundException e){
    		e.printStackTrace();
    	}catch(IOException e){
    		e.printStackTrace();
    	}
    }
    
    @Override public String toString(){
    	return "Nome do ficheiro: "+nameOfFile+"\n\n"+bitmapFileHeader+"\n"+bitmapInfoHeader;
    }
    
    @Override public boolean equals(Object b){
    	if(b==null){
    		return false;
    	}else if(b.getClass()!=getClass()){
    		return false;
    	}else{
    		return bitmapFileHeader.equals(((Bitmap)b).bitmapFileHeader) && bitmapInfoHeader.equals(((Bitmap)b).bitmapInfoHeader)
    			   && pixelData.equals(((Bitmap)b).pixelData) && nameOfFile.equals(((Bitmap)b).nameOfFile);
    	}
    }

	public byte[] getPixelData(){
		ByteBuffer bf = ByteBuffer.allocate(Math.abs(bitmapInfoHeader.getHeight()*bitmapInfoHeader.getWidth()*3));
		for(int i=0; i < pixelData.length; i++){
			for(int j=0; j < pixelData[i].length; j++){
				if(pixelData[i][j]!=null)
					bf.put(pixelData[i][j].getBytesReversed());
			}
		}
		
		return bf.array();
	}

	public int getWidth() {
		return Math.abs(bitmapInfoHeader.getWidth());
	}

	public int getHeight() {
		return Math.abs(bitmapInfoHeader.getHeight());
	}
}
