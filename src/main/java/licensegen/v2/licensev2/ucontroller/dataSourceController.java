package licensegen.v2.licensev2.ucontroller;

import licensegen.v2.licensev2.model.dataSourceDB;
import licensegen.v2.licensev2.service.dataSourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class dataSourceController {

    @Autowired
    private dataSourceService datasourceService;


    @PostMapping("/save")
    public dataSourceDB savedb(@RequestBody dataSourceDB datasavedb){
        return datasourceService.save(datasavedb);
    }

    @GetMapping("/getall")
    public List<dataSourceDB> getall(){
        return datasourceService.datalist();
    }

    @PostMapping("/getbyid/{id}")
    public Optional<dataSourceDB> getbyid(@PathVariable Long id){

        return datasourceService.findById(id);
    }

    @PutMapping("/update/{id}")
    public dataSourceDB update(@RequestBody dataSourceDB databasenm, @PathVariable ("id") Long id){
        return datasourceService.update(databasenm, id);
    }

    @DeleteMapping("/deletebyid/{id}")
    public void deleteData (dataSourceDB id){
        datasourceService.deleteUser(id);
    }

    @GetMapping("/getcon/{id}")
    public dataSourceDB getdatacon(@PathVariable("id") Long id) {
        return datasourceService.getdatacon(id);
    }


}
