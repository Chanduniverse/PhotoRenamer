import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifSubIFDDirectory;

public class mainjava {

	public static void main(String[] args)
			throws IOException, ImageProcessingException, NullPointerException, ArrayIndexOutOfBoundsException {
		File f = new File("C:\\Users\\Chandan Aralikatti\\Desktop\\Photo_Renamed\\");
		String[] list = f.list();
		File[] lister = f.listFiles();
		int lengthOfList = list.length;
		System.out.println(lengthOfList);
		for (int i = 0; i < lengthOfList; i++) {
				if (list[i].endsWith(".webp") || list[i].endsWith(".jpg") || list[i].endsWith(".jpeg") || list[i].endsWith(".png") || list[i].endsWith(".bmp") || list[i].endsWith(".tiff") || list[i].endsWith(".nef") || list[i].endsWith(".cr2") || list[i].endsWith(".")){
					Metadata metadata = ImageMetadataReader.readMetadata(lister[i]);
					ExifSubIFDDirectory directory = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
					Date date = directory.getDate(ExifSubIFDDirectory.TAG_DATETIME_ORIGINAL);
					BufferedImage bimg = ImageIO.read(lister[i]);
					int width = bimg.getWidth();
					int height = bimg.getHeight();
					int length = list[i].length();
					String experiment = list[i].substring(0, length - 4);
					String datey;
					if (date != null) {
						datey = date + "";
					} else {
						datey = "null";
					}

					String finaly = f + "\\" + experiment + "__" + datey.replace(':', ' ').replace(" ", "_") + "__"
							+ height + "X" + width + list[i].substring(length - 4, length);
					String path = lister[i] + "";
					File oldfile = new File(path);
					File newfile = new File(finaly);
					boolean renamed = oldfile.renameTo(newfile);
					System.out.println("renamed = " + renamed);
					System.out.println(finaly);
				}
			}
		}
	}


