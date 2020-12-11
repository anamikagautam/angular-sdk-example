package org.ehrbase.angularsdkexample.controller;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.ehrbase.angularsdkexample.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.N100Composition;
import org.ehrbase.angularsdkexample.service.DiagnosisService;
import org.ehrbase.angularsdkexample.service.ExampleService;
import org.ehrbase.client.openehrclient.VersionUid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class DiagnosisController {
    private final DiagnosisService service;
    private final ExampleService example;

    // private final N100Composition patientComposition;

    @Autowired
    public DiagnosisController(DiagnosisService service, ExampleService example) {
        this.service = service;
        this.example = example;
        // this.patientComposition = patientComposition;
    }

    @PostMapping(path = "/ehr")
    public ResponseEntity<Map<String, UUID>> postEhr() {
        UUID ehrId = service.createEhr();
        return ResponseEntity.ok(Collections.singletonMap("ehr_id", ehrId));
    }

    @PostMapping(path = "/{ehr_id}/diagnosis")
    public ResponseEntity<VersionUid> postDiagnosis(@PathVariable(value = "ehr_id") UUID ehrId,
            @RequestBody DiagnoseComposition body) {
        VersionUid versionUid = service.saveDiagnosis(ehrId, body);
        return ResponseEntity.ok(versionUid);
    }

    @GetMapping(path = "/{ehr_id}/diagnosis/{id}")
    public ResponseEntity<DiagnoseComposition> getAssessment(@PathVariable(value = "ehr_id") UUID ehrId,
            @PathVariable(value = "id") VersionUid id) {
        Optional<DiagnoseComposition> composition = service.getAssessment(ehrId, id);

        return composition.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // EXAMPLE section

    @GetMapping(path = "/example/diagnosis")
    public ResponseEntity<DiagnoseComposition> getExample() {
        return ResponseEntity.of(example.createExample());
    }

    @PostMapping(path = "/{ehr_id}/patients")
    public ResponseEntity<VersionUid> postPatients(@PathVariable(value = "ehr_id") UUID ehrId) {
        N100Composition patient = new N100Composition();
        patient.setPatientWeightUnits("patientWeightUnits");
        patient.setPatientNameValue("patientNameValue");
        VersionUid versionUid = service.savePatients(ehrId, patient);
        return ResponseEntity.ok(versionUid);
    }

    @GetMapping(path = "/{ehr_id}/patients/{id}")
    public ResponseEntity<N100Composition> getPatient(@PathVariable(value = "ehr_id") UUID ehrId,
            @PathVariable(value = "id") VersionUid id) {
        Optional<N100Composition> patient = service.getPatient(ehrId, id);

        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
