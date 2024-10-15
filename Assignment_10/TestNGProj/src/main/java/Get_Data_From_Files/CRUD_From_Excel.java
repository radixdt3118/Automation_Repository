package Get_Data_From_Files;

import java.io.File;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CRUD_From_Excel{
	
	public static String getData(String sheet_name,int row_num,String key,File fileobj) throws Exception {
		
		XSSFWorkbook wb = new XSSFWorkbook(fileobj);
		XSSFSheet sheet = wb.getSheet(sheet_name);
		int row_size = sheet.getLastRowNum();	//Get number of rows in excel sheet
		int col_size = sheet.getRow(0).getLastCellNum()-1;  //Get number of columns in an excel row
		String value=null;
		
		if(row_num>row_size) {
			System.err.print("invalid Row number\n");
			throw new IndexOutOfBoundsException();
		}
		
		Row row = sheet.getRow(0);	//For header
		for(int c=0;c<=col_size;c++) {
			if(row.getCell(c).toString().equalsIgnoreCase(key)) {
				value = sheet.getRow(row_num).getCell(c).toString();
				break;
			}
		}
		
		return value;	
	}
	
	public static void main(String[] args) throws Exception {
		
		File file = new File("TestData/Payment_Terms_Data.xlsx");
		String count_str = getData("Payment_Terms", 3, "no_of_terms", file);
		int count = Integer.parseInt(count_str.substring(0, count_str.indexOf(".")));
		System.out.println(count);
	}
	
	
}
