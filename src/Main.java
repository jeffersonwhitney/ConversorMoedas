import java.io.IOException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner leitura = new Scanner(System.in); // cria um scanner
        Scanner leitura2 = new Scanner(System.in); //cria um novo scanner
        Scanner leitura3 = new Scanner(System.in);
        MenuSelecao menu = new MenuSelecao(); // cria um objeto menu

        //PRIMEIRA ETAPA
        menu.mostrarTexto1(); // Printa primeiro texto
        menu.opcoesDeMoedas(); // Printa as opções de moedas
        menu.setMenuSelecao1((Integer.parseInt(leitura.nextLine())));// Armazena a primeira seleção
        menu.setTipoOrigem(menu.menuDeMoedas(menu.getMenuSelecao1())); // Usa o metodo menuDeMoedas para retornar e armazenar a moeda Origem

        //SEGUNDA ETAPA
        menu.mostrarTexto2(); // Printa segundo texto
        menu.setQuantidade(Double.parseDouble(leitura2.nextLine())); // Armazena a quantidade da moeda em Double

        //TERCEIRA ETAPA
        menu.mostrarTexto3(); //mostra a opcao de saida
        menu.opcoesDeMoedas(); //mostra o menu novamente
        menu.setMenuSelecao2(Integer.parseInt(leitura3.nextLine()));
        menu.setTipoDestino(menu.menuDeMoedas(menu.getMenuSelecao2()));
        System.out.println("processando..."); //aqui eh pra não pensar que ta demorando muito

        //CONSULTA DA API COM O RESULTADO DO METODO
        ConsultaAPI consultaapi = new ConsultaAPI();
        double resultado = consultaapi.Consulta(menu.menuDeMoedas(menu.getMenuSelecao1()), menu.menuDeMoedas(menu.getMenuSelecao2()), menu.getQuantidade());
        System.out.println(menu.getQuantidade()+" "+menu.getTipoOrigem()+" convertido em "+menu.getTipoDestino()+" equivalem a "+resultado+" "+menu.getTipoDestino());
    }
}