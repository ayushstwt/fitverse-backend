package com.ayshriv.fitversactivityservice.service.impl;

import com.ayshriv.fitversactivityservice.dto.ActivityRequest;
import com.ayshriv.fitversactivityservice.dto.ActivityResponse;
import com.ayshriv.fitversactivityservice.entities.Activity;
import com.ayshriv.fitversactivityservice.repositories.ActivityRepository;
import com.ayshriv.fitversactivityservice.service.ActivityService;
import com.ayshriv.fitversactivityservice.service.UserValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;
    @Autowired
    private UserValidationService userValidationService;


    @Override
    public ActivityResponse trackActivity(ActivityRequest request) {
        boolean isValidUser = userValidationService.validateUser(request.getUserId());
        if (!isValidUser) {
            throw new RuntimeException("Invalid user ID: " + request.getUserId());
        }
        ActivityResponse response = new ActivityResponse();
        Activity activity=new Activity();
        activity.setUserId(request.getUserId());
        activity.setType(request.getType());
        activity.setDuration(request.getDuration());
        activity.setCaloriesBurned(request.getCaloriesBurned());
        activity.setStartTime(request.getStartTime());
        activity.setAdditionalMatrices(request.getAdditionalMatrices());

        Activity saveActivity = activityRepository.save(activity);
        if (saveActivity != null) {
            response.setId(saveActivity.getId());
            response.setUserId(saveActivity.getUserId());
            response.setType(saveActivity.getType());
            response.setDuration(saveActivity.getDuration());
            response.setCaloriesBurned(saveActivity.getCaloriesBurned());
            response.setStartTime(saveActivity.getStartTime());
            response.setAdditionalMatrices(saveActivity.getAdditionalMatrices());
            response.setCreatedOn(saveActivity.getCreatedOn());
            response.setUpdatedOn(saveActivity.getUpdatedOn());
        }
        return response;
    }

    @Override
    public List<ActivityResponse> getUserActivities(String userId) {
        List<Activity> activities = activityRepository.findByUserId(userId);
        if (activities != null && !activities.isEmpty()) {
            return activities.stream().map(activity -> {
                ActivityResponse response = new ActivityResponse();
                response.setId(activity.getId());
                response.setUserId(activity.getUserId());
                response.setType(activity.getType());
                response.setDuration(activity.getDuration());
                response.setCaloriesBurned(activity.getCaloriesBurned());
                response.setStartTime(activity.getStartTime());
                response.setAdditionalMatrices(activity.getAdditionalMatrices());
                response.setCreatedOn(activity.getCreatedOn());
                response.setUpdatedOn(activity.getUpdatedOn());
                return response;
            }).toList();
        }
        return null;
    }

    @Override
    public ActivityResponse getActivity(String activityId) {
        return activityRepository.findById(activityId)
                .map(activity -> {
                    ActivityResponse response = new ActivityResponse();
                    response.setId(activity.getId());
                    response.setUserId(activity.getUserId());
                    response.setType(activity.getType());
                    response.setDuration(activity.getDuration());
                    response.setCaloriesBurned(activity.getCaloriesBurned());
                    response.setStartTime(activity.getStartTime());
                    response.setAdditionalMatrices(activity.getAdditionalMatrices());
                    response.setCreatedOn(activity.getCreatedOn());
                    response.setUpdatedOn(activity.getUpdatedOn());
                    return response;
                }).orElseThrow(()->
                        new RuntimeException("Activity not found with id: " + activityId));
    }

}
