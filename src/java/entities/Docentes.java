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
@Table(name = "docentes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docentes.findAll", query = "SELECT d FROM Docentes d"),
    @NamedQuery(name = "Docentes.findByDniDocente", query = "SELECT d FROM Docentes d WHERE d.dniDocente = :dniDocente"),
    @NamedQuery(name = "Docentes.findByNomDocente", query = "SELECT d FROM Docentes d WHERE d.nomDocente = :nomDocente"),
    @NamedQuery(name = "Docentes.findByApeDocente", query = "SELECT d FROM Docentes d WHERE d.apeDocente = :apeDocente"),
    @NamedQuery(name = "Docentes.findBySueldo", query = "SELECT d FROM Docentes d WHERE d.sueldo = :sueldo")})
public class Docentes implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "dni_docente")
    private Integer dniDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 35)
    @Column(name = "nom_docente")
    private String nomDocente;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "ape_docente")
    private String apeDocente;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sueldo")
    private long sueldo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dniDocente")
    private Collection<Cursos> cursosCollection;

    public Docentes() {
    }

    public Docentes(Integer dniDocente) {
        this.dniDocente = dniDocente;
    }

    public Docentes(Integer dniDocente, String nomDocente, String apeDocente, long sueldo) {
        this.dniDocente = dniDocente;
        this.nomDocente = nomDocente;
        this.apeDocente = apeDocente;
        this.sueldo = sueldo;
    }

    public Integer getDniDocente() {
        return dniDocente;
    }

    public void setDniDocente(Integer dniDocente) {
        this.dniDocente = dniDocente;
    }

    public String getNomDocente() {
        return nomDocente;
    }

    public void setNomDocente(String nomDocente) {
        this.nomDocente = nomDocente;
    }

    public String getApeDocente() {
        return apeDocente;
    }

    public void setApeDocente(String apeDocente) {
        this.apeDocente = apeDocente;
    }

    public long getSueldo() {
        return sueldo;
    }

    public void setSueldo(long sueldo) {
        this.sueldo = sueldo;
    }

    @XmlTransient
    public Collection<Cursos> getCursosCollection() {
        return cursosCollection;
    }

    public void setCursosCollection(Collection<Cursos> cursosCollection) {
        this.cursosCollection = cursosCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dniDocente != null ? dniDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docentes)) {
            return false;
        }
        Docentes other = (Docentes) object;
        if ((this.dniDocente == null && other.dniDocente != null) || (this.dniDocente != null && !this.dniDocente.equals(other.dniDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Docentes[ dniDocente=" + dniDocente + " ]";
    }
    
}
