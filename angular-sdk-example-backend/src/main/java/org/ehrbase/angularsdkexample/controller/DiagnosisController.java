package org.ehrbase.angularsdkexample.controller;

import java.io.FileReader;
import java.util.Collections;
import java.util.Date;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.tomcat.util.json.JSONParser;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.PatientDetailComposition;
import org.ehrbase.angularsdkexample.service.DiagnosisService;
import org.ehrbase.angularsdkexample.service.ExampleService;
import org.ehrbase.angularsdkexample.service.PatientPopulate;
import org.ehrbase.client.openehrclient.VersionUid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

@RestController
@RequestMapping(path = "/api")
@CrossOrigin(origins = "*")
public class DiagnosisController {
    private final DiagnosisService service;
    private final ExampleService example;
    private final PatientPopulate patientPopulate;

    @Autowired
    public DiagnosisController(DiagnosisService service, ExampleService example, PatientPopulate patientPopulate) {
        this.service = service;
        this.example = example;
        this.patientPopulate = patientPopulate;
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

    @GetMapping(path = "/example/patients")
    public ResponseEntity<PatientDetailComposition> getPatient() {
        return ResponseEntity.of(Optional.of(patientPopulate.createPatient()));
    }

    @GetMapping(path = "/patients")
    public ResponseEntity<String> postPatients() {
        UUID uuid = UUID.randomUUID();
        String stringUuid = uuid.toString();
        
         DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ"); 
         String string1 = "2001-07-04T12:08:56.235-0700"; 
         Date result1 = new Date();
         try {
             result1 = df1.parse(string1);
         } catch (java.text.ParseException e1) {
             // TODO Auto-generated catch block
             e1.printStackTrace();
         }
     
        try {
            String content = FileUtils.readFileToString(new File(
                    "/workspace/angular-sdk-example/angular-sdk-example-backend/src/main/java/org/ehrbase/angularsdkexample/controller/jsonfileupload.json"),
                    "UTF-8");
                  //  content.get("versions");

            content = content.replaceAll("anamika", UUID.randomUUID().toString());
            content = content.replaceAll("apnatimeaega", result1.toString());
             File tempFile = new File("/workspace/angular-sdk-example/OutputFile.json");
             FileUtils.writeStringToFile(tempFile, content, "UTF-8");
            System.out.println(tempFile);
        } catch (IOException e) {
            // Simple exception handling, replace with what's necessary for your use case!
            throw new RuntimeException("Generating file failed", e);
        }
        
        UUID ehrId = service.createEhr();
        String stringehrId = ehrId.toString();
        // VersionUid versionUid = service.savePatients(ehrId,
        // patientPopulate.createPatient());
        // return ResponseEntity.ok(versionUid);

        System.out.println(ehrId);
       // String command = "curl -X POST --header 'Content-Type:application/x-www-form-urlencoded' --header 'Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluQGNhYm9sYWJzLmNvbSIsImV4dHJhZGF0YSI6eyJvcmdfdWlkIjoiZTlkMTMyOTQtYmNlNy00NGU3LTk2MzUtOGU5MDZkYTBjOTE0In0sImlzc3VlZF9hdCI6IjIwMjAtMTItMTdUMTE6NDQ6MTIuMTcxWiIsImV4cGlyZXNfYXQiOiIyMDIwLTEyLTE4VDExOjQ0OjEyLjE3MVoifQ.EYz6P0BPdZqY_Min5R8sFkQsOwVVAElurX80bAif1_I' --data @ehr_new.json http://35.198.226.194:8090/rest/v1/ehrs";
       // String command1 = "curl -X POST --header 'Content-Type:application/json' --header 'Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluQGNhYm9sYWJzLmNvbSIsImV4dHJhZGF0YSI6eyJvcmdfdWlkIjoiZTlkMTMyOTQtYmNlNy00NGU3LTk2MzUtOGU5MDZkYTBjOTE0In0sImlzc3VlZF9hdCI6IjIwMjAtMTItMTdUMTE6NDQ6MTIuMTcxWiIsImV4cGlyZXNfYXQiOiIyMDIwLTEyLTE4VDExOjQ0OjEyLjE3MVoifQ.EYz6P0BPdZqY_Min5R8sFkQsOwVVAElurX80bAif1_I' --data @'/workspace/angular-sdk-example/angular-sdk-example-backend/OutputFile' http://35.198.226.194:8090/rest/v1/ehrs/";
       // String command2 = "1d1d4428-c475-4158-a1df-a69781c81c0c";
       // String command3 = "/compositions?auditCommitter=Sumit%20House,%20MD.";
       // String command = command1+command2+command3;
       Path path = Paths.get("/workspace/angular-sdk-example/OutputFile.json");
       String s = "#!/bin/sh \n";
       String c1 = "curl -X POST --header 'Content-Type:application/json' ";
       String url = " http://35.198.226.194:8090/rest/v1/ehrs/1d1d4428-c475-4158-a1df-a69781c81c0c/compositions?auditCommitter=Sumit%20House,%20MD.";
       String c2 = "--header 'Authorization:Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImFkbWluQGNhYm9sYWJzLmNvbSIsImV4dHJhZGF0YSI6eyJvcmdfdWlkIjoiZTlkMTMyOTQtYmNlNy00NGU3LTk2MzUtOGU5MDZkYTBjOTE0In0sImlzc3VlZF9hdCI6IjIwMjAtMTItMjFUMTA6Mzg6MTYuNTc0WiIsImV4cGlyZXNfYXQiOiIyMDIwLTEyLTIyVDEwOjM4OjE2LjU3NVoifQ.01rMbHq1y998HEUK_oUr4XN6U9oomLFUdBkhn1oPXWM' --data @"+path+url;
        String command = s+c1+c2;
        File tempFile1 = new File("/workspace/angular-sdk-example/file.sh");
             try {
            FileUtils.writeStringToFile(tempFile1, command);
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        System.out.println(command);
      //  ProcessBuilder process = new ProcessBuilder(command);
       try
        {
            Process p2 = Runtime.getRuntime().exec("chmod 777 /workspace/angular-sdk-example/file.sh");
           Process p = Runtime.getRuntime().exec("/workspace/angular-sdk-example/file.sh");
           p.getInputStream();
           System.out.print(p.exitValue());
           System.out.print("hello");
            /* BufferedReader reader =  new BufferedReader(new InputStreamReader(p.getInputStream()));
                StringBuilder builder = new StringBuilder();
                String line = null;
                while ( (line = reader.readLine()) != null) {
                        builder.append(line);
                        builder.append(System.getProperty("line.separator"));
                }
                String result = builder.toString();
                System.out.print(result);
*/
        }
        catch (IOException e)
        {   System.out.print("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok("Success");
    }

    @GetMapping(path = "/{ehr_id}/patients/{id}")
    public ResponseEntity<PatientDetailComposition> getPatient(@PathVariable(value = "ehr_id") UUID ehrId,
            @PathVariable(value = "id") VersionUid id) {
        Optional<PatientDetailComposition> patient = service.getPatient(ehrId, id);

        return patient.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

}
