package com.borrowing.controller;

import com.borrowing.entity.CollectStatus;
import com.borrowing.response.CollectStatusResponse;
import com.borrowing.services.CollectStatusService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@Api(value = "CollectStatus Api", description = "CollectStatus Api")
public class CollectStatusRepository {
    @Autowired
    CollectStatusService collectStatusService;
    private CollectStatusResponse collectStatusResponse =null;

    @ApiOperation(value = "Add CollectStatus", response = CollectStatus.class)
    @PostMapping("collect-Status")
    public ResponseEntity<CollectStatusResponse> saveDataCollectStatus(
            @ApiParam(value = "CollectStatus Object", required = true)
            @RequestBody CollectStatus collectStatus) {
        CollectStatus saveCollectStatus = collectStatusService.saveDataCollectStatus(collectStatus);
        collectStatusResponse = new CollectStatusResponse(HttpStatus.CREATED.value(), "Success Add CollectStatus " + saveCollectStatus, null, null);
        return new ResponseEntity<CollectStatusResponse>(collectStatusResponse, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Edit CollectStatus", response = CollectStatusResponse.class)
    @PutMapping("collect-Status")
    public ResponseEntity<CollectStatusResponse> updateDataCollectStatus(
            @ApiParam(value = "CollectStatus Object", required = true)
            @RequestBody CollectStatus collectStatus) {
        CollectStatus update = collectStatusService.updateDataCollectStatus(collectStatus);
        collectStatusResponse = new CollectStatusResponse(HttpStatus.CREATED.value(), "Success Update CollectStatus " + update, null, null);
        return new ResponseEntity<CollectStatusResponse>(collectStatusResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get CollectStatus By Id", response = CollectStatusResponse.class)
    @GetMapping("collect-status/{id}")
    public ResponseEntity<CollectStatusResponse> getDataCollectStatusById(
            @ApiParam(value = "CollectStatus Id", required = true)
            @PathVariable Integer id) {
        CollectStatus collectStatus = collectStatusService.getDataCollectStatusById(id);
        collectStatusResponse = new CollectStatusResponse(HttpStatus.OK.value(), "CollectStatus By Id " + collectStatus.getId(), collectStatus, null);
        return new ResponseEntity<CollectStatusResponse>(collectStatusResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get List CollectStatus", response = CollectStatusResponse.class)
    @GetMapping("collect-status")
    public ResponseEntity<CollectStatusResponse> getAllDataCollectStatus() {
        List<CollectStatus> collectStatus = collectStatusService.getAllDataCollectStatus();
        collectStatusResponse = new CollectStatusResponse(HttpStatus.OK.value(), "List Loan", null, collectStatus);
        return new ResponseEntity<CollectStatusResponse>(collectStatusResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete CollectStatus By Id", response = CollectStatusResponse.class)
    @DeleteMapping("collect-status/{id}")
    public void deleteDataCollectStatusById(
            @ApiParam(value = "Id", required = true)
            @PathVariable Integer id) {
        collectStatusService.deleteDataCollectStatusById(id);
    }
}
