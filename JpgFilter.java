import java.io.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Filters the files in a JFileChooser to only display .jpg images
 * @author Alvaro Morales
 * with references to "How to Use File Choosers" from the Java Tutorial found in
 * http://java.sun.com/docs/books/tutorial/uiswing/components/filechooser.html
 * @date 02/07/2010
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 * ---------------------------------------------------------------------
 */

/**
 * Filters the files in a JFileChooser to only display .jpg images
 */
public class JpgFilter extends javax.swing.filechooser.FileFilter{
	
	/**
	 * Constructs a new JpgFilter object
	 */
	public JpgFilter(){
		super();
	}
	
	/**
	 * Filters a file (accepts it only if its extension is a .jpg image or it is a directory)
	 * @param file - the file to filter
	 * @return true if the file has the extension .jpg or is a directory, else false
	 */
	public boolean accept(File file){
		if(file.isDirectory()){
			return true;
		}
		
		String extension = getExtension(file);
		if(extension!= null){
			if(extension.equals("jpg")){
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
		
	}
	
	/**
	 * Gets the extension of a file
	 * @param file - the file that will be processed to get its extension
	 * @return the extension of a file
	 */
	public String getExtension(File file){
		String fileName = file.getName();
		String extension = null;
		int extensionStart = fileName.lastIndexOf('.');		//Gets starting position of the '.extension' in the file
		
		if(extensionStart > 0 && extensionStart < fileName.length()-1){		//Checks for appropriate length to avoid
			extension = fileName.substring(extensionStart+1).toLowerCase();
		}
		
		return extension;
		
	}
	
	/**
	 * Gets the description of this FileFilter
	 * @return the description of this FileFilter
	 */
	public String getDescription(){
		return "JPG Images";
	}
	
}
