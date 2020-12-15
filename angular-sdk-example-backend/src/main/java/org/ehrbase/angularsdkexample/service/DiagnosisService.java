package org.ehrbase.angularsdkexample.service;

import org.ehrbase.client.openehrclient.VersionUid;
import org.ehrbase.client.openehrclient.defaultrestclient.DefaultRestClient;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.DiagnoseComposition;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.PatientDetailComposition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return client.ehrEndpoint().createEhr();
    }

    public VersionUid saveDiagnosis(UUID ehrId, DiagnoseComposition composition) {
        client.compositionEndpoint(ehrId).mergeCompositionEntity(composition);
        return composition.getVersionUid();
    }

    public Optional<DiagnoseComposition> getAssessment(UUID ehrId, VersionUid versionUid) {
        return client.compositionEndpoint(ehrId).find(versionUid.getUuid(), DiagnoseComposition.class);
    }

    public VersionUid savePatients(UUID ehrId, PatientDetailComposition patient) {
        client.compositionEndpoint(ehrId).mergeCompositionEntity(patient);
        return patient.getVersionUid();
    }

    public Optional<PatientDetailComposition> getPatient(UUID ehrId, VersionUid versionUid) {
        return client.compositionEndpoint(ehrId).find(versionUid.getUuid(), PatientDetailComposition.class);
    }
}
