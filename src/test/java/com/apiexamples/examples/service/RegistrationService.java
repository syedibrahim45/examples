package com.apiexamples.examples.service;


import com.apiexamples.examples.dto.RegistrationDto;

import java.util.List;

public interface RegistrationService  {

    public  RegistrationDto createRegistration(RegistrationDto registrationDto);

    void deleteRegistratonById(long id);

    RegistrationDto updateRegistration(long id, RegistrationDto registrationDto);





    List<RegistrationDto> getAllRegistration(int pageNumber, int pageSize, String sortBy, String sortDir);

    RegistrationDto getRegistratonById(long id);
}
