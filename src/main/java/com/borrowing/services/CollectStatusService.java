package com.borrowing.services;

import com.borrowing.entity.CollectStatus;

import java.util.List;

public interface CollectStatusService {
    CollectStatus saveDataCollectStatus(CollectStatus collectStatus);

    CollectStatus updateDataCollectStatus(CollectStatus collectStatus);

    CollectStatus getDataCollectStatusById(Integer id);

    List<CollectStatus> getAllDataCollectStatus();

    void deleteDataCollectStatusById(Integer id);
}
