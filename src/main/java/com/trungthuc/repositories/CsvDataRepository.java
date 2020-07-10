package com.trungthuc.repositories;

import com.trungthuc.domains.CsvData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CsvDataRepository extends JpaRepository<CsvData,Integer> {

//    @Query(value=" LOAD DATA LOCAL INFILE  '\" + \":param\" + \"'    \n " +
//                "   INTO TABLE csvdata FIELDS TERMINATED BY ',' \n " +
//                "  LINES TERMINATED BY '\\n' \n " +
//                "  IGNORE 1 ROWS (name, des) " ,nativeQuery=true)
//    void execFileCSV(@Param("param") String filePath);
}
