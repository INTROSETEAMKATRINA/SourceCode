import java.util.Date;

public class Personnel {
	private String name;
	private String position;
	private String assignment;
	private String educationalAttainment;
	private String employeeStatus;
	private String taxStatus;
	private String tin;
	private float sss;
	private float sssLoan;
	private float phic;
	private float hdmf;
	private float hdmfLoan;
	private float payrollAdvance;
	private float houseRental;
	private float uniformAndOthers;
	private float dailyRate;
	private float colaRate;
	private float monthlyRate;
	private Date dateStarted;
	private Date presentContractStartDate;
	private Date presentContractEndDate;
	private DTR dtr;

    public Personnel(String name, String position, String assignment,
    				 String educationalAttainment, String employeeStatus,String tin, String taxStatus,
    				 float sss, float sssLoan, float phic, float hdmf, float hdmfLoan,
    				 float payrollAdvance, float houseRental, float uniformAndOthers,
    				 float dailyRate, float colaRate,float monthlyRate,
    				 Date dateStarted, Date presentContractStartDate,
    				 Date presentContractEndDate) {
		this.name = name;
		this.position = position;
		this.assignment = assignment;
		this.educationalAttainment = educationalAttainment;
		this.employeeStatus = employeeStatus;
		this.tin = tin;
		this.taxStatus = taxStatus;
		this.sss = sss;
		this.sssLoan = sssLoan;
		this.phic = phic;
		this.hdmf = hdmf;
		this.hdmfLoan = hdmfLoan;
		this.payrollAdvance = payrollAdvance;
		this.houseRental = houseRental;
		this.uniformAndOthers = uniformAndOthers;
		this.dailyRate = dailyRate;
		this.colaRate = colaRate;
		this.monthlyRate = monthlyRate;
		this.dateStarted = dateStarted;
		this.presentContractStartDate = presentContractStartDate;
		this.presentContractEndDate = presentContractEndDate;
		this.dtr = null;
    }
	public String getName(){
		return name;
	}
	public String getPosition(){
		return position;
	}
	public void setPosition(String position){
		this.position = position;
	}
	public float getDailyRate(){
		return dailyRate;
	}
	public void setDailyRate(float dailyRate){
		this.dailyRate = dailyRate;
	}
	public String getAssignment(){
		return assignment;
	}
	public void setAssignment(String assignment){
		this.assignment = assignment;
	}
	public float getColaRate(){
		return colaRate;
	}
	public void setColaRate(float colaRate){
		this.colaRate = colaRate;
	}
	public String getTaxStatus(){
		return taxStatus;
	}
	public void setTaxStatus(String taxStatus){
		this.taxStatus = taxStatus;
	}
	public void setDTR(DTR dtr){
		this.dtr = dtr;
	}
}