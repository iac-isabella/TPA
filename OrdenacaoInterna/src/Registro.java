import java.util.Random;

/**
 * Classe que modela a estrutura de dados a ser utilizada para os testes de ordenação.
 */
public class Registro implements Comparable<Registro>, Cloneable {

    public static int quantidade = 0;

    private int numero;
    private char[] nome = new char[50];
    private char[] sobrenome = new char[50];
    private char[] endereco = new char[256];
    private char[] telefone = new char[20];
    private float saldo;

    /**
     * Construtor da classe. Responsável por inicializar os atribtuos do Registro.
     */
    public Registro() {
        Random random = new Random();
        quantidade++;
        numero = quantidade;
        gerarNome(nome, 50);
        gerarNome(sobrenome, 50);
        gerarNome(endereco, 256);
        gerarNome(telefone, 20);
        if (numero % 2 == 0) {
                saldo = random.nextInt(10001) * random.nextInt(10001);
        } else {
                saldo = random.nextInt(1001) * -random.nextInt(101);
        }
        if(saldo != 0){
                saldo /= 100;
        }
    }

    /**
     * Método para a geração de nomes aleatórios.
     * @param nomeVetor Variável que conterá o nome.
     * @param tamanhoVetor Tamanho do vetor de caracteres que conterá o nome.
     */
    private void gerarNome(char[] nomeVetor, int tamanhoVetor) {
        Random r = new Random();
        for (int i = 0; i < tamanhoVetor; i++) {
                nomeVetor[i] = (char) (r.nextInt(26) + 'a');
        }
    }

    /**
     * Método para a geração de uma String com os dados do Registro.
     * @return Dados do Registro.
     */
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Registro:\nSaldo: " + saldo);
        builder.append("\nNome: " + nome);
        builder.append("\nSobrenome: " + sobrenome);
        builder.append("\nTelefone: " + telefone);
        builder.append("\nEndereco: " + endereco);

        return builder.toString();

    }

    /**
     * Método para a comparação de objetos do tipo registro, para fins de ordenação.
     * @param registro Registro a ser comparado.
     * @return Inteiro indicando se o registro comparado precede ou antecede o atual.
     */
    @Override
    public int compareTo(Registro registro) {
        if (this.saldo < registro.saldo) {
                return -1;
        } else {
            if (this.saldo > registro.saldo) {
                return 1;
            }
        }
        return 0;
    }

    /**
     * Método para a clonagem de registros.
     * @return Objeto clonado.
     */
    @Override
    public Object clone() {
        Registro reg = new Registro();
        reg.setEndereco(endereco);
        reg.setNome(nome);
        reg.setNumero(numero);
        reg.setSobrenome(sobrenome);
        reg.setTelefone(telefone);
        reg.setSaldo(saldo);
        return reg;    
    }

    /* Getters and Setters */

    public float getSaldo() {
            return saldo;
    }

    public static void setQuantidade(int quantidade) {
        Registro.quantidade = quantidade;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public char[] getNome() {
        return nome;
    }

    public void setNome(char[] nome) {
        this.nome = nome;
    }

    public char[] getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(char[] sobrenome) {
        this.sobrenome = sobrenome;
    }

    public char[] getEndereco() {
        return endereco;
    }

    public void setEndereco(char[] endereco) {
        this.endereco = endereco;
    }

    public char[] getTelefone() {
        return telefone;
    }

    public void setTelefone(char[] telefone) {
        this.telefone = telefone;
    }

}