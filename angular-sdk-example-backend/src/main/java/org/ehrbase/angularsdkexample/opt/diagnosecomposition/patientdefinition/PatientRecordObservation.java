package org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientdefinition;

import org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientshareddefinition.Language;
import com.nedap.archie.rm.generic.PartyProxy;
import java.time.temporal.TemporalAccessor;
import java.util.List;
import org.ehrbase.client.annotations.Archetype;
import org.ehrbase.client.annotations.Choice;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.Path;

@Entity
@Archetype("openEHR-EHR-OBSERVATION.patient_record.v1")
public class PatientRecordObservation {
  @Path("/subject")
  private PartyProxy subject;

  @Path("/data[at0001]/origin|value")
  private TemporalAccessor originValue;

  @Path("/data[at0001]/events[at0002]")
  @Choice
  private List<PatientRecordAnyEventChoice> anyEvent;

  @Path("/language")
  private Language language;

  public void setSubject(PartyProxy subject) {
     this.subject = subject;
  }

  public PartyProxy getSubject() {
     return this.subject ;
  }

  public void setOriginValue(TemporalAccessor originValue) {
     this.originValue = originValue;
  }

  public TemporalAccessor getOriginValue() {
     return this.originValue ;
  }

  public void setAnyEvent(List<PatientRecordAnyEventChoice> anyEvent) {
     this.anyEvent = anyEvent;
  }

  public List<PatientRecordAnyEventChoice> getAnyEvent() {
     return this.anyEvent ;
  }

  public void setLanguage(Language language) {
     this.language = language;
  }

  public Language getLanguage() {
     return this.language ;
  }
}
