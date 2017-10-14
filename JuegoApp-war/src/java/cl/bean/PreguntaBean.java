/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.bean;

import cl.pojos.Pregunta;
import cl.services.PreguntaFacadeLocal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.apache.jasper.tagplugins.jstl.ForEach;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author rodo
 */
@Named(value = "preguntaBean")
@RequestScoped
public class PreguntaBean {

    @EJB
    private PreguntaFacadeLocal preguntaFacade;
    
    private Pregunta pregunta = new Pregunta();
    
    private String preguntaCuestionario;
    private String alternativaUno;
    private String alternativaDos;
    private String alternativaTres;
    private String alternativaCuatro;
    private String respuesta;
    private String premio;
    private String respuestaJugador;
    private ArrayList<Pregunta> lista = new ArrayList<>();

    ;

    
    public PreguntaBean() {
    }
    
    public List<Pregunta> getPreguntas() {
        return preguntaFacade.findAll();
    }
    
    public String crear() {
        System.out.println("Entra a crear");
        Pregunta pre = new Pregunta();        
        pre.setPreguntaCuestionario(preguntaCuestionario);
        pre.setAlternativauno(alternativaUno);
        pre.setAlternativados(alternativaDos);
        pre.setAlternativatres(alternativaTres);
        pre.setAlternativacuatro(alternativaCuatro);
        switch (respuesta) {
            case "A":
                pre.setRespuesta(alternativaUno);
                break;
            case "B":
                pre.setRespuesta(alternativaDos);
                break;
            case "C":
                pre.setRespuesta(alternativaTres);                
                break;
            case "D":
                pre.setRespuesta(alternativaCuatro);
                break;
            default:
                break;
        }
        pre.setPremio(0);
        this.preguntaFacade.create(pre);        
        System.out.println("Sale de crear");
        
        
        
        return "pregunta";
    }
    
    public String eliminar(Pregunta pregunta) {
        this.preguntaFacade.remove(pregunta);
        return "pregunta";
    }
    
   
    
   /*
    Metodo Modificar pasando a xhtml update, no resulta por que no pisa la misma entrada 
    a a modificar. Si no, que crea una entrada nueva en la base de datos.
    
    public String modificar(Pregunta pregunta) {
        this.pregunta = pregunta;        
        return "update";
    }
    
    public String modificar() {
        Pregunta pre = new Pregunta();        
        pre.setId(this.pregunta.getId());
        pre.setPreguntaCuestionario(this.pregunta.getPreguntaCuestionario());
        pre.setAlternativauno(this.pregunta.getAlternativauno());
        pre.setAlternativados(this.pregunta.getAlternativados());
        pre.setAlternativatres(this.pregunta.getAlternativatres());
        pre.setAlternativacuatro(this.pregunta.getAlternativacuatro());
        switch (respuesta) {
            case "A":
                pre.setRespuesta(this.pregunta.getAlternativauno());
                break;
            case "B":
                pre.setRespuesta(this.pregunta.getAlternativados());
                break;
            case "C":
                pre.setRespuesta(this.pregunta.getAlternativatres());                
                break;
            case "D":
                pre.setRespuesta(this.pregunta.getAlternativacuatro());
                break;
            default:
                break;
        }
        pre.setPremio(0);
        
        preguntaFacade.edit(pre);
        return "pregunta";
    }
    */
    
    public String getPreguntaCuestionario() {
        return preguntaCuestionario;
    }
    
    public void setPreguntaCuestionario(String preguntaCuestionario) {
        this.preguntaCuestionario = preguntaCuestionario;
    }
    
    public String getAlternativaUno() {
        return alternativaUno;
    }
    
    public void setAlternativaUno(String alternativaUno) {
        this.alternativaUno = alternativaUno;
    }
    
    public String getAlternativaDos() {
        return alternativaDos;
    }
    
    public void setAlternativaDos(String alternativaDos) {
        this.alternativaDos = alternativaDos;
    }
    
    public String getAlternativaTres() {
        return alternativaTres;
    }
    
    public void setAlternativaTres(String alternativaTres) {
        this.alternativaTres = alternativaTres;
    }
    
    public String getAlternativaCuatro() {
        return alternativaCuatro;
    }
    
    public void setAlternativaCuatro(String alternativaCuatro) {
        this.alternativaCuatro = alternativaCuatro;
    }
    
    public String getRespuesta() {
        return respuesta;
    }
    
    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }
    
    public String getPremio() {
        return premio;
    }
    
    public void setPremio(String premio) {
        this.premio = premio;
    }
    
    public String getRespuestaJugador() {
        return respuestaJugador;
    }
    
    public void setRespuestaJugador(String respuestaJugador) {
        this.respuestaJugador = respuestaJugador;
    }
    
    public ArrayList<Pregunta> getLista() {
        return lista;
    }
    
    public void setLista(ArrayList<Pregunta> lista) {
        this.lista = lista;
    }    
    
    public Pregunta getPregunta() {
        return pregunta;
    }
    
    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }
    
}
