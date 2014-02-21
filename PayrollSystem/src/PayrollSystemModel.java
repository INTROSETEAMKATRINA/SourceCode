/*******************************************************
	 *  Class name: PayrollSystemModel
 	 *  Inheritance:
	 *  Attributes: personnels
	 *  Methods:	PayrollSystemModel,addPersonnel,
	 *  Functionality: Model
	 *  Visibility: public
	 *******************************************************/
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import jxl.*;

public class PayrollSystemModel {

	public PayrollSystemModel(){

	}
	public void addPersonnel(String fileDirectory){
		try{
			File file = new File(fileDirectory);
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			ArrayList<Personnel> personnels = new ArrayList<Personnel>();;
			String name,position,assignment,employeeStatus,tin,taxStatus;
			float sss, sssLoan, phic, hdmf, hdmfLoan, payrollAdvance, houseRental, uniformAndOthers;
			float dailyRate, colaRate, monthlyRate;

			//getCell(column,row)
			int row,column;

			row = 0;
			column = 1;
			assignment = sheet.getCell(column,row).getContents();

			row += 2;
			column = 0;

			while(row < sheet.getRows()){

				name = sheet.getCell(column,row).getContents();

				if(name.length() > 0){

					column++;
					position = sheet.getCell(column,row).getContents();
					column++;
					employeeStatus = sheet.getCell(column,row).getContents();

					dailyRate = 0;
					column++;
					try{
						dailyRate 	= Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					colaRate = 0;
					column++;
					try{
						colaRate 	= Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					monthlyRate = 0;
					column++;
					try{
						monthlyRate = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					column++;
					tin 		= sheet.getCell(column,row).getContents();
					column++;
					taxStatus 	= sheet.getCell(column,row).getContents();

					sss = 0;
					column++;
					try{
						sss = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					sssLoan = 0;
					column++;
					try{
						sssLoan = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					phic = 0;
					column++;
					try{
						phic = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					hdmf = 0;
					column++;
					try{
						hdmf = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					hdmfLoan = 0;
					column++;
					try{
						hdmfLoan = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					payrollAdvance = 0;
					column++;
					try{
						payrollAdvance = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					houseRental = 0;
					column++;
					try{
						houseRental = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					uniformAndOthers = 0;
					column++;
					try{
						uniformAndOthers = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e.printStackTrace();
					}

					personnels.add(new Personnel(name, position, assignment,employeeStatus, tin, taxStatus,
												 sss, sssLoan, phic, hdmf,hdmfLoan, payrollAdvance, houseRental,
												 uniformAndOthers, dailyRate, colaRate, monthlyRate));
				}
				row++;
			}
		}catch(Exception e){
			System.out.println(e);
			//e.printStackTrace();
		}
	}

	public void addDTR(String fileDirectory){
		try{
			File file = new File(fileDirectory);
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			ArrayList<DTR> dtrs = new ArrayList<DTR>();;
			String name,tin;
			float regularHoursWorks, regularOvertime, regularNightShiftDifferential,
				  specialHoliday, specialHolidayOvertime, specialHolidayNightShiftDifferential,
				  legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential;
			Date  periodStartDate;
			SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
			        new SimpleDateFormat("yyyy-MM-dd"),
			        new SimpleDateFormat("yyyy/MM/dd"),
			        new SimpleDateFormat("MM/dd/yyyy"),
			        new SimpleDateFormat("MM-dd-yyyy") };
			int row,column;

			row = 0;
			column = 1;
			periodStartDate = null;
			for(SimpleDateFormat format : possibleFormats){

				try{
					format.setLenient(false);
					periodStartDate = format.parse(sheet.getCell(column,row).getContents());
				}catch(Exception e){
					System.out.println(e);
					//e.printStackTrace();
				}
			}

			row += 2;
			column = 0;
			while(row < sheet.getRows()){

				name = sheet.getCell(column,row).getContents();

				if(name.length() > 0){

					column++;
					tin = sheet.getCell(column,row).getContents();

					regularHoursWorks = 0;
					column++;
					try{
						regularHoursWorks = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

					regularOvertime = 0;
					column++;
					try{
						regularOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

					regularNightShiftDifferential = 0;
					column++;
					try{
						regularNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	specialHoliday = 0;
				  	column++;
				  	try{
						specialHoliday = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	specialHolidayOvertime = 0;
				  	column++;
				  	try{
						specialHolidayOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	specialHolidayNightShiftDifferential = 0;
				  	column++;
				  	try{
						specialHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	legalHoliday = 0;
				  	column++;
				  	try{
						legalHoliday = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	legalHolidayOvertime = 0;
				  	column++;
				  	try{
						legalHolidayOvertime = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				  	legalHolidayNightShiftDifferential = 0;
				  	column++;
				  	try{
						legalHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(column,row).getContents());
					}catch(Exception e){
					}

				    dtrs.add(new DTR(name, tin, regularHoursWorks, regularOvertime, regularNightShiftDifferential,
			   								 specialHoliday, specialHolidayOvertime,specialHolidayNightShiftDifferential,
			   								 legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential,
			   								 periodStartDate));
				}
				row++;
			}

		}catch(Exception e){
		}
	}
}
