package com.nimble.sbclinicsms.converter.mocks;

import com.nimble.sbclinicsms.data.model.Clinic;
import com.nimble.sbclinicsms.data.vo.ClinicVO;

import java.util.ArrayList;
import java.util.List;

public class MockClinic {
    public Clinic mockEntity() {
        return mockEntity(0);
    }

    public ClinicVO mockVO() {
        return mockVO(0);
    }

    public List<Clinic> mockEntityList() {
        List<Clinic> Clinics = new ArrayList<Clinic>();
        for (int i = 0; i < 14; i++) {
            Clinics.add(mockEntity(i));
        }
        return Clinics;
    }

    public List<ClinicVO> mockVOList() {
        List<ClinicVO> Clinics = new ArrayList<>();
        for (int i = 0; i < 14; i++) {
            Clinics.add(mockVO(i));
        }
        return Clinics;
    }

    private Clinic mockEntity(Integer number) {
        Clinic Clinic = new Clinic();
        Clinic.setId(number.longValue());
        Clinic.setName("Name Test" + number);
        Clinic.setLogo("Logo Test" + number);
        Clinic.setGroup((number % 2) == 0);
        Clinic.setAddress("Address Test" + number);
        Clinic.setLatitude("Latitude Test" + number);
        Clinic.setLongitude("Longitude Test" + number);
        Clinic.setBusinessName("Business Name Test" + number);
        Clinic.setBusinessAddress("Business Address Test" + number);
        Clinic.setTaxNumber("Tax Number Test" + number);
        Clinic.setFiscalCode("Fiscal Code Test" + number);
        Clinic.setShareCapital("Share Capital Test" + number);
        return Clinic;
    }

    private ClinicVO mockVO(Integer number) {
        ClinicVO Clinic = new ClinicVO();
        Clinic.setId(number.longValue());
        Clinic.setName("Name Test" + number);
        Clinic.setLogo("Logo Test" + number);
        Clinic.setGroup((number % 2) == 0);
        Clinic.setAddress("Address Test" + number);
        Clinic.setLatitude("Latitude Test" + number);
        Clinic.setLongitude("Longitude Test" + number);
        Clinic.setBusinessName("Business Name Test" + number);
        Clinic.setBusinessAddress("Business Address Test" + number);
        Clinic.setTaxNumber("Tax Number Test" + number);
        Clinic.setFiscalCode("Fiscal Code Test" + number);
        Clinic.setShareCapital("Share Capital Test" + number);
        return Clinic;
    }

}
