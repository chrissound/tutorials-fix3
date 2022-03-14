package com.baeldung.poi.excel.cellstyle;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Paths;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;

public class CellStyleHandlerUnitTest {
    private static final String FILE_NAME = "cellstyle/CellStyleHandlerTest.xlsx";
    private static final int SHEET_INDEX = 0;
    private static final int ROW_INDEX = 0;
    private static final int CELL_INDEX = 0;

    private String fileLocation;
    private CellStyleHandler cellStyleHandler;

    @Before
    public void setup() throws URISyntaxException {
        fileLocation = Paths.get(ClassLoader.getSystemResource(FILE_NAME).toURI()).toString();
        cellStyleHandler = new CellStyleHandler();
    }

    @Test
    public void givenWorkbookCell_whenChangeCellBackgroundColor() throws IOException {
        Workbook workbook = new XSSFWorkbook(fileLocation);
        Sheet sheet = workbook.getSheetAt(SHEET_INDEX);
        Row row = sheet.getRow(ROW_INDEX);
        Cell cell = row.getCell(CELL_INDEX);

        cellStyleHandler.changeCellBackgroundColor(cell);

        assertEquals(IndexedColors.LIGHT_BLUE.index, cell.getCellStyle().getFillForegroundColor());
        workbook.close();
    }

    @Test
    public void givenWorkbookCell_whenChangeCellBackgroundColorWithPattern() throws IOException {
        Workbook workbook = new XSSFWorkbook(fileLocation);
        Sheet sheet = workbook.getSheetAt(SHEET_INDEX);
        Row row = sheet.getRow(ROW_INDEX);
        Cell cell = row.getCell(CELL_INDEX + 1);

        cellStyleHandler.changeCellBackgroundColorWithPattern(cell);

        assertEquals(IndexedColors.LIGHT_BLUE.index, cell.getCellStyle().getFillForegroundColor());
        workbook.close();
    }
}
