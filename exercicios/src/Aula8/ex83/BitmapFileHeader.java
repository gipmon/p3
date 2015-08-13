// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author Ant—nio Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex83;

import java.nio.ByteBuffer;

public class BitmapFileHeader {
	 private static final short type = 19778;   //4D 42    // must be 'BM' to declare a bmp-file
	    private int size;       // specifies the size of the file in bytes
	    private static final short reserved1 = 0;  // P3 must always be set to zero
	    private static final short reserved2 = 0;  // must always be set to zero
	    private int offBits; // specifies the offset from the
	    					 // beginning of the file to the bitmap data
	    
	    public BitmapFileHeader(int size, int offBits){
	    	this.size = size;
	    	this.offBits = offBits;
	    }
	    
	    public BitmapFileHeader(byte[] array){
	    	ByteBuffer wrapper = ByteBuffer.wrap(array);
	    	if(wrapper.getShort(0) != type){
	    		throw new IllegalArgumentException("Type is invalid!");
	    	}
	    	this.size = wrapper.getInt(2);
	    	this.offBits =wrapper.getInt(10);
	    }
	    
	    public byte[] getFileHeader(){
	    	ByteBuffer wrapper = ByteBuffer.allocate(14);
	    	wrapper.putShort(type);
	    	wrapper.putInt(size);
	    	wrapper.putShort(reserved1);
	    	wrapper.putShort(reserved2);
	    	wrapper.putInt(offBits);
			return wrapper.array();
	    }
	    
	    public byte[] getFileHeaderReversed(){
	    	ByteBuffer wrapper = ByteBuffer.allocate(14);
	    	wrapper.putShort(Short.reverseBytes(type));
	    	wrapper.putInt(Integer.reverseBytes(size));
	    	wrapper.putShort(Short.reverseBytes(reserved1));
	    	wrapper.putShort(Short.reverseBytes(reserved2));
	    	wrapper.putInt(Integer.reverseBytes(offBits));
			return wrapper.array();
	    }
	    
	    public int getSize(){
	    	return this.size;
	    }
	    
	    public void setSize(int size){
	    	this.size = size;
	    }
	    
	    public int getoffBits(){
	    	return this.offBits;
	    }
	    
	    @Override public String toString(){
	    	return "-- BitMap File Header --\nType: BM\nSize: "+size+" bytes\nReserved 1: "+reserved1
	    			+"\nReserved 2: "+reserved2+"\nOffbits: "+offBits+"\n";
	    }
	    
	    @Override public boolean equals(Object b){
	    	if(b==null){
	    		return false;
	    	}else if(b.getClass()!=getClass()){
	    		return false;
	    	}else{
	    		return size==((BitmapFileHeader)b).size && offBits==((BitmapFileHeader)b).offBits;
	    	}
	    }
}
