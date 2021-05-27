package com.hrms.project.core.adapters.concretes;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import com.hrms.project.core.adapters.abstracts.MernisValidationService;
import com.hrms.project.entities.concretes.JobSeeker;

import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component
public class MernisValidationAdapter implements MernisValidationService{

	@Override
	public boolean checkIfRealPerson(JobSeeker jobSeeker) {
		KPSPublicSoapProxy client=new KPSPublicSoapProxy();
        boolean result=false;
        try {
            result=client.TCKimlikNoDogrula(
                        Long.valueOf(jobSeeker.getNationalIdentity()), 
                        jobSeeker.getFirstName().toUpperCase(), 
                        jobSeeker.getLastName().toUpperCase(), 
                        jobSeeker.getBirthYear());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return result;
	}

}
