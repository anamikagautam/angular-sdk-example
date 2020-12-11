package org.ehrbase.angularsdkexample.opt.diagnosecomposition;

import java.time.temporal.TemporalAccessor;
import java.util.List;

import com.nedap.archie.rm.archetyped.Archetyped;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;

import org.ehrbase.angularsdkexample.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.angularsdkexample.opt.shareddefinition.Language;
import org.ehrbase.angularsdkexample.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.angularsdkexample.opt.shareddefinition.Territory;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Id;
import org.ehrbase.client.annotations.Path;
import org.ehrbase.client.annotations.Template;
import org.ehrbase.client.openehrclient.VersionUid;

@Entity
@Archetype("openEHR-EHR-COMPOSITION.patient_document.v1")
@Template("100")
public class N100Composition {
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

  @Path("/context[at0002]/other_context[at0003]/items[at0012]/value|magnitude")
  private Double patientAgeMagnitude;

  @Path("/context[at0002]/other_context[at0003]/items[at0012]/value|units")
  private String patientAgeUnits;

  @Path("/context[at0002]/other_context[at0003]/items[at0013]/value|magnitude")
  private Double patientWeightMagnitude;

  @Path("/context[at0002]/other_context[at0003]/items[at0013]/value|units")
  private String patientWeightUnits;

  @Path("/context[at0002]/other_context[at0003]/items[at0014]/value|magnitude")
  private Double patientHeightMagnitude;

  @Path("/context[at0002]/other_context[at0003]/items[at0014]/value|units")
  private String patientHeightUnits;

  @Path("/territory")
  private Territory territory;

  @Path("/context[at0002]/other_context[at0003]/items[at0006]/value|value")
  private String patientNameValue;

  @Path("/context[at0002]/end_time|value")
  private TemporalAccessor endTimeValueEventContext;

  @Path("/context/start_time|value")
  private TemporalAccessor startTimeValueStartTime;

  @Path("/context[at0002]/setting|defining_code")
  private SettingDefiningcode settingDefiningcode;

  @Path("/archetype_details[at0005]")
  private List<Archetyped> patientDetails;

  @Path("/context[at0002]/other_context[at0003]/items[at0016]/value|value")
  private String patientAddressValue;

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

  public N100Composition(){
      
  }

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

  public void setLanguage(Language language) {
     this.language = language;
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

  public void setPatientAgeMagnitude(Double patientAgeMagnitude) {
     this.patientAgeMagnitude = patientAgeMagnitude;
  }

  public Double getPatientAgeMagnitude() {
     return this.patientAgeMagnitude ;
  }

  public void setPatientAgeUnits(String patientAgeUnits) {
     this.patientAgeUnits = patientAgeUnits;
  }

  public String getPatientAgeUnits() {
     return this.patientAgeUnits ;
  }

  public void setPatientWeightMagnitude(Double patientWeightMagnitude) {
     this.patientWeightMagnitude = patientWeightMagnitude;
  }

  public Double getPatientWeightMagnitude() {
     return this.patientWeightMagnitude ;
  }

  public void setPatientWeightUnits(String patientWeightUnits) {
     this.patientWeightUnits = patientWeightUnits;
  }

  public String getPatientWeightUnits() {
     return this.patientWeightUnits ;
  }

  public void setPatientHeightMagnitude(Double patientHeightMagnitude) {
     this.patientHeightMagnitude = patientHeightMagnitude;
  }

  public Double getPatientHeightMagnitude() {
     return this.patientHeightMagnitude ;
  }

  public void setPatientHeightUnits(String patientHeightUnits) {
     this.patientHeightUnits = patientHeightUnits;
  }

  public String getPatientHeightUnits() {
     return this.patientHeightUnits ;
  }

  public void setTerritory(Territory territory) {
     this.territory = territory;
  }

  public Territory getTerritory() {
     return this.territory ;
  }

  public void setPatientNameValue(String patientNameValue) {
     this.patientNameValue = patientNameValue;
  }

  public String getPatientNameValue() {
     return this.patientNameValue ;
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

  public void setSettingDefiningcode(SettingDefiningcode settingDefiningcode) {
     this.settingDefiningcode = settingDefiningcode;
  }

  public SettingDefiningcode getSettingDefiningcode() {
     return this.settingDefiningcode ;
  }

  public void setPatientDetails(List<Archetyped> patientDetails) {
     this.patientDetails = patientDetails;
  }

  public List<Archetyped> getPatientDetails() {
     return this.patientDetails ;
  }

  public void setPatientAddressValue(String patientAddressValue) {
     this.patientAddressValue = patientAddressValue;
  }

  public String getPatientAddressValue() {
     return this.patientAddressValue ;
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

  public void setCategoryDefiningcode(CategoryDefiningcode categoryDefiningcode) {
     this.categoryDefiningcode = categoryDefiningcode;
  }

  public CategoryDefiningcode getCategoryDefiningcode() {
     return this.categoryDefiningcode ;
  }
}
