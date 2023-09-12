package com.edburguer.service;

import com.edburguer.dto.OptionDto;
import com.edburguer.entity.Option;

import java.util.List;

public interface OptionService {
    Option create(OptionDto dto);

    List<Option> findAll();

    Option findById(Long id);

    Option update(OptionDto dto);

    void delete(Long id);
}
