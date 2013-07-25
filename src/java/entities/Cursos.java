/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

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
 * @author Smart
 */
@Entity
@Table(name = "cursos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursos.findAll", query = "SELECT c FROM Cursos c"),
    @NamedQuery(name = "Cursos.findByExpediente", query = "SELECT c FROM Cursos c WHERE c.expediente = :expediente"),
    @NamedQuery(name = "Cursos.findByDenominacion", query = "SELECT c FROM Cursos c WHERE c.denominacion = :denominacion"),
    @NamedQuery(name = "Cursos.findByDuracion", query = "SELECT c FROM Cursos c WHERE c.duracion = :duracion")})
public class Cursos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "expediente")
    private Integer expediente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "denominacion")
    private String denominacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duracion")
    private int duracion;
    @JoinColumn(name = "num_aula", referencedColumnName = "num_aula")
    @ManyToOne(optional = false)
    private Aulas numAula;
    @JoinColumn(name = "dni_docente", referencedColumnName = "dni_docente")
    @ManyToOne(optional = false)
    private Docentes dniDocente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "expCurso")
    private Collection<Alumnos> alumnosCollection;

    public Cursos() {
    }

    public Cursos(Integer expediente) {
        this.expediente = expediente;
    }

    public Cursos(Integer expediente, String denominacion, int duracion) {
        this.expediente = expediente;
        this.denominacion = denominacion;
        this.duracion = duracion;
    }

    public Integer getExpediente() {
        return expediente;
    }

    public void setExpediente(Integer expediente) {
        this.expediente = expediente;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Aulas getNumAula() {
        return numAula;
    }

    public void setNumAula(Aulas numAula) {
        this.numAula = numAula;
    }

    public Docentes getDniDocente() {
        return dniDocente;
    }

    public void setDniDocente(Docentes dniDocente) {
        this.dniDocente = dniDocente;
    }

    @XmlTransient
    public Collection<Alumnos> getAlumnosCollection() {
        return alumnosCollection;
    }

    public void setAlumnosCollection(Collection<Alumnos> alumnosCollection) {
        this.alumnosCollection = alumnosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (expediente != null ? expediente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursos)) {
            return false;
        }
        Cursos other = (Cursos) object;
        if ((this.expediente == null && other.expediente != null) || (this.expediente != null && !this.expediente.equals(other.expediente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Cursos[ expediente=" + expediente + " ]";
    }
    
}
