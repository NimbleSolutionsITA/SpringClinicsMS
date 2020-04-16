package com.nimble.sbclinicsms.parser;

import com.nimble.sbclinicsms.parser.mocks.MockClinic;
import com.nimble.sbclinicsms.data.model.Clinic;
import com.nimble.sbclinicsms.data.vo.v1.ClinicVO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DozerParserTest {

    MockClinic inputObject;

    @Before
    public void setUp() {
        inputObject = new MockClinic();
    }

    @Test
    public void parseEntityToVOTest() {
        ClinicVO output = DozerParser.parseObject(inputObject.mockEntity(), ClinicVO.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Name Test0", output.getName());
        Assert.assertEquals("Logo Test0", output.getLogo());
        Assert.assertEquals("Google Place Id Test0", output.getGooglePlaceId());
        Assert.assertEquals("Business Name Test0", output.getBusinessName());
        Assert.assertEquals("Business Address Test0", output.getBusinessAddress());
        Assert.assertEquals("Tax Number Test0", output.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test0", output.getFiscalCode());
        Assert.assertEquals("Share Capital Test0", output.getShareCapital());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<ClinicVO> outputList = DozerParser.parseListObjects(inputObject.mockEntityList(), ClinicVO.class);
        ClinicVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Name Test0", outputZero.getName());
        Assert.assertEquals("Logo Test0", outputZero.getLogo());
        Assert.assertEquals("Google Place Id Test0", outputZero.getGooglePlaceId());
        Assert.assertEquals("Business Name Test0", outputZero.getBusinessName());
        Assert.assertEquals("Business Address Test0", outputZero.getBusinessAddress());
        Assert.assertEquals("Tax Number Test0", outputZero.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test0", outputZero.getFiscalCode());
        Assert.assertEquals("Share Capital Test0", outputZero.getShareCapital());

        ClinicVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Name Test7", outputSeven.getName());
        Assert.assertEquals("Logo Test7", outputSeven.getLogo());
        Assert.assertEquals("Google Place Id Test7", outputSeven.getGooglePlaceId());
        Assert.assertEquals("Business Name Test7", outputSeven.getBusinessName());
        Assert.assertEquals("Business Address Test7", outputSeven.getBusinessAddress());
        Assert.assertEquals("Tax Number Test7", outputSeven.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test7", outputSeven.getFiscalCode());
        Assert.assertEquals("Share Capital Test7", outputSeven.getShareCapital());

        ClinicVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Name Test12", outputTwelve.getName());
        Assert.assertEquals("Logo Test12", outputTwelve.getLogo());
        Assert.assertEquals("Google Place Id Test12", outputTwelve.getGooglePlaceId());
        Assert.assertEquals("Business Name Test12", outputTwelve.getBusinessName());
        Assert.assertEquals("Business Address Test12", outputTwelve.getBusinessAddress());
        Assert.assertEquals("Tax Number Test12", outputTwelve.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test12", outputTwelve.getFiscalCode());
        Assert.assertEquals("Share Capital Test12", outputTwelve.getShareCapital());
    }

    @Test
    public void parseVOToEntityTest() {
        Clinic output = DozerParser.parseObject(inputObject.mockVO(), Clinic.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Name Test0", output.getName());
        Assert.assertEquals("Logo Test0", output.getLogo());
        Assert.assertEquals("Google Place Id Test0", output.getGooglePlaceId());
        Assert.assertEquals("Business Name Test0", output.getBusinessName());
        Assert.assertEquals("Business Address Test0", output.getBusinessAddress());
        Assert.assertEquals("Tax Number Test0", output.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test0", output.getFiscalCode());
        Assert.assertEquals("Share Capital Test0", output.getShareCapital());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Clinic> outputList = DozerParser.parseListObjects(inputObject.mockVOList(), Clinic.class);
        Clinic outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Name Test0", outputZero.getName());
        Assert.assertEquals("Logo Test0", outputZero.getLogo());
        Assert.assertEquals("Google Place Id Test0", outputZero.getGooglePlaceId());
        Assert.assertEquals("Business Name Test0", outputZero.getBusinessName());
        Assert.assertEquals("Business Address Test0", outputZero.getBusinessAddress());
        Assert.assertEquals("Tax Number Test0", outputZero.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test0", outputZero.getFiscalCode());
        Assert.assertEquals("Share Capital Test0", outputZero.getShareCapital());

        Clinic outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Name Test7", outputSeven.getName());
        Assert.assertEquals("Logo Test7", outputSeven.getLogo());
        Assert.assertEquals("Google Place Id Test7", outputSeven.getGooglePlaceId());
        Assert.assertEquals("Business Name Test7", outputSeven.getBusinessName());
        Assert.assertEquals("Business Address Test7", outputSeven.getBusinessAddress());
        Assert.assertEquals("Tax Number Test7", outputSeven.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test7", outputSeven.getFiscalCode());
        Assert.assertEquals("Share Capital Test7", outputSeven.getShareCapital());

        Clinic outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Name Test12", outputTwelve.getName());
        Assert.assertEquals("Logo Test12", outputTwelve.getLogo());
        Assert.assertEquals("Google Place Id Test12", outputTwelve.getGooglePlaceId());
        Assert.assertEquals("Business Name Test12", outputTwelve.getBusinessName());
        Assert.assertEquals("Business Address Test12", outputTwelve.getBusinessAddress());
        Assert.assertEquals("Tax Number Test12", outputTwelve.getTaxNumber());
        Assert.assertEquals("Fiscal Code Test12", outputTwelve.getFiscalCode());
        Assert.assertEquals("Share Capital Test12", outputTwelve.getShareCapital());
    }
}
