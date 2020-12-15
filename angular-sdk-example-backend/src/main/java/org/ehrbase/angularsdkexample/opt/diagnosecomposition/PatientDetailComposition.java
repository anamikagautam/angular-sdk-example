package org.ehrbase.angularsdkexample.opt.diagnosecomposition;

import org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientdefinition.PatientRecordObservation;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientshareddefinition.CategoryDefiningcode;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientshareddefinition.Language;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientshareddefinition.SettingDefiningcode;
import org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientshareddefinition.Territory;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Id;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.annotations.Template;
import org.ehrbase.client.openehrclient.VersionUid;

@Entity
@Archetype("openEHR-EHR-COMPOSITION.patient_document.v1")
@Template("patient_detail")
public class PatientDetailComposition {
  @Id
  private VersionUid versionUid;

  @Path("/context/end_time|value")
  private TemporalAccessor endTimeValue;

  @Path("/context[at0002]/health_care_facility")
  private PartyIdentified healthCareFacility;

  @Path("/context/participations")
  private List<Participation> participations;

  @Path("/context[at0002]/location")
  private String location;

  @Path("/language")
  private Language language;

  @Path("/context/health_care_facility")
  private PartyIdentified healthcarefacility;

  @Path("/context[at0002]/start_time|value")
  private TemporalAccessor startTimeValue;

  @Path("/territory")
  private Territory territory;

  @Path("/context[at0002]/other_context[at0003]/items[at0006]/value|magnitude")
  private Double heightMagnitude;

  @Path("/context[at0002]/other_context[at0003]/items[at0006]/value|units")
  private String heightUnits;

  @Path("/context[at0002]/end_time|value")
  private TemporalAccessor endTimeValueEventContext;

  @Path("/context/start_time|value")
  private TemporalAccessor startTimeValueStartTime;

  @Path("/context[at0002]/setting|defining_code")
  private SettingDefiningcode settingDefiningcode;

  @Path("/content[openEHR-EHR-OBSERVATION.patient_record.v1]")
  private PatientRecordObservation patientRecord;

  @Path("/composer")
  private PartyProxy composer;

  @Path("/context/setting|defining_code")
  private SettingDefiningcode settingDefiningcodeSetting;

  @Path("/feeder_audit")
  private FeederAudit feederAudit;

  @Path("/context[at0002]/participations")
  private List<Participation> participationsEventContext;

  @Path("/context/location")
  private String locationLocation;

  @Path("/category|defining_code")
  private CategoryDefiningcode categoryDefiningcode;

  public VersionUid getVersionUid() {
     return this.versionUid ;
  }

  public void setVersionUid(VersionUid versionUid) {
     this.versionUid = versionUid;
  }

  public void setEndTimeValue(TemporalAccessor endTimeValue) {
     this.endTimeValue = endTimeValue;
  }

  public TemporalAccessor getEndTimeValue() {
     return this.endTimeValue ;
  }

  public void setHealthCareFacility(PartyIdentified healthCareFacility) {
     this.healthCareFacility = healthCareFacility;
  }

  public PartyIdentified getHealthCareFacility() {
     return this.healthCareFacility ;
  }

  public void setParticipations(List<Participation> participations) {
     this.participations = participations;
  }

  public List<Participation> getParticipations() {
     return this.participations ;
  }

  public void setLocation(String location) {
     this.location = location;
  }

  public String getLocation() {
     return this.location ;
  }

  public void setLanguage(Language de) {
     this.language = de;
  }

  public Language getLanguage() {
     return this.language ;
  }

  public void setHealthcarefacility(PartyIdentified healthcarefacility) {
     this.healthcarefacility = healthcarefacility;
  }

  public PartyIdentified getHealthcarefacility() {
     return this.healthcarefacility ;
  }

  public void setStartTimeValue(TemporalAccessor startTimeValue) {
     this.startTimeValue = startTimeValue;
  }

  public TemporalAccessor getStartTimeValue() {
     return this.startTimeValue ;
  }

  public void setTerritory(Territory de) {
     this.territory = de;
  }

  public Territory getTerritory() {
     return this.territory ;
  }

  public void setHeightMagnitude(Double heightMagnitude) {
     this.heightMagnitude = heightMagnitude;
  }

  public Double getHeightMagnitude() {
     return this.heightMagnitude ;
  }

  public void setHeightUnits(String heightUnits) {
     this.heightUnits = heightUnits;
  }

  public String getHeightUnits() {
     return this.heightUnits ;
  }

  public void setEndTimeValueEventContext(TemporalAccessor endTimeValueEventContext) {
     this.endTimeValueEventContext = endTimeValueEventContext;
  }

  public TemporalAccessor getEndTimeValueEventContext() {
     return this.endTimeValueEventContext ;
  }

  public void setStartTimeValueStartTime(TemporalAccessor startTimeValueStartTime) {
     this.startTimeValueStartTime = startTimeValueStartTime;
  }

  public TemporalAccessor getStartTimeValueStartTime() {
     return this.startTimeValueStartTime ;
  }

  public void setSettingDefiningcode(SettingDefiningcode emergencyCare) {
     this.settingDefiningcode = emergencyCare;
  }

  public SettingDefiningcode getSettingDefiningcode() {
     return this.settingDefiningcode ;
  }

  public void setPatientRecord(PatientRecordObservation patientRecord) {
     this.patientRecord = patientRecord;
  }

  public PatientRecordObservation getPatientRecord() {
     return this.patientRecord ;
  }

  public void setComposer(PartyProxy composer) {
     this.composer = composer;
  }

  public PartyProxy getComposer() {
     return this.composer ;
  }

  public void setSettingDefiningcodeSetting(SettingDefiningcode settingDefiningcodeSetting) {
     this.settingDefiningcodeSetting = settingDefiningcodeSetting;
  }

  public SettingDefiningcode getSettingDefiningcodeSetting() {
     return this.settingDefiningcodeSetting ;
  }

  public void setFeederAudit(FeederAudit feederAudit) {
     this.feederAudit = feederAudit;
  }

  public FeederAudit getFeederAudit() {
     return this.feederAudit ;
  }

  public void setParticipationsEventContext(List<Participation> participationsEventContext) {
     this.participationsEventContext = participationsEventContext;
  }

  public List<Participation> getParticipationsEventContext() {
     return this.participationsEventContext ;
  }

  public void setLocationLocation(String locationLocation) {
     this.locationLocation = locationLocation;
  }

  public String getLocationLocation() {
     return this.locationLocation ;
  }

  public void setCategoryDefiningcode(CategoryDefiningcode event) {
     this.categoryDefiningcode = event;
  }

  public CategoryDefiningcode getCategoryDefiningcode() {
     return this.categoryDefiningcode ;
  }

public void setBerichtIdValue(String string) {
}
}
