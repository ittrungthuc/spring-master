package com.trungthuc.repositories;

import com.google.gson.JsonObject;
import com.trungthuc.domains.VanBan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VanbanRepository extends JpaRepository<VanBan,Long> {


  //  @Procedure( procedureName= "VanBan.createVanBanFromJson" )
    @Query(nativeQuery = true,value = "call createVanBanFromJson(:datas)")
    void execProcedure(@Param("datas") String datas);

    @Query(nativeQuery = true,value = "call test1(:ty)")
    void execProcedureTest(@Param("ty") String params);
}
