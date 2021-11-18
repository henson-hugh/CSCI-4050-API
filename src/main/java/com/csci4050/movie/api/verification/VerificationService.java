package com.csci4050.movie.api.verification;

import com.csci4050.movie.api.CodeGenerator;
import com.csci4050.movie.api.model.Customer;
import com.csci4050.movie.api.model.Verification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class VerificationService {
    @Autowired
    private CodeGenerator codeGenerator;

    @Autowired VerificationRepository verificationRepository;

    public String generateVerificationCode(Customer customer) {
        // generate code
        String code = codeGenerator.generateVerificationCode();
        // create verification entity
        Verification verification = new Verification();
        verification.setVcode(code);
        verification.setCustomerid(customer.getCid());
        // save entity
        verificationRepository.save(verification);

        return verification.getVcode();
    }

    public Optional<Verification> getVerificationByCode(String code) {
        return verificationRepository.findByVcode(code);
    }

    public void verifyCustomer(int cid) {
        Optional<Verification> verifEntity = verificationRepository.findById(cid);
        Verification verification = verifEntity.get();

        // remove entity from database
        verificationRepository.delete(verification);
    }
}
