package com.nimble.sbclinicsms.services;

import java.util.List;
import com.github.javafaker.Faker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nimble.sbclinicsms.exception.ResourceNotFoundException;
import com.nimble.sbclinicsms.model.Clinic;
import com.nimble.sbclinicsms.repository.ClinicRepository;

import java.util.Locale;
import java.util.Random;

@Service
public class ClinicServices {

    @Autowired
    ClinicRepository repository;

    public Clinic create(Clinic clinic) {
        return repository.save(clinic);
    }

    public List<Clinic> findAll() {
        return repository.findAll();
    }

    public Clinic findById(Long id) {
        System.out.println("ID: " + id);
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
    }

    public Clinic update(Clinic clinic) {
        Clinic entity = repository.findById(clinic.getId()).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        entity.setName(clinic.getName());
        entity.setLogo(clinic.getLogo());
        entity.setGroup(clinic.getGroup());
        entity.setAddress(clinic.getAddress());
        entity.setLatitude(clinic.getLatitude());
        entity.setLongitude(clinic.getLongitude());
        entity.setBusinessName(clinic.getBusinessName());
        entity.setBusinessAddress(clinic.getBusinessAddress());
        entity.setTaxNumber(clinic.getTaxNumber());
        entity.setFiscalCode(clinic.getFiscalCode());
        entity.setShareCapital(clinic.getShareCapital());
        return repository.save(entity);
    }

    public void delete(Long id) {
        Clinic entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No records found for this ID"));
        repository.delete(entity);
    }

    public Clinic mockGHC() {
        Clinic clinic = new Clinic();
        clinic.setName("Garofalo Health Care");
        clinic.setLogo("https://www.garofalohealthcare.com/images/logo.png");
        clinic.setGroup(true);
        clinic.setAddress("Piazzale Belle Arti, 6 00196 Roma RM");
        clinic.setLatitude("41.9190958");
        clinic.setLongitude("12.4700505");
        clinic.setBusinessName("Garofalo Health Care SpA");
        clinic.setBusinessAddress("Piazzale Belle Arti, 6 00196 Roma RM");
        clinic.setTaxNumber("03831150366");
        clinic.setFiscalCode("03831150366");
        clinic.setShareCapital("€ 28.700.000");

        return repository.save(clinic);
    }

    public void mockClinic(Long groupId) {
        Random randomNo = new Random();
        Faker faker = new Faker(new Locale("it"));
        String name = faker.medical().hospitalName();
        String address = faker.address().fullAddress();

        Clinic clinic = new Clinic();
        clinic.setName(name);
        clinic.setGroup(randomNo.nextBoolean());
        clinic.setGroupId(groupId);
        clinic.setLogo(faker.company().logo());
        clinic.setAddress(address);
        clinic.setLatitude(faker.address().latitude());
        clinic.setLongitude(faker.address().longitude());
        clinic.setBusinessName(name);
        clinic.setBusinessAddress(address);
        clinic.setTaxNumber(faker.idNumber().ssnValid());
        clinic.setFiscalCode(faker.idNumber().ssnValid());
        clinic.setShareCapital("€ " + faker.random().nextInt(1000000, 5000000));

        repository.save(clinic);
    }
}
