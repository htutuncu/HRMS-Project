package com.hrms.project.business.concretes;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hrms.project.business.abstracts.CvService;
import com.hrms.project.core.adapters.abstracts.CloudinaryService;
import com.hrms.project.core.utilities.results.DataResult;
import com.hrms.project.core.utilities.results.Result;
import com.hrms.project.core.utilities.results.SuccessDataResult;
import com.hrms.project.core.utilities.results.SuccessResult;
import com.hrms.project.dataAccess.abstracts.CvDao;
import com.hrms.project.entities.concretes.cv.Cv;

import lombok.var;

@Service
public class CvManager implements CvService {
	
	private CvDao cvDao;
	private CloudinaryService cloudinaryService;
	
	
	
	@Autowired
	public CvManager(CvDao cvDao, CloudinaryService cloudinaryService) {
		super();
		this.cvDao = cvDao;
		this.cloudinaryService = cloudinaryService;
	}




	@Override
	public Result add(Cv cv) {
		this.cvDao.save(cv);
		return new SuccessResult("Cv added.");
	}




	@Override
	public DataResult<List<Cv>> getAll() {
		return new SuccessDataResult<List<Cv>>(cvDao.findAll());
	}




	@Override
	public DataResult<Cv> getCvByNationalIdentity(String  nationalIdentity) {
		return new SuccessDataResult<Cv>(cvDao.getCvByNationalIdentity(nationalIdentity));
	}




	@Override
	public Result imageUpload(String nationalIdentity, MultipartFile multipartFile) throws IOException {
		Cv cv = cvDao.getCvByNationalIdentity(nationalIdentity);
		Map photoMap = cloudinaryService.upload(multipartFile);
		cv.setPhotoLink(photoMap.get("url").toString());
		cvDao.save(cv);
		return new SuccessResult("Photo added.");
	}
	
}
