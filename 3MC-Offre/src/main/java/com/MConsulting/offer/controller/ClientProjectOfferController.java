package com.MConsulting.offer.controller;

import java.time.LocalDate;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.MConsulting.offer.model.like.Like;
import com.MConsulting.offer.model.payload.response.ResponseMessage;
import com.MConsulting.offer.model.post.ProjectOffer;
import com.MConsulting.offer.model.post.ProjectOfferStatus;
import com.MConsulting.offer.service.like.LikeService;
import com.MConsulting.offer.service.offer.ProjectOfferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Users' project offer API", description = "Endpoints exposed for users to perform operations on project offers" )
@RestController
@RequestMapping("/api/v1/users")
public class ClientProjectOfferController {

    
    private final ProjectOfferService projectOfferService;
    private final LikeService likeService;

    public ClientProjectOfferController(ProjectOfferService projectOfferService, LikeService likeService) {
        this.projectOfferService = projectOfferService;
        this.likeService = likeService;
    }

    @Operation(summary = "Post a new project offer", description = "Endpoint used by clients to create new project offers for a given category")
    @ApiResponse(responseCode = "201", description = "Project offer created")
    @PostMapping(value = "/{id}/project-offers/", consumes = {"multipart/form-data"})
    public ResponseEntity<ResponseMessage> add(@PathVariable("id") UUID clientId,
                @RequestParam("title") String title,
                @RequestParam("categoryId") UUID categoryId,
                @RequestParam("description") String description,
                @RequestParam("budget") String budget,
                @RequestParam(name = "location", required = false) String location,
                @RequestParam(name = "image", required = false) MultipartFile image,
                @RequestParam(name = "submissionDeadline", required = false) String deadline,
                @RequestParam(name = "duration", required = true) String duration
                
            ) {

        ProjectOffer projectOffer = new ProjectOffer();
        projectOffer.setTitle(title);
        projectOffer.setBudget(budget);
        projectOffer.setDeadline(deadline);
        projectOffer.setDatePosted(LocalDate.now().toString());
        projectOffer.setDuration(duration);
        projectOffer.setDescription(description);
        projectOffer.setLocation(location);
        projectOffer.setProjectOfferStatus(ProjectOfferStatus.AVAILABLE);
        
        projectOffer = projectOfferService.add(clientId, categoryId, projectOffer);
        return ResponseEntity.ok().body(new ResponseMessage("Project offer created"));
    }

    @Operation(summary = "like a project offer", description = "add a new like by a user to a project offer")
    @ApiResponse(responseCode = "200", description = "like added to project offer")
    @PostMapping("/{id}/project-offers/{postId}/likes")
    public ResponseEntity<ResponseMessage> like(@PathVariable("id") UUID id, @PathVariable("postId") UUID postId) {
        
        Like like = new Like();
        like.setExtent("like");
        like.setUserId(id);
        likeService.add(postId, like);
        return ResponseEntity.ok().body(new ResponseMessage("like added to project offer"));
    }
    
}
