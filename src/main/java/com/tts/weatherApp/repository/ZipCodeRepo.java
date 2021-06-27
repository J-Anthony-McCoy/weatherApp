package com.tts.weatherApp.repository;

import com.tts.weatherApp.model.ZipCode;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ZipCodeRepo extends CrudRepository<ZipCode, Long> {
    public List<ZipCode> findAllByOrderByIdDesc();

    @Query(value = "SELECT * FROM ZIP_CODE ORDER BY TIME_STAMP DESC LIMIT 10", nativeQuery = true)
    List<ZipCode> selectTenRecent();

}

//SELECT * FROM ZIP_CODE
//        ORDER BY TIME_STAMP DESC
//        LIMIT 10;