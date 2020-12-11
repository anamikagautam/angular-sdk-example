package org.ehrbase.angularsdkexample.opt.diagnosecomposition;

import org.ehrbase.angularsdkexample.opt.shareddefinition.CategoryDefiningcode;
import org.ehrbase.angularsdkexample.opt.shareddefinition.Language;
import org.ehrbase.angularsdkexample.opt.shareddefinition.SettingDefiningcode;
import org.ehrbase.angularsdkexample.opt.shareddefinition.Territory;
import com.nedap.archie.rm.archetyped.Archetyped;
import com.nedap.archie.rm.archetyped.FeederAudit;
import com.nedap.archie.rm.generic.Participation;
import com.nedap.archie.rm.generic.PartyIdentified;
import com.nedap.archie.rm.generic.PartyProxy;
import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class N100CompositionContainment extends Containment {
  public SelectAqlField<N100Composition> N100_COMPOSITION = new AqlFieldImp<N100Composition>(N100Composition.class, "", "N100Composition", N100Composition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(N100Composition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(N100Composition.class, "/context[at0002]/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(N100Composition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(N100Composition.class, "/context[at0002]/location", "location", String.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(N100Composition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTHCAREFACILITY = new AqlFieldImp<PartyIdentified>(N100Composition.class, "/context/health_care_facility", "healthcarefacility", PartyIdentified.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(N100Composition.class, "/context[at0002]/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<Double> PATIENT_AGE_MAGNITUDE = new AqlFieldImp<Double>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0012]/value|magnitude", "patientAgeMagnitude", Double.class, this);

  public SelectAqlField<String> PATIENT_AGE_UNITS = new AqlFieldImp<String>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0012]/value|units", "patientAgeUnits", String.class, this);

  public SelectAqlField<Double> PATIENT_WEIGHT_MAGNITUDE = new AqlFieldImp<Double>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0013]/value|magnitude", "patientWeightMagnitude", Double.class, this);

  public SelectAqlField<String> PATIENT_WEIGHT_UNITS = new AqlFieldImp<String>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0013]/value|units", "patientWeightUnits", String.class, this);

  public SelectAqlField<Double> PATIENT_HEIGHT_MAGNITUDE = new AqlFieldImp<Double>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0014]/value|magnitude", "patientHeightMagnitude", Double.class, this);

  public SelectAqlField<String> PATIENT_HEIGHT_UNITS = new AqlFieldImp<String>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0014]/value|units", "patientHeightUnits", String.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(N100Composition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<String> PATIENT_NAME_VALUE = new AqlFieldImp<String>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0006]/value|value", "patientNameValue", String.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE_EVENT_CONTEXT = new AqlFieldImp<TemporalAccessor>(N100Composition.class, "/context[at0002]/end_time|value", "endTimeValueEventContext", TemporalAccessor.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE_START_TIME = new AqlFieldImp<TemporalAccessor>(N100Composition.class, "/context/start_time|value", "startTimeValueStartTime", TemporalAccessor.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(N100Composition.class, "/context[at0002]/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public ListSelectAqlField<Archetyped> PATIENT_DETAILS = new ListAqlFieldImp<Archetyped>(N100Composition.class, "/archetype_details[at0005]", "patientDetails", Archetyped.class, this);

  public SelectAqlField<String> PATIENT_ADDRESS_VALUE = new AqlFieldImp<String>(N100Composition.class, "/context[at0002]/other_context[at0003]/items[at0016]/value|value", "patientAddressValue", String.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(N100Composition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE_SETTING = new AqlFieldImp<SettingDefiningcode>(N100Composition.class, "/context/setting|defining_code", "settingDefiningcodeSetting", SettingDefiningcode.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(N100Composition.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS_EVENT_CONTEXT = new ListAqlFieldImp<Participation>(N100Composition.class, "/context[at0002]/participations", "participationsEventContext", Participation.class, this);

  public SelectAqlField<String> LOCATION_LOCATION = new AqlFieldImp<String>(N100Composition.class, "/context/location", "locationLocation", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(N100Composition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  private N100CompositionContainment() {
    super("openEHR-EHR-COMPOSITION.patient_document.v1");
  }

  public static N100CompositionContainment getInstance() {
    return new N100CompositionContainment();
  }
}
