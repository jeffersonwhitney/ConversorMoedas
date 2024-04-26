public class MenuSelecao {
    private int menuSelecao = 0;
    private int moedaMenu = 0;

    public void mostrarmenu1() {
        System.out.println("Digite a moeda de entrada:");
        System.out.println("1-ARS - Peso Argentino        4-CLP - Peso Chileno");
        System.out.println("2-BOB - Boliviano Boliviano   5-COP - Peso Colombiano");
        System.out.println("3-BRL - Real Brasileiro       6-USD - Dolar Americano");
    }
    public void mostrarmenu2()
    {
        System.out.println("Digite o valor a ser convertido com até duas casas decimais separados por ponto: ");
    }
    public void mostrarmenu3() {
        System.out.println("Digite a moeda de saida:");
        System.out.println("1-ARS - Peso Argentino        4-CLP - Peso Chileno");
        System.out.println("2-BOB - Boliviano Boliviano   5-COP - Peso Colombiano");
        System.out.println("3-BRL - Real Brasileiro       6-USD - Dolar Americano");
    }

    public String moedaMenu(int moedaMenu){
        this.moedaMenu = moedaMenu;
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
            return "ARS";
        }
        else return "Opção inválida";
    }

    public int getMenuSelecao() {
        return menuSelecao;
    }

    public void setMenuSelecao(int menuSelecao) {
        this.menuSelecao = menuSelecao;
    }
}
