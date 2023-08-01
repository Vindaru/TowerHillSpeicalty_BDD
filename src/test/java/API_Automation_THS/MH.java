package API_Automation_THS;

import java.io.FileOutputStream;

import com.bdd.variables.API_Constant_Values;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import utilities.ExcelUtils;

import static io.restassured.RestAssured.*;



public class MH  extends ExcelUtils{
//	private static Logger log = Logger.getLogger(MH.class.getName() + " ----------------------------------");
	// given, When ,There

	public static void main(String[] args) throws Exception {
//	String log4jConfPath = "C:\\Users\\vdaru\\eclipse-workspace\\API_Automation_THS\\src\\API_Automation_THS\\log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);

		ExcelUtils.setExcelFile(API_Constant_Values.MH_Path_TestData + API_Constant_Values.MH_File_TestData, "sheet1");
		int i, j;
		for (j = 0; j < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); j++) {
			for (int a = 5; a < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); a++) {

				System.out.println(
						"=========================================================================***     START MH --  API_AUTOMATION   ***==============================================================================================================");
		
		
		
	//	log.info("READ DATA FROM EXCEL");
		// Read values form EXCEL;    	     
	          String APIKey_UAT =                                                        ExcelUtils.getCellData(a, 1);
		  int AOP =                                       (int)                      ExcelUtils.getNumericCellValue(a, 2);  		     
		  int CovA =                                      (int)                      ExcelUtils.getNumericCellValue(a, 3);       
		  int CovB =                                      (int)                      ExcelUtils.getNumericCellValue(a, 4);       
		  int CovC =                                      (int)                      ExcelUtils.getNumericCellValue(a, 5);  	     
		  int CovE =                                      (int)                      ExcelUtils.getNumericCellValue(a, 6);  
		  int CovF =                                      (int)                      ExcelUtils.getNumericCellValue(a, 7);  
		  int WindHailDed =                               (int)                      ExcelUtils.getNumericCellValue(a, 11);  
		  String EffectiveDate =                                                     ExcelUtils.getCellData(a, 12);
		  String Address =                                                           ExcelUtils.getCellData(a, 18);
		  String Risk_City =                                                         ExcelUtils.getCellData(a, 19);
		  String Risk_State =                                                        ExcelUtils.getCellData(a, 20);
		  int Risk_ZpiCode =                              (int)                      ExcelUtils.getNumericCellValue(a, 21); 
		  int ConstructionYear =                          (int)                      ExcelUtils.getNumericCellValue(a, 22); 
		  String DwellingLossSettlement =                                            ExcelUtils.getCellData(a, 23);
		  String Near_Hyderate =                                                     ExcelUtils.getCellData(a, 27);
		  String Occupancy =                                                         ExcelUtils.getCellData(a, 28);
		  String OccupiedBY =                                                        ExcelUtils.getCellData(a, 29);
		  String ParkStatus =                                                        ExcelUtils.getCellData(a, 30);
		  int RooFYear =                                  (int)                      ExcelUtils.getNumericCellValue(a, 31); 
		  String PersonalPropertyReplacementCost =                                   ExcelUtils.getCellData(a, 34);
		  String InsurenceScore =                                                    ExcelUtils.getCellData(a, 36);
		  String FirstName =                                                         ExcelUtils.getCellData(a, 43);
		  String LastName =                                                          ExcelUtils.getCellData(a, 44);
		  String Date_OF_Birth =                                                     ExcelUtils.getCellData(a, 45);
		  int SquareFootage =                             (int)                      ExcelUtils.getNumericCellValue(a, 55);
//		  String WindHailExclusion =                                                 ExcelUtils.getCellData(a, 60);
		  String Group_ID =                                                          ExcelUtils.getCellData(a, 61);
		  String User_ID =                                                           ExcelUtils.getCellData(a, 62);
		  String Password =                                                          ExcelUtils.getCellData(a, 63);
		  
		
		
	      RestAssured.baseURI = API_Constant_Values.API_KEY_UAT;
//	      RestAssured.baseURI = "https://policy-ws.uat.thig.com"; API_API_Constant_Valuess
	    //  log.info("GO TO    --    "  +baseURI);
                 Response response=
		  given()
		       .header("Content","text/xml")
	               .and()
	               .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v2=\"http://www.thig.com/webservices/policy/external/v2\">\r\n" + 
	               	"   <soapenv:Header>\r\n" + 
	               	"      <v2:RequestHeader>\r\n" + 
	               	"         <v2:ApiKey>"+API_Constant_Values.API_KEY_UAT+"</v2:ApiKey>     \r\n" + 
	               	"      </v2:RequestHeader>\r\n" + 
	               	"   </soapenv:Header>\r\n" + 
	               	"   <soapenv:Body>\r\n" + 
	               	"      <v2:MHRateRequest>\r\n" + 
	               	"         <v2:PolicyTerm>\r\n" + 
	               	"            <v2:Coverages>\r\n" + 
	               	"               <v2:AllOtherPerilsDeductible>"+AOP+"</v2:AllOtherPerilsDeductible>\r\n" + 
	               	"               <v2:CoverageA>"+CovA+"</v2:CoverageA>\r\n" + 
	               	"               <v2:CoverageB>"+CovB+"</v2:CoverageB>\r\n" + 
	               	"               <v2:CoverageC>"+CovC+"</v2:CoverageC>\r\n" + 
	               	"               <v2:CoverageE>"+CovE+"</v2:CoverageE>\r\n" + 
	               	"               <v2:CoverageF>"+CovF+"</v2:CoverageF>\r\n" + 	
//	                "         	<!--Optional:-->\r\n" + 
//	               	"               <v2:HurricaneDeductible>"+"2pct"+"</v2:HurricaneDeductible>\r\n" + 
//	               	"               <!--Optional:-->\r\n" + 
//	               	"               <v2:WindHailDeductible>"+WindHailDed+"</v2:WindHailDeductible>\r\n" + 
	               	"            </v2:Coverages>\r\n" + 
	               	"            <v2:EffectiveDate>"+EffectiveDate+"</v2:EffectiveDate>\r\n" + 
	               	"            <!--Optional:-->\r\n" + 
	               	"            <v2:Form>MC</v2:Form>           \r\n" + 
	               	"            <v2:Location>\r\n" + 
	               	"               <v2:Address>\r\n" + 
	               	"                  <v2:Street>"+Address+"</v2:Street>\r\n" + 
	               	"                  \r\n" + 
	               	"                  <v2:City>"+Risk_City+"</v2:City>\r\n" + 
	               	"                  <v2:State>"+Risk_State+"</v2:State>\r\n" + 
	               	"                  <v2:Zipcode>"+Risk_ZpiCode+"</v2:Zipcode>\r\n" + 
	               	"               </v2:Address>\r\n" + 
	               	"               <v2:ConstructionYear>"+ConstructionYear+"</v2:ConstructionYear>\r\n" + 
	               	"               <v2:DwellingSettlementType>"+DwellingLossSettlement+"</v2:DwellingSettlementType>             \r\n" + 
	               	"               <v2:NearFireHydrant>"+Near_Hyderate+"</v2:NearFireHydrant>\r\n" + 
	               	"               <v2:Occupancy>"+Occupancy+"</v2:Occupancy>\r\n" + 
	               	"               <v2:OccupiedBy>"+OccupiedBY+"</v2:OccupiedBy>\r\n" + 
//	               	"               <!--Optional:-->\r\n" + 
//	               	"               <v2:ParkStatus>"+ParkStatus+"</v2:ParkStatus>\r\n" + 
	               	"               <v2:RoofYear>"+RooFYear+"</v2:RoofYear>\r\n" +
	               	"            </v2:Location>\r\n" + 
	               	"            <v2:PersonalPropertyReplacementCost>"+PersonalPropertyReplacementCost+"</v2:PersonalPropertyReplacementCost>\r\n" + 
	               	"            <v2:PrimaryInsured>\r\n" + 
//	               	"               <!--Optional:-->\r\n" + 
//	               	"               <v2:InsuranceScore>"+InsurenceScore+"</v2:InsuranceScore>\r\n" +
	               	"               <v2:FirstName>"+FirstName+"</v2:FirstName>              \r\n" + 
	               	"               <v2:LastName>"+LastName+"</v2:LastName>\r\n" + 
	               	"               <v2:DateOfBirth>"+Date_OF_Birth+"</v2:DateOfBirth>\r\n" + 
	               	"            </v2:PrimaryInsured>\r\n" + 
	               	"            <v2:Underwriting>\r\n" +  
	               	"               <v2:SquareFootage>"+SquareFootage+"</v2:SquareFootage>\r\n" + 
	               	"             </v2:Underwriting>\r\n" + 
	               	"            <v2:WindstormHailExclusion>"+"false"+"</v2:WindstormHailExclusion>\r\n" + 
	               	"         </v2:PolicyTerm>\r\n" + 
	               	"         <v2:User>\r\n" + 
	               	"            <v2:GroupId>"+Group_ID+"</v2:GroupId>\r\n" + 
	               	"            <v2:UserId>"+User_ID+"</v2:UserId>\r\n" + 
	               	"            <v2:Password></v2:Password>\r\n" + 
	               	"         </v2:User>\r\n" + 
	               	"      </v2:MHRateRequest>\r\n" + 
	               	"   </soapenv:Body>\r\n" + 
	               	"</soapenv:Envelope>")
	        .when()
	                .post("/v2/PolicyService")
	        .then()  	               
	                .and()
	                .log().all().extract().response();                 
             //    log.info("Status Code             :"+ " ------------------------------- "+response.getStatusCode());		
                 String stringResponse = response.asString();
	         XmlPath xmlpath = new XmlPath(stringResponse);	 
	         //
	         String PolicyNumber= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.PolicyNumber");  
	         String Premium= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Premiums.TotalPremium");	        
	         String ID_Generated= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Id");
	       
