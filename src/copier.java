import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import com.drew.imaging.ImageProcessingException;
public class copier {
	static File f = new File("C:\\Users\\Chandan Aralikatti\\Desktop\\muh stuff\\Importnt Pictures");
	static File copied = new File("C:\\Users\\Chandan Aralikatti\\Desktop\\Photo_Renamed\\");
	static String[] list = f.list();
	static File[] lister = f.listFiles();
	static int lengthOfList = list.length;
	 public static void copyfoldercontents(File x) throws IOException {
		 String[] listy = x.list();
     	int length = listy.length;
		 for(int z = 0; z < length; z++ ) {
	        	File[] folder = x.listFiles();
	        	if(folder[z].isFile()) {
	        		FileUtils.copyFileToDirectory(folder[z], copied);
	        	}else if(folder[z].isDirectory()) {
	        		f = folder[z];
	        		copyfoldercontents(folder[z]);
	        	}
	        }
	    }
	public static void main(String[] args)
			throws IOException, ImageProcessingException, NullPointerException, ArrayIndexOutOfBoundsException {
		System.out.println(lengthOfList);
		for (int i = 0; i < lengthOfList; i++) {
			if(lister[i].isFile()) {
				FileUtils.copyFileToDirectory(lister[i], copied);
			}else if(lister[i].isDirectory()) {
				copyfoldercontents(lister[i]);
	}
}
	
	}}
