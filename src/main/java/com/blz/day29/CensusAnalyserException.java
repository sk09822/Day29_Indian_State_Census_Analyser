package com.blz.day29;

public class CensusAnalyserException extends Exception {

    enum ExceptionType {

        Unable_To_Parse, Csv_File_Problem
    }

    ExceptionType type;

    public CensusAnalyserException(String message,ExceptionType type) {
        super(message);
        this.type = type;
    }

    public CensusAnalyserException( ExceptionType type, String message, Throwable cause) {
        super(message, cause);
        this.type = type;
    }

}
