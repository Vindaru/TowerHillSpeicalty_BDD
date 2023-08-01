package API_Automation_THS;


import java.io.FileOutputStream;

import com.bdd.variables.API_Constant_Values;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import utilities.ExcelUtils;

import static io.restassured.RestAssured.*;



public class DP1  extends ExcelUtils{

    //given, When ,There
    
    public static void main(String[] args) throws Exception {
           
     ExcelUtils.setExcelFile(API_Constant_Values.DP1_Path_TestData + API_Constant_Values.DP1_File_TestData, "sheet1");		
	int i, j;
	for (j = 0; j < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); j++) {    			
	    for (int a = 3; a <  ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); a++) {	
			System.out.println(ExcelWSheet.getPhysicalNumberOfRows());
		// read values form EXCEL;    	     
//	      String APIKey_UAT =                                                        ExcelUtils.getCellData(a, 1);
		  int AOP =                                       (int)                      ExcelUtils.getNumericCellValue(a, 2);  		     
		  int CovA =                                      (int)                      ExcelUtils.getNumericCellValue(a, 3);       
		  int CovC =                                      (int)                      ExcelUtils.getNumericCellValue(a, 4);  	     
		  int CovL =                                      (int)                      ExcelUtils.getNumericCellValue(a, 5);  
		  int CovM =                                      (int)                      ExcelUtils.getNumericCellValue(a, 6);  
		  int Hurrican_ded =                              (int)                      ExcelUtils.getNumericCellValue(a, 7);  
		  String EffectiveDate =                                                     ExcelUtils.getCellData(a, 8);
		  String Address =                                                           ExcelUtils.getCellData(a, 9);
		  String Risk_City =                                                         ExcelUtils.getCellData(a, 10);
		  String Risk_State =                                                        ExcelUtils.getCellData(a, 11);
		  int Risk_ZpiCode =                              (int)                      ExcelUtils.getNumericCellValue(a, 12); 
		  String ConstructionType =                                                  ExcelUtils.getCellData(a, 13); 
		  int ConstructionYear =                          (int)                      ExcelUtils.getNumericCellValue(a, 14);
		  String DwellingLossSettlement =                                            ExcelUtils.getCellData(a, 15);
		  String FireHydrate =                                                       ExcelUtils.getCellData(a, 16);
		  String NumberofStories =                                                    ExcelUtils.getCellData(a, 17);
		  String Occupancy =                                                         ExcelUtils.getCellData(a, 18);
		  String RoofType =                                                         ExcelUtils.getCellData(a, 19);
		  int RoofYear =                                  (int)                      ExcelUtils.getNumericCellValue(a, 20); 
		  String RoofingMaterial =                                         ExcelUtils.getCellData(a, 21);
		  String TownhomeorRowHome =                                   ExcelUtils.getCellData(a, 22);
		  String InsurenceScore =                                                    ExcelUtils.getCellData(a, 23);
		  String FirstName =                                                         ExcelUtils.getCellData(a, 24);
		  String LastName =                                                          ExcelUtils.getCellData(a, 25);
		  String Date_OF_Birth =                                                     ExcelUtils.getCellData(a, 26);
		  String New_Purchase =                                                      ExcelUtils.getCellData(a, 27);
		  String NumberofFamilyUnits =                                                      ExcelUtils.getCellData(a, 28);
		  int SquareFootage =                             (int)                      ExcelUtils.getNumericCellValue(a, 29);
		  String Group_ID =                                                          ExcelUtils.getCellData(a, 30);
		  String User_ID =                                                           ExcelUtils.getCellData(a, 31);
		  String Password =                                                          ExcelUtils.getCellData(a, 32);
		 
   
	     RestAssured.baseURI = "https://policy-ws.uat.thig.com";
                 Response response=
		  given()
		       .header("Content","text/xml")
	               .and()
	               .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v2=\"http://www.thig.com/webservices/policy/external/v2\">\r\n" 
	               		+ "   <soapenv:Header>\r\n"
	               		+ "      <v2:RequestHeader>\r\n"
	               		+ "         <v2:ApiKey>"+API_Constant_Values.API_KEY_UAT+"</v2:ApiKey>\r\n"
	               		+ "      </v2:RequestHeader>\r\n"
	               		+ "   </soapenv:Header>\r\n"
	               		+ "   <soapenv:Body>\r\n"
	               		+ "      <v2:D1RateRequest>\r\n"
	               		+ "         <v2:PolicyTerm>\r\n"
	               		+ "            <v2:Coverages>\r\n"
	               		+ "               <v2:AllOtherPerilsDeductible>"+AOP+"</v2:AllOtherPerilsDeductible>\r\n"
	               		+ "               <v2:CoverageA>"+CovA+"</v2:CoverageA>\r\n"
	               		+ "               <v2:CoverageC>"+CovC+"</v2:CoverageC>\r\n"
	               		+ "               <v2:CoverageL>"+CovL+"</v2:CoverageL>\r\n"
	               		+ "               <v2:CoverageM>"+CovM+"</v2:CoverageM>\r\n"
//	               		+ "               <!--Optional:-->\r\n"
//	               		+ "               <v2:HurricaneDeductible>"+Hurrican_ded+"</v2:HurricaneDeductible>               \r\n"
	               		+ "            </v2:Coverages>\r\n"
	               		+ "            <v2:EffectiveDate>"+EffectiveDate+"</v2:EffectiveDate>           \r\n"
	               		+ "            <v2:Form>D1</v2:Form>\r\n"
	               		+ "            <v2:Location>\r\n"
	               		+ "               <v2:Address>\r\n"
	               		+ "                  <v2:Street>"+Address+"</v2:Street>                  \r\n"
	               		+ "                  <v2:City>"+Risk_City+"</v2:City>\r\n"
	               		+ "                  <v2:State>"+Risk_State+"</v2:State>                 \r\n"
	               		+ "                  <v2:Zipcode>"+Risk_ZpiCode+"</v2:Zipcode>\r\n"
	               		+ "               </v2:Address>\r\n"
	               		+ "               <v2:Construction>"+ConstructionType+"</v2:Construction>\r\n"
	               		+ "               <v2:ConstructionYear>"+ConstructionYear+"</v2:ConstructionYear>\r\n"
	               		+ "               <v2:DwellingSettlementType>"+DwellingLossSettlement+"</v2:DwellingSettlementType>\r\n"
	               		+ "               <v2:NearFireHydrant>"+FireHydrate+"</v2:NearFireHydrant>\r\n"
	               		+ "               <v2:NumberOfStories>"+NumberofStories+"</v2:NumberOfStories>\r\n"
	               		+ "               <v2:Occupancy>"+Occupancy+"</v2:Occupancy>               \r\n"
	               		+ "               <v2:RoofShape>"+RoofType+"</v2:RoofShape>\r\n"
	               		+ "               <v2:RoofYear>"+RoofYear+"</v2:RoofYear>\r\n"
	               		+ "               <v2:RoofingMaterial>"+RoofingMaterial+"</v2:RoofingMaterial>               \r\n"
	               		+ "               <v2:TownhouseOrRowhouse>"+TownhomeorRowHome+"</v2:TownhouseOrRowhouse>              \r\n"
	               		+ "            </v2:Location>\r\n"
	               		+ "            <v2:PrimaryInsured>              \r\n"
	               		+ "               <!--Optional:-->\r\n"
	               		+ "               <v2:InsuranceScore>"+InsurenceScore+"</v2:InsuranceScore>               \r\n"
	               		+ "               <v2:FirstName>"+FirstName+"</v2:FirstName>               \r\n"
	               		+ "               <v2:LastName>"+LastName+"</v2:LastName>\r\n"
	               		+ "               <v2:DateOfBirth>"+Date_OF_Birth+"</v2:DateOfBirth>               \r\n"
	               		+ "            </v2:PrimaryInsured>\r\n"
	               		+ "            <v2:Underwriting>              \r\n"
	               		+ "               <v2:NewPurchase>"+New_Purchase+"</v2:NewPurchase>\r\n"
	               		+ "               <v2:NumberOfFamilyUnits>"+NumberofFamilyUnits+"</v2:NumberOfFamilyUnits>               \r\n"
	               		+ "               <v2:SquareFootage>"+SquareFootage+"</v2:SquareFootage>               \r\n"
	               		+ "            </v2:Underwriting>            \r\n"
	               		+ "         </v2:PolicyTerm>\r\n"
	               		+ "         <v2:User>\r\n"
	               		+ "            <v2:GroupId>"+Group_ID+"</v2:GroupId>\r\n"
	               		+ "            <v2:UserId>"+User_ID+"</v2:UserId>\r\n"
	               		+ "         </v2:User>\r\n"
	               		+ "      </v2:D1RateRequest>\r\n"
	               		+ "   </soapenv:Body>\r\n"
	               		+ "</soapenv:Envelope>")
	        .when()
	                .post("/v2/PolicyService")
	        .then()  	               
//	                .statusCode(200) 
	                .and()
	                .log().all().extract().response();                 
                 System.out.println(response.getStatusCode());		
                 String stringResponse = response.asString();
	         XmlPath xmlpath = new XmlPath(stringResponse);	 

	         
	         String PolicyNumber= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.PolicyNumber");  
	         String Premium= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Premiums.TotalPremium");	        
	         String ID_Generated= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Id");
	       
