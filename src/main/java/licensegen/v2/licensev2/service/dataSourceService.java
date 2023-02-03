package licensegen.v2.licensev2.service;

import licensegen.v2.licensev2.model.dataSourceDB;

import java.util.List;
import java.util.Optional;

public interface dataSourceService {

    dataSourceDB save(dataSourceDB savedb);

    dataSourceDB update(dataSourceDB datasourcenm, Long id);

    List<dataSourceDB> datalist();

    Optional<dataSourceDB> findById(Long id);

    void deleteUser (dataSourceDB id);

//    dataSourceDB findbydatasourcenm(dataSourceDB datasourcenm);

    dataSourceDB getdatacon(Long id);

}
