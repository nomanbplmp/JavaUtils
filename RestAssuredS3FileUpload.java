public class RestAssureS3Util {
  public void fileUpload(){ 
    RestAssured.urlEncodingEnabled = false;
        File uploadFile = new File("COMPLETE_FILE_PATH");
        Response response = given().contentType("text/csv")              
                        .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                        .body(uploadFile)
                        .when()
                        .put(uploadUrl)
                        .then().extract().response();

  }  
}
