package API_Automation_THS;

import java.io.FileOutputStream;

import com.bdd.variables.API_Constant_Values;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import utilities.ExcelUtils;

import static io.restassured.RestAssured.*;


public class HO3  extends ExcelUtils{
//    private static  Logger log = Logger.getLogger(HO3.class.getName()+" ----------------------------------");
    //given, When ,There
    
    public static void main(String[] args) throws Exception {
//	String log4jConfPath = "C:\\Users\\vdaru\\eclipse-workspace\\API_Automation_THS\\src\\API_Automation_THS\\log4j.properties";
//        PropertyConfigurator.configure(log4jConfPath);
           
     ExcelUtils.setExcelFile(API_Constant_Values.HO3_Path_TestData + API_Constant_Values.HO3_File_TestData, "sheet1");		
	int i, j;
	for (j = 0; j < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); j++) {    			
	    for (int a = 3; a <  ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); a++) {	
			
		
System.out.println("=====================================================================================================================================================================================================================================");
 System.out.println("                                                                                                                               Start Quoting");		
System.out.println("=====================================================================================================================================================================================================================================");
		
		
		// read values form EXCEL;    	     
	          String APIKey_UAT =                                                        ExcelUtils.getCellData(a, 1);
		  int AOP =                                       (int)                      ExcelUtils.getNumericCellValue(a, 2);  		     
		  int CovA =                                      (int)                      ExcelUtils.getNumericCellValue(a, 3);       
		  int CovB_percentage =                           (int)                      ExcelUtils.getNumericCellValue(a, 4);       
		  int CovC =                                      (int)                      ExcelUtils.getNumericCellValue(a, 5);  	     
		  int CovD_Percentage =                           (int)                      ExcelUtils.getNumericCellValue(a, 6);  
		  int CovE =                                      (int)                      ExcelUtils.getNumericCellValue(a, 7);  
		  int CovF =                                      (int)                      ExcelUtils.getNumericCellValue(a, 8);  		
		  int Hurrican_ded =                              (int)                      ExcelUtils.getNumericCellValue(a, 9);  		
		  String EffectiveDate =                                                     ExcelUtils.getCellData(a, 10);
		  String Address =                                                           ExcelUtils.getCellData(a, 11);
		  String Risk_City =                                                         ExcelUtils.getCellData(a, 12);
		  String Risk_State =                                                        ExcelUtils.getCellData(a, 13);		 
		  int Risk_ZpiCode =                              (int)                      ExcelUtils.getNumericCellValue(a, 14); 
		  String ConstructionType =                                                  ExcelUtils.getCellData(a, 15);		  
		  int ConstructionYear =                          (int)                      ExcelUtils.getNumericCellValue(a, 16); 
		  int MonthsUnOccupied =                          (int)                      ExcelUtils.getNumericCellValue(a, 17); 
		  String Near_Hyderate =                                                     ExcelUtils.getCellData(a, 18);
		  String NumberOfOccupants =                                                 ExcelUtils.getCellData(a, 19); 
		  int NumberOfStories =                           (int)                      ExcelUtils.getNumericCellValue(a, 20);
		  String Occupancy =                                                         ExcelUtils.getCellData(a, 21);
//		  String OccupiedBY =                                                        ExcelUtils.getCellData(a, 22);
		  String RoofShape =                                                         ExcelUtils.getCellData(a, 23);
		  int RooFYear =                                  (int)                      ExcelUtils.getNumericCellValue(a, 24);
		  String RoofingMaterial =                                                   ExcelUtils.getCellData(a, 25);
		  String TownhouseOrRowhouse =                                               ExcelUtils.getCellData(a, 27); 
		  String PersonalPropertyReplacementCost =                                   ExcelUtils.getCellData(a, 28);
//		  String InsurenceScore =                                                    ExcelUtils.getCellData(a, 29);
		  String FirstName =                                                         ExcelUtils.getCellData(a, 30);
		  String LastName =                                                          ExcelUtils.getCellData(a, 31);
		  String Date_OF_Birth =                                                     ExcelUtils.getCellData(a, 32);		 
		  String New_Purchase =                                                      ExcelUtils.getCellData(a, 33);
		  int SquareFootage =                             (int)                      ExcelUtils.getNumericCellValue(a, 34);
		  String WindHailExclusion =                                                 ExcelUtils.getCellData(a, 35);
		  String Group_ID =                                                          ExcelUtils.getCellData(a, 37);
		  String User_ID =                                                           ExcelUtils.getCellData(a, 38);
		  String Password =                                                          ExcelUtils.getCellData(a, 39);
		 
   
	     RestAssured.baseURI = API_Constant_Values.API_KEY_UAT;
                 Response response=
		  given()
		       .header("Content","text/xml")
	               .and()
	               .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v2=\"http://www.thig.com/webservices/policy/external/v2\">\r\n" + 
	               	"   <soapenv:Header>\r\n" + 
	               	"      <v2:RequestHeader>\r\n" + 
	               	"         <v2:ApiKey>"+API_Constant_Values.API_KEY_UAT+"</v2:ApiKey>\r\n" + 	               
	               	"      </v2:RequestHeader>\r\n" + 
	               	"   </soapenv:Header>\r\n" + 
	               	"   <soapenv:Body>\r\n" + 
	               	"      <v2:H3RateRequest>\r\n" + 
	               	"         <v2:PolicyTerm>\r\n" + 
	               	"            <v2:Coverages>\r\n" + 
	               	"               <v2:AllOtherPerilsDeductible>"+AOP+"</v2:AllOtherPerilsDeductible>\r\n" + 
	               	"               <v2:CoverageA>"+CovA+"</v2:CoverageA>\r\n" + 
	               	"               <v2:CoverageBPercentage>"+CovB_percentage+"</v2:CoverageBPercentage>\r\n" + 
	               	"               <v2:CoverageC>"+CovC+"</v2:CoverageC>\r\n" + 
	               	"               <v2:CoverageDPercentage>"+CovD_Percentage+"</v2:CoverageDPercentage>\r\n" + // new coverage D (HO3
	               	"               <v2:CoverageE>"+CovE+"</v2:CoverageE>\r\n" + 
	               	"               <v2:CoverageF>"+CovF+"</v2:CoverageF>\r\n" + 
	               	"               <!--Optional:-->\r\n" + 
	               	"               <v2:HurricaneDeductible>"+Hurrican_ded+"</v2:HurricaneDeductible>\r\n" + 
	               	"            </v2:Coverages>\r\n" + 
	               	"            <v2:EffectiveDate>"+EffectiveDate+"</v2:EffectiveDate>\r\n" + 
	               	"            <v2:Form>H3</v2:Form>\r\n" + 
	               	"            <v2:HasFloodInsuranceWithTowerHill>false</v2:HasFloodInsuranceWithTowerHill>\r\n" + 	               
	               	"            <v2:Location>\r\n" + 
	               	"               <v2:Address>\r\n" + 
	               	"                  <v2:Street>"+Address+"</v2:Street>\r\n" + 	              
	               	"                  <v2:City>"+Risk_City+"</v2:City>\r\n" + 
	               	"                  <v2:State>"+Risk_State+"</v2:State>\r\n" + 
	               	"                  <v2:Zipcode>"+Risk_ZpiCode+"</v2:Zipcode>\r\n" + 
	               	"               </v2:Address>\r\n" + 
	               	"               <v2:Construction>"+ConstructionType+"</v2:Construction>\r\n" + 
	               	"               <v2:ConstructionYear>"+ConstructionYear+"</v2:ConstructionYear>\r\n" + 	              
	               	"               <v2:NearFireHydrant>"+Near_Hyderate+"</v2:NearFireHydrant>\r\n" + 
	               	"               <v2:NumberOfOccupants>"+NumberOfOccupants+"</v2:NumberOfOccupants>\r\n" + 
	               	"               <v2:NumberOfStories>"+NumberOfStories+"</v2:NumberOfStories>\r\n" + 	                
	               	"               <v2:Occupancy>"+Occupancy+"</v2:Occupancy>\r\n" + 
	               	"               <v2:OccupiedBy>Owner</v2:OccupiedBy>\r\n" +             
	               	"               <v2:RoofShape>"+RoofShape+"</v2:RoofShape>\r\n" + 
	               	"               <v2:RoofYear>"+RooFYear+"</v2:RoofYear>\r\n" + 
	               	"               <v2:RoofingMaterial>"+RoofingMaterial+"</v2:RoofingMaterial>\r\n" + 
	               	"               <v2:StormShutters>None</v2:StormShutters>\r\n" + 
	               	"               <v2:TownhouseOrRowhouse>"+TownhouseOrRowhouse+"</v2:TownhouseOrRowhouse>\r\n" +            
	               	"            </v2:Location>\r\n" + 
	               	"            <v2:PersonalPropertyReplacementCost>"+PersonalPropertyReplacementCost+"</v2:PersonalPropertyReplacementCost>\r\n" + 
	               	"            <v2:PrimaryInsured>\r\n" + 
	               	"               <!--Optional:-->\r\n" + 
//	               	"               <v2:InsuranceScore>"+InsurenceScore+"</v2:InsuranceScore>\r\n" + 
	               	"               <v2:FirstName>"+FirstName +"</v2:FirstName>\r\n" + 	               
	               	"               <v2:LastName>"+LastName +"</v2:LastName>\r\n" + 
	               	"               <v2:DateOfBirth>"+Date_OF_Birth+"</v2:DateOfBirth>\r\n" + 
	               	"            </v2:PrimaryInsured>\r\n" + 
	               	"            <v2:Underwriting>\r\n" + 
	               	"               <v2:NewPurchase>"+New_Purchase+"</v2:NewPurchase>\r\n" + 
	               	"               <v2:SquareFootage>"+SquareFootage+"</v2:SquareFootage>\r\n" + 
	               	"            </v2:Underwriting>\r\n" + 
	               	"            <v2:WindstormHailExclusion>"+WindHailExclusion+"</v2:WindstormHailExclusion>\r\n" + 
	               	"         </v2:PolicyTerm>\r\n" + 
	               	"         <v2:User>\r\n" + 
	               	"            <v2:GroupId>"+Group_ID+"</v2:GroupId>\r\n" + 
	               	"            <v2:UserId>"+User_ID+"</v2:UserId>\r\n" + 
	               	"            <v2:Password></v2:Password>\r\n" + 
	               	"         </v2:User>\r\n" + 
	               	"      </v2:H3RateRequest>\r\n" + 
	               	"   </soapenv:Body>\r\n" + 
	               	"</soapenv:Envelope>")
	        .when()
	                .post("/v2/PolicyService")
	        .then()  	               
	               // .statusCode(200) 
	                .and()
	                .log().all().extract().response();                 
                 System.out.println(response.getStatusCode());		
                 String stringResponse = response.asString();
	         XmlPath xmlpath = new XmlPath(stringResponse);	 
	         String PolicyNumber= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.PolicyNumber");  
	         
	         
	         String Premium= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Premiums.TotalPremium");
	         String Policy_Form= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Form");
	         String ID_Generated= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Id");
	       
System.out.println("--------------------------------------------------****************************************************************************************-------------------------------------------------------------------------");  	      //   log.info("Premium  :"+ "  "+Premium);
//	       
//                 log.info("PolicyNumber :"+ "  "+PolicyNumber);
//	         log.info("PolicyNumber :"+ "  "+Policy_Form);
//	         log.info("PolicyNumber :"+ "  "+ID_Generated);         
//	         log.info("next Row   :" + (a + 1));    
//	         
System.out.println("--------------------------------------------------****************************************************************************************-------------------------------------------------------------------------");         
	         
//	       
	         // Risk char
	         String Res_FirstName= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.FirstName");  
	         String Res_LastName= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.LastName");
	         String Res_RiskAddress= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.Street");
	         String Res_RiskCity= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.City");
	         String Res_RiskState= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.State");
	         String Res_RiskZipcode= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.Zipcode");
	         String Res_DOB= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.DateOfBirth");
	         String Res_InsurenceScore= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.InsuranceScore");
	         
