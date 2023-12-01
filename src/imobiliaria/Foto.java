package imobiliaria;

public class Foto {
    private String codigo;
    private String descricao;
    private String imagem;

    // Construtor
    public Foto(String codigo, String descricao, String imagem) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.imagem = imagem;
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getImagem() {
        return imagem;
    }

    // Setters
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    // Método toString
    @Override
    public String toString() {
        return "Foto{" +
                "codigo='" + codigo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", imagem='" + imagem + '\'' +
                '}';
    }
}
