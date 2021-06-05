package com.hrms.project.business.abstracts;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.entities.concretes.cv.Cv;

public interface CvService {
	Result add(Cv cv);
	DataResult<List<Cv>> getAll();
	DataResult<Cv> getCvByNationalIdentity(String nationalIdentity);
	Result imageUpload(String nationalIdentity, MultipartFile multipartFile) throws IOException;
}
