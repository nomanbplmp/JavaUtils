import java.io.File;
 
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
 
public class UploadFileExample1 {
    public static void main(String[] args) {
        String bucketName = "REPLACE_WITH_S3_BUCKET";
         
        String fileName = "REPLACE_WITH_FILE_NAME";
        String filePath = "REPLACE_WITH_FILE_LOCATION";
         
        S3Client client = S3Client.builder().build();
         
        PutObjectRequest request = PutObjectRequest.builder()
                            .bucket(bucketName).key(fileName).build();
         
        client.putObject(request, RequestBody.fromFile(new File(filePath)));
                 
    }
}