	         // Risk char
	         String Res_FirstName= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.FirstName");  
	         String Res_LastName= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.LastName");
	         String Res_RiskAddress= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Location.Address.Street");
	         String Res_RiskCity= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Location.Address.City");
	         String Res_RiskState= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Location.Address.State");
	         String Res_RiskZipcode= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Location.Address.Zipcode");
	         String Res_DOB= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.DateOfBirth");
	         String Res_InsurenceScore= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.InsuranceScore");
	         
	         //Company Name
	         String CompanyName= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Company");
	       
	         // Coverages
	         String Res_CovA= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageA");
	         String Res_CovB= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageB");
	         String Res_CovC= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageC");
	         String Res_CovD= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageD");	        
	         String Res_CovE= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageE");
	         String Res_CovF= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageF");
	        //Effective Date
	         String Res_EffDate= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.EffectiveDate");
	         String Res_ExpDate= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.ExpirationDate");
	         
	         // Policy
	         String Res_PolicyForm= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Form");
	         String Res_Occupancy= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Location.Occupancy");
	         String Res_Yearbuilt= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Location.ConstructionYear");
	         String Res_SqFootage= xmlpath.getString("Envelope.Body.MHRateResponse.RateResults.RateResult.PolicyTerm.Underwriting.SquareFootage");
	       
//	         log.info("Premium                :"+ " ------------------------------- "+Premium);
//	         log.info("Policy Number          :"+ " ------------------------------- "+PolicyNumber);	        
//	         log.info("Term ID                :"+ " ------------------------------- "+ID_Generated);         
//	       
//	         //Company Name
//	         log.info("Company Name           :"+ " ------------------------------- "+CompanyName);
//	        
//	         // Coverages
//	         log.info("Coverage A             :"+ " ------------------------------- "+Res_CovA);	        
//	         log.info("Coverage B             :"+ " ------------------------------- "+Res_CovB);         
//	         log.info("Coverage C             :"+ " ------------------------------- "+Res_CovC);
//	         log.info("Coverage D             :"+ " ------------------------------- "+Res_CovD);
//	         log.info("Coverage E             :"+ " ------------------------------- "+Res_CovE);
//	         log.info("Coverage F             :"+ " ------------------------------- "+Res_CovF);	
//	         //Effective Date
//	         log.info("EffectiveDtae          :"+ " ------------------------------- "+Res_EffDate);   
//	         log.info("ExpirationDate         :"+ " ------------------------------- "+Res_ExpDate);
//	         // Risk char
//	         log.info("FIRSTNAME              :"+ " ------------------------------- "+Res_FirstName);	         
//	         log.info("LASTNAME               :"+ " ------------------------------- "+Res_LastName);
//	         log.info("DOB                    :"+ " ------------------------------- "+Res_DOB);	        
//	         log.info("INSURENCESCORE         :"+ " ------------------------------- "+Res_InsurenceScore);         
//	         log.info("Risk Address           :"+ " ------------------------------- "+Res_RiskAddress);
//	         log.info("Risk City              :"+ " ------------------------------- "+Res_RiskCity);	         
//	         log.info("Risk State             :"+ " ------------------------------- "+Res_RiskState);
//	         log.info("Risk Zipcode           :"+ " ------------------------------- "+Res_RiskZipcode);	
//	         // Policy
//	         log.info("PolicyForm             :"+ " ------------------------------- "+Res_PolicyForm);	         
//	         log.info("Occupancy              :"+ " ------------------------------- "+Res_Occupancy);
//	         log.info("YearBuilt              :"+ " ------------------------------- "+Res_Yearbuilt);	        
//	         log.info("SquareFootage          :"+ " ------------------------------- "+Res_SqFootage);         
	     
