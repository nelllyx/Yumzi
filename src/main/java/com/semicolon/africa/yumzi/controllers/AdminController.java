package com.semicolon.africa.yumzi.controllers;

import com.semicolon.africa.yumzi.dtos.request.AddFoodRequest;
import com.semicolon.africa.yumzi.dtos.response.AddFoodResponse;
import com.semicolon.africa.yumzi.dtos.response.ApiResponse;
import com.semicolon.africa.yumzi.services.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("add")
    public ResponseEntity<?> addFood(@RequestBody AddFoodRequest addFoodRequest) {
        try {
            AddFoodResponse addFoodResponse = adminService.addFood(addFoodRequest);
            return new ResponseEntity<>(new ApiResponse(addFoodResponse, true), HttpStatus.CREATED);
        }
        catch (Exception e) {
            return new ResponseEntity<>(new ApiResponse(e.getMessage(), false), HttpStatus.BAD_REQUEST);
        }
    }
}
