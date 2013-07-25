package beans;

import entities.Docentes;
import controllers.DocentesFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "docentesController")
@ViewScoped
public class DocentesController extends AbstractController<Docentes> implements Serializable {

    @EJB
    private DocentesFacade ejbFacade;

    public DocentesController() {
        super(Docentes.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
