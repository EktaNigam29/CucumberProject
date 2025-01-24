package utilites;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constants.ConstantsData;

public class FetchdatafromExcel {
	static Map<String, Object> mp= new LinkedHashMap<String, Object> ();

	public static String getData(int x, int y) throws IOException
	{
		
		FileInputStream fs= new FileInputStream (ConstantsData.testdDataPath);
		XSSFWorkbook workbook=new XSSFWorkbook(fs);
		XSSFSheet sheet=workbook.getSheetAt(0);
		XSSFCell value=sheet.getRow(x).getCell(y);
		String testdatavalue=value.toString();
		return testdatavalue;
		
		
		
	}
	public static Map AddNewUserDeatils() throws IOException
	{
		
		
		mp.put("username",FetchdatafromExcel.getData(1, 0) );
		mp.put("job", FetchdatafromExcel.getData(1, 1));
		return mp;
		
		
	}
	public static Object getUsername()
	{
		
		Object username=	mp.get("username");
		return username;
	}
	public static Object getJob()
	{
		
		Object job=	mp.get("job");
		return job;
	}
	
	
}
