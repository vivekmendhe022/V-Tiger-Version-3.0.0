package generic.utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * This file read data from excel sheet with apache poi dependency.
 * 
 * @author Vivek M
 */
public class ExcelFileUtility {

	/**
	 * This method will read data from excel sheet with sheetname, row number & cell
	 * number.
	 * 
	 * @param SHEETNAME
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelSheet(String SHEETNAME, int row, int cell)
			throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		return book.getSheet(SHEETNAME).getRow(row).getCell(cell).getStringCellValue();
	}

	/**
	 * This method will read multiple data from excel sheet using @DataProvider.
	 * 
	 * @param sheetname
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleDateFromExcelSheet(String sheetname) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(IConstantUtility.EXCELFILEPATH);
		Workbook book = WorkbookFactory.create(file);
		Sheet sheet = book.getSheet(sheetname);

		int row = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[row][cell];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < cell; j++) {
				data[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return data;
	}
}
