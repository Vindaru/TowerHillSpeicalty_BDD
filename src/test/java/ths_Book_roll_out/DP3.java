package ths_Book_roll_out;

import java.io.FileOutputStream;

import com.bdd.variables.API_Constant_Values;
import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import utilities.ExcelUtils;

import static io.restassured.RestAssured.*;



public class DP3  extends ExcelUtils{

    //given, When ,There
    
    public static void main(String[] args) throws Exception {
           
     ExcelUtils.setExcelFile(API_Constant_Values.DP3_Path_TestData + API_Constant_Values.DP3_File_TestData, "sheet1");		
	int i, j;
	for (j = 0; j < ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); j++) {    			
	    for (int a = 3; a <  ExcelUtils.ExcelWSheet.getPhysicalNumberOfRows(); a++) {	
			
		// read values form EXCEL;    	     
	    	  int AOP =                                       (int)                      ExcelUtils.getNumericCellValue(a, 2);  		     
			  int CovA =                                      (int)                      ExcelUtils.getNumericCellValue(a, 3);       
			  int CovBPercentage =                            (int)                      ExcelUtils.getNumericCellValue(a, 4);       
			  int CovC =                                      (int)                      ExcelUtils.getNumericCellValue(a, 5);  	     
			  int CovL =                                      (int)                      ExcelUtils.getNumericCellValue(a, 6);  
			  int CovM =                                      (int)                      ExcelUtils.getNumericCellValue(a, 7);  
			  int Hurrican_ded =                              (int)                      ExcelUtils.getNumericCellValue(a, 8);  
			  String EffectiveDate =                                                     ExcelUtils.getCellData(a, 9);
			  String Address =                                                           ExcelUtils.getCellData(a, 10);
			  String Risk_City =                                                         ExcelUtils.getCellData(a, 11);
			  String Risk_State =                                                        ExcelUtils.getCellData(a, 12);
			  int Risk_ZpiCode =                              (int)                      ExcelUtils.getNumericCellValue(a, 13); 
			  String ConstructionType =                                                  ExcelUtils.getCellData(a, 14); 
			  int ConstructionYear =                          (int)                      ExcelUtils.getNumericCellValue(a, 15);
			  String FireHydrate =                                                       ExcelUtils.getCellData(a, 17);
			  int NumberofStories =                           (int)                      ExcelUtils.getNumericCellValue(a, 18);
			  String Occupancy =                                                         ExcelUtils.getCellData(a, 19);
			  String OccupancyBY =                                                       ExcelUtils.getCellData(a, 20);
			  String RoofType =                                                          ExcelUtils.getCellData(a, 21);
			  int RoofYear =                                  (int)                      ExcelUtils.getNumericCellValue(a, 22); 
			  String RoofingMaterial =                                                   ExcelUtils.getCellData(a, 23);
			  String TownhomeorRowHome =                                                 ExcelUtils.getCellData(a, 24);
			  String InsurenceScore =                                                    ExcelUtils.getCellData(a, 25);
			  String FirstName =                                                         ExcelUtils.getCellData(a, 26);
			  String LastName =                                                          ExcelUtils.getCellData(a, 27);
			  String Date_OF_Birth =                                                     ExcelUtils.getCellData(a, 28);
			  String New_Purchase =                                                      ExcelUtils.getCellData(a, 29);
			  int NumberofFamilyUnits =                      (int)                       ExcelUtils.getNumericCellValue(a, 30);
			  int SquareFootage =                             (int)                      ExcelUtils.getNumericCellValue(a, 31);
			  String Group_ID =                                                          ExcelUtils.getCellData(a, 32);
			  String User_ID =                                                           ExcelUtils.getCellData(a, 33);
			  String Password =                                                          ExcelUtils.getCellData(a, 34);
		 
   
	     RestAssured.baseURI = API_Constant_Values.URL_API_UAT;
                 Response response=
		  given()
		       .header("Content","text/xml")
	               .and()
	               .body("<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:v2=\"http://www.thig.com/webservices/policy/external/v2\">\n"
	               		+ "   <soapenv:Header>\n"
	               		+ "      <v2:RequestHeader>\n"
	               		+ "         <v2:ApiKey>"+API_Constant_Values.API_KEY_UAT+"</v2:ApiKey>\n"
	               		+ "      </v2:RequestHeader>\n"
	               		+ "   </soapenv:Header>\n"
	               		+ "   <soapenv:Body>\n"
	               		+ "      <v2:D3RateRequest>\n"
	               		+ "         <v2:PolicyTerm>\n"
	               		+ "            <v2:Coverages>\n"
	               		+ "               <v2:AllOtherPerilsDeductible>"+AOP+"</v2:AllOtherPerilsDeductible>\n"
	               		+ "               <v2:CoverageA>"+CovA+"</v2:CoverageA>\n"
	               		+ "               <v2:CoverageBPercentage>"+CovBPercentage+"</v2:CoverageBPercentage>\n"
	               		+ "               <v2:CoverageC>"+CovC+"</v2:CoverageC>\n"
	               		+ "               <v2:CoverageL>"+CovL+"</v2:CoverageL>\n"
	               		+ "               <v2:CoverageM>"+CovM+"</v2:CoverageM>\n"
	               		+ "            </v2:Coverages>\n"
	               		+ "            <v2:EffectiveDate>"+EffectiveDate+"</v2:EffectiveDate>\n"
	               		+ "            <v2:Form>D3</v2:Form>\n"
	               		+ "            <v2:HasFloodInsuranceWithTowerHill>false</v2:HasFloodInsuranceWithTowerHill>\n"
	               		+ "            <v2:Location>\n"
	               		+ "               <v2:Address>\n"
	               		+ "                  <v2:Street>"+Address+"</v2:Street>\n"
	               		+ "                  <v2:City>"+Risk_City+"</v2:City>\n"
	               		+ "                  <v2:State>"+Risk_State+"</v2:State>\n"
	               		+ "                  <v2:Zipcode>"+Risk_ZpiCode+"</v2:Zipcode>\n"
	               		+ "               </v2:Address>\n"
	               		+ "               <v2:Construction>"+ConstructionType+"</v2:Construction>\n"
	               		+ "               <v2:ConstructionYear>"+ConstructionYear+"</v2:ConstructionYear>\n"
	               		+ "               <v2:NearFireHydrant>"+FireHydrate+"</v2:NearFireHydrant>\n"
	               		+ "               <v2:NumberOfStories>"+NumberofStories+"</v2:NumberOfStories>\n"
	               		+ "               <v2:Occupancy>"+Occupancy+"</v2:Occupancy>\n"
	               		+ "               <v2:OccupiedBy>"+OccupancyBY+"</v2:OccupiedBy>\n"
	               		+ "               <v2:RoofShape>"+RoofType+"</v2:RoofShape>\n"
	               		+ "               <v2:RoofYear>"+RoofYear+"</v2:RoofYear>\n"
	               		+ "               <v2:RoofingMaterial>"+RoofingMaterial+"</v2:RoofingMaterial>\n"
	               		+ "               <v2:StormShutters>None</v2:StormShutters>\n"
	               		+ "               <v2:TownhouseOrRowhouse>"+TownhomeorRowHome+"</v2:TownhouseOrRowhouse>\n"
	               		+ "            </v2:Location>\n"
	               		+ "            <v2:PrimaryInsured>\n"
	               		+ "               <!--Optional:-->\n"
	               		+ "               <v2:InsuranceScore>"+InsurenceScore+"</v2:InsuranceScore>\n"
	               		+ "               <v2:FirstName>"+FirstName+"</v2:FirstName>\n"
	               		+ "               <v2:LastName>"+LastName+"</v2:LastName>\n"
	               		+ "               <v2:DateOfBirth>"+Date_OF_Birth+"</v2:DateOfBirth>\n"
	               		+ "            </v2:PrimaryInsured>\n"
	               		+ "            <v2:Underwriting>\n"
	               		+ "               <v2:NewPurchase>"+New_Purchase+"</v2:NewPurchase>\n"
	               		+ "               <v2:NumberOfFamilyUnits>"+NumberofFamilyUnits+"</v2:NumberOfFamilyUnits>\n"
	               		+ "               <v2:SquareFootage>"+SquareFootage+"</v2:SquareFootage>\n"
	               		+ "            </v2:Underwriting>\n"
	               		+ "            <v2:WindstormHailExclusion>false</v2:WindstormHailExclusion>\n"
	               		+ "         </v2:PolicyTerm>\n"
	               		+ "         <v2:User>\n"
	               		+ "            <v2:GroupId>"+Group_ID+"</v2:GroupId>\n"
	               		+ "            <v2:UserId>"+User_ID+"</v2:UserId>\n"
	               		+ "            <v2:Password>?</v2:Password>\n"
	               		+ "         </v2:User>\n"
	               		+ "      </v2:D3RateRequest>\n"
	               		+ "   </soapenv:Body>\n"
	               		+ "</soapenv:Envelope>")
	        .when()
	                .post("/v2/PolicyService")
	        .then()  	               
	               // .statusCode(200) 
	                .and()
	                .log().all().extract().response();                 
                 System.out.println(response.getStatusCode());		
                 String stringResponse = response.asString();
	         XmlPath xmlpath = new XmlPath(stringResponse);	 

	         String PolicyNumber= xmlpath.getString("Envelope.Body.D3RateResponse.RateResults.RateResult.PolicyTerm.PolicyNumber");  
	         String Premium= xmlpath.getString("Envelope.Body.D3RateResponse.RateResults.RateResult.PolicyTerm.Premiums.TotalPremium");
	         String Policy_Form= xmlpath.getString("Envelope.Body.D3RateResponse.RateResults.RateResult.PolicyTerm.Form");
	         String ID_Generated= xmlpath.getString("Envelope.Body.D3RateResponse.RateResults.RateResult.PolicyTerm.Id");
	         System.out.println("Premium  :"+ "  "+Premium);
	         System.out.println("PolicyNumber :"+ "  "+PolicyNumber);
	         System.out.println("PolicyNumber :"+ "  "+Policy_Form);
	         System.out.println("PolicyNumber :"+ "  "+ID_Generated);         
	         System.out.println("next Row   :" + (a + 1));
	       
  // Write in Excel 
	         ExcelUtils.setExcelFile(API_Constant_Values.DP3_Path_TestData + API_Constant_Values.DP3_File_TestData, "sheet1"); 
             ExcelUtils.ExcelWSheet.getRow(a).createCell(35).setCellValue(PolicyNumber);
		     ExcelUtils.ExcelWSheet.getRow(a).createCell(36).setCellValue(Premium);
	         ExcelUtils.ExcelWSheet.getRow(a).createCell(37).setCellValue(Policy_Form);
	         ExcelUtils.ExcelWSheet.getRow(a).createCell(38).setCellValue(ID_Generated);
	             FileOutputStream fos=new FileOutputStream(API_Constant_Values.DP3_Path_TestData + API_Constant_Values.DP3_File_TestData);			
	          ExcelWBook.write(fos);
                  fos.close();
			     		         
			 }	   
		}
    }
}