	         // Risk char
	         String Res_FirstName= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.FirstName");  
	         String Res_LastName= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.LastName");
	         String Res_RiskAddress= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.Street");
	         String Res_RiskCity= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.City");
	         String Res_RiskState= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.State");
	         String Res_RiskZipcode= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Location.Address.Zipcode");
	         String Res_DOB= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.DateOfBirth");
	         String Res_InsurenceScore= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.PrimaryInsured.InsuranceScore");
	         
	         //Company Name
	         String CompanyName= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Company");
	       
	         // Coverages
	         String Res_CovA= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageA");
	         String Res_CovB= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageB");
	         String Res_CovC= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageC");
	         String Res_CovD= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageD");	        
	         String Res_CovE= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageE");
	         String Res_CovF= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Coverages.CoverageF");
	        //Effective Date
	         String Res_EffDate= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.EffectiveDate");
	         String Res_ExpDate= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.ExpirationDate");
	         
	         // Policy
	         String Res_PolicyForm= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Form");
	         String Res_Occupancy= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Location.Occupancy");
	         String Res_Yearbuilt= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Location.ConstructionYear");
	         String Res_SqFootage= xmlpath.getString("Envelope.Body.D1RateResponse.RateResults.RateResult.PolicyTerm.Underwriting.SquareFootage");
	         

	       
  // Write in Excel 
	         ExcelUtils.setExcelFile(API_Constant_Values.DP1_Path_TestData + API_Constant_Values.DP1_File_TestData, "sheet1"); 
                     ExcelUtils.ExcelWSheet.getRow(a).createCell(33).setCellValue(PolicyNumber);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(34).setCellValue(Premium);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(35).setCellValue(Res_PolicyForm);
	             ExcelUtils.ExcelWSheet.getRow(a).createCell(36).setCellValue(ID_Generated);
	             FileOutputStream fos=new FileOutputStream(API_Constant_Values.DP1_Path_TestData + API_Constant_Values.DP1_File_TestData);			
	          ExcelWBook.write(fos);
                  fos.close();
			     		         
			 }	   
		}
    }
}


