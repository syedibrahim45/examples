package com.apiexamples.examples.service;

import com.apiexamples.examples.dto.RegistrationDto;
import com.apiexamples.examples.entity.Registration;
import com.apiexamples.examples.exception.ResourceNotFound;
import com.apiexamples.examples.repository.RegistrationRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private RegistrationRepository registrationRepository;

    public RegistrationServiceImpl(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    @Override
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

        Registration registration = mapToEntity(registrationDto);
        Registration savedEntity = registrationRepository.save(registration);
        RegistrationDto dto = mapToDto(savedEntity);
        dto.setMessage("Registration saved");
        return dto;
    }

    @Override
    public void deleteRegistratonById(long id) {
        registrationRepository.deleteById(id);

    }

    @Override
    public RegistrationDto updateRegistration(long id, RegistrationDto registrationDto) {
        Optional<Registration> opReg = registrationRepository.findById(id);
        Registration registration = opReg.get();

        registration.setName(registration.getName());
        registration.setEmail(registration.getEmail());
        registration.setMobile(registrationDto.getMobile());
        Registration savedEntity = registrationRepository.save(registration);
        RegistrationDto dto =  mapToDto(registration);

        return dto;
    }

    @Override
    public List<RegistrationDto> getAllRegistration(int pageNumber, int pageSize, String sortBy, String sortDir) {
        //List<Registration> registration = registrationRepository.findAll();

      Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(Sort.Direction.ASC,sortBy): Sort.by(Sort.Direction.ASC,sortBy);
      PageRequest pageable =  PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Registration> all = registrationRepository.findAll(pageable);
        List<Registration> registrations = all.getContent();
        List<RegistrationDto> registrationDtos = registrations.stream().map(r -> mapToDto(r)).collect(Collectors.toList());
        System.out.println(all.getTotalPages());
        System.out.println(all.isLast());
        System.out.println(all.isFirst());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        return registrationDtos ;

    }

    @Override
    public RegistrationDto getRegistratonById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                () -> new ResourceNotFound("Registration not found with id: " + id)
        );

        RegistrationDto registrationDto = mapToDto(registration);
        return registrationDto;
    }

    Registration mapToEntity(RegistrationDto dto) {
        Registration entity = new Registration();
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setMobile(dto.getMobile());
        return entity;

    }

    RegistrationDto mapToDto(Registration registration) {
        RegistrationDto dto = new RegistrationDto();
        Registration entity = new Registration();
        dto.setId(registration.getId());
        dto.setName(registration.getName());
        dto.setEmail(registration.getEmail());
        dto.setMobile(registration.getMobile());
        return dto;
    }
}