                       // Write in Excel 
	      
	  //       log.info("WRITE DATA TO EXCEL");
	             ExcelUtils.setExcelFile(API_Constant_Values.MH_Path_TestData + API_Constant_Values.MH_File_TestData, "sheet1"); 
                     ExcelUtils.ExcelWSheet.getRow(a).createCell(64).setCellValue(response.getStatusCode());
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(65).setCellValue(CompanyName);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(66).setCellValue(Res_CovA);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(67).setCellValue(Res_CovB);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(68).setCellValue(Res_CovC);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(69).setCellValue(Res_CovD);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(70).setCellValue(Res_CovE);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(71).setCellValue(Res_CovF);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(72).setCellValue(Res_EffDate);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(73).setCellValue(Res_ExpDate);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(74).setCellValue(Res_FirstName);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(75).setCellValue(Res_LastName);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(76).setCellValue(Res_DOB);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(77).setCellValue(Res_InsurenceScore);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(78).setCellValue(Res_RiskAddress);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(79).setCellValue(Res_RiskCity);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(80).setCellValue(Res_RiskState);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(81).setCellValue(Res_RiskZipcode);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(82).setCellValue(Res_Occupancy);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(83).setCellValue(Res_Yearbuilt);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(84).setCellValue(Res_SqFootage);
	             
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(85).setCellValue(Res_PolicyForm);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(86).setCellValue(PolicyNumber);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(87).setCellValue(Premium);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(88).setCellValue(ID_Generated);
	             
	             
	             FileOutputStream fos=new FileOutputStream(API_Constant_Values.MH_Path_TestData + API_Constant_Values.MH_File_TestData);			
	          ExcelWBook.write(fos);
                  fos.close();	
                  
             //     log.info("next Row               :"+ " ------------------------------- "+ (a + 1));
                  
                  
                  
                  
    System.out.println("==========================================================================***     END MH --  API_AUTOMATION   ***======================================================================================================");			

			 }	 
	    
		}
    }
}


