package chapter12ReadWriteData;

public class WriteData {

	public static void main(String[] args)  throws Exception{
		
		java.io.File file = new java.io.File("scores.txt");
		if (file.exists()) {
			System.out.println("File already exists");
			System.exit(0);
		}
	
		java.io.PrintWriter output = new java.io.PrintWriter(file);
		
		output.print("John T Smith ");
		output.println(90);
		output.print("Erick K Jones ");
		output.println(85);

		output.close();
		
	}
	
	
	

}
