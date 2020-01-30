package com.borrowing.services.serviceImpl;

import com.borrowing.constanta.ConstantaLoanType;
import com.borrowing.entity.LoanType;
import com.borrowing.exception.NotFound;
import com.borrowing.repositories.LoanTypeRepository;
import com.borrowing.services.LoanTypeService;
import com.borrowing.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanTypeServiceImpl implements LoanTypeService {
    @Autowired
    LoanTypeRepository loanTypeRepository;

    @Override
    public LoanType saveDataLoanType(LoanType loanType){
        loanType.setLoanTypeId(Utility.generateIdLength5());
        return loanTypeRepository.save(loanType);
    }

    @Override
    public LoanType updateDataLoanType(LoanType loanType){
        getDataLoanTypeByLoanTypeId(loanType.getLoanTypeId());
        return loanTypeRepository.save(loanType);
    }

    @Override
    public LoanType getDataLoanTypeByLoanTypeId(String loanTypeId){
        if (!loanTypeRepository.findById(loanTypeId).isPresent()){
            throw new NotFound(String.format(ConstantaLoanType.MESSAGE_LOAN_TYPE_NOT_FOUND, loanTypeId));
        }
        return loanTypeRepository.findById(loanTypeId).get();
    }

    @Override
    public List<LoanType> getAllDataLoanType(){
        return loanTypeRepository.findAll();
    }

    @Override
    public void deleteDataLoanTypeByLoanTypeId(String loanTypeId){
        loanTypeRepository.deleteById(loanTypeId);
    }
}
