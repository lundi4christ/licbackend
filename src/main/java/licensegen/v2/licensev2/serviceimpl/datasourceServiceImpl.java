package licensegen.v2.licensev2.serviceimpl;

import licensegen.v2.licensev2.model.dataSourceDB;
import licensegen.v2.licensev2.repository.datasourceRepository;
import licensegen.v2.licensev2.service.dataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class datasourceServiceImpl implements dataSourceService {

    @Autowired
    private datasourceRepository datasourceRepository;

   // @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public dataSourceDB save(dataSourceDB savedb) {
        return datasourceRepository.save(savedb);
    }

    @Override
    public dataSourceDB update(dataSourceDB datasourcenm, Long id){

        dataSourceDB getid = datasourceRepository.findById(id).get();

        if(getid != null){
            getid.setUsername(datasourcenm.getDatabasenm());
            System.out.println("======= =====  " + getid.getUsername() );
        }
        return datasourceRepository.save(getid);
    }

    @Override
    public List<dataSourceDB> datalist(){
        return datasourceRepository.findAll();
    }

    @Override
    public void deleteUser(dataSourceDB id) {
        datasourceRepository.delete(id);
    }

    @Override
    public Optional<dataSourceDB> findById(Long id){
        return datasourceRepository.findById(id);
    }

   /* @Override
    public dataSourceDB findbydatasourcenm(dataSourceDB datasourcenm){
        return datasourceRepository.findOne(datasourcenm);
    }*/

    @Override
    public dataSourceDB getdatacon(Long id){

        dataSourceDB getdata = datasourceRepository.findById(id).get();

        System.out.println("====== get data === " + getdata.getUsername());
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getdata.getJdbcdriver());
        dataSource.setUsername(getdata.getUsername());
        dataSource.setPassword(getdata.getPassword());
        dataSource.setUrl("jdbc:sqlserver://" + getdata.getHost() + ":" + getdata.getPort() + ";" + "database=" + getdata.getDatabasenm());
        //dataSource.setUrl("jdbc:oracle:thin:@" + getdata.getHost() + ":" + getdata.getPort() + ":" + getdata.getDatabasenm());
        //dataSource.setUrl("jdbc:mysql://" + getdata.getHost()  + ":" + getdata.getPort() + "/" + getdata.getDatabasenm());

        try{
            dataSource.getConnection(getdata.getUsername(), getdata.getPassword());
            if(dataSource != null){
                System.out.println("===== connected successfully ==== ");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }

        jdbcTemplate = new JdbcTemplate(dataSource);
        List<Map<String, Object>> getList = jdbcTemplate.queryForList("SELECT code FROM DATATEST.control_parameter");

        SqlRowSet therowset = jdbcTemplate.queryForRowSet("SELECT value  FROM DATATEST.control_parameter WHERE code='129'");

        System.out.println("----uuuuu " + therowset);

        for(Map m : getList) {
            dataSourceDB db = new dataSourceDB();
            db.setDatabasenm((String) m.get("code"));

            System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" + m);

        }

        return getdata;
    }
}
