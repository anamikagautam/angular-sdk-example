package org.ehrbase.angularsdkexample.controller;

import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.angularsdkexample.service.DiagnosisService;
import org.ehrbase.angularsdkexample.service.ExampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Optional;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class DiagnosisController {

    private final DiagnosisService service;
    private final ExampleService example;

    @Autowired
    public DiagnosisController(DiagnosisService service, ExampleService example) {
        this.service = service;
        this.example = example;
    }

    @PostMapping(path = "/ehr")
    public ResponseEntity<Map<String, UUID>> postEhr() {
        UUID ehrId = service.createEhr();
        return ResponseEntity.ok(Collections.singletonMap("ehr_id", ehrId));
    }

    @PostMapping(path = "/{ehr_id}/diagnosis")
    public void postDiagnosis(
            @PathVariable(value = "ehr_id") UUID ehrId,
            @RequestBody DiagnoseComposition body) {
                try {
            FileWriter myWriter = new FileWriter("ehrid_versionid.txt");
            for(int i=0;i<1000;i++){
            UUID new_ehrid=service.createEhr();
        VersionUid versionUid = service.saveDiagnosis(new_ehrid, body);
        System.out.println(new_ehrid+"    "+versionUid+"   "+i+"\n");
            myWriter.write(new_ehrid+"    "+versionUid+"\n");
        }
        myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
        
        //return ResponseEntity.ok(versionUid);
    }

    @GetMapping(path = "/{ehr_id}/diagnosis/{id}")
    public ResponseEntity<DiagnoseComposition> getAssessment(
            @PathVariable(value = "ehr_id") UUID ehrId,
            @PathVariable(value = "id") VersionUid id) {
        Optional<DiagnoseComposition> composition = service.getAssessment(ehrId, id);

        return composition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // EXAMPLE section

    @GetMapping(path = "/example/diagnosis")
    public ResponseEntity<DiagnoseComposition> getExample() {
        return ResponseEntity.of(example.createExample());
    }
}
