/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "attendance")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendance.findAll", query = "SELECT a FROM Attendance a")
    , @NamedQuery(name = "Attendance.findByAttendanceID", query = "SELECT a FROM Attendance a WHERE a.attendanceID = :attendanceID")
    , @NamedQuery(name = "Attendance.findByAttendanceStatus", query = "SELECT a FROM Attendance a WHERE a.attendanceStatus = :attendanceStatus")})
public class Attendance implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "attendanceID")
    private Integer attendanceID;
    @Basic(optional = false)
    @NotNull
    @Column(name = "attendanceStatus")
    private int attendanceStatus;
    @JoinColumn(name = "codeID", referencedColumnName = "codeID")
    @ManyToOne(optional = false)
    private Attendancecode codeID;
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    @ManyToOne(optional = false)
    private Student studentID;

    public Attendance() {
    }

    public Attendance(Integer attendanceID) {
        this.attendanceID = attendanceID;
    }

    public Attendance(Integer attendanceID, int attendanceStatus) {
        this.attendanceID = attendanceID;
        this.attendanceStatus = attendanceStatus;
    }

    public Integer getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(Integer attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getAttendanceStatus() {
        return attendanceStatus;
    }

    public void setAttendanceStatus(int attendanceStatus) {
        this.attendanceStatus = attendanceStatus;
    }

    public Attendancecode getCodeID() {
        return codeID;
    }

    public void setCodeID(Attendancecode codeID) {
        this.codeID = codeID;
    }

    public Student getStudentID() {
        return studentID;
    }

    public void setStudentID(Student studentID) {
        this.studentID = studentID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (attendanceID != null ? attendanceID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendance)) {
            return false;
        }
        Attendance other = (Attendance) object;
        if ((this.attendanceID == null && other.attendanceID != null) || (this.attendanceID != null && !this.attendanceID.equals(other.attendanceID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.Attendance[ attendanceID=" + attendanceID + " ]";
    }
    
}
