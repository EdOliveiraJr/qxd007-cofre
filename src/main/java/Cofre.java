public class Cofre {
    private int volumeMaximo;
    private int volume;
    private int volumeRestante; 
    private boolean quebrado;
    private double moedas;
    private String itens = "";
       

    public Cofre(int volumeMaximo) {
        this.volumeMaximo = volumeMaximo;
        this.volume = 0;
        this.volumeRestante = volumeMaximo;
           
    }

    public int getVolume() {
        return volume;
    }

    public int getVolumeMaximo() {
        return volumeMaximo;
    }

    public int getVolumeRestante() {
        return volumeRestante;
    }

    public String getItens() {
        return itens;
    }

    public void setItens(Item item){
        if(this.itens.equals("")){
            itens += item.getItemDescricao();
        }else{
            itens += ", ";
            itens += item.getItemDescricao();
        }
    }

    public double getMoedas() {
        return moedas;
    }

    public boolean add(Item item) {
        if(quebrado){
            return false;
        }else if(item.getItemVolume() + volume > volumeMaximo){
            return false;
        }else{
            volume += item.getItemVolume();
            volumeRestante -= item.getItemVolume();
            setItens(item);
        }        
        return true;
    }

    public boolean add(Moeda moeda) {
        if(quebrado){
            return false;
        }else if(moeda.getMoedaVolume() + volume > volumeMaximo){
            return false;
        }else{
            volume += moeda.getMoedaVolume();
            moedas += moeda.getMoedaValor();
            volumeRestante -= moeda.getMoedaVolume();
        }        
        return true;
    }

    public String obterItens() {
        if(taInteiro()){
            return null;
        }else if(volume == 0){
            return "vazio";
        }
        String retorno = itens; 
        return retorno;
    }

    public double obterMoedas() {
        if(taInteiro()){
            return -1.0;
        }else if(volume == 0){
            return 0.0;
        }
        return moedas;
    }
    
    public boolean taInteiro() {
        if(quebrado){
            return false;
        }
        return true;
    }

    public boolean quebrar() {
        if(quebrado){
            return false;
        }
        quebrado = true;
        return true;
    }

}