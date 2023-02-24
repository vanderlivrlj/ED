import java.util.Arrays;

public class Vetor {

    private Aluno[] alunos = new Aluno[100];
    private int totalDeAlunos = 0;

    public void adiciona (Aluno aluno){
        //Lista O de N. Se um array tiver 70 posições preenchidas ele passará 70 vezes até encontrar uma posição vazia.
        /*for (int i =0; i< alunos.length; i++){
            if (alunos[i] == null){
                alunos[i] = aluno;
                break;
            }
        }*/
        //Dessa maneira, criamos uma variável para informar qual está null e adicionar facilmente. Melhorando performace
        this.garanteEspaco();

        this.alunos[totalDeAlunos] = aluno;
        totalDeAlunos++;
    }

    private boolean posicaoValida(int posicao){
        return posicao >=0 && posicao <= totalDeAlunos;
    }

    private void garanteEspaco(){
        if (totalDeAlunos == alunos.length){
            Aluno [] novoArray = new Aluno[alunos.length*2];
            for (int i = 0; i < alunos.length; i++){
                novoArray[i] = alunos[i];
            }
            this.alunos = novoArray;
        }
    }

    public void adiciona(int posicao, Aluno aluno){
        this.garanteEspaco();

        if (!posicaoValida(posicao)){
            throw new IllegalArgumentException("Posição Inválida");
        }

        for (int i = totalDeAlunos - 1; i >= posicao; i-=1){
            alunos[i+1] = alunos[i];
        }
        alunos[posicao] = aluno;
        totalDeAlunos++;
    }

    public void remove (int posicao){

        for (int i = posicao; i <= totalDeAlunos; i++){
            alunos[i] = alunos[i+1];
        }
        totalDeAlunos--;

    }

    private boolean posicaoOcupada(int posicao){
        return posicao >= 0 && posicao < totalDeAlunos;
    }

    public Aluno pega (int posicao){
        if(!posicaoOcupada(posicao)){
            throw new IllegalArgumentException("Posição ocupada");
        }
        return alunos[posicao];
    }

    public boolean contem (Aluno aluno){
        for (int i = 0; i < totalDeAlunos; i++){
            if (aluno.equals(alunos[i])){
                return true;
            }
        }
        return false;
    }

    public int tamanho(){
        return totalDeAlunos;
    }

    @Override
    public String toString() {
        return Arrays.toString(alunos);
    }
}
