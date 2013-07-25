package beans;

import entities.Cursos;
import controllers.CursosFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "cursosController")
@ViewScoped
public class CursosController extends AbstractController<Cursos> implements Serializable {

    @EJB
    private CursosFacade ejbFacade;

    public CursosController() {
        super(Cursos.class);
    }

    @PostConstruct
    public void init() {
        super.setFacade(ejbFacade);
    }
}
