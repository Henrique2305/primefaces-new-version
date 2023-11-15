package controller;

import model.Endereco;
import model.Usuario;
import repository.Usuarios;
import service.CadastroUsuarioService;
import util.UsuarioConverter;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class GestaoUsuariosBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Inject
    private Usuarios usuarios;
    
    @Inject
    private CadastroUsuarioService cadastroUsuarioService;
    
    private List<Usuario> listaUsuarios;
    
    private String termoPesquisa;
    
    private Converter ramoAtividadeConverter;
    
    private Usuario  usuario = new Usuario(new Endereco());

    private String message = "Cadastro";
    
//    public void prep() {
//        usuario = new Usuario();
//    }

//    public void prepararEdicao() {
//        ramoAtividadeConverter = new RamoAtividadeConverter(Arrays.asList(empresa.getRamoAtividade()));
//    }

    public void prepararEdicao(Usuario usuario) {
        this.usuario = usuario;
    }

//    public void prepararNovoUsuario() {
//        this.usuario = new Usuario();
//    }


//    public String  salvar() {
//
//        cadastroUsuarioService.salvar(usuario);
//
//        return "index.xhtml?faces-redirect=true";
//    }

    public void  salvar() {

        cadastroUsuarioService.salvar(usuario);
        cadastroUsuarioService.salvar(usuario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário editado com sucesso"));
    }
    
    public void excluir(Usuario usuario) {
        cadastroUsuarioService.excluir(usuario);

        usuario = null;
    }

    public void editar() {
//        Usuario usuario1 = UsuarioConverter.transformBOModelForUpdate(usuario, usuarios.porId(usuario.getId()));
        cadastroUsuarioService.salvar(usuario);
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso", "Usuário editado com sucesso"));;
    }

//    public String editar() {
//        Usuario usuario1 = UsuarioConverter.transformBOModelForUpdate(usuario, usuarios.porId(usuario.getId()));
//        cadastroUsuarioService.salvar(usuario1);
//
//        return "index.xhtml?faces-redirect=true";
//    }
    
//    public void pesquisar() {
//        listaEmpresas = empresas.pesquisar(termoPesquisa);
//
//        if (listaEmpresas.isEmpty()) {
//            messages.info("Sua consulta não retornou registros.");
//        }
//    }
    
    public void todosUsuarios() {
        listaUsuarios = usuarios.todas();
    }
    
//    public List<RamoAtividade> completarRamoAtividade(String termo) {
//        List<RamoAtividade> listaRamoAtividades = ramoAtividades.pesquisar(termo);
//
//        ramoAtividadeConverter = new RamoAtividadeConverter(listaRamoAtividades);
//
//        return listaRamoAtividades;
//    }
//
//    private void atualizarRegistros() {
//        if (jaHouvePesquisa()) {
//            pesquisar();
//        } else {
//            todasEmpresas();
//        }
//    }


    public String getMessage() {
        return message;
    }

    public String navigateIndex() {
        return "index.xhtml?faces-redirect=true";
    }

    public String navigateCreate() {
        return "insert.xhtml";
    }

    public String navigateUpdate() {
        return "update.xhtml";
    }

    private boolean jaHouvePesquisa() {
        return termoPesquisa != null && !"".equals(termoPesquisa);
    }
    
    public List<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }
    
    public String getTermoPesquisa() {
        return termoPesquisa;
    }
    
    public void setTermoPesquisa(String termoPesquisa) {
        this.termoPesquisa = termoPesquisa;
    }
    
//    public TipoEmpresa[] getTiposEmpresa() {
//        return TipoEmpresa.values();
//    }
    
//    public Converter getRamoAtividadeConverter() {
//        return ramoAtividadeConverter;
//    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    public void setusuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    public boolean isUsuarioSeleciona() {
        return usuario != null && usuario.getId() != null;
    }
}