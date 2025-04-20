package com.ayshriv.fitversactivityservice.service;

import com.ayshriv.fitversactivityservice.dto.ActivityRequest;
import com.ayshriv.fitversactivityservice.dto.ActivityResponse;

import java.util.List;

public interface ActivityService {
    ActivityResponse trackActivity(ActivityRequest request);

    List<ActivityResponse> getUserActivities(String userId);

    ActivityResponse getActivity(String activityId);
}
