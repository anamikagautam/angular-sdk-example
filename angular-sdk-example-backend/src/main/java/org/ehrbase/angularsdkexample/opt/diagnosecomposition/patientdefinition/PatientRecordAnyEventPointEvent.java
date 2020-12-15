package org.ehrbase.angularsdkexample.opt.diagnosecomposition.patientdefinition;

import java.lang.Double;
import java.lang.String;
import java.time.temporal.TemporalAccessor;
import org.ehrbase.client.annotations.Entity;
import org.ehrbase.client.annotations.OptionFor;
import org.ehrbase.client.annotations.Path;

@Entity
@OptionFor("POINT_EVENT")
public class PatientRecordAnyEventPointEvent implements PatientRecordAnyEventChoice {
  @Path("/time|value")
  private TemporalAccessor timeValue;

  @Path("/data[at0003]/items[at0007]/value|magnitude")
  private Double weightMagnitude;

  @Path("/data[at0003]/items[at0007]/value|units")
  private String weightUnits;

  @Path("/data[at0003]/items[at0006]/value|value")
  private String patientNameValue;

  public void setTimeValue(TemporalAccessor timeValue) {
     this.timeValue = timeValue;
  }

  public TemporalAccessor getTimeValue() {
     return this.timeValue ;
  }

  public void setWeightMagnitude(Double weightMagnitude) {
     this.weightMagnitude = weightMagnitude;
  }

  public Double getWeightMagnitude() {
     return this.weightMagnitude ;
  }

  public void setWeightUnits(String weightUnits) {
     this.weightUnits = weightUnits;
  }

  public String getWeightUnits() {
     return this.weightUnits ;
  }

  public void setPatientNameValue(String patientNameValue) {
     this.patientNameValue = patientNameValue;
  }

  public String getPatientNameValue() {
     return this.patientNameValue ;
  }
}
