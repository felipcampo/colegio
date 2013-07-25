package beans;

import entities.Alumnos;
import controllers.AlumnosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "alumnosController")
@ViewScoped
public class AlumnosController extends AbstractController<Alumnos> implements Serializable {

    @EJB
    private AlumnosFacade ejbFacade;

    public AlumnosController() {
        super(Alumnos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
