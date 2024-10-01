package Session_5;

import java.io.*;


import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_From_Excel {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		
		File file = new File("File_2/Products.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheetAt(0);
		
		int row_length = sheet.getLastRowNum();
		int column_length = sheet.getRow(0).getLastCellNum()-1;
		
		for(int r=0;r<=row_length;r++) {
			Row row = sheet.getRow(r);
			for(int c=0;c<=column_length;c++) {
				Cell cell = row.getCell(c);
				System.out.print(cell + "  \t  ");
			}
			System.out.println();			
		}
		
	}
	
}
