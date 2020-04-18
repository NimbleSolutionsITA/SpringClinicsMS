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
        Assert.assertEquals(Long.valueOf(0L), output.getKey());
        Assert.assertEquals("Name Test0", output.getName());
        Assert.assertEquals("Logo Test0", output.getLogo());
        Assert.assertEquals("Google Place Id Test0", output.getGooglePlaceId());
    }

    @Test
    public void parseEntityListToVOListTest() {
        List<ClinicVO> outputList = DozerParser.parseListObjects(inputObject.mockEntityList(), ClinicVO.class);
        ClinicVO outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getKey());
        Assert.assertEquals("Name Test0", outputZero.getName());
        Assert.assertEquals("Logo Test0", outputZero.getLogo());
        Assert.assertEquals("Google Place Id Test0", outputZero.getGooglePlaceId());

        ClinicVO outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getKey());
        Assert.assertEquals("Name Test7", outputSeven.getName());
        Assert.assertEquals("Logo Test7", outputSeven.getLogo());
        Assert.assertEquals("Google Place Id Test7", outputSeven.getGooglePlaceId());

        ClinicVO outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getKey());
        Assert.assertEquals("Name Test12", outputTwelve.getName());
        Assert.assertEquals("Logo Test12", outputTwelve.getLogo());
        Assert.assertEquals("Google Place Id Test12", outputTwelve.getGooglePlaceId());
    }

    @Test
    public void parseVOToEntityTest() {
        Clinic output = DozerParser.parseObject(inputObject.mockVO(), Clinic.class);
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("Name Test0", output.getName());
        Assert.assertEquals("Logo Test0", output.getLogo());
        Assert.assertEquals("Google Place Id Test0", output.getGooglePlaceId());
    }

    @Test
    public void parserVOListToEntityListTest() {
        List<Clinic> outputList = DozerParser.parseListObjects(inputObject.mockVOList(), Clinic.class);
        Clinic outputZero = outputList.get(0);

        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("Name Test0", outputZero.getName());
        Assert.assertEquals("Logo Test0", outputZero.getLogo());
        Assert.assertEquals("Google Place Id Test0", outputZero.getGooglePlaceId());

        Clinic outputSeven = outputList.get(7);

        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("Name Test7", outputSeven.getName());
        Assert.assertEquals("Logo Test7", outputSeven.getLogo());
        Assert.assertEquals("Google Place Id Test7", outputSeven.getGooglePlaceId());

        Clinic outputTwelve = outputList.get(12);

        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("Name Test12", outputTwelve.getName());
        Assert.assertEquals("Logo Test12", outputTwelve.getLogo());
        Assert.assertEquals("Google Place Id Test12", outputTwelve.getGooglePlaceId());
    }
}
