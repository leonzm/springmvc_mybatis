package tool;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Tool_File {
	
	public static byte[] getDatas(String path) {
		File file = new File(path);
		InputStream input = null;
		
		try {
			input = new FileInputStream(file);
	        byte[] b = new byte[(int) file.length()];
	        while (input.read(b) != -1) {
	        	return b;
	        }
		} catch (IOException e) {
			
		} finally {
			try {
				input.close();
			} catch (IOException e) {}
		}
		return null;
	}
	
	public static void writeDatas(String name, byte[] datas) throws IOException {
		File f = new File("C:/" + name);
		if (!f.exists()) {
			f.createNewFile();
		}
		OutputStream output = new FileOutputStream(f);
		output.write(datas);
		output.close();
	}
	
	public static void main(String[] args) throws IOException {
		byte[] b = Tool_File.getDatas("C:/Users/leonhzh/Desktop/img/img1.jpg");
		writeDatas("test.jpg", b);
	}

}
