package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The type Crop service.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FarmService farmService;

  /**
   * Instantiates a new Crop service.
   *
   * @param cropRepository the crop repository
   * @param farmService    the farm service
   */
  @Autowired
  public CropService(CropRepository cropRepository, FarmService farmService) {
    this.cropRepository = cropRepository;
    this.farmService = farmService;
  }

  /**
   * Find by id crop.
   *
   * @param id the id
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id)
        .orElseThrow(CropNotFoundException::new);
  }

  /**
   * Find all list.
   *
   * @return the list
   */
  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Create crop.
   *
   * @param cropToSave the crop to save
   * @return the crop
   */
  public Crop create(Crop cropToSave) {
    return cropRepository.save(cropToSave);
  }

  /**
   * Update crop.
   *
   * @param id              the id
   * @param cropWithChanges the crop with changes
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   * @throws FarmNotFoundException the farm not found exception
   */
  public Crop update(Long id, Crop cropWithChanges)
      throws CropNotFoundException, FarmNotFoundException {
    Crop cropToChange = findById(id);

    if (!cropWithChanges.getName().isEmpty() && !cropWithChanges.getName().isBlank()) {
      cropToChange.setName(cropWithChanges.getName());
    }

    if (!cropWithChanges.getPlantedArea().isNaN() && !(cropWithChanges.getPlantedArea() == null)) {
      cropToChange.setplantedArea(cropWithChanges.getPlantedArea());
    }

    if (!(cropWithChanges.getFarmId() == null)) {
      Farm farmToVinculate = farmService.findById(cropWithChanges.getFarmId());
      cropToChange.setFarm(farmToVinculate);
    }

    return cropRepository.save(cropToChange);
  }

  /**
   * Delete by id crop.
   *
   * @param id the id
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop deleteById(Long id) throws CropNotFoundException {
    Crop cropToExclude = findById(id);

    cropRepository.deleteById(id);

    return cropToExclude;
  }

  /**
   * Sets crop farm.
   *
   * @param cropId the crop id
   * @param farmId the farm id
   * @return the crop farm
   * @throws CropNotFoundException the crop not found exception
   * @throws FarmNotFoundException the farm not found exception
   */
  public Crop setCropFarm(
      Long cropId,
      Long farmId
  ) throws CropNotFoundException, FarmNotFoundException {
    Crop crop = findById(cropId);
    Farm farm = farmService.findById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  /**
   * Remove crop farm crop.
   *
   * @param cropId the crop id
   * @return the crop
   * @throws CropNotFoundException the crop not found exception
   */
  public Crop removeCropFarm(Long cropId) throws CropNotFoundException {
    Crop crop = findById(cropId);

    crop.setFarm(null);

    return cropRepository.save(crop);
  }
}
