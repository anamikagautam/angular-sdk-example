package org.ehrbase.angularsdkexample.service;

import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.DiagnoseComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileWriter;
import java.io.IOException; 
import java.util.Optional;
import java.util.UUID;

@Service
public class DiagnosisService {

    private final DefaultRestClient client;

    @Autowired
    public DiagnosisService(DefaultRestClient client) {
        this.client = client;
    }

    public UUID createEhr() {
        /*try {
            FileWriter myWriter = new FileWriter("filename.txt");
            for (int i=0;i<100000;i++){
            String ehrid = (client.ehrEndpoint().createEhr()).toString();
            myWriter.write(ehrid+"\n");
        }
        myWriter.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }*/
        
        return client.ehrEndpoint().createEhr();
    }

    public VersionUid saveDiagnosis(UUID ehrId, DiagnoseComposition composition) {
        client.compositionEndpoint(ehrId).mergeCompositionEntity(composition);
        return composition.getVersionUid();
    }

    public Optional<DiagnoseComposition> getAssessment(UUID ehrId, VersionUid versionUid) {
        return client.compositionEndpoint(ehrId).find(versionUid.getUuid(), DiagnoseComposition.class);
    }
}
