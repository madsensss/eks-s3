package basic.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;

import basic.service.S3Service;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class S3FileController {
	
	private final S3Service s3Service;
	private final AmazonS3 amazonS3;
	@GetMapping(value = "/api/s3/test")
	public String eksS3Api() {
		return "eks-s3-api";
	}
	
	@PostMapping(value = "/api/s3/files")
	public void uploadS3File(@RequestPart(value = "file", required = false) MultipartFile file) {
		try {
			s3Service.uploadS3File(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping(value = "/api/s3/files/{fileNo}")
	public ResponseEntity<Resource> downloadS3File(@PathVariable("fileNo") long fileNo) throws Exception {
		return s3Service.downloadS3File(fileNo);
	}
	
	@DeleteMapping(value = "/api/s3/files/{fineNo}")
	public void deleteS3File(@PathVariable("fileNo") long fileNo) {
//		fileNo로 jpa가 filename 찾아와서 파일네임 넣고 지우기 / 얘는 서비스에서 진행해야하는 로직
		amazonS3.deleteObject("bucket name", "s3_data/filename");
	}
}

