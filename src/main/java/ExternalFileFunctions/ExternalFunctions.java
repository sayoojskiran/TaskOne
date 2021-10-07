package ExternalFileFunctions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExternalFunctions {

	public void excelFileHandling(String excelLocation) throws IOException {

		FileInputStream fis = new FileInputStream(excelLocation);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();

		for (int i = 0; i < sheets; i++) {
			if (workbook.getSheetName(i).equalsIgnoreCase("Test1")) {
				XSSFSheet sheet = workbook.getSheetAt(i);

				Iterator<Row> rows = sheet.iterator();

//				Row firstrow = rows.next();
//
//				Iterator<Cell> ce = firstrow.cellIterator();
//
//				while (ce.hasNext()) {
//					Cell value = ce.next();
//
//					System.out.println(value.getStringCellValue());
//				}

				while (rows.hasNext()) {

					Row r = rows.next();

					Iterator<Cell> cv = r.cellIterator();
					while (cv.hasNext()) {
						Cell c = cv.next();

						if (c.getCellType() == CellType.STRING) {
							System.out.println(c.getStringCellValue());
						} else {
							System.out.println(NumberToTextConverter.toText(c.getNumericCellValue()));
						}
					}

				}
			}

		}
		;

	}
}
