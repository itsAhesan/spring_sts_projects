package com.jony.spring_boot.controller;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.jony.spring_boot.request.Books;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

public class ExcelExporter {
	
	public static void exportToExcel(List<Books> entities, OutputStream out) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Entities");

        // Create header row
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("ID");
        headerRow.createCell(1).setCellValue("Name");
        headerRow.createCell(2).setCellValue("Price");
        // Add more headers as needed

        // Fill data
        int rowIdx = 1;
        for (Books entity : entities) {
            Row row = sheet.createRow(rowIdx++);
            row.createCell(0).setCellValue(entity.getId());
            row.createCell(1).setCellValue(entity.getName());
            row.createCell(2).setCellValue(entity.getPrice());
            // Add more cells as needed
        }

        workbook.write(out);
        workbook.close();
    }

}
