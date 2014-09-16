//------------------------------------------------------------------------------
// Global_Settings.java
//
// Written By : Vikas Ojha
// Written For : CMC_Sanity_Automation_Scripts
// Date : February 23, 2012
// Version : 1.0
//
// Modified on : -
// Version : -
//------------------------------------------------------------------------------

/**
* This class contains the Global Variables and methods
* which are used in the complete execution of the code.
* 
* Version 1.0: Initial
*
* @Author Vikas Ojha vojha@appirio.com
* @Version 1.0, 03/23/12
*/

package com.appirio.automation.General;

import jxl.format.Alignment;
import jxl.format.BorderLineStyle;
import jxl.format.UnderlineStyle;
import jxl.write.Formula;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;


public class ExcelSettings 
{
	
	public WritableCellFormat forPass;
	public WritableCellFormat forFail;
	public WritableCellFormat forDefault;
	public WritableCellFormat forHeaders;
	
	
	static String csvfilepath ="Resources\\TestResults.csv";
	static String infilepath = "files\\CMC_Auto1.xls";
	static String outfilepath = "files\\outCMC_Auto1.xls";
	static String imagePath = System.getProperty("user.dir") + "\\files\\images\\TS1\\";
	static String infilepath_TestResults = "Resources\\CMC_TestResults.xls";
	
	//--------------------------------------------------------------------------
	/**
	 * Sets the Cell formats which are used to format the output XLS files
	 */
	public ExcelSettings() {
    	try {
    		WritableFont pass_fail = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
    		WritableFont general = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD, false, UnderlineStyle.NO_UNDERLINE);
			
	    	forPass = new WritableCellFormat(pass_fail);
	    	forPass.setAlignment(Alignment.LEFT);
	    	forPass.setBackground(jxl.format.Colour.LIGHT_GREEN);
	    	forPass.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
	    	forPass.setWrap(true);
			
			forFail = new WritableCellFormat(pass_fail);
			forFail.setAlignment(Alignment.LEFT);
			forFail.setBackground(jxl.format.Colour.ROSE);
			forFail.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
			forFail.setWrap(true);
			
			forDefault = new WritableCellFormat(general);
			forDefault.setAlignment(Alignment.LEFT);
			forDefault.setBackground(jxl.format.Colour.WHITE);
			forDefault.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
			forDefault.setWrap(false);	
			
			forHeaders = new WritableCellFormat(general);
			forHeaders.setAlignment(Alignment.LEFT);
			forHeaders.setBackground(jxl.format.Colour.GREY_25_PERCENT);
			forHeaders.setBorder(jxl.format.Border.ALL, BorderLineStyle.THIN);
			forHeaders.setWrap(true);
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}		
    }

	
	//--------------------------------------------------------------------------
	/**
	 * Adds a label to the outSheet
	 * <p>
	 * @param outSheet - The output sheet where label is to be added
	 * @param label - The label which is to be added
	 */
	static void outSheet_addCell(WritableSheet outSheet, Label label) {
    	try {
			outSheet.addCell(label);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }
    
	//--------------------------------------------------------------------------
	/**
	 * Adds a formula to the outSheet
	 * <p>
	 * @param outSheet - The output sheet where formula is to be added
	 * @param f - The formula which is to be added
	 */
    static void outSheet_addCell(WritableSheet outSheet, Formula f) {
    	try {
			outSheet.addCell(f);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
    }

}
