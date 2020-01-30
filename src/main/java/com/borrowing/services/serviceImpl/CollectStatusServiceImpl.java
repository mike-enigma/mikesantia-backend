package com.borrowing.services.serviceImpl;

import com.borrowing.constanta.ConstantaCollectStatus;
import com.borrowing.entity.CollectStatus;
import com.borrowing.exception.NotFound;
import com.borrowing.repositories.CollectStatusRepository;
import com.borrowing.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectStatusServiceImpl implements com.borrowing.services.CollectStatusService {
    @Autowired
    CollectStatusRepository collectStatusRepository;

    @Override
    public CollectStatus saveDataCollectStatus(CollectStatus collectStatus){
        collectStatus.setId(Utility.generateCollectStatusId());
        return collectStatusRepository.save(collectStatus);
    }

    @Override
    public CollectStatus updateDataCollectStatus(CollectStatus collectStatus){
        getDataCollectStatusById(collectStatus.getId());
        return collectStatusRepository.save(collectStatus);
    }

    @Override
    public CollectStatus getDataCollectStatusById(Integer id){
        if (!collectStatusRepository.findById(id).isPresent()){
            throw new NotFound(String.format(ConstantaCollectStatus.MESSAGE_COLLECT_STATUS_NOT_FOUND, id));
        }
        return collectStatusRepository.findById(id).get();
    }

    @Override
    public List<CollectStatus> getAllDataCollectStatus(){
        return collectStatusRepository.findAll();
    }

    @Override
    public void deleteDataCollectStatusById(Integer id){
        collectStatusRepository.deleteById(id);
    }
}
