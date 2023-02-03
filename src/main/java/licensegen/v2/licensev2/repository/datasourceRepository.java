package licensegen.v2.licensev2.repository;


import licensegen.v2.licensev2.model.dataSourceDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface datasourceRepository extends JpaRepository<dataSourceDB, Long> {

}
