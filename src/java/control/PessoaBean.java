package control;

import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.*;
import java.util.ArrayList;
import model.BancoDados;
import model.Pessoa;

/**
 *
 * @author 10361
 */
@ManagedBean
@SessionScoped
public class PessoaBean implements Serializable {

    /**
     * Creates a new instance of LivroBean
     */
    private String nome;
    private String celular;
    private String email;
    private String logradouro;
    private String numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String uf;
    private ArrayList<Pessoa> pessoas;
    private Pessoa pessoa;
    private BancoDados bd;

    public ArrayList<Pessoa> getPessoas() {

        try {
            bd = new BancoDados();

            Statement stm = bd.con().createStatement();

            String consulta = "select * from livros";
            ResultSet rs = stm.executeQuery(consulta);
            while (rs.next()) {
                pessoa = new Pessoa();
                pessoa.setNome(rs.getString("Nome"));
                pessoa.setCelular(rs.getString("Celular"));
                pessoa.setEmail(rs.getString("Email"));
                pessoa.endereco.setBairro(rs.getString("Bairro"));
                pessoa.endereco.setCidade(rs.getString("Cidade"));
                pessoa.endereco.setComplemento(rs.getString("Complemento"));
                pessoa.endereco.setLogradouro(rs.getString("Logradouro"));
                pessoa.endereco.setNumero(rs.getString("Numero"));
                pessoa.endereco.setUf(rs.getString("Uf"));
                pessoas.add(pessoa);

            }
            rs.close();
            bd.con().close();
        } catch (SQLException ex) {
            Logger.getLogger(PessoaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pessoas;
    }

    public PessoaBean() {
    }

    public String cadastrar() {
        try {
            bd = new BancoDados();

            String consulta = "INSERT INTO livros (nome, celular, email, logradouro, numero, complemento, bairro, cidade, uf) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement pstm = bd.con().prepareStatement(consulta);
            pstm.setString(1, nome);
            pstm.setString(2, celular);
            pstm.setString(3, email);
            pstm.setString(4, logradouro);
            pstm.setString(5, numero);
            pstm.setString(6, complemento);
            pstm.setString(7, bairro);
            pstm.setString(8, cidade);
            pstm.setString(9, uf);
            pstm.execute();
            bd.con().close();

        } catch (SQLException ex) {
            Logger.getLogger(PessoaBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "exibirPessoa";
    } 
}