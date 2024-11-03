package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.repository.FertilizerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Fertilizer service.
 */
@Service
public class FertilizerService {
  private final FertilizerRepository fertilizerRepository;
  private final CropService cropService;

  /**
   * Instantiates a new Fertilizer service.
   *
   * @param fertilizerRepository the fertilizer repository
   * @param cropService          the crop service
   */
  @Autowired
  public FertilizerService(FertilizerRepository fertilizerRepository, CropService cropService) {
    this.fertilizerRepository = fertilizerRepository;
    this.cropService = cropService;
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
