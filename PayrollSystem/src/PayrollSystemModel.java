import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.io.File;
import jxl.*;

public class PayrollSystemModel {
	private ArrayList<Personnel> personnels;

	public PayrollSystemModel(){
		personnels = new ArrayList<Personnel>();
	}
/*	public void addPersonnel(String fileDirectory){
		try{
			File file = new File(fileDirectory);
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			String name,position,assignment,educationalAttainment,employeeStatus,tin,taxStatus;
			float sss, sssLoan, phic, hdmf, hdmfLoan, payrollAdvance, houseRental, uniformAndOthers;
			float dailyRate, colaRate, monthlyRate;
			Date dateStarted, presentContractStartDate, presentContractEndDate;
			SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
			        new SimpleDateFormat("yyyy-MM-dd"),
			        new SimpleDateFormat("yyyy/MM/dd"),
			        new SimpleDateFormat("MM/dd/yyyy"),
			        new SimpleDateFormat("MM-dd-yyyy") };

			//getCell(column,row)
			int row = 0;
			assignment = sheet.getCell(1,row).getContents();

			row+=2;

			while(row < sheet.getRows()){

				name = sheet.getCell(0,row).getContents();

				if(name.length() > 0){

					position 			  = sheet.getCell(1,row).getContents();
					educationalAttainment = sheet.getCell(2,row).getContents();

					dateStarted = null;
					for(SimpleDateFormat format:possibleFormats){

						try{
							format.setLenient(false);
							dateStarted = format.parse(sheet.getCell(3,row).getContents());
						}catch(Exception e){
							System.out.println(e);
							//e1.printStackTrace();
						}
					}

					employeeStatus = sheet.getCell(4,row).getContents();

					String date = sheet.getCell(5,row).getContents();

					presentContractStartDate = null;
					presentContractEndDate = null;

					for(SimpleDateFormat format:possibleFormats){
						try{
							format.setLenient(false);
							presentContractStartDate  = format.parse(date.split("-")[0]);
							presentContractEndDate    = format.parse(date.split("-")[1]);
						}catch(Exception e){
							System.out.println(e);
							//e2.printStackTrace();
						}
					}

					dailyRate = 0;
					colaRate = 0;
					monthlyRate = 0;

					try{
						dailyRate 	= Float.parseFloat(sheet.getCell(6,row).getContents());
						colaRate 	= Float.parseFloat(sheet.getCell(7,row).getContents());
						monthlyRate = Float.parseFloat(sheet.getCell(8,row).getContents());
					}catch(Exception e){
						System.out.println(e);
						//e3.printStackTrace();
					}

					tin 		= sheet.getCell(10,row).getContents();

					taxStatus 	= sheet.getCell(13,row).getContents();

SSS 		= sheet.getCell(9,row).getContents();
PHIC 		= sheet.getCell(11,row).getContents();
					HDMF 		= sheet.getCell(12,row).getContents();
						personnels.add(new Personnel(name, position, assignment, educationalAttainment,
												 employeeStatus, SSS, TIN, PHIC, HDMF, taxStatus,
												 dailyRate, colaRate, monthlyRate, dateStarted,
												 presentContractStartDate, presentContractEndDate));
				}
				row++;
			}
		}catch(Exception e){
			System.out.println(e);
			//e.printStackTrace();
		}
		System.out.println(personnels.size());
	}*/

	public void addDTR(String fileDirectory){
		try{
			File file = new File(fileDirectory);
			Workbook workbook = Workbook.getWorkbook(file);
			Sheet sheet = workbook.getSheet(0);

			String name,client;
			float regularHoursWorks, regularOvertime, regularNightShiftDifferential,
				  specialHoliday, specialHolidayOvertime, specialHolidayNightShiftDifferential,
				  legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential;
			Date  periodStartDate;
			SimpleDateFormat[] possibleFormats = new SimpleDateFormat[] {
			        new SimpleDateFormat("yyyy-MM-dd"),
			        new SimpleDateFormat("yyyy/MM/dd"),
			        new SimpleDateFormat("MM/dd/yyyy"),
			        new SimpleDateFormat("MM-dd-yyyy") };
			int row = 0;

			client = sheet.getCell(1,row).getContents();

			row++;

			periodStartDate = null;
			for(SimpleDateFormat format : possibleFormats){

				try{
					format.setLenient(false);
					periodStartDate = format.parse(sheet.getCell(1,row).getContents());
				}catch(Exception e){
					System.out.println(e);
					//e1.printStackTrace();
				}
			}

			row+=2;
			while(row < sheet.getRows()){

				name = sheet.getCell(0,row).getContents();

				if(name.length() > 0){

					regularHoursWorks = 0;
					try{
						regularHoursWorks = Float.parseFloat(sheet.getCell(1,row).getContents());
					}catch(Exception e){
					}

					regularOvertime = 0;
					try{
						regularOvertime = Float.parseFloat(sheet.getCell(2,row).getContents());
					}catch(Exception e){
					}

					regularNightShiftDifferential = 0;
					try{
						regularNightShiftDifferential = Float.parseFloat(sheet.getCell(3,row).getContents());
					}catch(Exception e){
					}

				  	specialHoliday = 0;
				  	try{
						specialHoliday = Float.parseFloat(sheet.getCell(4,row).getContents());
					}catch(Exception e){
					}

				  	specialHolidayOvertime = 0;
				  	try{
						specialHolidayOvertime = Float.parseFloat(sheet.getCell(5,row).getContents());
					}catch(Exception e){
					}

				  	specialHolidayNightShiftDifferential = 0;
				  	try{
						specialHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(6,row).getContents());
					}catch(Exception e){
					}

				  	legalHoliday = 0;
				  	try{
						legalHoliday = Float.parseFloat(sheet.getCell(7,row).getContents());
					}catch(Exception e){
					}

				  	legalHolidayOvertime = 0;
				  	try{
						legalHolidayOvertime = Float.parseFloat(sheet.getCell(8,row).getContents());
					}catch(Exception e){
					}

				  	legalHolidayNightShiftDifferential = 0;
				  	try{
						legalHolidayNightShiftDifferential = Float.parseFloat(sheet.getCell(9,row).getContents());
					}catch(Exception e){
					}

					for(Personnel personnel : personnels){
						if(personnel.getName().equalsIgnoreCase(name)){
							if(personnel.getAssignment().equalsIgnoreCase(client)){
								personnel.setDTR(new DTR(regularHoursWorks, regularOvertime, regularNightShiftDifferential,
			   											 specialHoliday, specialHolidayOvertime,specialHolidayNightShiftDifferential,
			   											 legalHoliday, legalHolidayOvertime, legalHolidayNightShiftDifferential,
			   											 periodStartDate));
							}
						}
					}
				}
				row++;
			}

		}catch(Exception e){
		}
	}
}
