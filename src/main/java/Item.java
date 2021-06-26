public class Item {

    private int volume;
    private String descricao;

    public Item(String descricao, int volume) {
        this.volume = volume;
        this.descricao = descricao;
    }

    public int getItemVolume(){
        return volume;
    }

    public String getItemDescricao(){
        return descricao;
    }

    @Override
    public String toString() {
        return "Item{" +
                "volume=" + volume +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
