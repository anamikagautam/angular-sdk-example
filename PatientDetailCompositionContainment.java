package .patientdetailcomposition;

import .patientdetailcomposition.definition.PatientRecordObservation;
import .shareddefinition.CategoryDefiningcode;
import .shareddefinition.Language;
import .shareddefinition.SettingDefiningcode;
import .shareddefinition.Territory;
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

public class PatientDetailCompositionContainment extends Containment {
  public SelectAqlField<PatientDetailComposition> PATIENT_DETAIL_COMPOSITION = new AqlFieldImp<PatientDetailComposition>(PatientDetailComposition.class, "", "PatientDetailComposition", PatientDetailComposition.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(PatientDetailComposition.class, "/context/end_time|value", "endTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<PartyIdentified> HEALTH_CARE_FACILITY = new AqlFieldImp<PartyIdentified>(PatientDetailComposition.class, "/context[at0002]/health_care_facility", "healthCareFacility", PartyIdentified.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS = new ListAqlFieldImp<Participation>(PatientDetailComposition.class, "/context/participations", "participations", Participation.class, this);

  public SelectAqlField<String> LOCATION = new AqlFieldImp<String>(PatientDetailComposition.class, "/context[at0002]/location", "location", String.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(PatientDetailComposition.class, "/language", "language", Language.class, this);

  public SelectAqlField<PartyIdentified> HEALTHCAREFACILITY = new AqlFieldImp<PartyIdentified>(PatientDetailComposition.class, "/context/health_care_facility", "healthcarefacility", PartyIdentified.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE = new AqlFieldImp<TemporalAccessor>(PatientDetailComposition.class, "/context[at0002]/start_time|value", "startTimeValue", TemporalAccessor.class, this);

  public SelectAqlField<Territory> TERRITORY = new AqlFieldImp<Territory>(PatientDetailComposition.class, "/territory", "territory", Territory.class, this);

  public SelectAqlField<Double> HEIGHT_MAGNITUDE = new AqlFieldImp<Double>(PatientDetailComposition.class, "/context[at0002]/other_context[at0003]/items[at0006]/value|magnitude", "heightMagnitude", Double.class, this);

  public SelectAqlField<String> HEIGHT_UNITS = new AqlFieldImp<String>(PatientDetailComposition.class, "/context[at0002]/other_context[at0003]/items[at0006]/value|units", "heightUnits", String.class, this);

  public SelectAqlField<TemporalAccessor> END_TIME_VALUE_EVENT_CONTEXT = new AqlFieldImp<TemporalAccessor>(PatientDetailComposition.class, "/context[at0002]/end_time|value", "endTimeValueEventContext", TemporalAccessor.class, this);

  public SelectAqlField<TemporalAccessor> START_TIME_VALUE_START_TIME = new AqlFieldImp<TemporalAccessor>(PatientDetailComposition.class, "/context/start_time|value", "startTimeValueStartTime", TemporalAccessor.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE = new AqlFieldImp<SettingDefiningcode>(PatientDetailComposition.class, "/context[at0002]/setting|defining_code", "settingDefiningcode", SettingDefiningcode.class, this);

  public SelectAqlField<PatientRecordObservation> PATIENT_RECORD = new AqlFieldImp<PatientRecordObservation>(PatientDetailComposition.class, "/content[openEHR-EHR-OBSERVATION.patient_record.v1]", "patientRecord", PatientRecordObservation.class, this);

  public SelectAqlField<PartyProxy> COMPOSER = new AqlFieldImp<PartyProxy>(PatientDetailComposition.class, "/composer", "composer", PartyProxy.class, this);

  public SelectAqlField<SettingDefiningcode> SETTING_DEFININGCODE_SETTING = new AqlFieldImp<SettingDefiningcode>(PatientDetailComposition.class, "/context/setting|defining_code", "settingDefiningcodeSetting", SettingDefiningcode.class, this);

  public SelectAqlField<FeederAudit> FEEDER_AUDIT = new AqlFieldImp<FeederAudit>(PatientDetailComposition.class, "/feeder_audit", "feederAudit", FeederAudit.class, this);

  public ListSelectAqlField<Participation> PARTICIPATIONS_EVENT_CONTEXT = new ListAqlFieldImp<Participation>(PatientDetailComposition.class, "/context[at0002]/participations", "participationsEventContext", Participation.class, this);

  public SelectAqlField<String> LOCATION_LOCATION = new AqlFieldImp<String>(PatientDetailComposition.class, "/context/location", "locationLocation", String.class, this);

  public SelectAqlField<CategoryDefiningcode> CATEGORY_DEFININGCODE = new AqlFieldImp<CategoryDefiningcode>(PatientDetailComposition.class, "/category|defining_code", "categoryDefiningcode", CategoryDefiningcode.class, this);

  private PatientDetailCompositionContainment() {
    super("openEHR-EHR-COMPOSITION.patient_document.v1");
  }

  public static PatientDetailCompositionContainment getInstance() {
    return new PatientDetailCompositionContainment();
  }
}
