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
@Table(name = "lecturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lecturer.findAll", query = "SELECT l FROM Lecturer l")
    , @NamedQuery(name = "Lecturer.findByLecturerID", query = "SELECT l FROM Lecturer l WHERE l.lecturerID = :lecturerID")
    , @NamedQuery(name = "Lecturer.findByPassword", query = "SELECT l FROM Lecturer l WHERE l.password = :password")
    , @NamedQuery(name = "Lecturer.findByName", query = "SELECT l FROM Lecturer l WHERE l.name = :name")
    , @NamedQuery(name = "Lecturer.findByICNo", query = "SELECT l FROM Lecturer l WHERE l.iCNo = :iCNo")
    , @NamedQuery(name = "Lecturer.findByEmail", query = "SELECT l FROM Lecturer l WHERE l.email = :email")
    , @NamedQuery(name = "Lecturer.findByPhoneNo", query = "SELECT l FROM Lecturer l WHERE l.phoneNo = :phoneNo")
    , @NamedQuery(name = "Lecturer.findByAddress", query = "SELECT l FROM Lecturer l WHERE l.address = :address")})
public class Lecturer implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "lecturerID")
    private Integer lecturerID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Column(name = "ICNo")
    private Integer iCNo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Column(name = "phoneNo")
    private Integer phoneNo;
    @Size(max = 255)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lecturerID")
    private Collection<Course> courseCollection;

    public Lecturer() {
    }

    public Lecturer(Integer lecturerID) {
        this.lecturerID = lecturerID;
    }

    public Lecturer(Integer lecturerID, String password, String name, String email) {
        this.lecturerID = lecturerID;
        this.password = password;
        this.name = name;
        this.email = email;
    }

    public Integer getLecturerID() {
        return lecturerID;
    }

    public void setLecturerID(Integer lecturerID) {
        this.lecturerID = lecturerID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getICNo() {
        return iCNo;
    }

    public void setICNo(Integer iCNo) {
        this.iCNo = iCNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(Integer phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @XmlTransient
    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lecturerID != null ? lecturerID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lecturer)) {
            return false;
        }
        Lecturer other = (Lecturer) object;
        if ((this.lecturerID == null && other.lecturerID != null) || (this.lecturerID != null && !this.lecturerID.equals(other.lecturerID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.Lecturer[ lecturerID=" + lecturerID + " ]";
    }
    
}
