import java.io.*;

public class RAFTest {

	public static void main(String[] args){
		try {
			MainScreen main = new MainScreen(null);
			int numberOfRecords = 11;
			
			for(int i=0; i<numberOfRecords;i++){
				Item item = Items.getItemFromFile(i);
				if(item!=null){
					System.out.println(item.getID() + ". " + item.getCode() + ". " + item.getName() + item.getLocation().toString() + item.getGroup().toString());
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	
}
