import javax.swing.text.*;

/**
 * Warehouse Application
 * Limits the maximum number of characters in a JTextField
 * @author Real Gagnon
 * @authorsWebsite http://tactika.com/realhome/realhome.html
 * @date 05/07/1999
 */

public class TextFieldLimit extends PlainDocument {
	
	/**
	 * The maximum number of characters
	 */
	private int limit;

	/**
	 * Constructs a new TextFieldLimit object
	 * @param limit - the maximum number of characters
	 */
	public TextFieldLimit(int limit) {
		super();
		this.limit = limit;
	}

	/**
	 * Only inserts a character if the maximum number of characters has not been reached
	 */
	public void insertString (int offset, String  str, AttributeSet attr) throws BadLocationException {
		if (str == null) return;
		if ((getLength() + str.length()) <= limit) {
			super.insertString(offset, str, attr);
		}
	}
}