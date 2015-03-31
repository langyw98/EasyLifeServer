package cn.bdqn.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class FileUtil {

	public static byte[] readFile(String path, String name) throws Exception{
		File file = new File(path + "/images/"+name+".jpg");
		FileInputStream inStream = new FileInputStream(file);
		ByteArrayOutputStream outStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len =0;
		while((len = inStream.read(buffer))!=-1){
			outStream.write(buffer, 0, len);
		}
		outStream.close();
		inStream.close();
		return outStream.toByteArray();
	}
}