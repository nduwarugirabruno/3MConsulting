package com.MConsulting.offer.controller;


import java.io.File;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MConsulting.offer.model.category.JobCategory;
import com.MConsulting.offer.model.payload.response.ResponseMessage;
import com.MConsulting.offer.service.category.JobCategoryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Category api", description = "API endpoints for performing operations on categories")
@RestController
@RequestMapping("/api/v1/categories")
public class JobCategoryController {

    private final JobCategoryService jobCategoryService;

    private final static String IMAGE_PATH = "/home/patrick/java/images/categories/";

    public JobCategoryController(JobCategoryService jobCategoryService) {
        this.jobCategoryService = jobCategoryService;
    }

    @Operation(summary = "add a new category", description = "save a new category in the database")
    @ApiResponse(responseCode = "201", description = "Category added successfully")
    @PostMapping(value = "/", consumes = {"multipart/form-data"})
    public ResponseEntity<ResponseMessage> add(@RequestParam("image") MultipartFile image,
            @RequestParam("name") String name,
            @RequestParam(name = "description", required = false) String description) { 
        
                if (image == null) {
                    return ResponseEntity.badRequest().body(new ResponseMessage("Image is required"));
                }

                if(image.isEmpty()) {
                    return ResponseEntity.badRequest().body(new ResponseMessage("Image is required"));
                }   

                try {
                    File upLoadDir = new File(IMAGE_PATH);
                    if (!upLoadDir.exists()) {
                        Boolean operation = upLoadDir.mkdir();
                        System.out.println(operation);

                    }

                    String fileName = UUID.randomUUID().toString();
                    String filePath = IMAGE_PATH + fileName;
                    File dest = new File(filePath);
                    image.transferTo(dest);

                    JobCategory jobCategory = new JobCategory();
                    jobCategory.setDescription(description);
                    jobCategory.setName(name);
                    jobCategory.setImage(fileName);
                    
                    this.jobCategoryService.add(jobCategory);

                    return ResponseEntity.ok().body(new ResponseMessage("Category added successfully"));
                } catch (Exception e) {
                    System.err.println(e.getMessage());
                    return ResponseEntity.badRequest().body(new ResponseMessage("Failed to add category"));
                }
    }


}
