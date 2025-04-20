package com.ayshriv.fitversactivityservice.controllers;

import com.ayshriv.fitversactivityservice.dto.ActivityRequest;
import com.ayshriv.fitversactivityservice.dto.ActivityResponse;
import com.ayshriv.fitversactivityservice.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @PostMapping
    public ResponseEntity<ActivityResponse> trackActivity(@RequestBody ActivityRequest request) {
        ActivityResponse response = activityService.trackActivity(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<List<ActivityResponse>> getUserActivities(@PathVariable String userId) {
        List<ActivityResponse> response = activityService.getUserActivities(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{activityId}")
    public ResponseEntity<ActivityResponse> getActivity(@PathVariable String activityId) {
        ActivityResponse response = activityService.getActivity(activityId);
        return ResponseEntity.ok(response);
    }


}
