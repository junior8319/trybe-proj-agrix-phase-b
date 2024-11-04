package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.repository.FertilizerRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   */
  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository) {
    this.fertilizerRepository = fertilizerRepository;
  }

  /**
   * Gets all fertilizers.
   *
   * @return the all fertilizers
   */
  public List<Fertilizer> getAllFertilizers() {
    return fertilizerRepository.findAll();
  }

  /**
   * Create fertilizer fertilizer.
   *
   * @param fertilizerToSave the fertilizer to save
   * @return the fertilizer
   */
  public Fertilizer createFertilizer(Fertilizer fertilizerToSave) {
    return fertilizerRepository.save(fertilizerToSave);
  }
}
