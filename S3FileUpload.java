import java.io.File;
 
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
 
public class UploadFileExample1 {
    public static void main(String[] args) {
        String bucketName = "codejava-bucket";
         
        String fileName = "Java Logo.png";
        String filePath = "D:/Images/" + fileName;
         
        S3Client client = S3Client.builder().build();
         
        PutObjectRequest request = PutObjectRequest.builder()
                            .bucket(bucketName).key(fileName).build();
         
        client.putObject(request, RequestBody.fromFile(new File(filePath)));
                 
    }
}
