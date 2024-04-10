package com.dzi.project.services;

import com.dzi.project.models.Season;
import com.dzi.project.repositories.SeasonRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    private final SeasonRepository seasonRepository;

    public SeasonService(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    public List<Season> getSeasons() {
        return seasonRepository.findAll();
    }

    public Season getSeason(Integer id) {
        Optional<Season> user = seasonRepository.findById(id);
        return user.orElse(null);
    }

    public Season createSeason(Season user) {
        return seasonRepository.save(user);
    }

    public void editSeason(Season playgroundSeason) {
        seasonRepository.save(playgroundSeason);
    }

    public void deleteSeason(Integer id) {
        seasonRepository.deleteById(id);
    }


}
