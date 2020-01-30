package com.borrowing.response;

import com.borrowing.entity.CollectStatus;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CollectStatusResponse extends BaseResponse{
    private CollectStatus collectStatus;
    private List<CollectStatus> collectStatuses;

    public CollectStatusResponse(Integer httpCode, String message, CollectStatus collectStatus, List<CollectStatus> collectStatuses) {
        super(httpCode, message);
        this.collectStatus = collectStatus;
        this.collectStatuses = collectStatuses;
    }

    public CollectStatus getCollectStatus() {
        return collectStatus;
    }

    public List<CollectStatus> getCollectStatuses() {
        return collectStatuses;
    }
}
