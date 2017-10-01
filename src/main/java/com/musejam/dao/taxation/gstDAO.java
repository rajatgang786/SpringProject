package com.musejam.dao.taxation;

import com.musejam.table.taxation.GST;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GSTDAO extends JpaRepository<GST,Long> {

    //It will find all values where hsn value is given parameter
    public GST findByHsn(String hsn);
}
