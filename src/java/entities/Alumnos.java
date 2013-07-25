/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Smart
 */
@Entity
@Table(name = "alumnos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alumnos.findAll", query = "SELECT a FROM Alumnos a"),
    @NamedQuery(name = "Alumnos.findByDniAlumno", query = "SELECT a FROM Alumnos a WHERE a.dniAlumno = :dniAlumno"),
    @NamedQuery(name = "Alumnos.findByNomAlumno", query = "SELECT a FROM Alumnos a WHERE a.nomAlumno = :nomAlumno"),
    @NamedQuery(name = "Alumnos.findByApeAlumno", query = "SELECT a FROM Alumnos a WHERE a.apeAlumno = :apeAlumno")})
public class Alumnos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni_alumno")
    private Integer dniAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nom_alumno")
    private String nomAlumno;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ape_alumno")
    private String apeAlumno;
    @JoinColumn(name = "exp_curso", referencedColumnName = "expediente")
    @ManyToOne(optional = false)
    private Cursos expCurso;

    public Alumnos() {
    }

    public Alumnos(Integer dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public Alumnos(Integer dniAlumno, String nomAlumno, String apeAlumno) {
        this.dniAlumno = dniAlumno;
        this.nomAlumno = nomAlumno;
        this.apeAlumno = apeAlumno;
    }

    public Integer getDniAlumno() {
        return dniAlumno;
    }

    public void setDniAlumno(Integer dniAlumno) {
        this.dniAlumno = dniAlumno;
    }

    public String getNomAlumno() {
        return nomAlumno;
    }

    public void setNomAlumno(String nomAlumno) {
        this.nomAlumno = nomAlumno;
    }

    public String getApeAlumno() {
        return apeAlumno;
    }

    public void setApeAlumno(String apeAlumno) {
        this.apeAlumno = apeAlumno;
    }

    public Cursos getExpCurso() {
        return expCurso;
    }

    public void setExpCurso(Cursos expCurso) {
        this.expCurso = expCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniAlumno != null ? dniAlumno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alumnos)) {
            return false;
        }
        Alumnos other = (Alumnos) object;
        if ((this.dniAlumno == null && other.dniAlumno != null) || (this.dniAlumno != null && !this.dniAlumno.equals(other.dniAlumno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Alumnos[ dniAlumno=" + dniAlumno + " ]";
    }
    
}
