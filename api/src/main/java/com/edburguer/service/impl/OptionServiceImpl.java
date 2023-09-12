package com.edburguer.service.impl;

import com.edburguer.dto.OptionDto;
import com.edburguer.entity.Ingredient;
import com.edburguer.entity.Option;
import com.edburguer.exception.NotFoundException;
import com.edburguer.mapper.OptionMapper;
import com.edburguer.repository.OptionRepository;
import com.edburguer.service.IngredientService;
import com.edburguer.service.OptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OptionServiceImpl implements OptionService {
    @Autowired
    private OptionRepository optionRepository;

    @Autowired
    private IngredientService ingredientService;

    @Override
    public Option create(OptionDto dto) {
        List<Ingredient> ingredients = dto.getIngredients().stream().map(el -> ingredientService.findById(el)).toList();
        Option entity = OptionMapper.fromDtoToEntity(dto, ingredients);

        return optionRepository.save(entity);
    }

    @Override
    public List<Option> findAll() {
        return optionRepository.findAll();
    }

    @Override
    public Option findById(Long id) {
        Optional<Option> entity = optionRepository.findById(id);
        if(entity.isEmpty()) throw new NotFoundException("Option não encontrada");

        return entity.get();
    }

    @Override
    public Option update(OptionDto dto) {
        Option entity = this.findById(dto.getId());

        entity.setName(dto.getName());
        entity.setMaximumAmount(dto.getMaximumAmount());
        entity.setRequired(dto.getRequired());
        entity.setOptionsRequired(dto.getOptionsRequired());

        List<Ingredient> ingredients = dto.getIngredients().stream().map(el -> ingredientService.findById(el)).toList();
        entity.setIngredients(ingredients);

        return optionRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        Option entity = this.findById(id);

        optionRepository.delete(entity);
    }
}
