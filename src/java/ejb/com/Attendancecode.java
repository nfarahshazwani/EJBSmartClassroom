/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.com;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "attendancecode")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Attendancecode.findAll", query = "SELECT a FROM Attendancecode a")
    , @NamedQuery(name = "Attendancecode.findByCodeID", query = "SELECT a FROM Attendancecode a WHERE a.codeID = :codeID")
    , @NamedQuery(name = "Attendancecode.findByCode", query = "SELECT a FROM Attendancecode a WHERE a.code = :code")
    , @NamedQuery(name = "Attendancecode.findByCodeDate", query = "SELECT a FROM Attendancecode a WHERE a.codeDate = :codeDate")})
public class Attendancecode implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeID")
    private Integer codeID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codeDate")
    private int codeDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codeID")
    private Collection<Attendance> attendanceCollection;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course courseID;

    public Attendancecode() {
    }

    public Attendancecode(Integer codeID) {
        this.codeID = codeID;
    }

    public Attendancecode(Integer codeID, String code, int codeDate) {
        this.codeID = codeID;
        this.code = code;
        this.codeDate = codeDate;
    }

    public Integer getCodeID() {
        return codeID;
    }

    public void setCodeID(Integer codeID) {
        this.codeID = codeID;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getCodeDate() {
        return codeDate;
    }

    public void setCodeDate(int codeDate) {
        this.codeDate = codeDate;
    }

    @XmlTransient
    public Collection<Attendance> getAttendanceCollection() {
        return attendanceCollection;
    }

    public void setAttendanceCollection(Collection<Attendance> attendanceCollection) {
        this.attendanceCollection = attendanceCollection;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codeID != null ? codeID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Attendancecode)) {
            return false;
        }
        Attendancecode other = (Attendancecode) object;
        if ((this.codeID == null && other.codeID != null) || (this.codeID != null && !this.codeID.equals(other.codeID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.Attendancecode[ codeID=" + codeID + " ]";
    }
    
}
