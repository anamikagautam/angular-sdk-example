package .patientdetailcomposition.definition;

import .shareddefinition.Language;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.aql.containment.Containment;
import org.ehrbase.client.aql.field.AqlFieldImp;
import org.ehrbase.client.aql.field.ListAqlFieldImp;
import org.ehrbase.client.aql.field.ListSelectAqlField;
import org.ehrbase.client.aql.field.SelectAqlField;

public class PatientRecordObservationContainment extends Containment {
  public SelectAqlField<PatientRecordObservation> PATIENT_RECORD_OBSERVATION = new AqlFieldImp<PatientRecordObservation>(PatientRecordObservation.class, "", "PatientRecordObservation", PatientRecordObservation.class, this);

  public SelectAqlField<PartyProxy> SUBJECT = new AqlFieldImp<PartyProxy>(PatientRecordObservation.class, "/subject", "subject", PartyProxy.class, this);

  public SelectAqlField<TemporalAccessor> ORIGIN_VALUE = new AqlFieldImp<TemporalAccessor>(PatientRecordObservation.class, "/data[at0001]/origin|value", "originValue", TemporalAccessor.class, this);

  public ListSelectAqlField<PatientRecordAnyEventChoice> ANY_EVENT = new ListAqlFieldImp<PatientRecordAnyEventChoice>(PatientRecordObservation.class, "/data[at0001]/events[at0002]", "anyEvent", PatientRecordAnyEventChoice.class, this);

  public SelectAqlField<Language> LANGUAGE = new AqlFieldImp<Language>(PatientRecordObservation.class, "/language", "language", Language.class, this);

  private PatientRecordObservationContainment() {
    super("openEHR-EHR-OBSERVATION.patient_record.v1");
  }

  public static PatientRecordObservationContainment getInstance() {
    return new PatientRecordObservationContainment();
  }
}
