package com.dzi.project.controllers;

import com.dzi.project.models.Season;
import com.dzi.project.services.SeasonService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/")
public class SeasonController {
    private final SeasonService seasonService;

    public SeasonController(SeasonService seasonService) {
        this.seasonService = seasonService;
    }


    @DeleteMapping(value = "/season/{id}")
    public void deleteSeason(@PathVariable Integer id) {
        seasonService.deleteSeason(id);
    }

}
