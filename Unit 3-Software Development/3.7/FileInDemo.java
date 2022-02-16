import java.io.*;

public class FileInDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			FileReader fr = new FileReader("dataFile.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			line = br.readLine(); // read first line
			while (line != null){
				System.out.println(line);  // read next line
			line = br.readLine();
			}br.close();
			}catch(IOException e){
				System.out.println("File not found");
			}
		
			}
	

}
