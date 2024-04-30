public class MenuSelecao {
    private int menuSelecao1;
    private int menuSelecao2;

    public void mostrarTexto1() {
        System.out.println("Digite a moeda de entrada:");
    }
    public void opcoesDeMoedas(){
        System.out.println("1-ARS - Peso Argentino        4-CLP - Peso Chileno");
        System.out.println("2-BOB - Boliviano Boliviano   5-COP - Peso Colombiano");
        System.out.println("3-BRL - Real Brasileiro       6-USD - Dolar Americano");
    }
    public void mostrarTexto2()
    {
        System.out.println("Digite o valor a ser convertido com até duas casas decimais separados por ponto: ");
    }
    public void mostrarTexto3() {
        System.out.println("Digite a moeda de saida:");
    }

    public String menuDeMoedas(int moedaMenu){
        if (moedaMenu == 1)
        {
            return "ARS";
        }
        else if (moedaMenu == 2)
        {
            return "BOB";
        }
        else if (moedaMenu == 3)
        {
            return "BRL";
        }
        else if (moedaMenu == 4)
        {
            return "CLP";
        }
        else if (moedaMenu == 5)
        {
            return "COP";
        }
        else if (moedaMenu == 6)
        {
            return "DOL";
        }
        else return "Opção inválida";
    }

    public int getMenuSelecao1() {
        return menuSelecao1;
    }

    public void setMenuSelecao1(int menuSelecao1) {
        this.menuSelecao1 = menuSelecao1;
    }

    public int getMenuSelecao2() {
        return menuSelecao2;
    }

    public void setMenuSelecao2(int menuSelecao2) {
        this.menuSelecao2 = menuSelecao2;
    }

}
