package com.example.ReadCSV.service;

import com.example.ReadCSV.pojo.ZipCode;
import com.example.ReadCSV.repository.ZipcodesRepository;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;

@Service
public class SampleService
{
    private ZipcodesRepository zipcodesRepository;

    public SampleService(ZipcodesRepository zipcodesRepository) {
        this.zipcodesRepository = zipcodesRepository;
    }

    public List<ZipCode> readCSVfile(InputStream inputStream) throws IOException
    {
        try (Reader reader= new InputStreamReader(inputStream)){
            CsvToBean<ZipCode> csvToBean= new CsvToBeanBuilder<ZipCode>(reader)
                    .withType(ZipCode.class)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();
            List<ZipCode>zipCodes=csvToBean.parse();

            List<ZipCode>savedZipCodes=zipcodesRepository.saveAll(zipCodes);

            return savedZipCodes;
        }
    }

}
