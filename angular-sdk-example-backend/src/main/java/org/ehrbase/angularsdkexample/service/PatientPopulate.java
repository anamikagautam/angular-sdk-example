package org.ehrbase.angularsdkexample.service;

import org.ehrbase.angularsdkexample.opt.diagnosecomposition.PatientDetailComposition;
import org.ehrbase.angularsdkexample.opt.patientshareddefinition.CategoryDefiningcode;
import org.ehrbase.angularsdkexample.opt.patientshareddefinition.Language;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class PatientPopulate {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    public Optional<PatientDetailComposition> createPatient() {

        logger.info("Creating 'Patient' example");

        PatientDetailComposition patient = new PatientDetailComposition();
        patient.setStartTimeValue(OffsetDateTime.of(2020, 04, 02, 12, 00, 00, 00, ZoneOffset.UTC));
        patient.setEndTimeValue(OffsetDateTime.of(2020, 04, 02, 13, 00, 00, 00, ZoneOffset.UTC));
        patient.setHealthCareFacility(null);
        patient.setParticipations(null);
        patient.setLocation("Gorakhpur");
        patient.setLanguage(Language.EN);
        patient.setHealthcarefacility(null);
        patient.setTerritory(null);
        patient.setHeightMagnitude(22.0);
        patient.setHeightUnits("145cm");
        patient.setEndTimeValueEventContext(null);
        patient.setStartTimeValueStartTime(null);
        patient.setSettingDefiningcode(null);
        patient.setPatientRecord(null);
        patient.setComposer(null);
        patient.setSettingDefiningcodeSetting(null);
        patient.setFeederAudit(null);
        patient.setParticipationsEventContext(null);
        patient.setLocationLocation(null);

        CategoryDefiningcode categoryDefiningcode = new CategoryDefiningcode("value","description","terminologyId","code");
        patient.setCategoryDefiningcode(categoryDefiningcode);

        return Optional.of(patient);
    }
}
