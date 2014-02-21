/*******************************************************
	 *  Class name: PayrollSystemController
 	 *  Inheritance:
	 *  Attributes: con, periodStartdate, model, view, removeAdjustments,
					addAdjustments, viewSummaryReport, changePassword,
					generatePayslips
	 *  Methods:	PayrollSystemController
	 *  Functionality: Controller
	 *  Visibility: public
	 *******************************************************/

import javax.swing.*;
import java.sql.Connection;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
public class PayrollSystemController{

	private Connection con;
	private Date periodStartDate;
	private PayrollSystemModel model;
	private PayrollSystemView view;
	private RemoveAdjustmentsView removeAdjustments;
	private AddAdjustmentsView addAdjustments;
	private ViewSummaryReportView viewSummaryReport;
	private ChangePasswordView changePassword;
	private GeneratePayslipsView generatePayslips;

	public PayrollSystemController(PayrollSystemModel model, PayrollSystemView view){
		this.model = model;
		this.view = view;
	}

	//Main Menu Buttons Listeners

	//Add Personnel Button in Main Menu
	class addPersonnelListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			model.addPersonnel(view.fileChooser());

			/* place in fileChooserFunctionin View
				JFileChooser fc = new JFileChooser();
				//In response to a button click:
				int returnVal = fc.showOpenDialog(this);
				return fc.getSelectedFile();
				}
			*/
		}
	}

	//Add DTR button in main menu
	class addDTRListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JFileChooser fc = new JFileChooser();
			//In response to a button click:
			int returnVal = fc.showOpenDialog(view);
			if(returnVal==0){
				model.addDTR(fc.getSelectedFile());
			}
		}
	}

	//Add adjustment button in main menu
	class addAdjustmentListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			addAdjustments.setVisible(true);
		}
	}

	//Remove adjustment button in main menu
	class removeAdjustmentListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			removeAdjustments.setVisible(true);
		}
	}

	//Change password button in main menu
	class changePasswordListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			changePassword.setVisible(true);
		}
	}

	//View summary report button in main menu
	class viewSummaryReportListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			viewSummaryReport.setVisible(true);
		}
	}

	//Generate payslips button in main menu
	class generatePayslipsListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			generatePayslips.setVisible(true);
		}
	}

	//Listeners in Adjustments view
	//Add adjustments button in add adjustments view
	class addAdjustmentButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(addAdjustments.askConfirmation){
				model.addAdjustment(addAdjustments.getTypeAdjustment(),
									addAdjustments.getAdjustment(),
									addAdjustments.getTIN(),
									periodStartDate);
				addAdjustments.showSucces();
				addAdjustments.clear();
				addAdjustments.setVisible(false);
			}
		}
	}

	//Cancel add adjustments in add adjustments view
	class cancelAddAdjustmentButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			addAdjustments.clear();
			addAdjustments.setVisible(false);
		}
	}

	//client list combo box listener in add adjustments view
	class clientListAddAdjustmentListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			addAdjustments.updatePersonnelList();
		}
	}

	//listeners in remove adjustments view
	//remove adjustments in remove adjustments view
	class removeAdjustmentButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(removeAdjustments.askConfirmation){
				model.removeAdjustment(removeAdjustments.getAdjustment(),
									   removeAdjustments.getTIN(),
									   periodStartDate);
				removeAdjustments.showSuccess();
				removeAdjustments.setVisible(false);
			}
		}
	}

	//cancel remove adjustments in remove adjustments view
	class cancelRemoveAdjustmentButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			removeAdjustments.setVisible(false);
		}
	}

	//client list combo box in remove adjustments view
	class clientListRemoveAdjustmentListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			removeAdjustments.updatePersonnelList();
		}
	}

	//personnel list combo box in remove adjustments view
	class personnelListRemoveAdjustmentListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			removeAdjustments.updateAdjustmentsList();
		}
	}

	//listeners in view summary report view
	//view button listener in view summary report view
	class viewSummaryReportButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			viewSummaryReport.updateTable(model.getSummaryReport(
										  viewSummaryReport.getClient(),
										  viewSummaryReport.getReport(),
										  periodStartDate));
		}
	}

	//listeners in change password view
	//change password button in change password view
	class changePasswordButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			if(changePassword.askConfirmation()){
				if(changePassword.getOldPass().equals()){//GetPasswordFromDatabase
					String newPass = changePassword.getNewPass();
					String confirmNewPass = changePassword.getConfirmNewPass();
					if(newPass.equals(confirmNewPass)){
						model.changePassword(newPass);
						changePassword.showSuccess();
						changePassword.clear();
						changePassword.setVisible(false);
					}else{
						changePassword.showPasswordNotTheSame();
					}
				}else{
					changePassword.showWrongOldPassword();
				}
			}
		}
	}

	//cancel change password button in change password view
	class cancelChangePasswordButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			changePassword.clear();
			changePassword.setVisible(false);
		}
	}

	//listeners in generate payslips view
	//generate payslips in generate payslips view
	class generatePayslipsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			model.generatePaylips(generatePayslips.getFileDirectory,
								  generatePayslips.getClient());
			generatePayslips.showSuccess();
			generatePayslips.setFileDirectory(null);
			generatePayslips.setVisible(false);
		}
	}

	//cancel generate payslips in generate payslips view
	class cancelGeneratePayslipsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			generatePayslips.setFileDirectory(null);
			generatePayslips.setVisible(false);
		}
	}

	//choose where to save listener in generate payslips view
	class fileSaverGeneratePayslipsButtonListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			generatePayslips.setFileDirectory(generatePayslips.fileSaver());
			/* place in fileSaver() in view
				//Create a file chooser
				JFileChooser fc = new JFileChooser();
				//In response to a button click:
				int returnVal = fc.showSaveDialog(this);
				return fc.getSelectedFile();
			*/
		}
	}
}