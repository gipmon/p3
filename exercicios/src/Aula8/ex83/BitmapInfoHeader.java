// Rafael Ferreira https://github.com/gipmon/p3

/**
 * @author António Rafael Ferreira
 * nmec 67405
 */
package Aula8.ex83;

import java.nio.ByteBuffer;

public class BitmapInfoHeader {
	private static final int size = 40; // the size of this header (40 bytes)
    private int width;  // the bitmap width in pixels
    private int height; // the bitmap height in pixels
    					//Height of the bitmap in pixels. Positive for bottom to top pixel order. 
    					//Negative for top to bottom pixel order.
    private static final short planes = 1; // the number of color planes being used. Must be set to 1 
    private short bitCount;  // the number of bits per pixel (color depth) - 1, 4, 8, 16, 24, 32 
    // w * h * 3 , 24 bits, 3 bytes, RGB
    //sendo 8 bits, 1 byte, precisamos de uma palete de cores, 0 a 255
    //colocar excepção para os tipos suportados, suporta apenas inicialmente com 3bytes
    private int compression; // the compression method being used
    private int sizeImage; 	   // the image size. This is the size of the raw bitmap data 
    private int xPelsPerMeter; // the horizontal resolution of the image (pixel per meter) 
    private int yPelsPerMeter; // the vertical resolution of the image (pixel per meter)
    private int clrUsed; // the number of colors in the color palette,
    			 		 // or 0 to default to 2n
    private int clrImportant; // the number of important colors used,
    						  // or 0 when every color is important
    
    //short = 2bytes , int = 4bytes
    
    public BitmapInfoHeader(int width, int height, short bitCount,
    		int compression, int sizeImage, int xPelsPerMeter, int yPelsPerMeter,
    		int clrUsed, int clrImportant){
    	this.width = width;
    	this.height = height;
    	this.bitCount = bitCount;
    	this.compression = compression;
    	this.sizeImage = sizeImage;
    	this.xPelsPerMeter = xPelsPerMeter;
    	this.yPelsPerMeter = yPelsPerMeter;
    	this.clrUsed = clrUsed;
    	this.clrImportant = clrImportant;
    }
    
    public BitmapInfoHeader(byte[] array){
    	ByteBuffer wrapper = ByteBuffer.wrap(array);
    	if(wrapper.getInt(0) != size){
    		throw new IllegalArgumentException("Error! Invalid size!"+wrapper.getInt(0));
    	}
    	if(wrapper.getShort(12)!=planes){
    		throw new IllegalArgumentException("Error! Invalid planes!");
    	}
    	this.width = wrapper.getInt(4);
    	this.height = wrapper.getInt(8);
    	this.bitCount = wrapper.getShort(14);
    	this.compression = wrapper.getInt(16);
    	this.sizeImage = wrapper.getInt(20);
    	this.xPelsPerMeter = wrapper.getInt(24);
    	this.yPelsPerMeter = wrapper.getInt(28);
    	this.clrUsed = wrapper.getInt(32);
    	this.clrImportant =wrapper.getInt(36);
    }
    
    public byte[] getInfoHeader(){
    	ByteBuffer wrapper = ByteBuffer.allocate(40);
    	wrapper.putInt(size);
    	wrapper.putInt(width);
    	wrapper.putInt(height);
    	wrapper.putShort(planes);
    	wrapper.putShort(bitCount);
    	wrapper.putInt(compression);
    	wrapper.putInt(sizeImage);
    	wrapper.putInt(xPelsPerMeter);
    	wrapper.putInt(yPelsPerMeter);
    	wrapper.putInt(clrUsed);
    	wrapper.putInt(clrImportant);
		return wrapper.array();
    }
    
    public byte[] getInfoHeaderReversed(){
    	ByteBuffer wrapper = ByteBuffer.allocate(40);
    	wrapper.putInt(Integer.reverseBytes(size));
    	wrapper.putInt(Integer.reverseBytes(width));
    	wrapper.putInt(Integer.reverseBytes(height));
    	wrapper.putShort(Short.reverseBytes(planes));
    	wrapper.putShort(Short.reverseBytes(bitCount));
    	wrapper.putInt(Integer.reverseBytes(compression));
    	wrapper.putInt(Integer.reverseBytes(sizeImage));
    	wrapper.putInt(Integer.reverseBytes(xPelsPerMeter));
    	wrapper.putInt(Integer.reverseBytes(yPelsPerMeter));
    	wrapper.putInt(Integer.reverseBytes(clrUsed));
    	wrapper.putInt(Integer.reverseBytes(clrImportant));
		return wrapper.array();
    }
    
    public int getCompression(){
    	return compression;
    }
    
    public int getSizeRawImage(){
    	return sizeImage;
    }
    
    public void setSizeRawImage(int sizeImage){
    	this.sizeImage = sizeImage;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public void setWidth(int width){
    	this.width = width;
    }
    
    public int getHeight(){
    	return height;
    }
    
    public void setHeight(int height){
    	this.height = height;
    }
    
    @Override public String toString(){
    	return "-- Info Header --\nSize of the header: 40\nWidth: "+width+" pixeis\nHeight: "+height
    			+" pixeis\nPlanes: "+planes+"\nBitCount: "+bitCount+((bitCount==24)?"\nEspaço de cor: RGB":"")+"\nCompression: "+compression
    			+"\nSize of Image: "+sizeImage+"\nxPelsPerMeter: "+xPelsPerMeter+"\nyPelsPerMeter: "+yPelsPerMeter
    			+"\nClrUsed: "+clrUsed+"\nClrImportant: "+clrImportant+"\n\nNote: Height of the bitmap in pixels. Positive for bottom to top pixel order.\nNegative for top to bottom pixel order.\n";
    }
    
    @Override public boolean equals(Object b){
    	if(b==null){
    		return false;
    	}else if(b.getClass()!=getClass()){
    		return false;
    	}else{
    		return width==((BitmapInfoHeader)b).width && height==((BitmapInfoHeader)b).height  && bitCount==((BitmapInfoHeader)b).bitCount  && compression==((BitmapInfoHeader)b).compression
    			   && sizeImage==((BitmapInfoHeader)b).sizeImage  && xPelsPerMeter==((BitmapInfoHeader)b).xPelsPerMeter  && yPelsPerMeter==((BitmapInfoHeader)b).yPelsPerMeter
    			   && clrUsed==((BitmapInfoHeader)b).clrUsed  && clrImportant==((BitmapInfoHeader)b).clrImportant;
    	}
    }
}
