package com.borrowing.services.serviceImpl;

import com.borrowing.constanta.ConstantaLoan;
import com.borrowing.entity.CollectStatus;
import com.borrowing.entity.Customer;
import com.borrowing.entity.Loan;
import com.borrowing.entity.LoanType;
import com.borrowing.exception.NotFound;
import com.borrowing.repositories.LoanRepository;
import com.borrowing.services.CollectStatusService;
import com.borrowing.services.CustomerService;
import com.borrowing.services.LoanService;
import com.borrowing.services.LoanTypeService;
import com.borrowing.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    LoanRepository loanRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    LoanTypeService loanTypeService;
    @Autowired
    CollectStatusService collectStatusService;

    @Override
    public Loan saveDataLoan(Loan loan){
        loan.setLoanId(Utility.generateIdLength10());
        Customer customer=customerService.getDataCustomerByCif(loan.getCif());
        loan.setCustomer(customer);
        LoanType loanType=loanTypeService.getDataLoanTypeByLoanTypeId(loan.getLoanTypeTransient());
        loan.setLoanType(loanType);
        CollectStatus collectStatus=collectStatusService.getDataCollectStatusById(loan.getCollectStatusTransient());
        loan.setCollectStatus(collectStatus);
        loan.setOpenDate(Calendar.getInstance());
        return loanRepository.save(loan);
    }

    @Override
    public Loan updateDataLoan(Loan loan){
        getDataLoanByLoanId(loan.getLoanId());
        return loanRepository.save(loan);
    }

    @Override
    public Loan getDataLoanByLoanId(String loanId){
        if (!loanRepository.findById(loanId).isPresent()){
            throw new NotFound(String.format(ConstantaLoan.MESSAGE_LOAN_ID_NOT_FOUND, loanId));
        }
        return loanRepository.findById(loanId).get();
    }

    @Override
    public List<Loan> getAllDataLoan(){
        return loanRepository.findAll();
    }

    @Override
    public void deleteDataLoanByLoanId(String loanId){
        loanRepository.deleteById(loanId);
    }
}
