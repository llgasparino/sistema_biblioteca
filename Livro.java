public class Livro {
    private String titulo;
    private String autor;
    private int ano;

    public Livro(String titulo, String autor, int ano) {
        this.titulo = titulo;
        this.autor = autor;
        this.ano = ano;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public int getAno() {
        return ano;
    }


    public String toString() {
        return titulo + " (" + autor + ", " + ano + ")";
    }

    // para podermos comparar os livros.
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Livro livro = (Livro) obj;
        return titulo.equals(livro.titulo);
    }
    // Para verificar se os titulos dos livros sao iguais
    // se sim, o Hashcode sera o mesmo para os dois, mesmo tendo atributo de autor diferente
    public int hashCode() {
        return titulo.hashCode();
    }
}