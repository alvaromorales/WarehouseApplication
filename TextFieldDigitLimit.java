import javax.swing.text.*;

/**
 * ---------------------------------------------------------------------
 * Warehouse Application
 * Limits the maximum number of characters in a JTextField
 * @author Real Gagnon
 * @authorsWebsite http://tactika.com/realhome/realhome.html
 * @date 05/07/1999
 * @school Markham College
 * @IDE Eclipse SDK
 * @computer IBM ThinkPad R52
 */
public class TextFieldDigitLimit extends PlainDocument {
	
	/**
	 * The maximum number of digits
	 */
	private int limit;

	/**
	 * Constructs a new TextFieldDigitLimit object
	 * @param limit - the maximum number of digits
	 */
	public TextFieldDigitLimit(int limit) {
		super();
		this.limit = limit;
	}

	/**
	 * Only inserts a character if it is a digit
	 */
	public void insertString (int offset, String  str, AttributeSet attr) throws BadLocationException {
		if (str == null) return;

		Character c = new Character(str.charAt(0));
		
		if ((getLength() + str.length()) <= limit && Character.isDigit(c.charValue()) == true) {
			super.insertString(offset, str, attr);
		}
	}
}