	         //Company Name
	         String CompanyName= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Company");
	       
	         // Coverages
	         String Res_CovA= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageA");
	         String Res_CovB= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageB");
	         String Res_CovC= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageC");
	         String Res_CovD= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageD");	        
	         String Res_CovE= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageE");
	         String Res_CovF= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageF");
	        //Effective Date
	         String Res_EffDate= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.EffectiveDate");
	         String Res_ExpDate= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.ExpirationDate");
	         
	         // Policy
	         String Res_PolicyForm= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Form");
	         String Res_Occupancy= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Location.Occupancy");
	         String Res_Yearbuilt= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Location.ConstructionYear");
	         String Res_SqFootage= xmlpath.getString("Envelope.Body.H3RateResponse.RateResults.RateResult.PolicyTerm.Underwriting.SquareFootage");
	       
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
	     
	         
System.out.println("=====================================================================================================================================================================================================================================");
System.out.println(                                                                                                                   "End Quoting");		
System.out.println("=====================================================================================================================================================================================================================================");

	         
	         
	         
	         
                       // Write in Excel 
	      
//	         log.info("WRITE DATA TO EXCEL");
	             ExcelUtils.setExcelFile(API_Constant_Values.HO3_Path_TestData + API_Constant_Values.HO3_File_TestData, "sheet1"); 
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(40).setCellValue(response.getStatusCode());
                     ExcelUtils.ExcelWSheet.getRow(a).createCell(41).setCellValue(CompanyName);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(42).setCellValue(Res_CovA);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(43).setCellValue(Res_CovB);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(44).setCellValue(Res_CovC);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(45).setCellValue(Res_CovD);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(46).setCellValue(Res_CovE);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(47).setCellValue(Res_CovF);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(48).setCellValue(Res_EffDate);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(49).setCellValue(Res_ExpDate);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(50).setCellValue(Res_FirstName);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(51).setCellValue(Res_LastName);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(52).setCellValue(Res_DOB);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(53).setCellValue(Res_InsurenceScore);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(54).setCellValue(Res_RiskAddress);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(55).setCellValue(Res_RiskCity);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(56).setCellValue(Res_RiskState);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(57).setCellValue(Res_RiskZipcode);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(58).setCellValue(Res_Occupancy);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(59).setCellValue(Res_Yearbuilt);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(60).setCellValue(Res_SqFootage);
	             
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(61).setCellValue(Res_PolicyForm);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(62).setCellValue(PolicyNumber);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(63).setCellValue(Premium);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(64).setCellValue(ID_Generated);

	             FileOutputStream fos=new FileOutputStream(API_Constant_Values.HO3_Path_TestData + API_Constant_Values.HO3_File_TestData);			
	          ExcelWBook.write(fos);
                  fos.close();
			     		         
			 }	   
		}
    }
}


