package beans;

import entities.Aulas;
import controllers.AulasFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "aulasController")
@ViewScoped
public class AulasController extends AbstractController<Aulas> implements Serializable {

    @EJB
    private AulasFacade ejbFacade;

    public AulasController() {
        super(Aulas.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
