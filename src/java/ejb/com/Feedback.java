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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author User
 */
@Entity
@Table(name = "feedback")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Feedback.findAll", query = "SELECT f FROM Feedback f")
    , @NamedQuery(name = "Feedback.findByQuestionID", query = "SELECT f FROM Feedback f WHERE f.questionID = :questionID")
    , @NamedQuery(name = "Feedback.findByQuestion", query = "SELECT f FROM Feedback f WHERE f.question = :question")
    , @NamedQuery(name = "Feedback.findByCounter", query = "SELECT f FROM Feedback f WHERE f.counter = :counter")
    , @NamedQuery(name = "Feedback.findByQuestionDate", query = "SELECT f FROM Feedback f WHERE f.questionDate = :questionDate")})
public class Feedback implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "questionID")
    private Integer questionID;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "question")
    private String question;
    @Column(name = "counter")
    private Integer counter;
    @Basic(optional = false)
    @NotNull
    @Column(name = "questionDate")
    private int questionDate;
    @JoinColumn(name = "courseID", referencedColumnName = "courseID")
    @ManyToOne(optional = false)
    private Course courseID;
    @JoinColumn(name = "studentID", referencedColumnName = "studentID")
    @ManyToOne(optional = false)
    private Student studentID;

    public Feedback() {
    }

    public Feedback(Integer questionID) {
        this.questionID = questionID;
    }

    public Feedback(Integer questionID, String question, int questionDate) {
        this.questionID = questionID;
        this.question = question;
        this.questionDate = questionDate;
    }

    public Integer getQuestionID() {
        return questionID;
    }

    public void setQuestionID(Integer questionID) {
        this.questionID = questionID;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }

    public int getQuestionDate() {
        return questionDate;
    }

    public void setQuestionDate(int questionDate) {
        this.questionDate = questionDate;
    }

    public Course getCourseID() {
        return courseID;
    }

    public void setCourseID(Course courseID) {
        this.courseID = courseID;
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
        hash += (questionID != null ? questionID.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Feedback)) {
            return false;
        }
        Feedback other = (Feedback) object;
        if ((this.questionID == null && other.questionID != null) || (this.questionID != null && !this.questionID.equals(other.questionID))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.com.Feedback[ questionID=" + questionID + " ]";
    }
    
}
