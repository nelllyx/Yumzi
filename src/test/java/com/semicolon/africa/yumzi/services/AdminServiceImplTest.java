package com.semicolon.africa.yumzi.services;

import com.semicolon.africa.yumzi.dtos.request.AddFoodRequest;
import com.semicolon.africa.yumzi.dtos.request.RemoveFoodRequest;
import com.semicolon.africa.yumzi.dtos.response.AddFoodResponse;
import com.semicolon.africa.yumzi.dtos.response.RemoveFoodResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class AdminServiceImplTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void testAdminCanFoodBeAdded() {
        AddFoodRequest addFoodRequest = new AddFoodRequest();
        addFoodRequest.setFoodName("Rice");
        addFoodRequest.setFoodDescription("For Eating");
        addFoodRequest.setFoodPrice(BigDecimal.valueOf(2000));
        AddFoodResponse addFoodResponse = adminService.addFood(addFoodRequest);
        assertThat(addFoodResponse.getMessage()).isEqualTo("Food added successfully");

        AddFoodRequest addFoodRequest2 = new AddFoodRequest();
        addFoodRequest2.setFoodName("Beans");
        addFoodRequest2.setFoodDescription("For Eating");
        addFoodRequest2.setFoodPrice(BigDecimal.valueOf(1000));
        AddFoodResponse addFoodResponse2 = adminService.addFood(addFoodRequest2);
        assertThat(addFoodResponse2.getMessage()).isEqualTo("Food added successfully");
    }
    @Test
    public void testAdminCanFoodBeRemoved() {
        RemoveFoodRequest removeFoodRequest = new RemoveFoodRequest();
        removeFoodRequest.setFoodId(4L);
        RemoveFoodResponse removeFoodResponse = adminService.removeFood(removeFoodRequest);
        assertThat(removeFoodResponse.getMessage()).isEqualTo("Food removed successfully");
    }
}