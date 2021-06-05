package com.hrms.project.core.adapters.abstracts;

import java.io.IOException;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface CloudinaryService {
	 Map upload(MultipartFile multipartFile) throws IOException;
	
	 Map delete(String id) throws IOException;
}
