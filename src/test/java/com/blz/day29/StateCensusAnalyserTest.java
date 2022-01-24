package com.blz.day29;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StateCensusAnalyserTest {
    private static final String csvPath ="D:\\BridgeLabz Assignments\\IndianStateCenesus-master\\Data\\IndiaStateCensusData.csv";
    private static final String csvWrongPath = "D:\\BridgeLabz Assignments\\IndiaStateCensusData.csv";
    private static final String pdfPath ="D:\\BridgeLabz Assignments\\IndianStateCenesus-master\\Data\\IndiaStateCensusData.pdf";

    @Test
    public void givenCensusCsvFile_returnCorrectRecords() throws IOException, CensusAnalyserException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        int recordsNumb = stateCensusAnalyser.LoadIndiaCensusData(csvPath);
        assertEquals(0,recordsNumb);
    }

    @Test
    public void given_IndiaCensusData_CsvFile_ShouldThrowException() throws IOException {
        try {
            StateCensusAnalyser censusAnalyZer = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyZer.LoadIndiaCensusData(csvWrongPath);
        } catch(CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.Csv_File_Problem, e.type);
        }
    }

    @Test
    public void given_IndiaCensusData_WithWrongFile_ShoulThrewException() throws IOException {
        try {
            StateCensusAnalyser censusAnalyZer = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyZer.LoadIndiaCensusData(pdfPath);
        } catch(CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.Unable_To_Parse, e.type);
        }
    }

    @Test
    public void given_IndiaCensusData_WithWrongDelimeter_ShoulThrowException() throws IOException {
        try {
            StateCensusAnalyser censusAnalyser = new StateCensusAnalyser();
            ExpectedException exceptionRule = ExpectedException.none();
            exceptionRule.expect(CensusAnalyserException.class);
            censusAnalyser.LoadIndiaCensusCSVData(csvPath);
        } catch(CensusAnalyserException e) {
            assertEquals(CensusAnalyserException.ExceptionType.Unable_To_Parse, e.type);
        }
    }
}

