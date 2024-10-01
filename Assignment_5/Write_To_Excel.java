package Session_5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Write_To_Excel {
	
	public static void main(String[] args) throws FileNotFoundException {
		
		FileOutputStream file = new FileOutputStream("File_2/Test_Cases.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("TestCase_Sheet");
		
		Object data[][] = {
				{"TC_ID","TC_Title","Assignee","Is_Passed"},
				{1,"Verify login","Jack",true},
				{2,"Verify registration","James",false},
				{3,"Verify Logo","Jack",true},
				{4,"Verify Performance","Paul",false},
				{5,"Verify UI","Robert",true},
				{6,"Verify Device Heat","Robert",false},
				{7,"Verify with slow internet","Paul",true},
				{8,"Verify with linux","Robert",false},
				{9,"Verify with javascript disabled","Jack",false},
				{10,"Verify performance with cache disabled","James",true},			
		};
		
		int count_row=0;
		for (Object[] r : data) {
			Row row = sheet.createRow(count_row++);
			int count_column=0;
			for (Object c : r) {
				Cell cell = row.createCell(count_column++);
				if (c instanceof String) {
					cell.setCellValue((String)c);
				} else if (c instanceof Integer) {
					cell.setCellValue((int)c);
				} else if (c instanceof Boolean) {
					cell.setCellValue((boolean)c);
				}
			}
		}
		
		try {			
			wb.write(file);
			System.out.println("File Write : Success");
		}catch (Exception e) {
			System.out.println("File Write : Failed :- "+e.getLocalizedMessage());
		}
		
	}
	
}
