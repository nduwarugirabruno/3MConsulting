package com.MConsulting.offer.controller;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.MConsulting.offer.model.post.ProjectOffer;
import com.MConsulting.offer.service.offer.ProjectOfferService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Project offer api", description = "API for visitors that enables search operations on project offers")
@RestController
@RequestMapping("/api/v1/project-offers")
public class ProjectOfferController {
    
    private final ProjectOfferService projectOfferService;

    public ProjectOfferController(ProjectOfferService projectOfferService) {
        this.projectOfferService = projectOfferService;
    }

    @Operation(summary = "Search project offers", description = "Search project offers by category sorted by budget, date posted, and likes.")
    @GetMapping("/search")
    public ResponseEntity<Page<ProjectOffer>> searchProjectOffers(@RequestParam(name = "categoryId") UUID category,
            @RequestParam(name = "sort", required = false) String sort,
            @RequestParam(name = "page") Integer page,
            @RequestParam(name = "size") Integer size
            ) {

                Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, sort));
                Page<ProjectOffer> projectOffers = projectOfferService.findByJobCategoryEntitiesIn(category, pageable);

        return ResponseEntity.ok().body(projectOffers);
    }




}
